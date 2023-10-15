package xyz.cybertheye.test;

import org.junit.Test;
import xyz.cybertheye.MimicTomcatServer;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @description:
 */
public class TestMimicTomcat {

    @Test
    public void test() throws IOException, URISyntaxException {
        URL systemResources = ClassLoader.getSystemResource("xyz/cybertheye/test/project/servlet");
        File file1 = new File(systemResources.toURI());
        System.out.println(file1.getPath());




    }

}
