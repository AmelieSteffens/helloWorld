package com.company;

import java.io.IOException;
import java.util.Arrays;

import static java.util.Arrays.fill;

public class CurGen {

    //Definition Spielfeld
    final int zeile;
    final int spalte;
    int spielFeld[][];

    //Konstruktor
    CurGen(int zeile, int spalte) {
        this.zeile = zeile;
        this.spalte = spalte;

        spielFeld = new int[zeile][spalte];
    }


    // Nachbarn zählen
    public int zaehlNachbarn(int zeile, int spalte) {

        int anzahlNachbarn = 0;

        int [][] array = new int [zeile][spalte];

        for (int aktZeile = 0; aktZeile <= zeile; aktZeile++) {
            for (int aktSpalte = 0; aktSpalte <= spalte; aktSpalte++) {



                //Zellen, die nicht am Rand liegen
//                if (!isFirstRow(aktZeile) && !isLastRow(zeile, aktZeile) && !isFirstColumn(aktSpalte) && !isLastColumn(spalte, aktSpalte)) {
//
//                    System.out.println("Bedingung erfüllt.");
//
//                    int ausschnitt[][] = schneideAus(array); //deklarieren vor for-schleifen?
//
//                    for (int i = 0; i < 3; i++) {
//                        for (int j = 0; j < 3; j++) {
//                            if (ausschnitt[i][j] == 1) {
//                                anzahlNachbarn++;
//                            }
//                        }
//                    }
//                } else if (isFirstRow(aktZeile) || isLastRow(zeile, aktZeile)){
//                    if (isFirstRow(aktZeile)){
//                        System.out.println("1. zeile");
//                    } else {
//                        System.out.println("letzte Zeile");
//                    }
//                }



//                    if (isFirstRow(spielFeld[aktZeile - 1][aktSpalte - 1])) {
//                        anzahlNachbarn++;
//                    }
//
//                    if (isFirstRow(spielFeld[aktZeile - 1][aktSpalte])) {
//                        anzahlNachbarn++;
//                    }
//                    if (isFirstRow(spielFeld[aktZeile - 1][aktSpalte + 1])) {
//                        anzahlNachbarn++;
//                    }
//                    if (isFirstRow(spielFeld[aktZeile][aktSpalte - 1])) {
//                        anzahlNachbarn++;
//                    }
//                    if (isFirstRow(spielFeld[aktZeile][aktSpalte + 1])) {
//                        anzahlNachbarn++;
//                    }
//                    if (isFirstRow(spielFeld[aktZeile + 1][aktSpalte - 1])) {
//                        anzahlNachbarn++;
//                    }
//                    if (isFirstRow(spielFeld[aktZeile + 1][aktSpalte])) {
//                        anzahlNachbarn++;
//                    }
//                    if (isFirstRow(spielFeld[aktZeile + 1][aktSpalte + 1])) {
//                        anzahlNachbarn++;
//                    }
                    //Zellen erste Zeile
                    }

                    /* else if (aktZeile = 0 && (aktSpalte > 0) && (aktSpalte < spalte - 1)) {
                    if (spielFeld[aktZeile][aktSpalte - 1] > 0) {
                        anzahlNachbarn++;
                    }
                    if (spielFeld[aktZeile][aktSpalte + 1] > 0) {
                        anzahlNachbarn++;
                    }
                    if (spielFeld[aktZeile + 1][aktSpalte - 1] > 0) {
                        anzahlNachbarn++;
                    }
                    if (spielFeld[aktZeile + 1][aktSpalte] > 0) {
                        anzahlNachbarn++;
                    }
                    if (spielFeld[aktZeile + 1][aktSpalte + 1] > 0) {
                        anzahlNachbarn++;
                    }
                    //Zellen erste Spalte
                } else if (aktSpalte = 0 && (aktZeile > 0) && (aktZeile < zeile - 1)) {
                    if (spielFeld[aktZeile - 1][aktSpalte] > 0) {
                        anzahlNachbarn++;
                    }
                    if (spielFeld[aktZeile - 1][aktSpalte + 1] > 0) {
                        anzahlNachbarn++;
                    }
                    if (spielFeld[aktZeile + 1][aktSpalte] > 0) {
                        anzahlNachbarn++;
                    }
                    if (spielFeld[aktZeile + 1][aktSpalte] > 0) {
                        anzahlNachbarn++;
                    }
                    if (spielFeld[aktZeile + 1][aktSpalte + 1] > 0) {
                        anzahlNachbarn++;
                    }
                    //Zelle letzte Zeile
                } else if (aktZeile = zeile && (aktSpalte > 0) && (aktSpalte < spalte - 1)) {
                    if (spielFeld[aktZeile - 1][aktSpalte - 1] > 0) {
                        anzahlNachbarn++;
                    }
                    if (spielFeld[aktZeile - 1][aktSpalte] > 0) {
                        anzahlNachbarn++;
                    }
                    if (spielFeld[aktZeile - 1][aktSpalte + 1] > 0) {
                        anzahlNachbarn++;
                    }
                    if (spielFeld[aktZeile][aktSpalte - 1] > 0) {
                        anzahlNachbarn++;
                    }
                    if (spielFeld[aktZeile][aktSpalte + 1] > 0) {
                        anzahlNachbarn++;
                    }
                    //Zelle letzte Spalte
                } else if (aktSpalte = spalte && (aktZeile > 0) && (aktZeile < zeile - 1)) {
                    if (spielFeld[aktZeile - 1][aktSpalte - 1] > 0) {
                        anzahlNachbarn++;
                    }
                    if (spielFeld[aktZeile - 1][aktSpalte] > 0) {
                        anzahlNachbarn++;
                    }
                    if (spielFeld[aktZeile][aktSpalte - 1] > 0) {
                        anzahlNachbarn++;
                    }
                    if (spielFeld[aktZeile + 1][aktSpalte - 1] > 0) {
                        anzahlNachbarn++;
                    }
                    if (spielFeld[aktZeile + 1][aktSpalte] > 0) {
                        anzahlNachbarn++;
                    }
                    //Zelle OL
                } else if (aktZeile = 0 && aktSpalte = 0) {
                    if (spielFeld[aktZeile + 1][aktSpalte] > 0) {
                        anzahlNachbarn++;
                    }
                    if (spielFeld[aktZeile + 1][aktSpalte + 1] > 0) {
                        anzahlNachbarn++;
                    }
                    if (spielFeld[aktZeile][aktSpalte + 1] > 0) {
                        anzahlNachbarn++;
                    }
                    // Zelle OR
                } else if (aktZeile = 0 && aktSpalte = spalte) {
                    if (spielFeld[aktZeile][aktSpalte - 1] > 0) {
                        anzahlNachbarn++;
                    }
                    if (spielFeld[aktZeile + 1][aktSpalte - 1] > 0) {
                        anzahlNachbarn++;
                    }
                    if (spielFeld[aktZeile + 1][aktSpalte] > 0) {
                        anzahlNachbarn++;
                    }
                    //Zelle UL
                } else if (aktZeile = zeile && aktSpalte = 0) {
                    if (spielFeld[aktZeile - 1][aktSpalte] > 0) {
                        anzahlNachbarn++;
                    }
                    if (spielFeld[aktZeile - 1][aktSpalte + 1] > 0) {
                        anzahlNachbarn++;
                    }
                    if (spielFeld[aktZeile][aktSpalte + 1] > 0) {
                        anzahlNachbarn++;
                    }
                    //Zelle UR
                } else if (aktZeile = zeile && aktSpalte = spalte) {
                    if (spielFeld[aktZeile - 1][aktSpalte - 1] > 0) {
                        anzahlNachbarn++;
                    }
                    if (spielFeld[aktZeile - 1][aktSpalte] > 0) {
                        anzahlNachbarn++;
                    }
                    if (spielFeld[aktZeile][aktSpalte - 1] > 0) {
                        anzahlNachbarn++;
                    }
                }*/
            //}
        }
        return anzahlNachbarn;
    }

    private boolean isLastColumn(int spalte, int aktSpalte) {
        return aktSpalte == spalte;
    }

    private boolean isLastRow(int zeile, int aktZeile) {
        return aktZeile == zeile;
    }

    private boolean isFirstRow(int aktZeile) {
        return aktZeile == 0;
    }

    private boolean isFirstColumn(int aktSpalte) {
        return aktSpalte == 0;
    }


    public int[][] schneideAus(int[][] spielFeld, int cellX, int cellY) {

        int[][] ausschnitt = new int[3][3];

        for (int i = cellX - 1; i < ausschnitt.length; i++) {
            for (int j = cellY - 1; j < ausschnitt.length; j++) {
                ausschnitt[i][j] = spielFeld[i][j];
            }
        }
        return ausschnitt;
    }

    public int[][] schneideAusRobust(int[][] spielFeld, int startX, int startY) {

        int[][] ausschnitt = new int[3][3];

        for (int i = startX; i < ausschnitt.length; i++) {
            for (int j = startY; j < ausschnitt.length; j++) {

                //funktioniert mit if nicht
                while (startX == 1){
                    ausschnitt[i-1][j] = 0;
                    startX++;
                }
                while (startY == 1) {
                    ausschnitt[i][j - 1] = 0;
                    startY++;
                }

                while (startX == ausschnitt.length-1){
                    ausschnitt[startX+1][j] = 0;
                    break;
                }
                while (startY == ausschnitt.length-1){
                    ausschnitt[i][startY+1] = 0;
                    break;
                }
                ausschnitt[i][j] = spielFeld[i][j];
            }
        }
        return ausschnitt;
    }

    public int [][] scanRobust (int [][] spielFeld, int pointX, int pointY){

        int [][]ausschnitt = new int [3][3];

        if (pointX == 0 || pointY == 0 || pointX == spielFeld.length || pointY == spielFeld.length){
            System.out.println("Kein valider Startpunkt.");
        }
        else {
            for (int i = pointX; i < 3; i++) {
                for (int j = pointY; j < 3; j++) {
                    ausschnitt[i][j] = spielFeld[i][j];
                }
            }
        }
        return ausschnitt;
    }


    //nächste Generation erzeugen
   /* public int[][] nextGen(int[][] curGen, int zeilen, int spalten) {

        int[][] nextGen = new int[zeilen][];
        for (int aktZeile = 0; aktZeile < zeile; aktZeile++) {
            nextGen[aktZeile] = Array.copyOf(curGen[aktZeile], spalte);
        }

        for (int aktZeile = 0; aktZeile < zeile; aktZeile++) {
            for (int aktSpalte = 0; aktSpalte < spalte; aktSpalte++) {
                int anzahlNachbarn = zaehlNachbarn(curGen, zeile, spalte, aktZeile, aktSpalte);

                //Tote Zelle, 3 Nachbarn, Wiedergeburt
                if (i = 0 && anzahlNachbarn = 3) {
                    i == 1;
                }
                //Lebende Zelle, weniger als 2 Nachbarn, Tod
                if (i = 1 && anzahlNachbarn < 2) {
                    i == 0;
                }
                //Lebende Zelle, 2 oder 3 Nachbarn, lebend
                if (i = 1 && anzahlNachbarn = 2 || anzahlNachbarn = 3) {
                    i == 1;
                }
                //Lebende Zelle, mehr als 2 Nachbarn, Tod
                if (i = 1 && anzahlNachbarn > 3) {
                    i == 0;
                }
            }
        }
        return nextGen;
    }*/

}