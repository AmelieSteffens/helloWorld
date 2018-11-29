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

    // 3x3 Ausschnitt verschieben
    public int[][] verschiebeAusschnitt(int[][] spielFeld, int pointX, int pointY) {

        int[][] ausschnitt = new int[3][3];

        for (int j = pointY; j < spielFeld.length - 1; j++) {
            for (int i = pointX; i < spielFeld.length - 1; i++) {
                ausschnitt = spielfeldHelper.kopiereAusschnitt(spielFeld, i, j);
            }
        }

        return ausschnitt;
    }

    //zeichne Generation
    public void drawNextGen() {
        spielfeldHelper.printArray(nextGeneration());
    }

    //berechne nächste Generation
    public int[][] nextGeneration() {

        int[][] nextGen = spielFeld;
        for (int i = 0; i < nextGen.length - 1; i++) {
            for (int j = 0; j < nextGen.length - 1; j++) {
                nextGen[i][j] = decideAliveOrNot();
            }
        }
        return nextGen;
    }
    private int decideAliveOrNot() {
        return entscheidungLebenTot.status(getNextExtract());
    }
    private int[][] getNextExtract() {
        return verschiebeAusschnitt (copyExtract(), 1, 1);
    }
    private int [][] copyExtract () {
        return spielfeldHelper.kopiereAusschnitt(spielFeld, 1, 1);
    }

}