package com.solvd.aircraft.military.bomber;

public class Nighthawk extends Bomber {
    public Nighthawk(){
        setMaxHeight(14);
        setMaxSpeed(993);
        setCrewNum(1);
        setCountryName("USA");
        setPlaneName("Nighthawk");
        setAirClass(19);
    }

    @Override
    public void printDescrip(){
        System.out.println("Nighthawk - description");
    }
}
