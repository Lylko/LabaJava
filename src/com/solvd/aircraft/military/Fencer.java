package com.solvd.aircraft.military;

public class Fencer extends Bomber{

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
        FirstTemplateInfo();
        SecondTemplateInfo();
    }
}
