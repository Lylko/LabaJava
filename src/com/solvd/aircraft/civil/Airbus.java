package com.solvd.aircraft.civil;

public class Airbus extends Airliner{
    public Airbus(){
        setMaxHeight(12);
        setMaxSpeed(860);
        setPassengerCap(280);
        setCountryName("France");
    }

    public void printInfo(){
        System.out.println("----------------------Airliner 'Airbus'-----------------------");
        FirstTemplateInfo();
        SecondTemplateInfo();
    }
}
