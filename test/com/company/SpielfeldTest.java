package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SpielfeldTest {

    Spielfeld sut;
    SpielfeldHelperStub spielfeldHelperStub;

    @BeforeEach
    void setUp() {
        spielfeldHelperStub = new SpielfeldHelperStub();

        sut = new Spielfeld(10, 10, spielfeldHelperStub);
    }

    @Test
    void verschiebeAusschnitt() {
        //given:
        int[][] returnedArray = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 0}
        };

        spielfeldHelperStub.returnedArray = returnedArray;

        sut.spielFeld = fillArray(sut.spielFeld);
        sut.spielFeld[1][1] = 1;
        sut.spielFeld[1][2] = 1;
        sut.spielFeld[1][3] = 1;
        sut.spielFeld[4][4] = 1;
        sut.spielFeld[4][5] = 1;
        sut.spielFeld[5][4] = 1;
        sut.spielFeld[7][7] = 1;
        sut.spielFeld[6][7] = 1;
        sut.spielFeld[6][6] = 1;
        sut.spielFeld[7][6] = 1;

        //when:
        int [][] isMoved = sut.verschiebeAusschnitt(sut.spielFeld, 1, 1);
        printArray(isMoved);
        //then:
        assertArrayEquals(returnedArray,isMoved);
    }


    public int[][] fillArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = 0;
            }
        }
        return array;
    }

    public void printArray(int[][] array) {
        for (int zeile = 0; zeile < array.length; zeile++) {
            System.out.print("Zeile " + zeile + ": ");
            for (int spalte = 0; spalte < array[zeile].length; spalte++)
                System.out.print(array[zeile][spalte] + " ");
            System.out.println();
        }

    }

    class SpielfeldHelperStub extends SpielfeldHelper {

        public int[][] returnedArray;

        @Override
        public int[][] kopiereAusschnitt(int[][] spielFeld, int pointX, int pointY) {
            return returnedArray;

        }
    }
}