package com.celleree.framework.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Loads framework settings from src/test/resources/config.properties.
 */
public final class ConfigReader {

    private static final String CONFIG_FILE = "config.properties";
    private static final Properties PROPERTIES = loadProperties();

    private ConfigReader() {
        // Utility class; prevent instantiation.
    }

    public static String get(String key) {
        String value = PROPERTIES.getProperty(key);

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Missing or blank configuration value for key: " + key);
        }

        return value.trim();
    }

    public static int getInt(String key) {
        String value = get(key);

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(
                    "Configuration value for key '" + key + "' must be a whole number, but was: " + value,
                    exception);
        }
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();

        try (InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (inputStream == null) {
                throw new IllegalStateException("Could not find " + CONFIG_FILE + " on the classpath.");
            }

            properties.load(inputStream);
            return properties;
        } catch (IOException exception) {
            throw new IllegalStateException("Could not load " + CONFIG_FILE + ".", exception);
        }
    }
}
