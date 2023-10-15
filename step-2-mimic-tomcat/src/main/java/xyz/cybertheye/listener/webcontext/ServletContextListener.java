package xyz.cybertheye.listener.webcontext;

import xyz.cybertheye.listener.EventListener;

/**
 * @description:
 */
public interface ServletContextListener extends EventListener {
    void contextInitialized(ServletContextEvent sce);
}
