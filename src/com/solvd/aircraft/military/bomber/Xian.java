package com.solvd.aircraft.military.bomber;

public class Xian extends Bomber {
    public Xian(){
        setMaxHeight(13);
        setMaxSpeed(1050);
        setCrewNum(4);
        setCountryName("USSR");
        setPlaneName("Xian");
        setAirClass(15);
    }

    @Override
    public void printDescrip(){
        System.out.println("Xian - description");
    }
}
