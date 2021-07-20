package com.solvd.utils;

import com.solvd.runway.Airport;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class PropertiesLoad {

    public static String getValueFromProperties (String key){

        Properties properties = new Properties();
        FileInputStream fileInp = null;

        try {
            fileInp = new FileInputStream("src/main/resources/config.properties");
            properties.load(fileInp);
            return properties.getProperty(key);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return "default";
    }

    public static void setValueFromProperties (ArrayList<String> values) {

        Properties properties = new Properties();

        try {
            FileOutputStream fileOut = new FileOutputStream("src/main/resources/config.properties");
            properties.setProperty("login", values.get(0));
            properties.setProperty("password", values.get(1));
            properties.store(fileOut, "");
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

}

