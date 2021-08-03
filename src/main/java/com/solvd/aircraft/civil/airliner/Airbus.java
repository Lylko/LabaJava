package com.solvd.aircraft.civil.airliner;

public class Airbus extends Airliner {

    public Airbus(){
        setMaxSpeed(860);
        setPassengerCap(280);
        setCountryName("France");
        setPlaneName("Airbus");
        setAirClass(35);
    }

    @Override
    public void printDescrip(){
        System.out.println("Beluga - description");
    }
}
