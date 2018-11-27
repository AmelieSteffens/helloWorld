package com.company;

public class Spielfeld {

    EntscheidungLebenTot entscheidungLebenTot;

    //Definition Spielfeld
    final int zeile;
    final int spalte;
    int spielFeld[][];

    SpielfeldHelper spielfeldHelper;

    //Konstruktor
    Spielfeld(int zeile, int spalte, SpielfeldHelper spielfeldHelper) {
        this.zeile = zeile;
        this.spalte = spalte;
        this.spielfeldHelper = spielfeldHelper;
        spielFeld = new int[zeile][spalte];
        this.entscheidungLebenTot = new EntscheidungLebenTot();
    }

    public int [][] verschiebeAusschnitt(int [][] spielFeld, int pointX, int pointY) {

        int[][] ausschnitt = spielfeldHelper.kopiereAusschnitt(spielFeld, pointX, pointY);

            for (int j = pointY; j < spielFeld.length - 1; j++) {
                for (int i = pointX; i < spielFeld.length - 1; i++) {
                    ausschnitt = spielfeldHelper.kopiereAusschnitt(spielFeld, i, j);
                }
            }

        return ausschnitt;
    }

    public void drawNextGen (){
        //zeichne
        spielfeldHelper.printArray(nextGeneration());
    }

    public int[][] nextGeneration() {

        int[][] nextGen = spielFeld;
        for (int i = 0; i < nextGen.length-1; i++) {
            for (int j = 0; j < nextGen.length-1; j++) {
                nextGen[i][j] = entscheidungLebenTot.status(verschiebeAusschnitt(spielfeldHelper.kopiereAusschnitt(spielFeld, 1, 1), 1, 1));
            }
        }
        return nextGen;
    }


}