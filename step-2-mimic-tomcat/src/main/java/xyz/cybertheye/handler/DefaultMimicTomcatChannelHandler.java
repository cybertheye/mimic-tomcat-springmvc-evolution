package xyz.cybertheye.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpRequest;
import xyz.cybertheye.ComponentScanner;
import xyz.cybertheye.context.ServletContext;
import xyz.cybertheye.context.ServletContextFactory;
import xyz.cybertheye.filter.chain.Chain;
import xyz.cybertheye.filter.chain.FilterChainImplFactory;
import xyz.cybertheye.http.HttpMTResponse;
import xyz.cybertheye.http.HttpRequestProxyFactory;
import xyz.cybertheye.http.MTRequest;
import xyz.cybertheye.http.MTResponse;
import xyz.cybertheye.servlet.Servlet;
import xyz.cybertheye.servlet.ServletManager;
import xyz.cybertheye.servlet.ServletManagerFactory;

/**
 * @description:
 */

public class DefaultMimicTomcatChannelHandler extends ChannelInboundHandlerAdapter {

    private ComponentScanner scanner;
    private ServletContext servletContext;
    public DefaultMimicTomcatChannelHandler(ComponentScanner scanner, ServletContext servletContext) {
        this.scanner = scanner;
        this.servletContext = servletContext;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        MTRequest request = (MTRequest) msg;
        String uri = request.uri();

        RouteStrategy strategy = new RouteMaxMatchStrategy(ServletManagerFactory.getInstance(scanner,servletContext));
        Servlet servlet = strategy.route(uri);

        MTResponse response = new HttpMTResponse(ctx);

        Chain filterChain = FilterChainImplFactory.createFilterChain(servlet,uri,scanner);

        filterChain.start(request,response);
    }
}
