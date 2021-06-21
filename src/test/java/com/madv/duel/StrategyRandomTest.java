package com.madv.duel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrategyRandomTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void makeAttackingMove() {
        Desk<Integer> desk = new Desk<>();
        desk.fillDesk(0,12);
//        Gamer gamer = new Gamer("Vovan", new StrategyRandom(desk, desk))
        AbstractStrategy strategy = new StrategyRandom();
        System.out.println(strategy.makeAttackingMove(desk, desk));
    }
}