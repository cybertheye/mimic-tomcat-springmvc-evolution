package xyz.cybertheye.listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.sound.midi.Soundbank;

/**
 * @description:
 */
@WebListener
public class SimpleServletListener implements ServletContextListener, ServletContextAttributeListener {
    private static int priority = 0;
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("=====servlet context+++++");
        System.out.println("inside attributedAdded :" + priority);
        System.out.println("=====servlet context-----");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("=====servlet context+++++");
        sce.getServletContext();
        Object source = sce.getSource();
        System.out.println(source);
        System.out.println("inside contextInitialized:" + priority);
        System.out.println("=====servlet context-----");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("=====servlet context+++++");
        System.out.println("inside contextDestroyed:" + priority);
        System.out.println("=====servlet context-----");
    }
}
