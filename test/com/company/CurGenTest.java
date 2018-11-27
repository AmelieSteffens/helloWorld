package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class CurGenTest {

    CurGen sut;

    SpielfeldHelperStub spielfeldHelperStub;

    @BeforeEach
    void setUp() {
        spielfeldHelperStub = new SpielfeldHelperStub();

        sut = new CurGen(10, 10, spielfeldHelperStub);
    }

//    @Test
//    void zaehlNachbarn() {
//        //given:
//        sut.spielFeld[1][1] = 1;
//        sut.spielFeld[1][2] = 1;
//        sut.spielFeld[1][3] = 1;
//
//        //when:
//        int neighbourCount = sut.zaehlNachbarn(2, 2);
//
//
//        //then:
//        assertEquals(14, neighbourCount);
//
//    }


    @Test
    void verschiebeAusschnitt() {
        //given:
        int[][] returnedArray = new int[][]{
                {0, 1, 1},
                {0, 1, 1},
                {0, 1, 1}
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

        //when:
        boolean isMoved = sut.verschiebeAusschnitt(sut.spielFeld, 1, 1);

        //then:
        assertFalse(!isMoved);
        // bei erfolg = true

    }


    public int[][] fillArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = 0;
            }
        }
        return array;
    }


    class SpielfeldHelperStub extends SpielfeldHelper {

        public int[][] returnedArray;

        @Override
        public int[][] kopiereAusschnitt(int[][] spielFeld, int pointX, int pointY) {
            return returnedArray;

        }

    }
}