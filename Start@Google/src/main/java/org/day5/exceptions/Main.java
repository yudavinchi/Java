package org.day5.exceptions;

import org.day5.exceptions.ConfigService.ConfigService;

import javax.swing.plaf.nimbus.NimbusStyle;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ConfigService configService = new ConfigService();

        configService.readFile("notRealPath.txt"); // default file will be created

        try {
            Map<String, String> temp = configService.getConfigData();
        } catch (NullPointerException nullPointerException) {
            System.out.println(nullPointerException);
        }

        configService.readFile("configFile.txt"); // default file will be created

        try {
            Map<String, String> temp = configService.getConfigData();
        } catch (NullPointerException nullPointerException) {
            System.out.println(nullPointerException);
        }

        try {
            System.out.println(configService.getConfigKey("test"));
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException);
        }

        try {
            System.out.println(configService.getConfigKey("field4"));
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException);
        }
    }
}
