package com.example.web3.models;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static String configFolder = "jboss.server.config.dir";
    private static String propertyFile = "app.properties";
    private static String localPropertyFile = "C:\\studs\\programming\\web№3\\src\\main\\resources\\app.properties";

    public static String getProperty(String name) {
        Properties properties = new Properties();
        FileInputStream inputStream;
        String path = System.getProperty(configFolder);
        try {
            inputStream = new FileInputStream(path.concat("/").concat(propertyFile));
            properties.load(inputStream);
            return properties.getProperty(name);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
