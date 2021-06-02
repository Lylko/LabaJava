package com.solvd.runway;

import com.solvd.aircraft.Aircraft;
import com.solvd.aircraft.civil.Civil;
import com.solvd.aircraft.military.Military;

public abstract class Runway {

    private int classNum;

    public void setClassNum(int classNum){
        this.classNum = classNum;
    }

    public int getClassNum(){
        return this.classNum;
    }

    public void printAccess(Military aircraft){
        double airClass = aircraft.getAirClass();
        if (airClass <= (getClassNum()*1.05)){
            System.out.println("Landing permit");
        } else {
            System.out.println("Denied aircraft landing");
        }
    }

    public void printAccess(Civil aircraft){
        double airClass = aircraft.getAirClass();
        if (airClass <= (getClassNum()*1.05)){
            System.out.println("Landing permit");
        } else {
            System.out.println("Denied aircraft landing");
        }
    }

    public void printAccess(int aircraftClass){
        double airClass = aircraftClass;
        if (airClass <= (getClassNum()*1.05)){
            System.out.println("Landing permit");
        } else {
            System.out.println("Denied aircraft landing");
        }
    }

    public void printAccess(double aircraftClass){
        double airClass = aircraftClass;
        if (airClass <= (getClassNum()*1.05)){
            System.out.println("Landing permit");
        } else {
            System.out.println("Denied aircraft landing");
        }
    }

}
