package com.solvd.aircraft.civil.cargo;

import com.solvd.aircraft.civil.Civil;

public class Cargo extends Civil {

    private int maxLiftCap;

    public Cargo(){
        setMaxSpeed(750);
        setMaxLiftCap(155000);
        setCountryName("Solvd");
        setPlaneName("Example");
        setAirType("Cargo");
    }

    public Cargo(String planeName, String countryName, int maxSpeed, int airClass){
        super(maxSpeed, countryName, planeName);
        setAirClass(airClass);
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

    public String toString(){
        return ("----------------------Cargo aircraft '" + getPlaneName() + "'-----------------------\n" +
                "The aircraft was developed in " + getCountryName() +
                "\nMaximum speed of this aircraft is " + getMaxSpeed() + " km/h\n" +
                "Maximum lifting capacity of this cargo aircraft is " + getMaxLiftCap() + " kg\n" +
                "------------------------------------------------------------------");
    }

}
