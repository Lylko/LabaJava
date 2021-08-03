package com.solvd.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.runway.Airport;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class JsonExec {

    private final static Logger LOGGER = Logger.getLogger(JsonExec.class);

    public static String convertJavaToJsonStr(Object obj) {

        String jsonStr = "";

        try {
            jsonStr = new ObjectMapper().writeValueAsString(obj);
            LOGGER.info("Converted to JSON string!");

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonStr;
    }

    public static void convertJavaToJsonFile(Object obj, String pathToFile) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(Paths.get(pathToFile).toFile(), obj);
            LOGGER.info("Converted to file!");

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static Airport convertJsonStrToAirportClass(String pathToFile) {

        Airport airport = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            airport  = mapper.readValue(new File(pathToFile), Airport.class);
            LOGGER.info("Converted from file to class!");

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return airport;
    }


}
