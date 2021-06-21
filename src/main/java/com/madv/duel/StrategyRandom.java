package com.madv.duel;
/**
 * Карты выбираются из всей колоды уеликом и для атаки и для защиты
 */

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@NoArgsConstructor
public class StrategyRandom extends AbstractStrategy {
    private final Random random = new Random(System.currentTimeMillis());

        @Override
        public Integer makeAttackingMove(Desk<Integer> deskOwn, Desk<Integer> deskForeign) {
        return makeMove (deskOwn);
        }

        @Override
        public Integer makeDefensiveMove(Desk<Integer> deskOwn, Desk<Integer> deskForeign) {
            return makeMove (deskOwn);
        }
        private Integer makeMove (Desk<Integer> deskOwn) {
            Object [] m = deskOwn.toArray();
            int num = random.nextInt(m.length);
            return  (int) (m[num]);
        }

    }
