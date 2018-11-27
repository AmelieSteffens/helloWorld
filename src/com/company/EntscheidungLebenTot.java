package com.company;

public class EntscheidungLebenTot {

    public int countNeighbors(int[][] ausschnitt) {
        int neighbors = 0;

        for (int i = 0; i < ausschnitt.length; i++) {
            for (int j = 0; j < ausschnitt.length; j++) {
                if (ausschnitt[i][j] == 1) {
                    neighbors++;
                }
            }
        }
        return neighbors;
    }

    public int testStatus(int neighbors) {
        int status = 0;

        if (neighbors < 2 || neighbors > 3) {
            status = 0;
        } else if (neighbors == 3) {
            status = 1;
        }
        return status;
    }
}
