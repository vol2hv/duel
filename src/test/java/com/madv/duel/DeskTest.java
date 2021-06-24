package com.madv.duel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DeskTest {
    Desk desk = new Desk();

    @BeforeEach
    void setUp() {
        desk.init();
    }

    @Test
    void getItem() {
        assertEquals(0, desk.getItem(0));
        assertEquals(11, desk.getItem(11));
    }

    @Test
    void getRandomCard(){
        int numMax = 0;
        int numMin = 0;
        for (int i = 0; i < 1000 ; i++) {
            System.out.println();
            int res = desk.getRandomCard(desk.size());
            assertTrue(desk.contains(res));
            if (res == 0) {
                numMin++;
            }  else if ( res ==desk.size() - 1) {
                numMax++;
            }
        }
        assertTrue((numMax > 0)&&(numMin > 0));
    }

}