package xyz.cybertheye.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @description:
 */
@WebServlet(
        urlPatterns = {"/init"},
        loadOnStartup = 1,
        initParams = {
                @WebInitParam(name = "cy",value = "yeah")
        }
)
public class CyeServlet extends HttpServlet {
    private String state;
    @Override
    public void init(ServletConfig config) throws ServletException {
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        while(initParameterNames.hasMoreElements()){
            String s = initParameterNames.nextElement();
            System.out.println(s);
        }
        super.init(config);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("inside init method");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("inside cyeservlet");
    }
}
