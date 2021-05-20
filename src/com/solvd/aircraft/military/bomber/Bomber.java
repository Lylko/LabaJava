package com.solvd.aircraft.military.bomber;

import com.solvd.aircraft.military.Military;

public class Bomber extends Military {

    private int crewNum;

    public Bomber(){

    }

    public Bomber(int maxSpeed, int maxHeight, String countryName, int crewNum){
        super(maxSpeed, maxHeight, countryName);
        this.crewNum = crewNum;
    }

    public void setCrewNum(int crewNum){
        this.crewNum = crewNum;
    }

    public int getCrewNum(){
        return this.crewNum;
    }

    protected void SecondTemplateInfo(){
        System.out.println("Number of crew members on this bomber aircraft is " + getCrewNum() + " persons");
        System.out.println("------------------------------------------------------------------");
    }
}
