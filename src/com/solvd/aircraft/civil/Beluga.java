package com.solvd.aircraft.civil;

public class Beluga extends Cargo{

    public Beluga(){
        setMaxHeigh(11);
        setMaxSpeed(750);
        setMaxLiftCap(155000);
        setCountryName("France");
    }

    public Beluga(int maxSpeed, int maxHeight, int maxLiftCap, String countryName){
        super(maxSpeed, maxHeight, countryName, maxLiftCap);
    }

    public void printInfo(){
        System.out.println("----------------------Cargo aircraft 'Beluga'--------------------");
        System.out.println("The aircraft was developed in " + getCountryName());
        System.out.println("Maximum speed of this aircraft is " + getMaxSpeed() + " km/h");
        System.out.println("Maximum flight altitude of this aircraft is " + getMaxHeigh() + " km");
        System.out.println("Maximum lifting capacity of this cargo aircraft is " + getMaxLiftCap() + " kg");
        System.out.println("------------------------------------------------------------------");
    }
}
