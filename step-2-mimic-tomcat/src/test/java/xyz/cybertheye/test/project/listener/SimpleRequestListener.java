package xyz.cybertheye.test.project.listener;

import xyz.cybertheye.listener.WebListener;
import xyz.cybertheye.listener.request.ServletRequestAttributeEvent;
import xyz.cybertheye.listener.request.ServletRequestAttributeListener;

/**
 * @description:
 */
@WebListener
public class SimpleRequestListener implements ServletRequestAttributeListener {
    @Override
    public void requestAttributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("inside request attribute added listener : \n"+ srae.getName()+"="+srae.getValue());
    }
}
