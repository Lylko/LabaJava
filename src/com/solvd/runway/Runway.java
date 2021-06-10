package com.solvd.runway;

import com.solvd.aircraft.Aircraft;
import com.solvd.aircraft.civil.Civil;
import com.solvd.aircraft.military.Military;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Runway {

    private int classNum;
    private final double airIndex = 1.05;
    private List<Military> militaryList;
    private List<Civil> civilList;
    private List<Aircraft> aircraftList;

    public Runway(){
        militaryList = new ArrayList<>();
        civilList = new ArrayList<>();
        aircraftList = new LinkedList<>();
    }

    public void setClassNum(int classNum){
        this.classNum = classNum;
    }

    public int getClassNum(){
        return this.classNum;
    }

    public void addRunwayList(Civil plane){
        if (printAccess(plane)){
            civilList.add(plane);
            addAircraftList(plane);
        } else {
            System.out.println(plane.getPlaneName() + " is not suitable for accommodation.");
        }
    }

    public void addRunwayList(Military plane){
        if (printAccess(plane)){
            militaryList.add(plane);
            addAircraftList(plane);
        } else {
            System.out.println(plane.getPlaneName() + " is not suitable for accommodation.");
        }
    }

    private void addAircraftList(Military aircraft){
        aircraftList.add(aircraft);
    }

    private void addAircraftList(Civil aircraft){
        aircraftList.add(aircraft);
    }

    public List<Aircraft> getAircraftList(){
        return aircraftList;
    }

    public boolean printAccess(Military aircraft){
        double airClass = aircraft.getAirClass();
        return airClass <= (getClassNum() * airIndex);
    }

    public boolean printAccess(Civil aircraft){
        double airClass = aircraft.getAirClass();
        return airClass <= (getClassNum() * airIndex);
    }

    public void printRunwayList(){

        if ( civilList.size()>0 ) {
            System.out.println("\n----------------------------Civil aircraft" +
                    "----------------------------\n");

            for (Civil aircraft : civilList) {
                System.out.println(aircraft.getPlaneName());
            }
        }

        if ( militaryList.size()>0 ) {
            System.out.println("\n----------------------------Military aircraft" +
                    "----------------------------\n");

            for (Military aircraft : militaryList) {
                System.out.println(aircraft.getPlaneName());
            }
        }
    }

}
