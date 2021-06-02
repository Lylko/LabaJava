package com.solvd;

import com.solvd.aircraft.civil.airliner.Airbus;
import com.solvd.aircraft.civil.cargo.Beluga;
import com.solvd.aircraft.civil.cargo.Cossack;
import com.solvd.aircraft.civil.cargo.Globemaster;
import com.solvd.aircraft.military.bomber.Fencer;
import com.solvd.aircraft.military.stormtrooper.Dragonfly;

import java.util.Scanner;


public class Executor {
    public static void main(String[] args) {

        Airbus plane = new Airbus();
        System.out.println(plane.toString());

        Dragonfly plane1 = new Dragonfly();
        System.out.println(plane1.toString());

        System.out.println("\n-----Creating new aircraft-----");
        Scanner in = new Scanner(System.in);

        int i = 0;

        while (i == 0) {

            System.out.println("Choose type of aircraft: \n 0 - Civil, 1 - Military, e - Exit.");
            String choice = in.nextLine();

            if ("0".equals(choice)) {

                while (i == 0) {

                    System.out.println("Choose type of civil aircraft: " +
                            "\n 0 - Cargo, 1 - Airliner, e - Exit.");
                    String secondChoice = in.nextLine();

                    if ("0".equals(secondChoice)) {

                        while (i == 0) {

                            System.out.println("Choose cargo aircraft:" +
                                    "\n 0 - Beluga, 1 - Cossack, 2 - Globemaster, e - Exit.");
                            String cargoChoice = in.nextLine();

                            switch (cargoChoice) {
                                case "0":
                                    Beluga beluga = new Beluga();
                                    System.out.println("Aircraft 'Beluga' created.");
                                    i = 1;
                                    break;
                                case "1":
                                    Cossack cossack = new Cossack();
                                    System.out.println("Aircraft 'Cossack' created.");
                                    i = 1;
                                    break;
                                case "2":
                                    Globemaster globe = new Globemaster();
                                    System.out.println("Aircraft 'Globemaster' created.");
                                    i = 1;
                                    break;
                                case "e":
                                    System.out.println("Exit from the program was initiated.");
                                    i = 1;
                                    break;
                                default:
                                    System.out.println("Incorrect value. Please, try again.");
                                    break;

                            }
                        }

                    } else if ("1".equals(secondChoice)) {

                        while (i == 0) {

                            System.out.println("Choose cargo aircraft:" +
                                    "\n 0 - Airbus, 1 - Noname, 2 - Noname, e - Exit.");
                            String airlinerChoice = in.nextLine();

                            switch (airlinerChoice) {
                                case "0":
                                    Airbus airbus = new Airbus();
                                    System.out.println("Aircraft 'Airbus' created.");
                                    i = 1;
                                    break;
                                case "1":
                                    System.out.println("Noname - 1");
                                    i = 1;
                                    break;
                                case "2":
                                    System.out.println("Noname - 2");
                                    i = 1;
                                    break;
                                case "e":
                                    System.out.println("Exit from the program was initiated.");
                                    i = 1;
                                    break;
                                default:
                                    System.out.println("Incorrect value. Please, try again.");
                                    break;

                            }
                        }
                    } else if ("e".equals(secondChoice)) {
                        System.out.println("Exit from the program was initiated.");
                        i = 1;
                    } else {
                        System.out.println("Incorrect value. Please, try again.");
                    }
                }
            } else if ("1".equals(choice)) {

                while (i == 0) {

                    System.out.println("Choose type of military aircraft: " +
                            "\n 0 - Bomber, 1 - Stormtrooper, e - Exit.");
                    String secondChoice = in.nextLine();

                    if ("0".equals(secondChoice)) {

                        while (i == 0) {

                            System.out.println("Choose bomber aircraft:" +
                                    "\n 0 - Fencer, 1 - Noname, 2 - Noname, e - Exit.");
                            String bomberChoice = in.nextLine();

                            switch (bomberChoice) {
                                case "0":
                                    Fencer fencer = new Fencer();
                                    System.out.println("Aircraft 'Fencer' created.");
                                    i = 1;
                                    break;
                                case "1":
                                    System.out.println("Noname - 1");
                                    i = 1;
                                    break;
                                case "2":
                                    System.out.println("Noname - 2");
                                    i = 1;
                                    break;
                                case "e":
                                    System.out.println("Exit from the program was initiated.");
                                    i = 1;
                                    break;
                                default:
                                    System.out.println("Incorrect value. Please, try again.");
                                    break;

                            }
                        }

                    } else if ("1".equals(secondChoice)) {

                        while (i == 0) {

                            System.out.println("Choose stormtrooper aircraft:" +
                                    "\n 0 - Dragonfly, 1 - Noname, 2 - Noname, e - Exit.");
                            String stormChoice = in.nextLine();

                            switch (stormChoice) {
                                case "0":
                                    Dragonfly dragon = new Dragonfly();
                                    System.out.println("Aircraft 'DragonFly' created.");
                                    i = 1;
                                    break;
                                case "1":
                                    System.out.println("Noname - 1");
                                    i = 1;
                                    break;
                                case "2":
                                    System.out.println("Noname - 2");
                                    i = 1;
                                    break;
                                case "e":
                                    System.out.println("Exit from the program was initiated.");
                                    i = 1;
                                    break;
                                default:
                                    System.out.println("Incorrect value. Please, try again.");
                                    break;

                            }
                        }
                    } else if ("e".equals(secondChoice)) {
                        System.out.println("Exit from the program was initiated.");
                        i = 1;
                    } else {
                        System.out.println("Incorrect value. Please, try again.");
                    }
                }

            } else if ("e".equals(choice)) {
                System.out.println("Exit from the program was initiated.");
                i = 1;
            } else {
                System.out.println("Incorrect value. Please, try again.");
            }

        }

    }
}
