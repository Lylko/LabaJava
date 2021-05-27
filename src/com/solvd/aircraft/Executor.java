package com.solvd.aircraft;

import com.solvd.aircraft.civil.airliner.Airliner;
import com.solvd.aircraft.civil.cargo.Beluga;
import com.solvd.aircraft.civil.cargo.Cargo;
import com.solvd.aircraft.civil.Civil;
import com.solvd.aircraft.civil.cargo.Cossack;
import com.solvd.aircraft.military.bomber.Fencer;
import com.solvd.aircraft.military.stormtrooper.Stormtrooper;

public class Executor {
    public static void main(String[] args){

//        Beluga newPlane1 = new Beluga();
//        newPlane1.setCountryName("!!!!Set_check!!!!");
//        System.out.println("--------Get_check-----------");
//        System.out.println(newPlane1.getMaxHeight());
//        System.out.println("---------------------------");
//        newPlane1.printInfo();
//
//        Airliner plane1 = new Airliner();
//        plane1.printInfo();

        Cargo plane = new Cargo();
        plane.setMaxHeight(11111);
        plane.printDescrip();
        plane.printInfo();

        Cossack plane1 = new Cossack();
        plane1.setMaxHeight(11111);
        plane1.printInfo();

        Stormtrooper plane2 = new Stormtrooper();
        plane2.printDescrip();
        plane2.printInfo();

    }
}
