package xyz.cybertheye.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @description:
 */
@WebListener
public class SimpleRequestListener implements ServletRequestListener, ServletRequestAttributeListener {
    private static int priority = 0;
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("=====servlet request+++++");
        System.out.println("inside attributedAdded :" + priority);
        System.out.println("=====servlet request-----");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {

    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {

    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("=====servlet request+++++");
        System.out.println("inside requestDestroyed :" + priority);
        System.out.println("=====servlet request-----");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("=====servlet request+++++");
        System.out.println("inside requestInitialized :" + priority);
        System.out.println("=====servlet request-----");
    }
}
