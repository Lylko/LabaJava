package com.solvd.aircraft.military.stormtrooper;

public class Dragonfly extends Stormtrooper {

    public Dragonfly(){
        setMaxHeight(13);
        setMaxSpeed(816);
        setNumSuspPoints(8);
        setCountryName("UK");
        setPlaneName("Dragonfly");
        setAirClass(14);
    }

    @Override
    public void printDescrip(){
        System.out.println("Stormtrooper - description");
    }

}
