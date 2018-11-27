package com.company;

public class VerschiebeAusschnitt {

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
}
