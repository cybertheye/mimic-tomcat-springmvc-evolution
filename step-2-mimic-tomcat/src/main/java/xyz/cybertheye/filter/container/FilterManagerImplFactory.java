package xyz.cybertheye.filter.container;

import xyz.cybertheye.ComponentScanner;

/**
 * @description:
 */
public class FilterManagerImplFactory {
    private FilterManagerImplFactory(){}

    public static FilterManager getFilterManager(ComponentScanner scanner){
        return FilterManagerImpl.getInstance(scanner);
    }
}
