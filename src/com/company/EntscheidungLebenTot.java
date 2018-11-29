package com.company;

public class EntscheidungLebenTot {


    /**
     * Coole Doku
     *
     * @param ausschnitt
     * @return int
     */
    public int status(int[][] ausschnitt) {
        int neighbors = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ausschnitt[j][i] == 1) {
                    neighbors++;
                }
            }
        }

        if (ausschnitt[1][1] == 1) {
            neighbors = neighbors - 1;
        }

        if ((neighbors == 2) && ausschnitt[1][1] == 1 || (neighbors == 3)) {
            return 1;
        } else {
            return 0;
        }
    }
}
