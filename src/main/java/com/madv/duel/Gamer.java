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
    private AbstractStrategy strategy;
    private Desk<Integer> desk = new Desk<>();
    private int penaltyPoints = 0; // штрафные очки игрока

    public Gamer(String name, AbstractStrategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public void init() {
        desk.init();
        penaltyPoints = 0;
    }

    public void install(){
        init();
    }
}
