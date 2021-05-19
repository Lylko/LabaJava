package com.solvd.aircraft.civil;

public class Cargo extends Civil {

    private int maxLiftCap;

    public Cargo(){

    }

    public Cargo(int maxSpeed, int maxHeight, String countryName, int maxLiftCap){
        super(maxSpeed, maxHeight, countryName);
        this.maxLiftCap = maxLiftCap;
    }

    public void setMaxLiftCap(int maxLiftCap){
        this.maxLiftCap = maxLiftCap;
    }

    public int getMaxLiftCap(){
        return this.maxLiftCap;
    }



    protected void SecondTemplateInfo(){
        System.out.println("Maximum lifting capacity of this cargo aircraft is " + getMaxLiftCap() + " kg");
        System.out.println("------------------------------------------------------------------");
    }

}
