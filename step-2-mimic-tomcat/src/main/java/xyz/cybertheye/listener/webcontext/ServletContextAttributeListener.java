package xyz.cybertheye.listener.webcontext;

import xyz.cybertheye.listener.EventListener;

/**
 * @description:
 */

public interface ServletContextAttributeListener extends EventListener {
    void attributeAdded(ServletContextAttributeEvent scae);
}
