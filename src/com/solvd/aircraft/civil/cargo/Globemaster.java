package com.solvd.aircraft.civil.cargo;

import com.solvd.aircraft.civil.cargo.Cargo;

public class Globemaster extends Cargo {

    public Globemaster(){
        setMaxHeight(14);
        setMaxSpeed(640);
        setMaxLiftCap(265000);
        setCountryName("USA");
        setPlaneName("Globemaster");
    }

}
