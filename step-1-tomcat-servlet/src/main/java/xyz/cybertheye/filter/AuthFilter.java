package xyz.cybertheye.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @description:
 */
@WebFilter("/hello/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String requestURI = req.getRequestURI();
        //login
        if (!requestURI.endsWith("login") && !validate(request)) {
            response.getWriter().println("no authority, please login first");
            return;
        }

        chain.doFilter(request, response);

        System.out.println("filter after");
    }

    private boolean validate(ServletRequest request) {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        String authInfo = (String) session.getAttribute("auth");
        if ("ok".equals(authInfo)) {
            return true;
        }
        return false;
    }

    @Override
    public void destroy() {

    }
}
