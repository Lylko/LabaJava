package com.solvd.aircraft.military;

import com.solvd.aircraft.Aircraft;

public abstract class Military implements Aircraft {

    private int maxSpeed;
    private int maxHeight;
    private String countryName;
    private String planeName;
    private int airClass;
    private String airType;

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

    protected void setAirType(String type){
        this.airType = type;
    }

    public void setCountryName(String countryName){
        this.countryName = countryName;
    }

    public void setAirClass(int airClass){
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

    public String getAirType(){
        return this.airType;
    }

    public int getAirClass(){
        return this.airClass;
    }

}
