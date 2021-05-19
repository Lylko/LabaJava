package com.solvd.aircraft.civil;

public class Cossack extends Cargo {

    public Cossack(){
        setMaxHeigh(12);
        setMaxSpeed(850);
        setMaxLiftCap(640000);
        setCountryName("USSR");
    }

    public Cossack(int maxSpeed, int maxHeight, String countryName, int maxLiftCap){
        super(maxSpeed, maxHeight, countryName, maxLiftCap);
    }

    public void printInfo(){
        System.out.println("----------------------Cargo aircraft 'Cossack'--------------------");
        System.out.println("The aircraft was developed in the " + getCountryName());
        System.out.println("Maximum speed of this aircraft is " + getMaxSpeed() + " km/h");
        System.out.println("Maximum flight altitude of this aircraft is " + getMaxHeigh() + " km");
        System.out.println("Maximum lifting capacity of this cargo aircraft is " + getMaxLiftCap() + " kg");
        System.out.println("------------------------------------------------------------------");
    }
}
