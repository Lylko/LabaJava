package com.solvd.aircraft.civil.airliner;

public class Xiangfeng extends Airliner {

    public Xiangfeng(){
        setMaxHeight(11);
        setMaxSpeed(870);
        setPassengerCap(95);
        setCountryName("China");
        setPlaneName("Xiangfeng");
        setAirClass(39);
    }

    @Override
    public void printDescrip(){
        System.out.println("Xiangfeng - description");
    }

}
