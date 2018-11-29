package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntscheidungLebenTotTest {

    EntscheidungLebenTot sut;

    @BeforeEach
    void setUp(){
        sut = new EntscheidungLebenTot();
    }

    @Test
    void statusStart1() {
        //given:
        int [][] test  = new int[][]{
                {0, 1, 0},
                {1, 1, 1},
                {0, 0, 0}
        };

        //when:
        int status = sut.status(test);

        //then:
        assertEquals(1,status);
        //mit 2 oder 3 Nachbarn wiedergeboren
    }

    @Test
    void statusStart0(){
        //given:
        int [][] test  = new int[][]{
                {0, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };

        //when:
        int status = sut.status(test);

        //then
        assertEquals(1, status);
        //nur mit GENAU 3 Nachbarn zum Leben erweckt
    }
}