package com.solvd.aircraft.civil.cargo;

import com.solvd.aircraft.civil.cargo.Cargo;

public class Cossack extends Cargo {

    public Cossack(){
        setMaxHeight(12);
        setMaxSpeed(850);
        setMaxLiftCap(640000);
        setCountryName("USSR");
        setPlaneName("Cossack");
    }

}
