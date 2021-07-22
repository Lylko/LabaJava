package com.solvd.runway;

import com.solvd.runway.flex.HighFlex;
import com.solvd.runway.flex.LowFlex;
import com.solvd.runway.flex.MediumFlex;
import com.solvd.runway.flex.ULowFlex;
import com.solvd.runway.rigid.HighRigid;
import com.solvd.runway.rigid.LowRigid;
import com.solvd.runway.rigid.MediumRigid;
import com.solvd.runway.rigid.ULowRigid;
import org.apache.log4j.Logger;

import java.util.*;

public class Airport {

    final static Logger LOGGER = Logger.getLogger(Airport.class);

    private Map<String,Runway> runwayMap;
    private Set<Runway> runwaySet;

    public Airport(){
        runwayMap = new HashMap<>();
        runwaySet = new HashSet<>();
    }

    public void addRunway(Runway runway){
        Scanner in = new Scanner(System.in);

        int i = 3;
        while (i > 0) {
            System.out.println("\nPlease, give name for this runway.");
            String name = in.nextLine();

            if ((runwayMap != null) && (runwayMap.size() > 0)) {
                if (runwayMap.containsKey(name)) {
                    LOGGER.info("This name already exist. Please, try to put another.");
                } else if ("error".equals(name)){
                    LOGGER.info("This name cannot be used. Please, try to put another.");
                } else {
                    runwayMap.put(name, runway);
                    addToSet(runway);
                    i = 0;
                    LOGGER.info("Created new runway '" + runway.getRunwayType() + "'.");
                }
            } else if (runwayMap != null) {
                runwayMap.put(name, runway);
                addToSet(runway);
                i = 0;
                LOGGER.info("Created new runway '" + runway.getRunwayType() + "'.");
            } else {
                LOGGER.info("Runway list doesnt exist.");
            }
            i--;
        }
        if (i == 0) {
            LOGGER.info("\n---Creating failed.---\n");
        }



    }

    public Map<String,Runway> getRunwayList(){
        return runwayMap;
    }

    public void removeRunway(String name){
        if ( (runwayMap != null) && (runwayMap.size() > 1) ){
            runwayMap.remove(name);
            LOGGER.info(name + " successfully deleted.\n");
        } else if (runwayMap != null){
            LOGGER.info("\nYou need to have more than 1 runway to make this operation.\n");
        } else {
            LOGGER.error("Runway list doesnt exist.");
        }
    }

    public void printRunwayList(){
        if ( (runwayMap != null) && (runwayMap.size() > 0) ) {
            LOGGER.info("\n===========================");
            int i = 1;
            for (String name : runwayMap.keySet()) {
                LOGGER.info(i + " - " + name + " (" + runwayMap.get(name).getRunwayType() + ")");
                i++;
            }
            LOGGER.info("===========================");
        } else if (runwayMap != null) {
            LOGGER.info("Runway list don't have any object.");
        } else {
            LOGGER.error("Runway list doesnt exist.");
        }
    }

    public boolean isRunwayExist(){

        Scanner in = new Scanner(System.in);
        if (runwayMap.size() > 0){
            return true;
        } else {
            int i = 3;
            while (i > 0){

                LOGGER.info("First of all you need to create minimum 1 runway." +
                        "\n1 - Create runway,\ne - exit.");
                String choice = in.nextLine();

                if ("1".equals(choice)){
                    createRunway();
                    return true;
                } else if ("e".equals(choice)){
                    return false;
                } else {
                    LOGGER.info("Incorrect value. Please, try again.\n");
                    i--;
                }
            }
            return false;
        }
    }

    public String chooseRunway(){

        Scanner in = new Scanner(System.in);
        int i = 3;

        while (i > 0) {
            LOGGER.info("\nChoose runway, which you want to use:");
            printRunwayList();
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
                LOGGER.info("Incorrect value. Please, try again later.");
                i--;
            }
        }

        return "error";
    }

    private void addToSet(Runway runway){
        runwaySet.add(runway);
    }

    public void printAllTypes(){
        LOGGER.info("====================");

        for (Runway runway : runwaySet){
            LOGGER.info(runway.getRunwayType());
        }
        LOGGER.info("===================");
    }

    public void createRunway(){
        Scanner in = new Scanner(System.in);
        int i = 3;

        while (i > 0){
            LOGGER.info("\nWhat type of runway you wonna create?\n1 - Flex,\n2 - Rigid," +
                    "\ne - exit.");
            String choice = in.nextLine();

            if ("1".equals(choice)){
                i = 3;

                while (i > 0) {

                    LOGGER.info("\nChoose type of flex runway:\n1 - HighFlex,\n2 - MediumFlex," +
                            "\n3 - LowFlex,\n4 - ULowFlex,\ne - exit.");
                    String typeChoice = in.nextLine();

                    switch (typeChoice) {
                        case "1":
                            HighFlex highFlex = new HighFlex();
                            addRunway(highFlex);
                            i = 0;
                            break;
                        case "2":
                            MediumFlex mediumFlex = new MediumFlex();
                            addRunway(mediumFlex);
                            i = 0;
                            break;
                        case "3":
                            LowFlex lowFlex = new LowFlex();
                            addRunway(lowFlex);
                            i = 0;
                            break;
                        case "4":
                            ULowFlex uLowFlex = new ULowFlex();
                            addRunway(uLowFlex);
                            i = 0;
                            break;
                        case "e":
                            i = 0;
                            LOGGER.info("Exit from the program was initiated.");
                        default:
                            LOGGER.info("Incorrect value. Please, try again.");
                            i--;

                    }
                }

            } else if ("2".equals(choice)){
                i = 3;

                while (i > 0) {

                    LOGGER.info("\nChoose type of rigid runway:\n1 - HighRigid,\n2 - MediumRigid," +
                            "\n3 - LowRigid,\n4 - ULowRigid,\ne - exit.");
                    String typeChoice = in.nextLine();

                    switch (typeChoice) {
                        case "1":
                            HighRigid highRigid = new HighRigid();
                            addRunway(highRigid);
                            i = 0;
                            break;
                        case "2":
                            MediumRigid mediumRigid = new MediumRigid();
                            addRunway(mediumRigid);
                            i = 0;
                            break;
                        case "3":
                            LowRigid lowRigid = new LowRigid();
                            addRunway(lowRigid);
                            i = 0;
                            break;
                        case "4":
                            ULowRigid uLowRigid = new ULowRigid();
                            addRunway(uLowRigid);
                            i = 0;
                            break;
                        case "e":
                            i = 0;
                            LOGGER.info("Exit from the program was initiated.");
                        default:
                            LOGGER.info("Incorrect value. Please, try again.");
                            i--;
                    }
                }

            } else if ("e".equals(choice)){
                i = 0;
                LOGGER.info("Exit from the program was initiated.");
            } else {
                LOGGER.info("Incorrect value. Please, try again.\n");
                i--;
            }
        }
    }

}
