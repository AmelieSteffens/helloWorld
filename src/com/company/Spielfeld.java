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

    // 3x3 Ausschnitt verschieben //cursor --> weniger forschleife
    public int[][] verschiebeAusschnitt(int[][] spielFeld, int pointX, int pointY) {

        int[][] ausschnitt = spielFeld;

        for (int y = pointY; y < spielFeld.length - 1; y++) {
            for (int x = pointX; x < spielFeld[x].length - 1; x++) {
                ausschnitt = spielfeldHelper.kopiereAusschnitt(spielFeld, y, x);
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

        int [][]ausschnitt = spielFeld;

        for (int y = 1; y < spielFeld.length - 1; y++) {
            for (int x = 1; x < spielFeld[y].length - 1; x++) {
                ausschnitt = verschiebeAusschnitt(spielFeld,y,x);
                spielFeld[y][x] = entscheidungLebenTot.status(ausschnitt);

            }
        }
        return spielFeld;
    }


    private int [][] decideAliveOrNot(int i, int j) {
        return verschiebeAusschnitt(spielFeld, i, j);
    }

}