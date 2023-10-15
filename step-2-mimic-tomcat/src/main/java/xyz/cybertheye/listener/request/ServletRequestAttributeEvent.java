package xyz.cybertheye.listener.request;

import xyz.cybertheye.listener.Event;
import xyz.cybertheye.listener.EventListener;

/**
 * @description:
 */
public class ServletRequestAttributeEvent implements Event {
    private String name;
    private Object value;

    public ServletRequestAttributeEvent(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
