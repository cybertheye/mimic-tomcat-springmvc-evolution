package xyz.cybertheye.filter.chain;

import xyz.cybertheye.http.MTRequest;
import xyz.cybertheye.http.MTResponse;

/**
 * @description:
 */

public interface Chain {
    void start(MTRequest request, MTResponse response);
}
