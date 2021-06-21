package com.madv.duel;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.EnumMap;
import java.util.Map;

/**
 * Игровой стол
 */
@Data
@NoArgsConstructor
public class GameTable {
    private Gamer[] gamers = new Gamer[2];
    int curGamer = 0;
    private MoveType curMoveType;

    public void init() {
        Gamer human = new Gamer("human", new StrategyHuman());
        human.init();
        gamers[0] = human;

        Gamer computer = new Gamer("computer", new StrategyRandom());
        computer.init();
        gamers[1] = computer;
    }

    public void reinstall() {
        for (int i = 0; i < 2; i++) {
            gamers[i].install();
        }
    }

    // Перейти к следующему полуходу
    public void nextMove(int move) {
        gamers[curGamer].getDesk().remove(move);
        curGamer = (curGamer +1) % 2;
        curMoveType = (curMoveType.equals(MoveType.ATACK)) ? MoveType.PROTECTION : MoveType.ATACK;
    }

}
