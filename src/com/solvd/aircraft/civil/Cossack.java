package com.solvd.aircraft.civil;

public class Cossack extends Cargo {

    public Cossack(){
        setMaxHeight(12);
        setMaxSpeed(850);
        setMaxLiftCap(640000);
        setCountryName("USSR");
    }

    public Cossack(int maxSpeed, int maxHeight, String countryName, int maxLiftCap){
        super(maxSpeed, maxHeight, countryName, maxLiftCap);
    }

    public void printInfo(){
        System.out.println("----------------------Cargo aircraft 'Cossack'--------------------");
        FirstTemplateInfo();
        SecondTemplateInfo();
    }
}
