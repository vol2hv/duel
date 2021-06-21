package com.madv.duel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GamerTest {
    @Test
    void initInstall() {
        Gamer gamer = new Gamer("Vovan", new StrategyRandom());
        gamer.init();
        assertEquals("Vovan", gamer.getName());
        assertEquals(Game.MAX_CARDS, gamer.getDesk().size());
        gamer.getDesk().clear();
        gamer.setPenaltyPoints(88);
        gamer.install();
        assertEquals(0, gamer.getPenaltyPoints());
        assertEquals(Game.MAX_CARDS, gamer.getDesk().size() );
        assertEquals(0, gamer.getPenaltyPoints() );
    }
}