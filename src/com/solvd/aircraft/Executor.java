package com.solvd.aircraft;

import com.solvd.aircraft.civil.*;

public class Executor {
    public static void main(String[] args){

        Beluga newPlane1 = new Beluga();
        newPlane1.printInfo();

        Cossack newPlane2 = new Cossack();
        newPlane2.printInfo();

        Globemaster newPlane3 = new Globemaster();
        newPlane3.printInfo();

        Airbus newPlane4 = new Airbus();
        newPlane4.printInfo();

    }
}
