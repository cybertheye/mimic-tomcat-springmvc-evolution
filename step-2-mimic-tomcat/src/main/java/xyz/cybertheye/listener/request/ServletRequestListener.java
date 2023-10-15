package xyz.cybertheye.listener.request;

import xyz.cybertheye.listener.EventListener;

/**
 * @description:
 */

public interface ServletRequestListener extends EventListener {
    void requestInitialized();
}
