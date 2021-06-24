
package com.madv.duel;
/**
 * Карты выбираются из всей колоды уеликом и для атаки и для защиты
 */

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StrategyRandom extends AbstractStrategy {

    @Override
    public Integer makeAttackingMove(Desk deskOwn, Desk deskForeign) {
        return deskOwn.getRandomCard(deskOwn.size());
    }

    @Override
    public Integer makeDefensiveMove(Desk deskOwn, Desk deskForeign) {
        return deskOwn.getRandomCard(deskOwn.size());
    }



}
