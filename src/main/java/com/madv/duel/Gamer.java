package com.madv.duel;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Игрок
 */
@Data
@NoArgsConstructor
public class Gamer {
    private GamerType gamerType;
    private String name;
    private List<Integer> openCards = new ArrayList<>();
    private List<Integer> holeCards = new ArrayList<>();
    public void initialize() {

    }
    public void makeMove(){

    }
    public void openCards(){

    }

}
