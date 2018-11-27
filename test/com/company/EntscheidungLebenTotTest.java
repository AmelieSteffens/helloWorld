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
    void status() {
        //given:
        int [][] test  = new int[][]{
                {0, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };

        //when:
        int status = sut.status(test);

        //then:
        assertEquals(1,status);
    }

    @Test
    void statusOhneStart(){
        //given:
        int [][] test  = new int[][]{
                {0, 1, 0},
                {1, 1, 1},
                {0, 0, 0}
        };

        //when:
        int status = sut.status(test);

        //then
        assertEquals(1, status);
    }
}