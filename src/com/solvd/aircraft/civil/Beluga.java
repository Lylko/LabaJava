package com.solvd.aircraft.civil;

public class Beluga extends Cargo{

    public Beluga(){
        setMaxHeight(11);
        setMaxSpeed(750);
        setMaxLiftCap(155000);
        setCountryName("France");
    }

    public void printInfo(){
        System.out.println("----------------------Cargo aircraft 'Beluga'--------------------");
        FirstTemplateInfo();
        SecondTemplateInfo();
    }
}
