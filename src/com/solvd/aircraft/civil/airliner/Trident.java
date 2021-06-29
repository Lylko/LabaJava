package com.solvd.aircraft.civil.airliner;

public class Trident extends Airliner {

    public Trident(){
        setMaxSpeed(959);
        setPassengerCap(115);
        setCountryName("UK");
        setPlaneName("Trident");
        setAirClass(40);
    }

    @Override
    public void printDescrip(){
        System.out.println("Trident - description");
    }

}
