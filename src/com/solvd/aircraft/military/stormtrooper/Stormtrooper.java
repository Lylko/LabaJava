package com.solvd.aircraft.military.stormtrooper;

import com.solvd.aircraft.military.Military;

public class Stormtrooper extends Military{

    private int suspensionPoint;

    public Stormtrooper(){

    }

    public Stormtrooper(int maxSpeed, int maxHeight, String countryName, int suspensionPoint, String planeName){
        super(maxSpeed, maxHeight, countryName, planeName);
        this.suspensionPoint = suspensionPoint;
    }

    public void setNumSuspPoints(int suspensionPoint){
        this.suspensionPoint = suspensionPoint;
    }

    public int getNumSuspPoints(){
        return this.suspensionPoint;
    }

    public void printDescrip(){
        System.out.println("Stormtrooper - bla bla bla");
    }

    public void printInfo(){
        System.out.println("----------------------Stormtrooper '" + getPlaneName() + "'--------------------");
        printFirstTemp();
        printSecondTemp();
    }

    protected void printSecondTemp(){
        System.out.println("Number of suspension points on this stormtrooper is " + getNumSuspPoints());
        System.out.println("------------------------------------------------------------------");
    }
}
