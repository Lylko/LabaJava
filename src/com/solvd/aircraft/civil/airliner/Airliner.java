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
        System.out.println("Airliner - bla bla bla");
    }

    public void printInfo(){
        System.out.println("----------------------Airliner '" + getPlaneName() + "'-----------------------");
        printFirstTemp();
        printSecondTemp();
    }

    protected void printSecondTemp(){
        System.out.println("Limit of passengers on this airliner is " + getPassengerCap() + " persons");
        System.out.println("------------------------------------------------------------------");
    }
}
