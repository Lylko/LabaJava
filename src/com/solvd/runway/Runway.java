package com.solvd.runway;

import com.solvd.aircraft.Aircraft;
import com.solvd.aircraft.civil.Civil;
import com.solvd.aircraft.military.Military;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Runway {

    private int classNum;
    private String runwayName;
    private final double AIRINDEX = 1.05;
    private List<Military> militaryList;
    private List<Civil> civilList;
    private Set<Aircraft> uniqueList;

    public Runway(){
        militaryList = new ArrayList<>();
        civilList = new ArrayList<>();
        uniqueList = new HashSet<>();
    }

    public void setClassNum(int classNum){
        this.classNum = classNum;
    }

    public void setRunwayName(String name){
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
            addToUniqueList(plane);
            System.out.println("Aircraft " + plane.getPlaneName() + " created.");
        } else {
            System.out.println(plane.getPlaneName() + " is not suitable for accommodation.");
        }
    }

    public void addPlane(Military plane){
        if (isPrintAccess(plane)){
            militaryList.add(plane);
            addToUniqueList(plane);
            System.out.println("Aircraft " + plane.getPlaneName() + " created.");
        } else {
            System.out.println(plane.getPlaneName() + " is not suitable for accommodation.");
        }
    }

    private void addToUniqueList(Civil aircraft){
        uniqueList.add(aircraft);
    }

    private void addToUniqueList(Military aircraft){
        uniqueList.add(aircraft);
    }

    public Set<Aircraft> getUniqueList(){
        return uniqueList;
    }

    public List<Civil> getCivilList(){
        return civilList;
    }

    public List<Military> getMilitaryList(){
        return militaryList;
    }

    public boolean isPrintAccess(Military aircraft){
        double airClass = aircraft.getAirClass();
        return airClass <= (getClassNum() * AIRINDEX);
    }

    public boolean isPrintAccess(Civil aircraft){
        double airClass = aircraft.getAirClass();
        return airClass <= (getClassNum() * AIRINDEX);
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

}
