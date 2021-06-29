package com.solvd.aircraft.civil.cargo;

public class Beluga extends Cargo {

    public Beluga(){
        setMaxSpeed(750);
        setMaxLiftCap(155000);
        setCountryName("France");
        setPlaneName("Beluga");
        setAirClass(45);
    }

    @Override
    public void printDescrip(){
        System.out.println("Beluga - description");
    }

}
