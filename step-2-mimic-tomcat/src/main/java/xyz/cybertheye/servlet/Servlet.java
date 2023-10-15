package xyz.cybertheye.servlet;


import xyz.cybertheye.context.ServletContext;
import xyz.cybertheye.http.MTRequest;
import xyz.cybertheye.http.MTResponse;

import java.io.UnsupportedEncodingException;

/**
 * @description:
 */

public interface Servlet {
    public void service(MTRequest req, MTResponse response) throws UnsupportedEncodingException;

    ServletContext getServletContext();
}
