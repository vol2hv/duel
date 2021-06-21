package com.madv.duel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeskTest {
    @Test
    void fillDesk() {
        Desk<Integer> desk = new Desk<>();
        desk.fillDesk(0,9);
        assertEquals(10, desk.size());
        assertTrue(desk.contains(0));
        assertTrue(desk.contains(9));
    }

    @Test
    void getLast() {
        Desk<Integer> desk = new Desk<>();
        desk.add(6);
        assertEquals(6, desk.getLast());
    }
}