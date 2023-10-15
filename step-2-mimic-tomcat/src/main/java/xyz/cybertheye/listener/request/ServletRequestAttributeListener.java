package xyz.cybertheye.listener.request;

import xyz.cybertheye.listener.EventListener;

/**
 * @description:
 */

public interface ServletRequestAttributeListener extends EventListener {
    void requestAttributeAdded(ServletRequestAttributeEvent srae);
}
