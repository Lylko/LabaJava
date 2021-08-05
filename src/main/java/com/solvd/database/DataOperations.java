package com.solvd.database;

import com.solvd.aircraft.civil.airliner.Airliner;
import com.solvd.aircraft.civil.cargo.Cargo;
import com.solvd.aircraft.military.bomber.Bomber;
import com.solvd.aircraft.military.stormtrooper.Stormtrooper;
import com.solvd.database.Connector;
import com.solvd.runway.Airport;
import com.solvd.runway.Runway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DataOperations {

    public static Airport loadRunway(Airport airport, String runwayName){

        Connection conn = Connector.connect();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT DISTINCT * FROM based_aircrafts, runway WHERE" +
                    " based_aircrafts.runway_name = '" + runwayName + "' AND based_aircrafts.runway_type = " +
                    "runway.type");

            Runway runway = new Runway();
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                runway.setRunwayName(rs.getString(2));
                runway.setRunwayType(rs.getString(4));
                runway.setClassNum(rs.getInt(7));
            }


            pst = conn.prepareStatement("SELECT military.aircraft_type, military.aircraft_name, military.country," +
                    " military.max_speed, military.max_height,military.class FROM based_aircrafts, military WHERE" +
                    " based_aircrafts.runway_name = '" + runwayName + "' AND based_aircrafts.aircraft_name = " +
                    "military.aircraft_name;");

            rs = pst.executeQuery();

            while (rs.next()){
                if ("Stormtrooper".equals(rs.getString(1))){
                    Stormtrooper aircraft = new Stormtrooper();
                    aircraft.setPlaneName(rs.getString(2));
                    aircraft.setCountryName(rs.getString(3));
                    aircraft.setMaxSpeed(rs.getInt(4));
                    aircraft.setMaxHeight(rs.getInt(5));
                    aircraft.setAirClass(rs.getInt(6));
                    runway.addExternalPlane(aircraft);
                } else {
                    Bomber aircraft = new Bomber();
                    aircraft.setPlaneName(rs.getString(2));
                    aircraft.setCountryName(rs.getString(3));
                    aircraft.setMaxSpeed(rs.getInt(4));
                    aircraft.setMaxHeight(rs.getInt(5));
                    aircraft.setAirClass(rs.getInt(6));
                    runway.addExternalPlane(aircraft);
                }

            }

            pst = conn.prepareStatement("SELECT civil.aircraft_type, civil.aircraft_name, civil.country," +
                    " civil.max_speed, civil.class FROM based_aircrafts, civil WHERE" +
                    " based_aircrafts.runway_name = '" + runwayName + "' AND based_aircrafts.aircraft_name = " +
                    "civil.aircraft_name;");

            rs = pst.executeQuery();

            while (rs.next()){
                if ("Cargo".equals(rs.getString(1))){
                    Cargo aircraft = new Cargo();
                    aircraft.setPlaneName(rs.getString(2));
                    aircraft.setCountryName(rs.getString(3));
                    aircraft.setMaxSpeed(rs.getInt(4));
                    aircraft.setAirClass(rs.getInt(5));
                    runway.addExternalPlane(aircraft);
                } else {
                    Airliner aircraft = new Airliner();
                    aircraft.setPlaneName(rs.getString(2));
                    aircraft.setCountryName(rs.getString(3));
                    aircraft.setMaxSpeed(rs.getInt(4));
                    aircraft.setAirClass(rs.getInt(5));
                    runway.addExternalPlane(aircraft);
                }
            }

            airport.addExternalRunway(runway);

            return airport;


        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println("Something going wrong. No changes.");
        return airport;

    }

    public static String chooseExternalRunway(){

        Connection conn = Connector.connect();
        int i = 3;

        while (i >= 0) {
            System.out.println("--------------------------------------\n" +
                    "Write runway name, which you want to copy: ");
            Scanner in = new Scanner(System.in);
            String choice = in.nextLine();

            try {
                PreparedStatement pst = conn.prepareStatement("SELECT DISTINCT COUNT(id) FROM " +
                        "based_aircrafts WHERE runway_name = '" + choice + "'");

                int count = 0;
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    count = rs.getInt(1);
                }

                if (count >= 1){
                    i = 0;
                    System.out.println("Runway exist! Downloading runway details.");
                    return choice;
                } else {
                    System.out.println("Incorrect runway name! Please, try again.");
                    i--;
                }

            } catch (SQLException ex) {
                i = 0;
                System.out.println(ex.getMessage());
            }

        }

        System.out.println("Something going wrong. No changes.");
        return "error";

    }

    public static void removeExternalRunway(String name){
        Connection conn = Connector.connect();
        System.out.println("Runway exist! Enter name of this runway to confirm removing.");
        Scanner in = new Scanner(System.in);
        String confirm = in.nextLine();
        if (name.equals(confirm)) {
            try {
                PreparedStatement pst = conn.prepareStatement("DELETE FROM based_aircrafts" +
                        " WHERE runway_name = '" + name + "'");
                pst.executeQuery();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static boolean isRunwayExist(String name){
        Connection conn = Connector.connect();

        try{
            PreparedStatement pst = conn.prepareStatement("SELECT DISTINCT COUNT(id) FROM " +
                    "based_aircrafts WHERE runway_name = '" + name + "'");
            ResultSet rs = pst.executeQuery();
            int count = 0;
            while (rs.next()){
                count = rs.getInt(1);
            }
            return count>=1;
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public static void addTobd(Runway runway, String aircraftName) {

        Connection conn = Connector.connect();

        try {
            PreparedStatement pst = conn.prepareStatement("INSERT INTO based_aircrafts (runway_name, " +
                    "aircraft_name, runway_type) VALUES ('" + runway.getRunwayName() + "', '" + aircraftName +
                    "', '" + runway.getRunwayType() + "')");

            pst.executeQuery();

            pst.close();
            conn.close();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

}
