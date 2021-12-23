package com.company.homeworks.homework15.JDBC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public final class PropertiesManager {

    private static final Properties properties = new Properties();
    public static final String RESOURCES = "resources";
    public static final String HOMEWORK_15 = "homework15";
    public static final String DB_PROPERTIES = "db.properties";

    private PropertiesManager() {
        throw new UnsupportedOperationException();
    }

    static {
        try {
            properties.load(Files.newInputStream(Path.of(RESOURCES, HOMEWORK_15, DB_PROPERTIES)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPropertyByKey(String key) {
        return properties.getProperty(key);
    }
}