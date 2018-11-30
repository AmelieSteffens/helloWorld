package com.company;

public class EntscheidungLebenTot {

    public int status(int[][] ausschnitt) {
        int neighbors = 0;

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (ausschnitt[x][y] == 1) {
                    neighbors++;
                }
            }
        }

        if (ausschnitt[1][1] == 1) {
            neighbors = neighbors - 1;
        }

        if ((neighbors == 3)||((neighbors == 2) && ausschnitt[1][1] == 1)) {
            return 1;
        } else {
            return 0;
        }
    }
}
