package com.madv.duel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class GameTableTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void init() {
        GameTable table = new GameTable();
//        assertEquals(2, table.getDesks().length);
//        assertEquals(2, table.getDesks().length);
    }

    @Test
    void next() {
        GameTable table = new GameTable();
        table.init();
        table.setCurMoveType(MoveType.ATACK);
        table.nextMove(10);
        assertEquals(MoveType.PROTECTION, table.getCurMoveType());
        assertEquals(1, table.getCurGamer());
        assertEquals(Game.MAX_CARDS - 1, table.getGamers()[0].getDesk().size());
        assertFalse(table.getGamers()[0].getDesk().contains(10));
    }

    @Test
    void testInit() {
    }

    @Test
    void reinstall() {
    }
}