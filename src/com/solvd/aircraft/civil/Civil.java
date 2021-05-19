package com.solvd.aircraft.civil;

public class Civil {

    private int maxSpeed;
    private int maxHeight;
    private String countryName;

    public Civil(){

    }

    public Civil(int maxSpeed, int maxHeight, String countryName){
        this.maxSpeed = maxSpeed;
        this.maxHeight = maxHeight;
    }

    public void setMaxSpeed(int maxSpeed){
        this.maxSpeed = maxSpeed;
    }

    public void setMaxHeigh(int maxHeigh){
        this.maxHeight = maxHeigh;
    }

    public void setCountryName(String countryName){
        this.countryName = countryName;
    }

    public int getMaxSpeed(){
        return this.maxSpeed;
    }

    public int getMaxHeigh(){
        return this.maxHeight;
    }

    public String getCountryName(){
        return this.countryName;
    }
}
