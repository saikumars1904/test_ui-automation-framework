package com.utility;

import com.constants.Env;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    //read properties file

    public static String readProperty(Env env, String propertieyName)  {
        File file = new File("config/"+env+".properties");
        Properties properties = new Properties();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            properties.load(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String value = properties.getProperty(propertieyName.toUpperCase());
        return value;

    }
}
