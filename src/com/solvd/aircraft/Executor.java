package com.solvd.aircraft;

import com.solvd.aircraft.civil.*;

public class Executor {
    public static void main(String[] args){

        Civil plane = new Civil(100,100, "Test");
        plane.setMaxSpeed(120);

        System.out.println("Maximum speed of this aircraft is " + plane.getMaxSpeed() + " km/h");
        System.out.println("Maximum flight altitude of this aircraft is " + plane.getMaxHeigh() + " km");
        System.out.println("------------------------------------------------------------------------");

        Cargo cargo = new Cargo(100,100,"Test", 1000);
        cargo.setMaxSpeed(130);

        System.out.println("Maximum speed of this aircraft is " + cargo.getMaxSpeed() + " km/h");
        System.out.println("Maximum flight altitude of this aircraft is " + cargo.getMaxHeigh() + " km");
        System.out.println("Maximum lifting capacity of this cargo aircraft is " + cargo.getMaxLiftCap() + " kg");
        System.out.println("------------------------------------------------------------------------");

        Cossack newPlane = new Cossack();
        newPlane.printInfo();

        Beluga newPlane1 = new Beluga();
        newPlane1.printInfo();
    }
}
