package com.company;

public class SpielfeldHelper {

    public int [][] kopiereAusschnitt(int [][] spielFeld, int pointX, int pointY){

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

}
