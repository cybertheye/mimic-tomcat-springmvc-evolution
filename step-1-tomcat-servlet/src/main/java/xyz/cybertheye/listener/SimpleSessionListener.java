package xyz.cybertheye.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @description:
 */
@WebListener
public class SimpleSessionListener implements HttpSessionListener, HttpSessionAttributeListener {
    private static int priority = 0;
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("=====http session+++++");
        System.out.println("inside attributedAdded :" + priority);
        System.out.println("=====http session-----");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("=====http session+++++");
        System.out.println("inside sessionCreated:" + priority);
        System.out.println("=====http session-----");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("=====http session+++++");
        System.out.println("inside sessionDestroyed:" + priority);
        System.out.println("=====http session-----");
    }
}
