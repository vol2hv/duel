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
    @Override
    public Integer makeAttackingMove(Desk<Integer> deskOwn, Desk<Integer> deskForeign) {
        return Input.inputMove(MessageCode.MSG_ATTACKING_MOVE.getText(), deskOwn);
    }
    @Override
    public Integer makeDefensiveMove(Desk<Integer> deskOwn, Desk<Integer> deskForeign) {
        return Input.inputMove(MessageCode.MSG_PROTECTIVE_MOVE.getText(), deskOwn);
    }
}
