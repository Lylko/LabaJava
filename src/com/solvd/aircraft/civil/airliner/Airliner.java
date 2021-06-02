package com.solvd.aircraft.civil.airliner;

import com.solvd.aircraft.civil.Civil;

public class Airliner extends Civil {

    private int passengerCap;

    public Airliner(){
        setMaxHeight(12);
        setMaxSpeed(860);
        setPassengerCap(280);
        setCountryName("Solvd");
        setPlaneName("Example");
    }

    public Airliner(int maxSpeed, int maxHeight, String countryName, int passengerCap, String planeName){
        super(maxSpeed, maxHeight, countryName, planeName);
        this.passengerCap = passengerCap;
    }

    public void setPassengerCap(int passengerCap){
        this.passengerCap = passengerCap;
    }

    public int getPassengerCap(){
        return this.passengerCap;
    }

    public void printDescrip(){
        System.out.println("Airliner - description");
    }

    public String toString(){
        return ("----------------------Airliner '" + getPlaneName() + "'-----------------------\n" +
                "The aircraft was developed in " + getCountryName() +
                "\nMaximum speed of this aircraft is " + getMaxSpeed() + " km/h\n" +
                "Maximum flight altitude of this aircraft is " + getMaxHeight() + " km\n" +
                "Limit of passengers on this airliner is " + getPassengerCap() + " persons\n" +
                "------------------------------------------------------------------");
    }

}
