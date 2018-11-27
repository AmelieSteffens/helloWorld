package com.company;

import java.util.Scanner;

public class GameOfLife {
    //Main
    public static void main(String[] args) {

        Scanner eingabe = new Scanner(System.in);

        SpielfeldHelper spielfeldHelper = new SpielfeldHelper();

        CurGen curGen = new CurGen(10, 10, spielfeldHelper);

        System.out.println("Wie viele Schritte möchten Sie sehen?");
        int x = eingabe.nextInt();

        for (int i = 0; i < x; i++) {
            System.out.println("Step " + i);
            curGen.nextGeneration();
        }


//        CurGen spielBeginn = new CurGen(100, 100);
//        spielBeginn.zeichnen();
//        NextGen nextStep = new NextGen(spielBeginn);
//
//        for (int i = 0; i <= x-1; i++) {
//             NextGen nextStep = new NextGen(nextStep);
//             zaehlNachbarn methode
//            nextStep.nextGen(nextStep, 100, 100)
//            zeichnen
//        }
    }
}