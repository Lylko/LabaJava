package com.solvd;

import com.solvd.aircraft.Aircraft;
import com.solvd.aircraft.civil.airliner.Airbus;
import com.solvd.aircraft.civil.airliner.Trident;
import com.solvd.aircraft.civil.cargo.Beluga;
import com.solvd.aircraft.military.bomber.Xian;
import com.solvd.aircraft.military.stormtrooper.Dragonfly;
import com.solvd.aircraft.military.stormtrooper.Skyhawk;
import com.solvd.runway.flex.HighFlex;

import java.util.Arrays;


public class Executor {
    public static void main(String[] args) {

        Airbus plane = new Airbus();
        Trident plane1 = new Trident();
        Beluga plane2 = new Beluga();

        Dragonfly plane3 = new Dragonfly();
        Skyhawk plane4 = new Skyhawk();
        Xian plane5 = new Xian();
        Xian plane6 = new Xian();

        HighFlex runway = new HighFlex();

        runway.addRunwayList(plane);
        runway.addRunwayList(plane1);
        runway.addRunwayList(plane2);

        runway.addRunwayList(plane3);
        runway.addRunwayList(plane4);
        runway.addRunwayList(plane5);
        runway.addRunwayList(plane6);

        runway.printRunwayList();

        for (Aircraft aircraft : runway.getAircraftList()){
            System.out.println(aircraft.toString());
        }

    }
}
