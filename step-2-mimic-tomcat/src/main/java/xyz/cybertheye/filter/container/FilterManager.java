package xyz.cybertheye.filter.container;

import xyz.cybertheye.filter.chain.Filter;

import java.util.List;
import java.util.Set;

/**
 * @description:
 */
public interface FilterManager {
    //Filter getSpecifedFilter(String uri);
    List<Filter> getSpecifedFilters(String uri);
    Set<String> getAllFilterUri();
}
