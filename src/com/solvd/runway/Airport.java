package com.solvd.runway;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Airport {

    private Map<String,Runway> runwayMap;

    public Airport(){
        runwayMap = new HashMap<>();
    }

    public void addRunway(Runway runway){
        Scanner in = new Scanner(System.in);

        int i = 3;
        while (i > 0) {
            System.out.println("\nPlease, give name for this runway.");
            String name = in.nextLine();

            if ((runwayMap != null) && (runwayMap.size() > 0)) {
                if (runwayMap.containsKey(name)) {
                    System.out.println("This name already exist. Please, try to put another.");
                } else {
                    runwayMap.put(name, runway);
                    i = 0;
                    System.out.println("Created new runway '" + runway.getRunwayName() + "'.");
                }
            } else if (runwayMap != null) {
                runwayMap.put(name, runway);
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
        return runwayMap;
    }

    public void printRunwayList(){
        if ( (runwayMap!=null) && (runwayMap.size()>0) ) {
            System.out.println("\n===========================");
            int i = 1;
            for (String name : runwayMap.keySet()) {
                System.out.println(i + " - " + name + " (" + runwayMap.get(name).getRunwayName() + ")");
                i++;
            }
            System.out.println("===========================");
        } else if (runwayMap!=null) {
            System.out.println("Runway list don't have any object.");
        } else {
            System.out.println("Runway list doesnt exist.");
        }
    }


}
