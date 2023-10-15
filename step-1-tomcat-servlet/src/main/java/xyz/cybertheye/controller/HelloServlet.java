package xyz.cybertheye.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @description:
 */
public class HelloServlet extends HttpServlet {

    /**
     * /admin/login
     * /admin/show
     * @param req   the {@link HttpServletRequest} object that
     *                  contains the request the client made of
     *                  the servlet
     *
     * @param res   the {@link HttpServletResponse} object that
     *                  contains the response the servlet returns
     *                  to the client
     *
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;

        String method = request.getMethod();
        if("GET".equals(method)){
            doGet((HttpServletRequest) req, (HttpServletResponse) res);
        }
        else if("POST".equals(method)){
            doPost(request, (HttpServletResponse) res);
        }
        //分发方法

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String methodName = uri.substring(uri.lastIndexOf("/")+1);


        if("login".equals(methodName)){
            login(req,resp);
            return;
        }
        if("world".equals(methodName)){
            hello(req,resp);
            return;
        }

    }

    private void hello(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getServletContext().setAttribute("tomorrow","better");
        req.getSession().invalidate();
        resp.getWriter().println("hello world");
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //
        if(validate(req)){
            HttpSession session = req.getSession();
            session.setAttribute("auth","ok");

            Cookie cookie = new Cookie("auth2", "ok2");
            resp.addCookie(cookie);

            resp.setHeader("Set-Cookie","auth3=ok3");


        }
        resp.getWriter().println("login sucessfully");
    }

    private boolean validate(HttpServletRequest req) {
        //?user=xxx&password=xxx
        //mysql
        return true;
    }
}
