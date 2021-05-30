package com.solvd.aircraft.civil.airliner;

import com.solvd.aircraft.civil.airliner.Airliner;

public class Airbus extends Airliner {
    public Airbus(){
        setMaxHeight(12);
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
