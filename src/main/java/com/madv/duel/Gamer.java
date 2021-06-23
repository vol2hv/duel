package com.madv.duel;

import lombok.Data;

@Data
public class Gamer {
    private SlotMachine slotMachine = null;
    private Desk desk = null;

    private String name;
    private GamerType gamerType;
    private AbstractStrategy strategy;
    private int penaltyPoint = 0;
    
    public void init (){
//        if (i == 0) { // Computer
//                String nameGamer = Util.inputString(MessageCode.MSG_GAMER_NAME.getText());
//                gamers[i].setName(nameGamer);
//                gamers[i].setStrategy(new StrategyHuman());
//            }    
        // Определить право первого хода
//        game.setCurNumGamer(numBegin(1, 3));
//        game.setMoveType(MoveType.ATACK);        
    }

    public void reinstall() {
    }
}
