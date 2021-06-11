package com.solvd.runway;

import java.util.ArrayList;
import java.util.List;

public class Airport {

    private List<Runway> runwayList;

    public Airport(){
        runwayList = new ArrayList<>();
    }

    public void addRunway(Runway runway){
        runwayList.add(runway);
    }

    public List<Runway> getRunwayList(){
        return runwayList;
    }

    public void printRunwayList(){
        if ( (runwayList!=null) && (runwayList.size()>0) ) {
            int i = 1;
            System.out.println("\n===========================");
            for (Runway runway : runwayList) {
                System.out.println(i + " - " + runway.getRunwayName());
                i++;
            }
            System.out.println("===========================");
        } else if (runwayList!=null) {
            System.out.println("Runway list doesnt exist.");
        } else {
            System.out.println("Runway list don't have any object.");
        }
    }

}
