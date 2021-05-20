package com.solvd.aircraft;

import com.solvd.aircraft.civil.airliner.Airliner;
import com.solvd.aircraft.civil.cargo.Beluga;
import com.solvd.aircraft.civil.cargo.Cargo;
import com.solvd.aircraft.military.bomber.Fencer;

public class Executor {
    public static void main(String[] args){

        Beluga newPlane1 = new Beluga();
        newPlane1.setCountryName("!!!!Set_check!!!!");
        System.out.println("--------Get_check-----------");
        System.out.println(newPlane1.getMaxHeight());
        System.out.println("---------------------------");
        newPlane1.printInfo();

        Fencer newPlane5 = new Fencer();
        newPlane5.printInfo();

        Cargo plane = new Cargo(12,12,"Solvd",12);
        plane.printInfo();

        Airliner plane1 = new Airliner();
        plane1.printInfo();

    }
}
