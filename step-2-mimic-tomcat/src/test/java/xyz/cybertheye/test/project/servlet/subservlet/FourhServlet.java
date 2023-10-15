package xyz.cybertheye.test.project.servlet.subservlet;

import xyz.cybertheye.WebScanPackage;
import xyz.cybertheye.context.ServletContext;
import xyz.cybertheye.http.MTRequest;
import xyz.cybertheye.http.MTResponse;
import xyz.cybertheye.servlet.MimicServlet;
import xyz.cybertheye.servlet.WebServlet;

import java.io.UnsupportedEncodingException;

/**
 * @description:
 */
@WebServlet("/hello/a/b")
public class FourhServlet extends MimicServlet {
    @Override
    protected void doPost(MTRequest req, MTResponse response) {

    }

    @Override
    protected void doGet(MTRequest req, MTResponse response) throws UnsupportedEncodingException {
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("name","cy");
        req.getParameters().forEach((key,value)->{
            System.out.println(key+"="+value);
        });
        response.writeAndFlush("在这 /hello/a/b : uri="+req.uri());
    }
}
