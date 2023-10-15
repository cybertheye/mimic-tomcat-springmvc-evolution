package xyz.cybertheye;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import xyz.cybertheye.context.ServletContext;
import xyz.cybertheye.context.ServletContextFactory;
import xyz.cybertheye.handler.DefaultMimicTomcatChannelHandler;
import xyz.cybertheye.handler.MimicHttpInBoundHandler;
import xyz.cybertheye.listener.Notifier;
import xyz.cybertheye.listener.NotifierImpl;

/**
 * @description:
 */
public class MimicTomcatServer {
    private final int PORT;

    public MimicTomcatServer(int PORT) {
        this.PORT = PORT;
    }


    private ComponentScanner scanner;
    private ServletContext servletContext;
    public void start(Class<?> clazz){
        WebScanPackage annotation = clazz.getAnnotation(WebScanPackage.class);
        String[] scanPackages = annotation.value();
        if(scanPackages.length == 1 && scanPackages[0].equals("")){
            String clazzName = clazz.getName();
            String packagePath = clazzName.substring(0, clazzName.lastIndexOf("."));
            scanPackages[0] = packagePath;
        }
        scanner = new WebComponentScanner(scanPackages);
        Notifier notifiler = new NotifierImpl(scanner.getWebListenerComponents());
        servletContext = ServletContextFactory.getInstance(scanner.getWebListenerComponents(),notifiler);

        servletContext.registerAll(scanner.getWebListenerComponents());
        run();
    }

    private void run(){
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        try{
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap
                    .group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE,true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new HttpServerCodec());
                            pipeline.addLast(new HttpObjectAggregator(65536));
                            pipeline.addLast(new MimicHttpInBoundHandler(servletContext));
                            pipeline.addLast(new DefaultMimicTomcatChannelHandler(scanner,servletContext));

                        }
                    });

            ChannelFuture cf = serverBootstrap.bind(PORT).sync();
            cf.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
