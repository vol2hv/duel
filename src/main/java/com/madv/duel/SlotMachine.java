package com.madv.duel;

import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Игровой автомат
 * Управляется из класса Main
 * опрашивает игроков для получения ходов
 * запускает останавлливае игру
 * Выдает информацию о состоянии игры
 * отображает состояние колод игроков
 * */
@Data
@NoArgsConstructor

public class SlotMachine {
    private final Gamer[] gamers = new Gamer[2]; //0-human 1-computer

    public void init() {
        Game game = new Game();
        game.init();    // может быть и пустая
        for (int i = 0; i < 2; i++) {
            Gamer g = new Gamer();
            GamerType gt = (i == 0)?GamerType.HUMAN: GamerType.COMPUTER;
            g.setGamerType(gt);
            g.init();
            gamers[i] = g;
        }
    }

//    public void reinstall(){}  не предусмортено для этого класса


    //   старт автомата
    public void start() {
    }

}
