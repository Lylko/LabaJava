package com.solvd.aircraft.military;

import com.solvd.aircraft.Aircraft;

public abstract class Military implements Aircraft {

    private int maxSpeed;
    private int maxHeight;
    private String countryName;
    private String planeName;
    private int airClass;

    public Military(){

    }

    public Military(int maxSpeed, int maxHeight, String countryName, String planeName){
        this.maxSpeed = maxSpeed;
        this.maxHeight = maxHeight;
        this.countryName = countryName;
        this.planeName = planeName;
    }

    public void setMaxSpeed(int maxSpeed){
        this.maxSpeed = maxSpeed;
    }

    public void setMaxHeight(int maxHeight){
        this.maxHeight = maxHeight;
    }

    public void setCountryName(String countryName){
        this.countryName = countryName;
    }

    protected void setAirClass(int airClass){
        this.airClass = airClass;
    }

    public void setPlaneName(String planeName){
        this.planeName = planeName;
    }

    public String getPlaneName(){
        return this.planeName;
    }

    public int getMaxSpeed(){
        return this.maxSpeed;
    }

    public int getMaxHeight(){
        return this.maxHeight;
    }

    public String getCountryName(){
        return this.countryName;
    }

    public int getAirClass(){
        return this.airClass;
    }

    protected void printFirstTemp(){
        System.out.println("The aircraft was developed in " + getCountryName());
        System.out.println("Maximum speed of this aircraft is " + getMaxSpeed() + " km/h");
        System.out.println("Maximum flight altitude of this aircraft is " + getMaxHeight() + " km");
    }

//    public abstract int getCrewNum();

    protected abstract void printSecondTemp();

}
