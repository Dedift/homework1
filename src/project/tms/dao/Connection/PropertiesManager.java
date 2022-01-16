package project.tms.dao.Connection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public final class PropertiesManager {

    private static final Properties properties = new Properties();
    public static final String RESOURCES = "resources";
    public static final String PROJECT = "project";
    public static final String DB_PROPERTIES = "db.properties";

    private PropertiesManager() {
        throw new UnsupportedOperationException();
    }

    static {
        try {
            properties.load(Files.newInputStream(Path.of(RESOURCES, PROJECT, DB_PROPERTIES)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPropertyByKey(String key) {
        return properties.getProperty(key);
    }
}