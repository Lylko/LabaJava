package com.solvd.aircraft.military.stormtrooper;

public class Buccaneer extends Stormtrooper {

    public Buccaneer(){
        setMaxHeight(12);
        setMaxSpeed(1040);
        setNumSuspPoints(4);
        setCountryName("UK");
        setPlaneName("Buccaneer");
        setAirClass(17);
    }

    @Override
    public void printDescrip(){
        System.out.println("Buccaneer - description");
    }
}
