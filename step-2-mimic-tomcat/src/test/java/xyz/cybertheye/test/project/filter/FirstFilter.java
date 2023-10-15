package xyz.cybertheye.test.project.filter;

import xyz.cybertheye.filter.chain.Filter;
import xyz.cybertheye.filter.WebFilter;
import xyz.cybertheye.http.MTRequest;
import xyz.cybertheye.http.MTResponse;

import java.io.UnsupportedEncodingException;

/**
 * @description:
 */
@WebFilter("/*")
public class FirstFilter implements Filter {

    @Override
    public boolean doFilter(MTRequest request, MTResponse response) throws UnsupportedEncodingException {
        response.write("pass filter /*");
        return true;
    }
}
