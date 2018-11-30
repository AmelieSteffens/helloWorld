package com.company;

public class SpielfeldHelper {

    public int[][] kopiereAusschnitt(int[][] spielFeld, int pointX, int pointY) {

        int[][] ausschnitt = new int[3][3];

        if (pointX == 0 || pointY == 0 || pointX == spielFeld[pointY].length - 1 || pointY == spielFeld.length - 1) {
            int i = spielFeld.length - 1;
            throw new IllegalArgumentException("Kein valider Startpunkt. Keiner der Punkte darf 0 bzw. gleich oder größer " + i + " sein.");
        } else {
            for (int y = pointY; y < 3 + pointY; y++) {
                for (int x = pointX; x < 3 + pointX; x++) {
                    ausschnitt[x - pointX][y - pointY] = spielFeld[x - 1][y - 1];
                }
            }
        }
        return ausschnitt;
    }


    public void printArray(int[][] array) {
        for (int x = 0; x < array.length; x++) {
            System.out.print("Zeile " + x + ": ");
            for (int y = 0; y < array[x].length; y++)

                if (array[x][y] == 0){
                    System.out.print("_ ");
                } else {
                    System.out.print("X ");
                }
            System.out.println();
        }

    }
}
