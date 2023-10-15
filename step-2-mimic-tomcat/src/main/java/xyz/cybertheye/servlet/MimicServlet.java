package xyz.cybertheye.servlet;

import xyz.cybertheye.context.ServletContext;
import xyz.cybertheye.http.HttpMTRequest;
import xyz.cybertheye.http.HttpMTResponse;
import xyz.cybertheye.http.MTRequest;
import xyz.cybertheye.http.MTResponse;

import java.io.UnsupportedEncodingException;

/**
 * @description:
 */
public abstract class MimicServlet implements Servlet{
    @Override
    public ServletContext getServletContext() {
        return this.servletContext;
    }

    //TODO servletContext
    private ServletContext servletContext;
    @Override
    public void service(MTRequest req, MTResponse response) throws UnsupportedEncodingException {
        //
        String method = req.method().name();
        if("GET".equals(method)){
            doGet(req,response);
        } else if ("POST".equals(method)) {
            doPost(req,response);
        }

    }

    protected abstract void doPost(MTRequest req, MTResponse response);

    protected abstract void doGet(MTRequest req, MTResponse response) throws UnsupportedEncodingException;
}
