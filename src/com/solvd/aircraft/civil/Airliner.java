package com.solvd.aircraft.civil;

public class Airliner extends Civil{

    private int passengerCap;

    public Airliner(){

    }

    public Airliner(int maxSpeed, int maxHeight, String countryName, int passengerCap){
        super(maxSpeed, maxHeight, countryName);
        this.passengerCap = passengerCap;
    }

    public void setPassengerCap(int passengerCap){
        this.passengerCap = passengerCap;
    }

    public int getPassengerCap(){
        return this.passengerCap;
    }

    protected void SecondTemplateInfo(){
        System.out.println("Limit of passengers on this airliner is " + getPassengerCap() + " persons");
        System.out.println("------------------------------------------------------------------");
    }
}
