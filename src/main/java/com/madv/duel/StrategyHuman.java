package com.madv.duel;

/**
 * Источник стратегии голова игрока
 */

import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.BufferedReader;

@Data
@NoArgsConstructor
public class StrategyHuman  extends AbstractStrategy{
    public StrategyHuman(GameTable gameTable, BufferedReader in) {
        super(gameTable, in);
    }

    @Override
    public Integer makeAttackingMove(GameTable gameTable) {
        Desk<Integer> desk = gameTable.getDesks()[gameTable.getNumGamerCurrentMove()];
        return Input.inputMove(in, MessageCode.MSG_ATTACKING_MOVE.getText(), desk);
    }

    @Override
    public Integer makeDefensiveMove(GameTable gameTable) {
        Desk<Integer> desk = gameTable.getDesks()[gameTable.getNumGamerCurrentMove()];
        return Input.inputMove(in, MessageCode.MSG_PROTECTIVE_MOVE.getText(), desk);
    }
}
