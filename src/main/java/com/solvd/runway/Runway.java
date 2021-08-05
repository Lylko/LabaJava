package com.solvd.runway;

import com.solvd.aircraft.civil.Civil;
import com.solvd.aircraft.civil.airliner.Airbus;
import com.solvd.aircraft.civil.airliner.Trident;
import com.solvd.aircraft.civil.airliner.Xiangfeng;
import com.solvd.aircraft.civil.cargo.Beluga;
import com.solvd.aircraft.civil.cargo.Cossack;
import com.solvd.aircraft.civil.cargo.Globemaster;
import com.solvd.aircraft.military.Military;
import com.solvd.aircraft.military.bomber.Fencer;
import com.solvd.aircraft.military.bomber.Nighthawk;
import com.solvd.aircraft.military.bomber.Xian;
import com.solvd.aircraft.military.stormtrooper.Buccaneer;
import com.solvd.aircraft.military.stormtrooper.Dragonfly;
import com.solvd.aircraft.military.stormtrooper.Skyhawk;
import com.solvd.database.DataOperations;
import org.apache.log4j.Logger;

import java.util.*;

public class Runway {

    private final static Logger LOGGER = Logger.getLogger(Runway.class);

    private String runwayType;
    private int classNum;
    private String runwayName;
    private final double AIR_INDEX = 1.05;
    private List<Military> militaryList;
    private List<Civil> civilList;

    public Runway(){
        militaryList = new ArrayList<>();
        civilList = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Runway runway = (Runway) o;
        return Objects.equals(runwayType, runway.runwayType);
    }

    @Override
    public int hashCode() {
        int i = 0;
        int result = 0;

        while (i < runwayType.length()){
            result += 31 * runwayType.charAt(i) * (i + 1);
            i++;
        }
        return result;
    }

    public void setClassNum(int classNum){
        this.classNum = classNum;
    }

    public void setRunwayName(String name){
        this.runwayName = name;
    }

    public void setRunwayType(String name){
        this.runwayType = name;
    }

    public String getRunwayType(){
        return runwayType;
    }

    public String getRunwayName(){
        return runwayName;
    }

    public int getClassNum(){
        return this.classNum;
    }

    public void addExternalPlane(Civil plane){

        civilList.add(plane);

        civilList.sort(new Comparator<>() {
            @Override
            public int compare(Civil o1, Civil o2) {
                return o1.getPlaneName().compareTo(o2.getPlaneName());
            }
        });

        LOGGER.info("Aircraft " + plane.getPlaneName() + " created.");

    }

    public void addExternalPlane(Military plane){

        militaryList.add(plane);

        militaryList.sort(new Comparator<>() {
            @Override
            public int compare(Military o1, Military o2) {
                return o1.getPlaneName().compareTo(o2.getPlaneName());
            }
        });

        LOGGER.info("Aircraft " + plane.getPlaneName() + " created.");

    }


    public void addPlane(Civil plane, Runway runway){
        if (isPrintAccess(plane)){
            DataOperations.addToDB(runway, plane.getPlaneName());
            civilList.add(plane);

            civilList.sort(new Comparator<>() {
                @Override
                public int compare(Civil o1, Civil o2) {
                    return o1.getPlaneName().compareTo(o2.getPlaneName());
                }
            });

            LOGGER.info("Aircraft " + plane.getPlaneName() + " created.");
        } else {
            LOGGER.info(plane.getPlaneName() + " is not suitable for accommodation.");
        }
    }

    public void addPlane(Military plane, Runway runway){
        if (isPrintAccess(plane)){
            DataOperations.addToDB(runway, plane.getPlaneName());
            militaryList.add(plane);

            militaryList.sort(new Comparator<>() {
                @Override
                public int compare(Military o1, Military o2) {
                    return o1.getPlaneName().compareTo(o2.getPlaneName());
                }
            });

            LOGGER.info("Aircraft " + plane.getPlaneName() + " created.");
        } else {
            LOGGER.info(plane.getPlaneName() + " is not suitable for accommodation.");
        }
    }

    public List<Civil> getCivilList(){
        return civilList;
    }

    public List<Military> getMilitaryList(){
        return militaryList;
    }

    public boolean isPrintAccess(Military aircraft){
        double airClass = aircraft.getAirClass();
        return airClass <= (getClassNum() * AIR_INDEX);
    }

    public boolean isPrintAccess(Civil aircraft){
        double airClass = aircraft.getAirClass();
        return airClass <= (getClassNum() * AIR_INDEX);
    }

    public void printAircraftList(){

        if ( (civilList != null) && (civilList.size() > 0) ) {
            LOGGER.info("\n----------------------------Civil aircraft" +
                    "----------------------------\n");

            for (Civil aircraft : civilList) {
                LOGGER.info(aircraft.getPlaneName());
            }
        } else if (civilList != null){
            LOGGER.info("\n------No civil aircrafts------\n");

        } else {
            LOGGER.error("Runway list doesnt exist.");
        }

        if ( (civilList != null) && (militaryList.size() > 0) ) {
            LOGGER.info("\n----------------------------Military aircraft" +
                    "----------------------------\n");

            for (Military aircraft : militaryList) {
                LOGGER.info(aircraft.getPlaneName());
            }
        } else if (civilList != null){
            LOGGER.info("\n------No military aircrafts------\n");
        } else {
            LOGGER.error("Runway list doesnt exist.");
        }
    }

    public void createAircraft(Runway runway){
        LOGGER.info("\n-----Creating new aircraft-----");
        Scanner in = new Scanner(System.in);

        int i = 0;

        while (i == 0) {

            LOGGER.info("Choose type of aircraft: \n 0 - Civil, 1 - Military, e - Exit.");
            String choice = in.nextLine();

            if ("0".equals(choice)) {

                while (i == 0) {

                    LOGGER.info("Choose type of civil aircraft: " +
                            "\n 0 - Cargo, 1 - Airliner, e - Exit.");
                    String secondChoice = in.nextLine();

                    if ("0".equals(secondChoice)) {

                        while (i == 0) {

                            LOGGER.info("Choose cargo aircraft:" +
                                    "\n 0 - Beluga, 1 - Cossack, 2 - Globemaster, e - Exit.");
                            String cargoChoice = in.nextLine();

                            switch (cargoChoice) {
                                case "0":
                                    Beluga beluga = new Beluga();
                                    addPlane(beluga, runway);
                                    i = 1;
                                    break;
                                case "1":
                                    Cossack cossack = new Cossack();
                                    addPlane(cossack, runway);
                                    i = 1;
                                    break;
                                case "2":
                                    Globemaster globe = new Globemaster();
                                    addPlane(globe, runway);
                                    i = 1;
                                    break;
                                case "e":
                                    LOGGER.info("Exit from the program was initiated.");
                                    i = 1;
                                    break;
                                default:
                                    LOGGER.info("Incorrect value. Please, try again.");
                                    break;

                            }
                        }

                    } else if ("1".equals(secondChoice)) {

                        while (i == 0) {

                            LOGGER.info("Choose cargo aircraft:" +
                                    "\n 0 - Airbus, 1 - Xiangfeng, 2 - Trident, e - Exit.");
                            String airlinerChoice = in.nextLine();

                            switch (airlinerChoice) {
                                case "0":
                                    Airbus airbus = new Airbus();
                                    addPlane(airbus, runway);
                                    i = 1;
                                    break;
                                case "1":
                                    Xiangfeng xiangfeng = new Xiangfeng();
                                    addPlane(xiangfeng, runway);
                                    i = 1;
                                    break;
                                case "2":
                                    Trident trident = new Trident();
                                    addPlane(trident, runway);
                                    i = 1;
                                    break;
                                case "e":
                                    LOGGER.info("Exit from the program was initiated.");
                                    i = 1;
                                    break;
                                default:
                                    LOGGER.info("Incorrect value. Please, try again.");
                                    break;

                            }
                        }
                    } else if ("e".equals(secondChoice)) {
                        LOGGER.info("Exit from the program was initiated.");
                        i = 1;
                    } else {
                        LOGGER.info("Incorrect value. Please, try again.");
                    }
                }
            } else if ("1".equals(choice)) {

                while (i == 0) {

                    LOGGER.info("Choose type of military aircraft: " +
                            "\n 0 - Bomber, 1 - Stormtrooper, e - Exit.");
                    String secondChoice = in.nextLine();

                    if ("0".equals(secondChoice)) {

                        while (i == 0) {

                            LOGGER.info("Choose bomber aircraft:" +
                                    "\n 0 - Fencer, 1 - Nighthawk, 2 - Xian, e - Exit.");
                            String bomberChoice = in.nextLine();

                            switch (bomberChoice) {
                                case "0":
                                    Fencer fencer = new Fencer();
                                    addPlane(fencer, runway);
                                    i = 1;
                                    break;
                                case "1":
                                    Nighthawk nighthawk = new Nighthawk();
                                    addPlane(nighthawk, runway);
                                    i = 1;
                                    break;
                                case "2":
                                    Xian xian = new Xian();
                                    addPlane(xian, runway);
                                    i = 1;
                                    break;
                                case "e":
                                    LOGGER.info("Exit from the program was initiated.");
                                    i = 1;
                                    break;
                                default:
                                    LOGGER.info("Incorrect value. Please, try again.");
                                    break;

                            }
                        }

                    } else if ("1".equals(secondChoice)) {

                        while (i == 0) {

                            LOGGER.info("Choose stormtrooper aircraft:" +
                                    "\n 0 - Dragonfly, 1 - Buccaneer, 2 - Skyhawk, e - Exit.");
                            String stormChoice = in.nextLine();

                            switch (stormChoice) {
                                case "0":
                                    Dragonfly dragon = new Dragonfly();
                                    addPlane(dragon, runway);
                                    i = 1;
                                    break;
                                case "1":
                                    Buccaneer buccaneer = new Buccaneer();
                                    addPlane(buccaneer, runway);
                                    i = 1;
                                    break;
                                case "2":
                                    Skyhawk skyhawk = new Skyhawk();
                                    addPlane(skyhawk, runway);
                                    i = 1;
                                    break;
                                case "e":
                                    LOGGER.info("Exit from the program was initiated.");
                                    i = 1;
                                    break;
                                default:
                                    LOGGER.info("Incorrect value. Please, try again.");
                                    break;

                            }
                        }
                    } else if ("e".equals(secondChoice)) {
                        LOGGER.info("Exit from the program was initiated.");
                        i = 1;
                    } else {
                        LOGGER.info("Incorrect value. Please, try again.");
                    }
                }

            } else if ("e".equals(choice)) {
                LOGGER.info("Exit from the program was initiated.");
                i = 1;
            } else {
                LOGGER.info("Incorrect value. Please, try again.");
            }

        }
    }

}
