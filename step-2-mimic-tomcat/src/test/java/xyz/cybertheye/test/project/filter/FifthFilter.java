package xyz.cybertheye.test.project.filter;

import xyz.cybertheye.filter.WebFilter;
import xyz.cybertheye.filter.chain.Filter;
import xyz.cybertheye.http.MTRequest;
import xyz.cybertheye.http.MTResponse;

import java.io.UnsupportedEncodingException;


/**
 * @description:
 */
@WebFilter("/hello/b")
public class FifthFilter implements Filter {
    @Override
    public boolean doFilter(MTRequest request, MTResponse response) throws UnsupportedEncodingException {
        response.write("pass filter /hello/b");
        return true;
    }
}
