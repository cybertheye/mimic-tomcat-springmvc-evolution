package xyz.cybertheye;

import xyz.cybertheye.filter.WebFilter;
import xyz.cybertheye.listener.WebListener;
import xyz.cybertheye.servlet.Servlet;
import xyz.cybertheye.servlet.WebServlet;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

/**
 * @description:
 */
public class WebComponentScanner implements ComponentScanner {

    private String[] scanPackages;

    public WebComponentScanner(String[] scanPackages) {
        this.scanPackages = scanPackages;
        scan();
    }

    private void scan() {
        try {
            for (String scanPackage : scanPackages) {
                scanSingle(scanPackage);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private void scanSingle(String scanPackage) throws IOException, URISyntaxException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String scanPath = scanPackage.replaceAll("\\.", "/");
        URL systemResources = ClassLoader.getSystemResource(scanPath);
        URI resourceUri = systemResources.toURI();
        File file = new File(resourceUri);
        iterateScan(file, scanPackage);
    }


    private void iterateScan(File file, String scanPackage) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        for (File listFile : file.listFiles()) {
            if (listFile.isDirectory()) {
                iterateScan(listFile, scanPackage + "." + listFile.getName());
            } else {
                String fileName = listFile.getName();
                if (fileName.endsWith(".class")) {
                    Class<?> clazz = Class.forName(scanPackage + "." + fileName.split("\\.")[0]);
                    WebServlet webServletAnno = clazz.getAnnotation(WebServlet.class);
                    WebFilter webFilterAnno = clazz.getAnnotation(WebFilter.class);
                    WebListener webListenerAnno = clazz.getAnnotation(WebListener.class);
                    if (webServletAnno != null) {
                        String[] uris = webServletAnno.value();
                        for (String uri : uris) {
                            webServletComponents.put(uri, clazz.getName());
                        }
                    }
                    if (webFilterAnno != null) {
                        String[] uris = webFilterAnno.value();
                        for (String uri : uris) {
                            Set<String> uriSet = webFilterComponents.getOrDefault(uri, new HashSet<>());
                            uriSet.add(clazz.getName());
                            webFilterComponents.put(uri,uriSet);
                        }
                    }
                    if (webListenerAnno != null) {
                        webListenerComponents.add(clazz.getName());
                    }
                }
            }
        }
    }


    private List<String> webListenerComponents = new ArrayList<>();
    private Map<String, String> webServletComponents = new HashMap<>();
    private Map<String, Set<String>> webFilterComponents = new HashMap<>();

    @Override
    public List<String> getWebListenerComponents() {
        return this.webListenerComponents;
    }

    @Override
    public Map<String, String> getWebServletComponents() {
        return this.webServletComponents;
    }

    @Override
    public Map<String, Set<String>> getWebFilterComponents() {
        return this.webFilterComponents;
    }
}
