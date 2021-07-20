package com.solvd.aircraft.civil.cargo;

import com.solvd.aircraft.civil.cargo.Cargo;

public class Cossack extends Cargo {

    public Cossack(){
        setMaxSpeed(850);
        setMaxLiftCap(640000);
        setCountryName("USSR");
        setPlaneName("Cossack");
        setAirClass(51);
    }

    @Override
    public void printDescrip(){
        System.out.println("Cossack - description");
    }

}
