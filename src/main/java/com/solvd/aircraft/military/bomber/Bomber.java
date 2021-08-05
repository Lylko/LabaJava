package com.solvd.aircraft.military.bomber;

import com.solvd.aircraft.military.Military;

public class Bomber extends Military {

    private int crewNum;

    public Bomber(){
        setMaxHeight(15);
        setMaxSpeed(1700);
        setCrewNum(2);
        setCountryName("Solvd");
        setPlaneName("Example");
        setAirType("Bomber");
    }

    public Bomber(String planeName, String countryName, int maxSpeed, int maxHeight, int airClass){
        super(maxSpeed, maxHeight, countryName, planeName);
        setAirClass(airClass);
    }

    public void setCrewNum(int crewNum){
        this.crewNum = crewNum;
    }

    public int getCrewNum(){
        return this.crewNum;
    }

    public void printDescrip(){
        System.out.println("Bomber - description");
    }

    public String toString(){
        return ("----------------------Stormtrooper '" + getPlaneName() + "'--------------------\n" +
                "The aircraft was developed in " + getCountryName() +
                "\nMaximum speed of this aircraft is " + getMaxSpeed() + " km/h\n" +
                "Maximum flight altitude of this aircraft is " + getMaxHeight() + " km\n" +
                "Number of crew members on this bomber aircraft is " + getCrewNum() + " persons" +
                "\n------------------------------------------------------------------");
    }

}
