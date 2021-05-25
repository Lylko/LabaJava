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
    }

    public Bomber(int maxSpeed, int maxHeight, String countryName, int crewNum, String planeName){
        super(maxSpeed, maxHeight, countryName, planeName);
        this.crewNum = crewNum;
    }

    public void setCrewNum(int crewNum){
        this.crewNum = crewNum;
    }

    public int getCrewNum(){
        return this.crewNum;
    }

    public void printDescrip(){
        System.out.println("Bomber - bla bla bla");
    }

    public void printInfo(){
        System.out.println("----------------------Bomber aircraft '" + getPlaneName() + "'--------------------");
        printFirstTemp();
        printSecondTemp();
    }

    protected void printSecondTemp(){
        System.out.println("Number of crew members on this bomber aircraft is " + getCrewNum() + " persons");
        System.out.println("------------------------------------------------------------------");
    }
}
