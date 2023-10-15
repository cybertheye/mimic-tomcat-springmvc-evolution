package xyz.cybertheye.test.project.listener;

import xyz.cybertheye.listener.*;
import xyz.cybertheye.listener.webcontext.ServletContextAttributeEvent;
import xyz.cybertheye.listener.webcontext.ServletContextAttributeListener;
import xyz.cybertheye.listener.webcontext.ServletContextEvent;
import xyz.cybertheye.listener.webcontext.ServletContextListener;

/**
 * @description:
 */
@WebListener
public class SimpleContextListener implements ServletContextListener, ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("inside attributeAdded ");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("inside contextInitialized : contextname = "+sce.getName());
    }
}
