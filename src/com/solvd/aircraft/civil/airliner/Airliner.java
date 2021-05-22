package com.solvd.aircraft.civil.airliner;

import com.solvd.aircraft.civil.Civil;

public class Airliner extends Civil {

    private int passengerCap;

    public Airliner(){
        setCountryName("Solvd");
    }

    public Airliner(int maxSpeed, int maxHeight, String countryName, int passengerCap){
        super(maxSpeed, maxHeight, countryName);
        this.passengerCap = passengerCap;
    }

    public void setPassengerCap(int passengerCap){
        this.passengerCap = passengerCap;
    }

    public int getPassengerCap(){
        return this.passengerCap;
    }

    public void printInfo(){
        System.out.println("----------------------My own airliner-------------------------");
        printFirstTemp();
        printSecondTemp();
    }

    protected void printSecondTemp(){
        System.out.println("Limit of passengers on this airliner is " + getPassengerCap() + " persons");
        System.out.println("------------------------------------------------------------------");
    }
}
