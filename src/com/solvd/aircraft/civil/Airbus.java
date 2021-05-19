package com.solvd.aircraft.civil;

public class Airbus extends Airliner{
    public Airbus(){
        setMaxHeight(12);
        setMaxSpeed(860);
        setPassengerCap(280);
        setCountryName("France");
    }

    public Airbus(int maxSpeed, int maxHeight, String countryName, int passengerCap){
        super(maxSpeed, maxHeight, countryName, passengerCap);
    }

    public void printInfo(){
        System.out.println("----------------------Cargo aircraft 'Airbus'--------------------");
        FirstTemplateInfo();
        SecondTemplateInfo();
    }
}
