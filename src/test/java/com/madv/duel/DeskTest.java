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
    void getFirst() {
        Desk<Integer> desk = new Desk<>();
        desk.add(6);

        assertEquals(6, desk.getFirst());
    }

    @Test
    void init() {
        Desk<Integer> desk = new Desk<>();
        desk.init();
        assertEquals(Game.MAX_CARDS, desk.size());
        assertTrue(desk.contains(0));
        assertFalse(desk.contains(Game.MAX_CARDS));
    }
    @Test
    void install() {
        Desk<Integer> desk = new Desk<>();
        desk.init();
        desk.fillDesk(0,99);
        assertEquals(100, desk.size());
        desk.install();
        assertEquals(Game.MAX_CARDS, desk.size());
    }
}