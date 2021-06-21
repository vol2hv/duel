package com.madv.duel;
/**
 * Карты выбираются из всей колоды уеликом и для атаки и для защиты
 */

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@NoArgsConstructor
public class StrategyRandom extends AbstractStrategy{
    private final Random random = new Random(System.currentTimeMillis());

    @Override
    public Integer makeAttackingMove(GameTable gameTable) {
        return makeMove (gameTable);
    }

    @Override
    public Integer makeDefensiveMove(GameTable gameTable) {
        return makeMove (gameTable);
    }
    private Integer makeMove (GameTable gameTable) {
        Desk<Integer> desk = gameTable.getDesks()[gameTable.getNumGamerCurrentMove()];
        Object [] m = desk.toArray();
        int num = random.nextInt(m.length);
        return  (int) (m[num]);
    }
}
