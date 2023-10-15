package xyz.cybertheye.handler;

import xyz.cybertheye.servlet.Servlet;

/**
 * @description:
 */

public interface RouteStrategy {
    Servlet route(String uri);
}
