package com.solvd.aircraft.civil.cargo;

import com.solvd.aircraft.civil.cargo.Cargo;

public class Globemaster extends Cargo {

    public Globemaster(){
        setMaxSpeed(640);
        setMaxLiftCap(265000);
        setCountryName("USA");
        setPlaneName("Globemaster");
        setAirClass(42);
    }

    @Override
    public void printDescrip(){
        System.out.println("Globemaster - description");
    }

}
