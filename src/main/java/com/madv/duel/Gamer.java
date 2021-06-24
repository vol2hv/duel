package com.madv.duel;

import lombok.Data;

@Data
public class Gamer {
    private Desk desk = new Desk();

    private String name;
    private GamerType gamerType;
    private AbstractStrategy strategy;
    private int penaltyPoint = 0;
    
    public void init (){
        desk.init();
        penaltyPoint = 0;
     }

    public void reinstall() {
        desk.reinstall();
        penaltyPoint = 0;
    }
}
