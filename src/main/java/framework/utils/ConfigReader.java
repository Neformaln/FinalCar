package framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by User on 22.06.2017.
 */
public class ConfigReader {
    private static final String MAIN_PROPERTY_PATH = "config.properties";

    public Properties readProperties(String path) {
        File ff = new File(getClass().getClassLoader().getResource(path).getFile());
        FileInputStream fis = null;
        Properties property = new Properties();
        try {
            fis = new FileInputStream(ff);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            property.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }

    public Properties initProperties() {
        Properties properties = readProperties(MAIN_PROPERTY_PATH);
        return properties;
    }

    }
