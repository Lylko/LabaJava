package com.solvd.aircraft.civil.airliner;

import com.solvd.aircraft.civil.Civil;

import java.io.StringReader;

public class Airliner extends Civil {

    private int passengerCap;

    public Airliner(){
        setMaxSpeed(860);
        setPassengerCap(280);
        setCountryName("Solvd");
        setPlaneName("Example");
        setAirType("Airliner");
    }

    public Airliner(int maxSpeed, String countryName, int passengerCap, String planeName){
        super(maxSpeed, countryName, planeName);
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
                "Limit of passengers on this airliner is " + getPassengerCap() + " persons\n" +
                "------------------------------------------------------------------");
    }

}
