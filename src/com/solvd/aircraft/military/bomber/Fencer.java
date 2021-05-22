package com.solvd.aircraft.military.bomber;

import com.solvd.aircraft.military.bomber.Bomber;

public class Fencer extends Bomber {

    public Fencer(){
        setMaxHeight(15);
        setMaxSpeed(1700);
        setCrewNum(2);
        setCountryName("USSR");
    }

    public Fencer(int maxSpeed, int maxHeight, String countryName, int crewNum){
        super(maxSpeed, maxHeight, countryName, crewNum);
    }

    public void printInfo(){
        System.out.println("----------------------Bomber aircraft 'Fencer'--------------------");
        printFirstTemp();
        printSecondTemp();
    }
}