package project.tms.daoLayer.databaseLayer.Connection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesManager {

    private static final Properties properties = new Properties();
    public static final String RESOURCES = "resources";
    public static final String DB_PROPERTIES = "db.properties";

    private PropertiesManager() {
        throw new UnsupportedOperationException();
    }

    static {
        try {
            Class.forName("org.postgresql.Driver");
            ClassLoader classLoader = PropertiesManager.class.getClassLoader();
            InputStream resourceAsStream = classLoader.getResourceAsStream(DB_PROPERTIES);
            properties.load(resourceAsStream);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getPropertyByKey(String key) {
        return properties.getProperty(key);
    }
}