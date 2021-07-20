package com.solvd.utils;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class Logging {

    final static Logger LOGGER = Logger.getLogger(Logging.class);

    public static ArrayList<String> registration(){
        Scanner in = new Scanner(System.in);

        LOGGER.info("You need to register before using:\n");
        ArrayList<String> values = new ArrayList<>();
        int i = 3;
        while (i > 0){
            LOGGER.info("Login (4-20 characters):");
            String choice = in.nextLine();
            if (choice != null && choice.length() >= 4 && choice.length() <= 20) {
                values.add(choice);
                i = 0;
            }
            i--;
        }
        if (values.size() < 1) {
            return values;
        }
        i=3;
        while (i > 0){
            LOGGER.info("Password (8-20 characters): ");
            String choice = in.nextLine();
            if (choice != null && choice.length() >= 8 && choice.length() <= 20) {
                values.add(choice);
                i = 0;
            }
        }
        return values;
    }

    public static boolean isRightPassword(){

        Scanner in = new Scanner(System.in);

        LOGGER.info("\n------------------------------\n");
        int j = 3;

        while (j > 0) {
            ArrayList<String> values = new ArrayList<>();
            int i = 3;
            while (i > 0) {
                LOGGER.info("Login (4-20 characters):");
                String choice = in.nextLine();
                if (choice != null && choice.length() >= 4 && choice.length() <= 20) {
                    if (choice.equals(PropertiesLoad.getValueFromProperties("login"))) {
                        values.add(choice);
                    }
                    i = 0;
                }
                i--;
            }
            i = 3;
            while (i > 0) {
                LOGGER.info("Password (8-20 characters): ");
                String choice = in.nextLine();
                if (choice != null && choice.length() >= 8 && choice.length() <= 20) {
                    if (choice.equals(PropertiesLoad.getValueFromProperties("password"))) {
                        values.add(choice);
                    }
                    i = 0;
                }
            }
            if (values.size() < 2){
                LOGGER.info("Login or password is not correct.");
                j--;
            } else {
                return true;
            }
        }
        LOGGER.info("\nToo many tries.");
        LOGGER.info("\n------------------------------\n");
        return false;

    }


}
