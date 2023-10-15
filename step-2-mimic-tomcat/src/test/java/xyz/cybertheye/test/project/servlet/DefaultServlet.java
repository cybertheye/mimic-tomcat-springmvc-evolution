package xyz.cybertheye.test.project.servlet;

import xyz.cybertheye.http.MTRequest;
import xyz.cybertheye.http.MTResponse;
import xyz.cybertheye.servlet.MimicServlet;
import xyz.cybertheye.servlet.WebServlet;

import java.io.UnsupportedEncodingException;

/**
 * @description:
 */
@WebServlet("/*")
public class DefaultServlet extends MimicServlet {


    @Override
    public void service(MTRequest req, MTResponse response) throws UnsupportedEncodingException {
        super.service(req, response);



    }

    @Override
    protected void doPost(MTRequest req, MTResponse response) {

    }

    @Override
    protected void doGet(MTRequest req, MTResponse response) throws UnsupportedEncodingException {
        response.writeAndFlush("inside /*");
    }
}
