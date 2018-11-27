package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CurGenTest {

    CurGen sut;

    @BeforeEach
    void setUp() {
        sut = new CurGen(10, 10);
    }

    @Test
    void zaehlNachbarn() {
        //given:
        sut.spielFeld[1][1] = 1;
        sut.spielFeld[1][2] = 1;
        sut.spielFeld[1][3] = 1;

        //when:
        int neighbourCount = sut.zaehlNachbarn(2, 2);


        //then:
        assertEquals(14, neighbourCount);

    }

    @Test
    void robusterScan (){
        //given:
        sut.spielFeld = fillArray1Rand0(sut.spielFeld);

        //and:
        int[][] expectedAusschnitt = new int[][]{
                { 0, 1, 1 },
                { 0, 1, 1 },
                { 0, 1, 1 }
        };

        //when:
        int [][] ausschnitt = sut.scanRobust(sut.spielFeld, 4,1);

        System.out.println("expected:");
        printArray(expectedAusschnitt);

        System.out.println("ausschnitt:");
        printArray(ausschnitt);

        //then:
        assertArrayEquals(expectedAusschnitt,ausschnitt);

    }

    @Test
    void verschiebeAusschnitt (){
        //given:
        sut.spielFeld = fillArray(sut.spielFeld);
        sut.spielFeld[1][1] = 1;
        sut.spielFeld[1][2] = 1;
        sut.spielFeld[1][3] = 1;
        sut.spielFeld[4][4] = 1;
        sut.spielFeld[4][5] = 1;
        sut.spielFeld[5][4] = 1;
        sut.spielFeld[7][7] = 1;

        //when:
        boolean isMoved = sut.verschiebeAusschnitt(sut.spielFeld,1,1);

        //then:
        assertFalse(!isMoved);
        // bei erfolg = true
    }


    @Test
//    void countNeighboursAusschnitt (){
//        //given:
//        sut.spielFeld = fillArray1Rand0(sut.spielFeld);
//        sut.scanRobust(sut.spielFeld);
//        //when:
//
//        //then:
//    }

    public void printArray(int  [][] array){
        for ( int zeile = 0; zeile < array.length; zeile++ )
        {
            System.out.print("Zeile " + zeile + ": ");
            for ( int spalte=0; spalte < array[zeile].length; spalte++ )
                System.out.print( array[zeile][spalte] + " ");
            System.out.println();
        }

    }

    public int [][] fillArray (int [][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = 0;
            }
        }
        return array;
    }

    public int [][] fillArray1Rand0 (int [][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == 0 || j == 0){
                    array [i][j] = 0;
                }
                else if (i == array.length-1 || j == array.length-1){
                    array[i][j] = 0;
                }
                else {
                    array [i][j] = 1;
                }
            }
        }
        return array;
    }

}