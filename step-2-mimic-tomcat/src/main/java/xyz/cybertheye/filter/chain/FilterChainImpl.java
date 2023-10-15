package xyz.cybertheye.filter.chain;

import xyz.cybertheye.http.MTRequest;
import xyz.cybertheye.http.MTResponse;
import xyz.cybertheye.servlet.Servlet;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @description:
 */
public class FilterChainImpl implements FilterChain {

    private FilterNode head = new FilterNode(); //soldier
    private FilterNode tail;

    private Servlet targetServlet;

    private FilterChainImpl(Servlet targetServlet) {
        this.targetServlet = targetServlet;
        tail = head;
    }

    public static FilterChain createFilterChain(Servlet targetServlet,List<Filter> filters){
        FilterChainImpl filterChain = new FilterChainImpl(targetServlet);
        filterChain.addLast(filters);
        return filterChain;
    }

    @Override
    public void addFirst(List<Filter> filters) {
        FilterNode pre = head.getNext();
        for (Filter filter : filters) {
            FilterNode filterNode = new FilterNode();
            filterNode.setFilter(filter);
            filterNode.setNext(pre);
            pre = filterNode;
        }

        head.setNext(pre);
    }

    @Override
    public void addLast(List<Filter> filters) {
        for (Filter filter : filters) {
            FilterNode filterNode = new FilterNode();
            filterNode.setFilter(filter);

            tail.setNext(filterNode);
            tail = filterNode;
        }

    }

    @Override
    public void start(MTRequest request, MTResponse response) {

        FilterNode traveler = head.getNext();
        try {
            while (traveler != null && traveler.exec(request, response)) {
                traveler=traveler.next;
            }

            targetServlet.service(request,response);

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }


    }
}
