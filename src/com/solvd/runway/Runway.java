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

import java.util.*;

public abstract class Runway {

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
        return Objects.equals(runwayName, runway.runwayName);
    }

    @Override
    public int hashCode() {
        int i = 0;
        int result = 0;

        while (i < runwayName.length()){
            result += 31 * runwayName.charAt(i) * (i + 1);
            i++;
        }
        return result;
    }

    protected void setClassNum(int classNum){
        this.classNum = classNum;
    }

    protected void setRunwayName(String name){
        this.runwayName = name;
    }

    public String getRunwayName(){
        return runwayName;
    }

    public int getClassNum(){
        return this.classNum;
    }

    public void addPlane(Civil plane){
        if (isPrintAccess(plane)){
            civilList.add(plane);

            civilList.sort(new Comparator<Civil>() {
                @Override
                public int compare(Civil o1, Civil o2) {
                    return o1.getPlaneName().compareTo(o2.getPlaneName());
                }
            });

            System.out.println("Aircraft " + plane.getPlaneName() + " created.");
        } else {
            System.out.println(plane.getPlaneName() + " is not suitable for accommodation.");
        }
    }

    public void addPlane(Military plane){
        if (isPrintAccess(plane)){
            militaryList.add(plane);

            militaryList.sort(new Comparator<Military>() {
                @Override
                public int compare(Military o1, Military o2) {
                    return o1.getPlaneName().compareTo(o2.getPlaneName());
                }
            });

            System.out.println("Aircraft " + plane.getPlaneName() + " created.");
        } else {
            System.out.println(plane.getPlaneName() + " is not suitable for accommodation.");
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
            System.out.println("\n----------------------------Civil aircraft" +
                    "----------------------------\n");

            for (Civil aircraft : civilList) {
                System.out.println(aircraft.getPlaneName());
            }
        } else if (civilList != null){
            System.out.println("\n------No civil aircrafts------\n");
        } else {
            System.out.println("Runway list doesnt exist.");
        }

        if ( (civilList != null) && (militaryList.size() > 0) ) {
            System.out.println("\n----------------------------Military aircraft" +
                    "----------------------------\n");

            for (Military aircraft : militaryList) {
                System.out.println(aircraft.getPlaneName());
            }
        } else if (civilList != null){
            System.out.println("\n------No military aircrafts------\n");
        } else {
            System.out.println("Runway list doesnt exist.");
        }
    }

    public void createAircraft(){
        System.out.println("\n-----Creating new aircraft-----");
        Scanner in = new Scanner(System.in);

        int i = 0;

        while (i == 0) {

            System.out.println("Choose type of aircraft: \n 0 - Civil, 1 - Military, e - Exit.");
            String choice = in.nextLine();

            if ("0".equals(choice)) {

                while (i == 0) {

                    System.out.println("Choose type of civil aircraft: " +
                            "\n 0 - Cargo, 1 - Airliner, e - Exit.");
                    String secondChoice = in.nextLine();

                    if ("0".equals(secondChoice)) {

                        while (i == 0) {

                            System.out.println("Choose cargo aircraft:" +
                                    "\n 0 - Beluga, 1 - Cossack, 2 - Globemaster, e - Exit.");
                            String cargoChoice = in.nextLine();

                            switch (cargoChoice) {
                                case "0":
                                    Beluga beluga = new Beluga();
                                    addPlane(beluga);
                                    i = 1;
                                    break;
                                case "1":
                                    Cossack cossack = new Cossack();
                                    addPlane(cossack);
                                    i = 1;
                                    break;
                                case "2":
                                    Globemaster globe = new Globemaster();
                                    addPlane(globe);
                                    i = 1;
                                    break;
                                case "e":
                                    System.out.println("Exit from the program was initiated.");
                                    i = 1;
                                    break;
                                default:
                                    System.out.println("Incorrect value. Please, try again.");
                                    break;

                            }
                        }

                    } else if ("1".equals(secondChoice)) {

                        while (i == 0) {

                            System.out.println("Choose cargo aircraft:" +
                                    "\n 0 - Airbus, 1 - Xiangfeng, 2 - Trident, e - Exit.");
                            String airlinerChoice = in.nextLine();

                            switch (airlinerChoice) {
                                case "0":
                                    Airbus airbus = new Airbus();
                                    addPlane(airbus);
                                    i = 1;
                                    break;
                                case "1":
                                    Xiangfeng xiangfeng = new Xiangfeng();
                                    addPlane(xiangfeng);
                                    i = 1;
                                    break;
                                case "2":
                                    Trident trident = new Trident();
                                    addPlane(trident);
                                    i = 1;
                                    break;
                                case "e":
                                    System.out.println("Exit from the program was initiated.");
                                    i = 1;
                                    break;
                                default:
                                    System.out.println("Incorrect value. Please, try again.");
                                    break;

                            }
                        }
                    } else if ("e".equals(secondChoice)) {
                        System.out.println("Exit from the program was initiated.");
                        i = 1;
                    } else {
                        System.out.println("Incorrect value. Please, try again.");
                    }
                }
            } else if ("1".equals(choice)) {

                while (i == 0) {

                    System.out.println("Choose type of military aircraft: " +
                            "\n 0 - Bomber, 1 - Stormtrooper, e - Exit.");
                    String secondChoice = in.nextLine();

                    if ("0".equals(secondChoice)) {

                        while (i == 0) {

                            System.out.println("Choose bomber aircraft:" +
                                    "\n 0 - Fencer, 1 - Nighthawk, 2 - Xian, e - Exit.");
                            String bomberChoice = in.nextLine();

                            switch (bomberChoice) {
                                case "0":
                                    Fencer fencer = new Fencer();
                                    addPlane(fencer);
                                    i = 1;
                                    break;
                                case "1":
                                    Nighthawk nighthawk = new Nighthawk();
                                    addPlane(nighthawk);
                                    i = 1;
                                    break;
                                case "2":
                                    Xian xian = new Xian();
                                    addPlane(xian);
                                    i = 1;
                                    break;
                                case "e":
                                    System.out.println("Exit from the program was initiated.");
                                    i = 1;
                                    break;
                                default:
                                    System.out.println("Incorrect value. Please, try again.");
                                    break;

                            }
                        }

                    } else if ("1".equals(secondChoice)) {

                        while (i == 0) {

                            System.out.println("Choose stormtrooper aircraft:" +
                                    "\n 0 - Dragonfly, 1 - Buccaneer, 2 - Skyhawk, e - Exit.");
                            String stormChoice = in.nextLine();

                            switch (stormChoice) {
                                case "0":
                                    Dragonfly dragon = new Dragonfly();
                                    addPlane(dragon);
                                    i = 1;
                                    break;
                                case "1":
                                    Buccaneer buccaneer = new Buccaneer();
                                    addPlane(buccaneer);
                                    i = 1;
                                    break;
                                case "2":
                                    Skyhawk skyhawk = new Skyhawk();
                                    addPlane(skyhawk);
                                    i = 1;
                                    break;
                                case "e":
                                    System.out.println("Exit from the program was initiated.");
                                    i = 1;
                                    break;
                                default:
                                    System.out.println("Incorrect value. Please, try again.");
                                    break;

                            }
                        }
                    } else if ("e".equals(secondChoice)) {
                        System.out.println("Exit from the program was initiated.");
                        i = 1;
                    } else {
                        System.out.println("Incorrect value. Please, try again.");
                    }
                }

            } else if ("e".equals(choice)) {
                System.out.println("Exit from the program was initiated.");
                i = 1;
            } else {
                System.out.println("Incorrect value. Please, try again.");
            }

        }
    }

}
