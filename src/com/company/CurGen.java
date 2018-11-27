package com.company;

public class CurGen {

    //Definition Spielfeld
    final int zeile;
    final int spalte;
    int spielFeld[][];

    SpielfeldHelper spielfeldHelper;

    //Konstruktor
    CurGen(int zeile, int spalte, SpielfeldHelper spielfeldHelper) {
        this.zeile = zeile;
        this.spalte = spalte;

        spielFeld = new int[zeile][spalte];

        this.spielfeldHelper = spielfeldHelper;
    }

//    // Nachbarn zählen
//
//    public int zaehlNachbarn(int zeile, int spalte) {
//
//        int anzahlNachbarn = 0;
//
//        int [][] array = new int [zeile][spalte];
//
//        for (int aktZeile = 0; aktZeile <= zeile; aktZeile++) {
//            for (int aktSpalte = 0; aktSpalte <= spalte; aktSpalte++) {
//
//                int[][] ausschnitt = kopiereAusschnitt(array, zeile, spalte);
//            }
//        }
//        return anzahlNachbarn;
//    }

    public boolean verschiebeAusschnitt(int[][] spielFeld, int pointX, int pointY) {
        boolean isMoved = false;
        int[][] ausschnitt = spielfeldHelper.kopiereAusschnitt(spielFeld, pointX, pointY);
        try {
            for (int j = pointY; j < spielFeld.length - 1; j++) {
                for (int i = pointX; i < spielFeld.length - 1; i++) {
                    ausschnitt = spielfeldHelper.kopiereAusschnitt(spielFeld, i, j);
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

    public void printArray(int[][] array) {
        for (int zeile = 0; zeile < array.length; zeile++) {
            System.out.print("Zeile " + zeile + ": ");
            for (int spalte = 0; spalte < array[zeile].length; spalte++)
                System.out.print(array[zeile][spalte] + " ");
            System.out.println();
        }

    }
}