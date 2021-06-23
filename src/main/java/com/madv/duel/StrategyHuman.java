package com.madv.duel;

/**
 * Источник стратегии голова игрока
 */

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StrategyHuman  extends AbstractStrategy{
    @Override
    public Integer makeAttackingMove(Desk  deskOwn, Desk  deskForeign) {
        return  Util.inputMove(MessageCode.MSG_ATTACKING_MOVE.getText(), deskOwn);
    }
    @Override
    public Integer makeDefensiveMove(Desk  deskOwn, Desk  deskForeign) {
        return  Util.inputMove(MessageCode.MSG_PROTECTIVE_MOVE.getText(), deskOwn);
    }
}
