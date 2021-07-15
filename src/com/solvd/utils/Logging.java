package com.solvd.utils;

import java.util.ArrayList;
import java.util.Scanner;

public class Logging {

    public static ArrayList<String> registration(){
        Scanner in = new Scanner(System.in);

        System.out.println("You need to register before using:\n");
        ArrayList<String> values = new ArrayList<>();
        int i = 3;
        while (i > 0){
            System.out.println("Login (4-20 characters):");
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
            System.out.println("Password (8-20 characters): ");
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

        System.out.println("\n------------------------------\n");
        int j = 3;

        while (j > 0) {
            ArrayList<String> values = new ArrayList<>();
            int i = 3;
            while (i > 0) {
                System.out.println("Login (4-20 characters):");
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
                System.out.println("Password (8-20 characters): ");
                String choice = in.nextLine();
                if (choice != null && choice.length() >= 8 && choice.length() <= 20) {
                    if (choice.equals(PropertiesLoad.getValueFromProperties("password"))) {
                        values.add(choice);
                    }
                    i = 0;
                }
            }
            if (values.size() < 2){
                System.out.println("Login or password is not correct.");
                j--;
            } else {
                return true;
            }
        }
        System.out.println("\nToo many tries.");
        System.out.println("\n------------------------------\n");
        return false;

    }


}
