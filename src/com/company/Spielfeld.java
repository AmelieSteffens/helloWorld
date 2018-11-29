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

    // 3x3 Ausschnitt verschieben & Anwendung Regeln!
    public int[][] verschiebeAusschnitt(int[][] spielFeld, int pointX, int pointY) {

        int[][] ausschnitt;

        for (int j = pointY; j < spielFeld.length - 1; j++) {
            for (int i = pointX; i < spielFeld.length - 1; i++) {
                ausschnitt = spielfeldHelper.kopiereAusschnitt(spielFeld, i, j);
                spielFeld[i][j] = entscheidungLebenTot.status(ausschnitt);
            }
        }
        return spielFeld;
    }

    //zeichne Generation
    public void drawNextGen() {
        spielfeldHelper.printArray(nextGeneration());
    }

    //berechne nächste Generation
    public int[][] nextGeneration() {

        for (int y = 1; y < spielFeld.length - 1; y++) {
            for (int x = 1; x < spielFeld[y].length - 1; x++) {
                spielFeld[x][y] = decideAliveOrNot(x,y) [x][y];
            }
        }
        return spielFeld;
    }


    private int [][] decideAliveOrNot(int i, int j) {
        return verschiebeAusschnitt(spielFeld, i, j);
    }

}