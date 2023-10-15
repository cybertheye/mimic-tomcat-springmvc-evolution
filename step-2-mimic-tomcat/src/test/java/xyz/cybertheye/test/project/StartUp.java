package xyz.cybertheye.test.project;

import xyz.cybertheye.MimicTomcatServer;
import xyz.cybertheye.WebScanPackage;

/**
 * @description:
 */

@WebScanPackage
public class StartUp {
    public static void main(String[] args) {
        new MimicTomcatServer(9999).start(StartUp.class);
    }
}
