package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CurGenTest {

    CurGen sut;

    @BeforeEach
    void setUp() {
        sut = new CurGen(9, 9);
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
    void schneideAus3x3 (){
        //given:
        sut.spielFeld[0][0] = 1;
        sut.spielFeld[0][1] = 1;
        sut.spielFeld[0][2] = 1;

        //and:
        int[][] expectedAusschnitt = new int[][]{
                { 1, 1, 1 },
                { 0, 0, 0 },
                { 0, 0, 0 }
        };

        //when:
        int [][] ausschnitt = sut.schneideAus(sut.spielFeld, 1,1);

        System.out.println("expected:");
        printArray(expectedAusschnitt);
        System.out.println(expectedAusschnitt[0]);

        System.out.println("ausschnitt:");
        printArray(ausschnitt);
        System.out.println(ausschnitt[0]);

        //then:
        assertArrayEquals(expectedAusschnitt, ausschnitt);

    }

    @Test
    void schneideAus2x2 (){
        //given:
        sut.spielFeld[0][0] = 1;
        sut.spielFeld[0][1] = 1;
        sut.spielFeld[0][2] = 1;

        //and:
        int[][] expectedAusschnitt = new int[][]{
                { 1, 1 },
                { 0, 0 }
        };

        //when:
        int [][] ausschnitt = sut.schneideAus(sut.spielFeld,0,0);

        System.out.println("expected:");
        printArray(expectedAusschnitt);
        System.out.println(expectedAusschnitt[0]);

        System.out.println("ausschnitt:");
        printArray(ausschnitt);
        System.out.println(ausschnitt[0]);

        //then:
        assertArrayEquals(expectedAusschnitt, ausschnitt);

    }

    @Test
    void startingPointOL (){
        //given:
        sut.spielFeld[1][1] = 1;
        sut.spielFeld[1][2] = 1;
        sut.spielFeld[1][3] = 1;

        //and:
        int[][] expectedAusschnitt = new int[][]{
                { 0, 0, 0 },
                { 0, 1, 1 },
                { 0, 0, 0 }
        };

        //when:
        int [][] ausschnitt = sut.schneideAusRobust(sut.spielFeld, 1,1);

        System.out.println("expected:");
        printArray(expectedAusschnitt);

        System.out.println("ausschnitt:");
        printArray(ausschnitt);

        //then:
        assertArrayEquals(expectedAusschnitt,ausschnitt);
    }

    @Test
    void startingPointUR () {
        //given:
        sut.spielFeld[7][8] = 1;
        sut.spielFeld[8][7] = 1;
        sut.spielFeld[8][8] = 1;

        //and:
        int[][] expectedAusschnitt = new int[][]{
                { 0, 1, 0 },
                { 1, 1, 0 },
                { 0, 0, 0 }
        };

        //when:
        int [][] ausschnitt = sut.schneideAusRobust(sut.spielFeld, 8,8);

        System.out.println("expected:");
        printArray(expectedAusschnitt);

        System.out.println("ausschnitt:");
        printArray(ausschnitt);

        //then:
        assertArrayEquals(expectedAusschnitt,ausschnitt);
    }

    @Test
    void robusterScan (){
        //given:
        sut.spielFeld[1][1] = 1;
        sut.spielFeld[1][2] = 1;
        sut.spielFeld[1][3] = 1;

        //and:
        int[][] expectedAusschnitt = new int[][]{
                { 0, 0, 0 },
                { 0, 1, 1 },
                { 0, 0, 0 }
        };

        //and:
        //wenn nicht anders spezifiziert: array komplett mit 0 gefüllt --> äußerer rand auch mit 0 gefüllt

        //when:
        int [][] ausschnitt = sut.scanRobust(sut.spielFeld, 1,1);

        System.out.println("expected:");
        printArray(expectedAusschnitt);

        System.out.println("ausschnitt:");
        printArray(ausschnitt);

        //then:
        assertArrayEquals(expectedAusschnitt,ausschnitt);

    }

    public void printArray(int  [][] array){
        for ( int zeile = 0; zeile < array.length; zeile++ )
        {
            System.out.print("Zeile " + zeile + ": ");
            for ( int spalte=0; spalte < array[zeile].length; spalte++ )
                System.out.print( array[zeile][spalte] + " ");
            System.out.println();
        }

    }

}