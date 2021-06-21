package com.madv.duel;
/**
 *   игрок
 */
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.BufferedReader;

@Data
@NoArgsConstructor
public class Gamer {
    private String name;
    private GamerType gamerType;
    private AbstractStrategy strategy;
    private GameTable gameTable;
    private BufferedReader in;

    public Gamer(String name, GamerType gamerType, AbstractStrategy strategy, GameTable gameTable
            , BufferedReader in) {
        this.name = name;
        this.gamerType = gamerType;
        this.strategy = strategy;
        this.gameTable = gameTable;
        this.in = in;
    }
}
