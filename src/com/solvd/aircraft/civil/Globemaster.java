package com.solvd.aircraft.civil;

public class Globemaster extends Cargo{

    public Globemaster(){
        setMaxHeight(14);
        setMaxSpeed(640);
        setMaxLiftCap(265000);
        setCountryName("USA");
    }

    public void printInfo(){
        System.out.println("----------------------Cargo aircraft 'Globemaster'--------------------");
        FirstTemplateInfo();
        SecondTemplateInfo();
    }

}
