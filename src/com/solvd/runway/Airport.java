package com.solvd.runway;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Airport {

    private Map<String, Runway> runwayList;

    public Airport(){
        runwayList = new HashMap<>();
    }

    public void addRunway(Runway runway){
        Scanner in = new Scanner(System.in);

        int i = 3;
        while (i > 0) {
            System.out.println("\nPlease, give name for this runway.");
            String name = in.nextLine();

            if ((runwayList != null) && (runwayList.size() > 0)) {
                if (runwayList.containsKey(name)) {
                    System.out.println("This name already exist. Please, try to put another.");
                } else {
                    runwayList.put(name, runway);
                    i = 0;
                    System.out.println("Created new runway '" + runway.getRunwayName() + "'.");
                }
            } else if (runwayList != null) {
                runwayList.put(name, runway);
                i = 0;
                System.out.println("Created new runway '" + runway.getRunwayName() + "'.");
            } else {
                System.out.println("Runway list doesnt exist.");
            }
            i--;
        }
        if (i == 0){
            System.out.println("\n---Creating failed.---\n");
        }
    }

    public Map<String,Runway> getRunwayList(){
        return runwayList;
    }

    public void printRunwayList(){
        if ( (runwayList!=null) && (runwayList.size()>0) ) {
            System.out.println("\n===========================");
            int i = 1;
            for (String name : runwayList.keySet()) {
                System.out.println(i + " - " + name + " (" + runwayList.get(name).getRunwayName() + ")");
                i++;
            }
            System.out.println("===========================");
        } else if (runwayList!=null) {
            System.out.println("Runway list don't have any object.");
        } else {
            System.out.println("Runway list doesnt exist.");
        }
    }


}
