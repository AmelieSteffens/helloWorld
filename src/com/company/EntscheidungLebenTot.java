package com.company;

public class EntscheidungLebenTot {


    /**
     *Coole Doku
     *
     * @param ausschnitt
     * @return int
     */
    public int status (int[][] ausschnitt) {
        int neighbors = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ausschnitt[i][j] == 1) {
                    if (i == 1 && j == 1){
                        break;
                    }
                    neighbors++;
                }
            }
        }
        if ((neighbors == 2) || (neighbors == 3)) {
            return 1;
        }
        return 0;
    }
}
