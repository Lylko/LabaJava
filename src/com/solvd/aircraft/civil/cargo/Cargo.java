package com.solvd.aircraft.civil.cargo;

import com.solvd.aircraft.civil.Civil;

public class Cargo extends Civil {

    private int maxLiftCap;

    public Cargo(){
        setMaxHeight(11);
        setMaxSpeed(750);
        setMaxLiftCap(155000);
        setCountryName("Solvd");
        setPlaneName("Example");
    }

    public Cargo(int maxSpeed, int maxHeight, String countryName, int maxLiftCap, String planeName){
        super(maxSpeed, maxHeight, countryName, planeName);
        this.maxLiftCap = maxLiftCap;
    }

    public void setMaxLiftCap(int maxLiftCap){
        this.maxLiftCap = maxLiftCap;
    }

    public int getMaxLiftCap(){
        return this.maxLiftCap;
    }

    public void printDescrip(){
        System.out.println("Cargo aircraft - description");
    }

    public void printInfo(){
        System.out.println("----------------------Cargo aircraft '" + getPlaneName() + "'--------------------");
        printFirstTemp();
        printSecondTemp();
    }

    protected void printSecondTemp(){
        System.out.println("Maximum lifting capacity of this cargo aircraft is " + getMaxLiftCap() + " kg");
        System.out.println("------------------------------------------------------------------");
    }

}
