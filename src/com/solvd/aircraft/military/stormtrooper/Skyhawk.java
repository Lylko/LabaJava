package com.solvd.aircraft.military.stormtrooper;

public class Skyhawk extends Stormtrooper {

    public Skyhawk(){
        setMaxHeight(12);
        setMaxSpeed(1083);
        setNumSuspPoints(5);
        setCountryName("USA");
        setPlaneName("Skyhawk");
        setAirClass(20);
    }

    @Override
    public void printDescrip(){
        System.out.println("Skyhawk - description");
    }

}
