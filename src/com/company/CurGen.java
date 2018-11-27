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

                int [][] ausschnitt = scanRobust(array,zeile,spalte);



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


    public int [][] scanRobust (int [][] spielFeld, int pointX, int pointY){

        int [][]ausschnitt = new int [3][3];

        if (pointX == 0 || pointY == 0 || pointX == spielFeld.length-1 || pointY == spielFeld.length-1){
            int i = spielFeld.length-1;
            throw new IllegalArgumentException("Kein valider Startpunkt. Keiner der Punkte darf 0 bzw. gleich oder größer " + i +" sein.");
        }
        else {
            for (int j = pointY; j < 3 + pointY; j++) {
                for (int i = pointX; i < 3 + pointX; i++){
                    ausschnitt[i-pointX][j-pointY] = spielFeld[i-1][j-1];
                }
            }
        }
        return ausschnitt;
    }

    public boolean verschiebeAusschnitt(int[][] spielFeld, int pointX, int pointY) {
        boolean isMoved = false;
        int[][] ausschnitt = scanRobust(spielFeld, pointX, pointY);
        try {
            for (int j = pointY; j < spielFeld.length-1; j++) {
                for (int i = pointX; i < spielFeld.length-1; i++) {
                    ausschnitt = scanRobust(spielFeld, i, j);
                    //printArray(ausschnitt);
                    //System.out.println("X: "+ i);
                    //System.out.println("Y: "+ j);
                    isMoved = true;
                }
            }
        } catch (IllegalArgumentException e) {
            isMoved = false;
        }
        return isMoved;
    }

    public void printArray(int  [][] array){
        for ( int zeile = 0; zeile < array.length; zeile++ )
        {
            System.out.print("Zeile " + zeile + ": ");
            for ( int spalte=0; spalte < array[zeile].length; spalte++ )
                System.out.print( array[zeile][spalte] + " ");
            System.out.println();
        }

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