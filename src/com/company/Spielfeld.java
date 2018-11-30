package com.company;

public class Spielfeld {

    //Definition Spielfeld
    final int zeile;
    final int spalte;
    int spielFeld[][];

    SpielfeldHelper spielfeldHelper;
    EntscheidungLebenTot entscheidungLebenTot;

    //Konstruktor
    Spielfeld(int zeile, int spalte, SpielfeldHelper spielfeldHelper) {
        this.zeile = zeile;
        this.spalte = spalte;
        this.spielfeldHelper = spielfeldHelper;
        spielFeld = new int[zeile][spalte];
        this.entscheidungLebenTot = new EntscheidungLebenTot();
    }

     //3x3 Ausschnitt verschieben
    public int[][] verschiebeAusschnitt(int[][] spielFeld, int pointX, int pointY) {

        return spielfeldHelper.kopiereAusschnitt(spielFeld, pointX, pointY);
    }

    //zeichne Generation
    public void drawNextGen() {

        spielfeldHelper.printArray(nextGeneration());
    }

    //berechne nächste Generation
    public int[][] nextGeneration() { // nach erstem durchlauf, ausführung nicht mehr auf beginn sondern ergebnis erster durchlauf

        int [][]ausschnitt;
        int [][]nextGen = new int [zeile][spalte];

        for (int y = 1; y < spielFeld.length - 1; y++) {
            for (int x = 1; x < spielFeld[y].length - 1; x++) {
                ausschnitt = spielfeldHelper.kopiereAusschnitt(spielFeld,x,y);
                nextGen[x][y] = entscheidungLebenTot.status(ausschnitt);
            }
        }
        return nextGen;
    }

}