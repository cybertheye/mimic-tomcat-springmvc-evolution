package xyz.cybertheye.filter.chain;

import xyz.cybertheye.http.MTRequest;
import xyz.cybertheye.http.MTResponse;

import java.io.UnsupportedEncodingException;

/**
 * @description:
 */

public interface Filter {
    boolean doFilter(MTRequest request, MTResponse response) throws UnsupportedEncodingException;
}
