package com.company;

import java.util.Scanner;

public class GameOfLife {

    public static void main(String[] args) {

        Scanner eingabe = new Scanner(System.in);

        SpielfeldHelper spielfeldHelper = new SpielfeldHelper();

        Spielfeld beginn = new Spielfeld(10, 10, spielfeldHelper);

        beginn.spielFeld = erzeugeStart();

        System.out.println("Wie viele Schritte möchten Sie sehen?");
        int x = eingabe.nextInt();

        for (int i = 0; i < x; i++) {
            System.out.println("Step " + (i + 1));
            System.out.println();
            beginn.drawNextGen();
            System.out.println();
        }
    }

    private static int[][] erzeugeStart() {
        return new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0, 1, 1, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
    }
}