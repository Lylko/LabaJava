package com.solvd.aircraft.civil.cargo;

import com.solvd.aircraft.civil.Civil;

public class Cargo extends Civil {

    private int maxLiftCap;

    public Cargo(){
        setCountryName("Solvd");
    }

    public Cargo(int maxSpeed, int maxHeight, String countryName, int maxLiftCap){
        super(maxSpeed, maxHeight, countryName);
        this.maxLiftCap = maxLiftCap;
    }

    public void setMaxLiftCap(int maxLiftCap){
        this.maxLiftCap = maxLiftCap;
    }

    public int getMaxLiftCap(){
        return this.maxLiftCap;
    }

    public void printInfo(){
        System.out.println("----------------------My own сargo aircraft--------------------");
        printFirstTemp();
        printSecondTemp();
    }

    protected void printSecondTemp(){
        System.out.println("Maximum lifting capacity of this cargo aircraft is " + getMaxLiftCap() + " kg");
        System.out.println("------------------------------------------------------------------");
    }

}
