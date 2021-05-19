package com.solvd.aircraft.civil;

public class Globemaster extends Cargo{

    public Globemaster(){
        setMaxHeight(14);
        setMaxSpeed(640);
        setMaxLiftCap(265000);
        setCountryName("USA");
    }

    public Globemaster(int maxSpeed, int maxHeight, int maxLiftCap, String countryName){
        super(maxSpeed, maxHeight, countryName, maxLiftCap);
    }

    public void printInfo(){
        System.out.println("----------------------Cargo aircraft 'Globemaster'--------------------");
        FirstTemplateInfo();
        SecondTemplateInfo();
    }

}
