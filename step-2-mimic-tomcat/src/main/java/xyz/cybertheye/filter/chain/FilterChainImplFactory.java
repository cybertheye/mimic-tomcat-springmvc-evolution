package xyz.cybertheye.filter.chain;

import xyz.cybertheye.ComponentScanner;
import xyz.cybertheye.filter.container.FilterManager;
import xyz.cybertheye.filter.container.FilterManagerImplFactory;
import xyz.cybertheye.servlet.Servlet;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 */
public class FilterChainImplFactory {
    private FilterChainImplFactory(){}

    
    public static Chain createFilterChain(Servlet servlet, String uri, ComponentScanner scanner){
        //
        FilterManager filterManager = FilterManagerImplFactory.getFilterManager(scanner);
        List<Filter> filterList = filterManager.getSpecifedFilters(uri);

        return FilterChainImpl.createFilterChain(servlet,filterList);
    }
}
