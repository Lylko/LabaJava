package com.solvd.aircraft.civil;

import com.solvd.aircraft.Aircraft;

public abstract class Civil implements Aircraft{

    private int maxSpeed;
    private String countryName;
    private String planeName;
    private int airClass;
    private String airType;

    public Civil(){

    }

    public Civil(int maxSpeed, String countryName, String planeName){
        this.maxSpeed = maxSpeed;
        this.countryName = countryName;
        this.planeName = planeName;
    }

    public void setMaxSpeed(int maxSpeed){
        this.maxSpeed = maxSpeed;
    }

    public void setCountryName(String countryName){
        this.countryName = countryName;
    }

    public void setPlaneName(String planeName){
        this.planeName = planeName;
    }

    protected void setAirType(String type){
        this.airType = type;
    }

    public void setAirClass(int airClass){
        this.airClass = airClass;
    }

    public String getPlaneName(){
        return this.planeName;
    }

    public int getMaxSpeed(){
        return this.maxSpeed;
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
