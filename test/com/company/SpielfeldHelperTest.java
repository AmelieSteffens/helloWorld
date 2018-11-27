package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SpielfeldHelperTest {

    SpielfeldHelper sut;
    int[][] spielFeld = new int[10][10];

    @BeforeEach
    void setUp() {
        sut = new SpielfeldHelper();

    }

    @Test
    void robusterScan() {
        //given:
        spielFeld = fillArray1Rand0(spielFeld);

        //and:
        int[][] expectedAusschnitt = new int[][]{
                {0, 1, 1},
                {0, 1, 1},
                {0, 1, 1}
        };

        //when:
        int[][] ausschnitt = sut.kopiereAusschnitt(spielFeld, 4, 1);

        System.out.println("expected:");
        printArray(expectedAusschnitt);

        System.out.println("ausschnitt:");
        printArray(ausschnitt);

        //then:
        assertArrayEquals(expectedAusschnitt, ausschnitt);

    }


    public void printArray(int[][] array) {
        for (int zeile = 0; zeile < array.length; zeile++) {
            System.out.print("Zeile " + zeile + ": ");
            for (int spalte = 0; spalte < array[zeile].length; spalte++)
                System.out.print(array[zeile][spalte] + " ");
            System.out.println();
        }

    }

    public int[][] fillArray1Rand0(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == 0 || j == 0) {
                    array[i][j] = 0;
                } else if (i == array.length - 1 || j == array.length - 1) {
                    array[i][j] = 0;
                } else {
                    array[i][j] = 1;
                }
            }
        }
        return array;
    }

}