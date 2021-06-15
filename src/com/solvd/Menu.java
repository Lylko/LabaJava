package com.solvd;

import com.solvd.aircraft.civil.airliner.Airbus;
import com.solvd.aircraft.civil.airliner.Trident;
import com.solvd.aircraft.civil.airliner.Xiangfeng;
import com.solvd.aircraft.civil.cargo.Beluga;
import com.solvd.aircraft.civil.cargo.Cossack;
import com.solvd.aircraft.civil.cargo.Globemaster;
import com.solvd.aircraft.military.bomber.Fencer;
import com.solvd.aircraft.military.bomber.Nighthawk;
import com.solvd.aircraft.military.bomber.Xian;
import com.solvd.aircraft.military.stormtrooper.Buccaneer;
import com.solvd.aircraft.military.stormtrooper.Dragonfly;
import com.solvd.aircraft.military.stormtrooper.Skyhawk;
import com.solvd.runway.Airport;
import com.solvd.runway.Runway;
import com.solvd.runway.flex.HighFlex;
import com.solvd.runway.flex.LowFlex;
import com.solvd.runway.flex.MediumFlex;
import com.solvd.runway.flex.ULowFlex;
import com.solvd.runway.rigid.HighRigid;
import com.solvd.runway.rigid.LowRigid;
import com.solvd.runway.rigid.MediumRigid;
import com.solvd.runway.rigid.ULowRigid;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private Map<String, Runway> runwayMap;
    private Airport airport;

    public Menu(){
        airport = new Airport();
        runwayMap = airport.getRunwayList();
    }

    public void showStartMenu(){

        Scanner in = new Scanner(System.in);

        int i = 3;

        if (isRunwayExist()) {

            String runwayChoice;

            while (i > 0) {
                System.out.println("\nChoose what you want to do: " +
                        "\n1 - Create new runway,\n2 - Add aircraft to runway," +
                        "\n3 - show created aircrafts,\n4 - show available runways," +
                        "\ne - exit.");

                String choice = in.nextLine();
                switch (choice) {
                    case "1":
                        createRunway();
                        i = checkExit();
                        break;
                    case "2":
                        runwayChoice = chooseRunway();
                        if (!"error".equals(runwayChoice)) {
                            addAircraft(runwayMap.get(runwayChoice));
                        } else {
                            System.out.println("Please, try again later.");
                        }
                        i = checkExit();
                        break;
                    case "3":
                        runwayChoice = chooseRunway();
                        if (!"error".equals(runwayChoice)) {
                            runwayMap.get(runwayChoice).printAircraftList();
                        } else {
                            System.out.println("Please, try again later.");
                        }
                        i = checkExit();
                        break;
                    case "4":
                        airport.printRunwayList();
                        i = checkExit();
                        break;
                    case "e":
                        i = 0;
                        break;
                    default:
                        System.out.println("Incorrect value. Please, try again.");
                        i--;
                        break;
                }
            }
        }

        System.out.println("--------End of program--------");
    }

    private boolean isRunwayExist(){

        Scanner in = new Scanner(System.in);
        if (runwayMap.size() > 0){
            return true;
        } else {
            int i = 3;
            while (i > 0){

                System.out.println("First of all you need to create minimum 1 runway." +
                        "\n1 - Create runway,\ne - exit.");
                String choice = in.nextLine();

                if ("1".equals(choice)){
                    createRunway();
                    return true;
                } else if ("e".equals(choice)){
                    return false;
                } else {
                    System.out.println("Incorrect value. Please, try again.\n");
                    i--;
                }
            }
            return false;
        }
    }

    private int checkExit(){
        Scanner in = new Scanner(System.in);
        int i = 3;

        while(i > 0) {
            System.out.println("\nDo you want to make something else?\ny - yes,\nn - no.");
            String choice = in.nextLine();
            if ("y".equals(choice)) {
                return 3;
            } else if ("n".equals(choice)) {
                return 0;
            } else {
                System.out.println("Incorrect value. Please, try again.\n");
                i--;
            }
        }

        return 0;
    }

    private String chooseRunway(){

        Scanner in = new Scanner(System.in);
        int i = 3;

        while (i > 0) {
            System.out.println("\nChoose runway, which you want to use:");
            airport.printRunwayList();
            int choice = in.nextInt();

            if ((choice <= runwayMap.size()) && (choice > 0)) {
                int j = 1;
                for (String name : runwayMap.keySet()){
                    if (choice == j){
                        return name;
                    }
                    j++;
                }
            } else {
                System.out.println("Incorrect value. Please, try again later.");
                i--;
            }
        }

        return "error";
    }

    private void createRunway(){
        Scanner in = new Scanner(System.in);
        int i = 3;

        while (i > 0){
            System.out.println("\nWhat type of runway you wonna create?\n1 - Flex,\n2 - Rigid," +
                    "\ne - exit.");
            String choice = in.nextLine();

            if ("1".equals(choice)){
                i = 3;

                while (i > 0) {

                    System.out.println("\nChoose type of flex runway:\n1 - HighFlex,\n2 - MediumFlex," +
                            "\n3 - LowFlex,\n4 - ULowFlex,\ne - exit.");
                    String typeChoice = in.nextLine();

                    switch (typeChoice) {
                        case "1":
                            HighFlex highFlex = new HighFlex();
                            airport.addRunway(highFlex);
                            i = 0;
                            break;
                        case "2":
                            MediumFlex mediumFlex = new MediumFlex();
                            airport.addRunway(mediumFlex);
                            i = 0;
                            break;
                        case "3":
                            LowFlex lowFlex = new LowFlex();
                            airport.addRunway(lowFlex);
                            i = 0;
                            break;
                        case "4":
                            ULowFlex uLowFlex = new ULowFlex();
                            airport.addRunway(uLowFlex);
                            i = 0;
                            break;
                        case "e":
                            i = 0;
                            System.out.println("Exit from the program was initiated.");
                        default:
                            System.out.println("Incorrect value. Please, try again.");
                            i--;

                    }
                }

            } else if ("2".equals(choice)){
                i = 3;

                while (i > 0) {

                    System.out.println("\nChoose type of rigid runway:\n1 - HighRigid,\n2 - MediumRigid," +
                            "\n3 - LowRigid,\n4 - ULowRigid,\ne - exit.");
                    String typeChoice = in.nextLine();

                    switch (typeChoice) {
                        case "1":
                            HighRigid highRigid = new HighRigid();
                            airport.addRunway(highRigid);
                            i = 0;
                            break;
                        case "2":
                            MediumRigid mediumRigid = new MediumRigid();
                            airport.addRunway(mediumRigid);
                            i = 0;
                            break;
                        case "3":
                            LowRigid lowRigid = new LowRigid();
                            airport.addRunway(lowRigid);
                            i = 0;
                            break;
                        case "4":
                            ULowRigid uLowRigid = new ULowRigid();
                            airport.addRunway(uLowRigid);
                            i = 0;
                            break;
                        case "e":
                            i = 0;
                            System.out.println("Exit from the program was initiated.");
                        default:
                            System.out.println("Incorrect value. Please, try again.");
                            i--;
                    }
                }

            } else if ("e".equals(choice)){
                i = 0;
                System.out.println("Exit from the program was initiated.");
            } else {
                System.out.println("Incorrect value. Please, try again.\n");
                i--;
            }
        }
    }

    private void addAircraft(Runway runway){
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
                                    runway.addPlane(beluga);
                                    i = 1;
                                    break;
                                case "1":
                                    Cossack cossack = new Cossack();
                                    runway.addPlane(cossack);
                                    i = 1;
                                    break;
                                case "2":
                                    Globemaster globe = new Globemaster();
                                    runway.addPlane(globe);
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
                                    runway.addPlane(airbus);
                                    i = 1;
                                    break;
                                case "1":
                                    Xiangfeng xiangfeng = new Xiangfeng();
                                    runway.addPlane(xiangfeng);
                                    i = 1;
                                    break;
                                case "2":
                                    Trident trident = new Trident();
                                    runway.addPlane(trident);
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
                                    runway.addPlane(fencer);
                                    i = 1;
                                    break;
                                case "1":
                                    Nighthawk nighthawk = new Nighthawk();
                                    runway.addPlane(nighthawk);
                                    i = 1;
                                    break;
                                case "2":
                                    Xian xian = new Xian();
                                    runway.addPlane(xian);
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
                                    runway.addPlane(dragon);
                                    i = 1;
                                    break;
                                case "1":
                                    Buccaneer buccaneer = new Buccaneer();
                                    runway.addPlane(buccaneer);
                                    i = 1;
                                    break;
                                case "2":
                                    Skyhawk skyhawk = new Skyhawk();
                                    runway.addPlane(skyhawk);
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
