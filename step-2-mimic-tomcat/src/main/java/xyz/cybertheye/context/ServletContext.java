package xyz.cybertheye.context;

import xyz.cybertheye.listener.EventListener;
import xyz.cybertheye.listener.Notifier;

import java.util.List;

/**
 * @description:
 */

public interface ServletContext {

    void setAttribute(String name, Object obj);
    Object getAttribute(String name);
    void register(EventListener listener);

    void registerAll(List<String> listeners);


    Notifier getNotifiler();
}
