package com.solvd.aircraft.military.stormtrooper;

import com.solvd.aircraft.military.Military;

public class Stormtrooper extends Military{

    private int suspensionPoint;

    public Stormtrooper(){
        setMaxHeight(13);
        setMaxSpeed(816);
        setNumSuspPoints(8);
        setCountryName("Solvd");
        setPlaneName("Example");
        setAirType("Stormtrooper");
    }

    public Stormtrooper(String planeName, String countryName, int maxSpeed, int maxHeight, int airClass){
        super(maxSpeed, maxHeight, countryName, planeName);
        setAirClass(airClass);
    }

    public void setNumSuspPoints(int suspensionPoint){
        this.suspensionPoint = suspensionPoint;
    }

    public int getNumSuspPoints(){
        return this.suspensionPoint;
    }

    public void printDescrip(){
        System.out.println("Stormtrooper - description");
    }

    public String toString(){
        return ("----------------------Stormtrooper '" + getPlaneName() + "'--------------------\n" +
                "The aircraft was developed in " + getCountryName() +
                "\nMaximum speed of this aircraft is " + getMaxSpeed() + " km/h\n" +
                "Maximum flight altitude of this aircraft is " + getMaxHeight() + " km\n" +
                "Number of suspension points on this stormtrooper is " + getNumSuspPoints() +
                "\n------------------------------------------------------------------");
    }
}
