package com.company;

public class Cell {

    boolean isAlive;

    //Konstruktor
    Cell (boolean isAlive, int neighbors){
        this.isAlive = isAlive;
    }

    //status
    public boolean isAlive(boolean[][] ausschnitt) {
        int neighbors = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ausschnitt[i][j]) {
                    neighbors++;
                }
            }
        }

        if (ausschnitt[1][1]) {
            neighbors = neighbors - 1;
        }

        if ((neighbors == 2) && ausschnitt[1][1] || (neighbors == 3)) {
            return true;
        } else {
            return false;
        }
    }

}
