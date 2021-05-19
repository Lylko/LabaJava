package com.solvd.aircraft;

import com.solvd.aircraft.civil.*;
import com.solvd.aircraft.military.*;

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

    }
}
