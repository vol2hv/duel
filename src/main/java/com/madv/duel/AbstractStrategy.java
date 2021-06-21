package com.madv.duel;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;

@Data
@NoArgsConstructor
public abstract class AbstractStrategy  {
    protected GameTable gameTable;
    protected BufferedReader in;

    public AbstractStrategy(GameTable gameTable, BufferedReader in) {
        this.gameTable = gameTable;
        this.in = in;
    }
    public abstract Integer makeAttackingMove(GameTable gameTable) ;
    public abstract Integer makeDefensiveMove(GameTable gameTable) ;
}
