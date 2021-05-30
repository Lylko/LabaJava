package com.solvd;

import com.solvd.aircraft.civil.cargo.Cossack;
import com.solvd.aircraft.military.stormtrooper.Dragonfly;
import com.solvd.runway.flex.HighFlex;


public class Executor {
    public static void main(String[] args){

        Cossack plane1 = new Cossack();
        HighFlex way = new HighFlex();

        way.printAccess(plane1);
        way.printAccess(12);
        way.printAccess(12.6);
        plane1.printDescrip();


    }
}
