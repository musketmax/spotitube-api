package com.thomas.spotitube.data.properties;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SingletonDatabaseProperties {
    private Properties props;
    private Logger logger;
    private static SingletonDatabaseProperties instance;

    private SingletonDatabaseProperties() {
        logger = Logger.getLogger(getClass().getName());
        props = new Properties();

        loadProperties();
    }

    public static SingletonDatabaseProperties getInstance() {
        if (instance == null) {
            instance = new SingletonDatabaseProperties();
        }

        return instance;
    }

    public String database()
    {
        return props.getProperty("database");
    }

    public String connectionString()
    {
        return props.getProperty("connectionString");
    }

    public void loadProperties() {
        try {
            props.load(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("database.properties")));
        } catch (IOException exception) {
            logger.log(Level.SEVERE, "-- Error: cannot find database configuration!", exception);
        }
    }
}