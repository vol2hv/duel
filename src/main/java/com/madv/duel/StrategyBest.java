
package com.madv.duel;
/**
 * Атака - своя максимальная карта
 * Защита - своя наименьшая карта
 */

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StrategyBest extends AbstractStrategy {

    @Override
    public Integer makeAttackingMove(Desk deskOwn, Desk deskForeign) {
        return deskOwn.getMax();
    }

    @Override
    public Integer makeDefensiveMove(Desk deskOwn, Desk deskForeign) {
        return deskOwn.getMin();
//        int atackNum = deskForeign.getRandomCard(deskForeign.size());
//        return deskOwn.getMEmax(deskForeign);
    }



}
