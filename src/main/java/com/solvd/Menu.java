package com.solvd;

import com.solvd.runway.Airport;
import com.solvd.runway.Runway;
import com.solvd.utils.Logging;
import com.solvd.utils.PropertiesLoad;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    final static Logger LOGGER = Logger.getLogger(Menu.class);

    private Map<String, Runway> runwayMap;
    private Airport airport;

    public Menu() {
        airport = new Airport();
        runwayMap = airport.getRunwayList();
    }

    public void showStartMenu(){
        Scanner in = new Scanner(System.in);

        int i = 3;
        String runwayChoice;
        ArrayList<String> values = Logging.registration();

        if (values.size() == 2 && airport.isRunwayExist()) {

            PropertiesLoad.setValueFromProperties(values);

            while (i > 0) {

                System.out.println("\nChoose what you want to do: " +
                        "\n1 - Create new runway,\n2 - Add aircraft to runway," +
                        "\n3 - Show created aircrafts,\n4 - Show available runways," +
                        "\n5 - Delete runway,\n6 - Show all available types of runway on this airport," +
                        "\ne - exit.");

                String choice = in.nextLine();
                switch (choice) {
                    case "1":
                        if (Logging.isRightPassword()) {
                            airport.createRunway();
                            i = checkExit();
                        }
                        break;
                    case "2":
                        if (Logging.isRightPassword()) {
                            runwayChoice = airport.chooseRunway();
                            if (!"error".equals(runwayChoice)) {
                                runwayMap.get(runwayChoice).createAircraft();
                            } else {
                                LOGGER.info("Try again later.");
                            }
                            i = checkExit();
                        }
                        break;
                    case "3":
                        runwayChoice = airport.chooseRunway();
                        if (!"error".equals(runwayChoice)){
                            runwayMap.get(runwayChoice).printAircraftList();
                        } else {
                            LOGGER.info("Try again later.");
                        }
                        i = checkExit();
                        break;
                    case "4":
                        airport.printRunwayList();
                        i = checkExit();
                        break;
                    case "5":
                        if (Logging.isRightPassword()) {
                            runwayChoice = airport.chooseRunway();
                            if (!"error".equals(runwayChoice)) {
                                airport.removeRunway(runwayChoice);
                            } else {
                                LOGGER.info("Try again later.");
                            }
                            i = checkExit();
                        }
                        break;
                    case "6":
                        airport.printAllTypes();
                        i = checkExit();
                        break;
                    case "e":
                        i = 0;
                        break;
                    default:
                        LOGGER.info("Incorrect value. Please, try again.");
                        i--;
                        break;
                }
            }
        } else if (values.size() != 2) {
            LOGGER.info("Incorrect login or password. Please, try again later.");
        }

        LOGGER.info("--------End of program--------");
    }

    private int checkExit(){
        Scanner in = new Scanner(System.in);
        int i = 3;

        while(i > 0) {
            LOGGER.info("\nDo you want to make something else?\ny - yes,\nn - no.");
            String choice = in.nextLine();
            if ("y".equals(choice)) {
                return 3;
            } else if ("n".equals(choice)) {
                return 0;
            } else {
                LOGGER.info("Incorrect value. Please, try again.\n");
                i--;
            }
        }

        return 0;
    }

}
