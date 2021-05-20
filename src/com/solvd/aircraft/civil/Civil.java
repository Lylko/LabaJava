package com.solvd.aircraft.civil;

public abstract class Civil {

    private int maxSpeed;
    private int maxHeight;
    private String countryName;

    public Civil(){

    }

    public Civil(int maxSpeed, int maxHeight, String countryName){
        this.maxSpeed = maxSpeed;
        this.maxHeight = maxHeight;
        this.countryName = countryName;
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

    public int getMaxSpeed(){
        return this.maxSpeed;
    }

    public int getMaxHeight(){
        return this.maxHeight;
    }

    public String getCountryName(){
        return this.countryName;
    }

    protected void FirstTemplateInfo(){
        System.out.println("The aircraft was developed in " + getCountryName());
        System.out.println("Maximum speed of this aircraft is " + getMaxSpeed() + " km/h");
        System.out.println("Maximum flight altitude of this aircraft is " + getMaxHeight() + " km");
    }

    protected abstract void SecondTemplateInfo();

}
