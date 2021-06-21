package com.madv.duel;

import lombok.Data;

/**
 * Игровой стол
 */
@Data
public class GameTable {
    private Desk<Integer> [] desks = new Desk[2];
    private int numGamerCurrentMove;
    private MoveType moveType;
    private int[]  penaltyPoints = {0, 0}; // штрафные очки игрока

    public GameTable() {
        for (int i = 0; i < 2; i++) {
            desks[i] = new Desk<>();
        }
        init();
    }

    public void init() {
        for (int i = 0; i < 2; i++) {
            desks[i].fillDesk(0, Game.MAX_CARDS - 1);
            penaltyPoints[i] = 0;
        }
        moveType = MoveType.ATACK;
    }

    public void next (int move){
        desks[numGamerCurrentMove].remove(move);
        numGamerCurrentMove = (numGamerCurrentMove + 1) % 2;
        switch(moveType){
            case ATACK:
                moveType = MoveType.PROTECTION;
                break;
            case PROTECTION:
                moveType = MoveType.ATACK;
                break;
          }
    }
}
