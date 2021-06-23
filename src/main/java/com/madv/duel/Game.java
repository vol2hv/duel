package com.madv.duel;

import lombok.Data;
import lombok.NoArgsConstructor;

/*
* Играю
* Хранит свое состояние
* (в том числе колоды игроков)
* и выдает информацию об этом состоянии
* */

@Data
@NoArgsConstructor
public class Game {
    public static int MAX_CARDS = 12;
    
    private SlotMachine slotMachine = null;

    private int curNumGamer;    // номер игрока который должен выполнить полуход
    private MoveType moveType ;  // тип текущего полухода
    private int semiMove;   // номер полухода в ходе 0, 1

    public Game(SlotMachine slotMachine) {
        this.slotMachine = slotMachine;
    }

    public void init() {
    }

    public void reinstall(){

    }

    // провести цикл игр
    public void loopGame() {
        while (true) {
            selectBeginer();
            // выбрать силу игры конпьютера
//            selectAlgoritm();
            // сыграть очередную игру
            playCurentGame();
            // вопрос о продолжение игры
            // При вводе пустой строки программа завершиться
            Util.inputString(MessageCode.MSG_CONTINUE_GAME.getText());
        }
    }

    public void makeMove(){
        int atackMove, protMove;

        // сделать ход за атакующего
        semiMove = 0;
        atackMove = makeSemiMove();
        // сделать ход за зашитника
        semiMove = 0;
        protMove = makeSemiMove();

        endPhase(atackMove, protMove);
    }

    // сделать полу-ход
    private int makeSemiMove() {
        int move;
        int num = ( curNumGamer + 1)%2;
        Gamer g = slotMachine.getGamers()[curNumGamer];
        Desk desk = g.getDesk();
        Desk desk1 = slotMachine.getGamers()[num].getDesk();
        if ((curNumGamer == 0) || (desk.size() == 1)){
            move = desk.getNext();
        } else {
            move = g.getStrategy().makeAttackingMove(desk, desk1);   
        }
       
        g.getDesk().remove(move);
        curNumGamer = num;
        if ( semiMove != 1) {   // последний полуход хода
            moveType = (moveType.equals(MoveType.ATACK)) ? MoveType.PROTECTION : MoveType.ATACK;
        }
        return move;
    }

   // сделать ход


    private void endPhase(int atackMove, int protMove) {
        // подвести итоги  фазы игры
        int pp = atackMove - protMove;
        pp = (pp > 0) ? pp : 0;
        Gamer g = slotMachine.getGamers()[(curNumGamer + 1) % 2];
        g.setPenaltyPoint(pp + g.getPenaltyPoint());

        // Иформация о завершении фазы
        Desk desk = g.getDesk();
        Desk desk1 = slotMachine.getGamers()[curNumGamer].getDesk();;
        System.out.printf(MessageCode.MSG_PHASE_END_INFORMATION.getText(),
                atackMove, protMove, pp, desk, desk1);
    }
    
    // Сыграть текущую игру
    private void playCurentGame() {
        while (true) {
            // сделать спаренный ход
            makeMove();
            if (slotMachine.getGamers()[curNumGamer].getDesk().size() ==0){
                // колода пустая 
                break;
            }
        }
        // Подвести итоги игры
        gameOverInformation();
    }

    private void gameOverInformation() {
        String[] name = new String[2];
        int[] pp = {0, 0};
        Gamer[] gamers = slotMachine.getGamers();
        for (int i = 0; i < 2; i++) {
            Gamer g = gamers[i];
            name[i] = g.getName();
            pp[i] = g.getPenaltyPoint();
        }
        System.out.printf(MessageCode.MSG_GAME_END_INFORMATION.getText(),
                name[0], pp[0], name[1], pp[1]);
    }

    // выбрать начинающего
    private void selectBeginer() {
        // опредилиться с правом первого хода
        int i = Util.inputInteger(MessageCode.MSG_WHO_BEGIN.getText(), 1, 3);
        int num = 0;
        if (i == 1) {
            num = 0;
        } else if (i == 2) {
            num = 1;
        } else {
            num = Util.random.nextInt(2);
        }
        curNumGamer = num;
        moveType = MoveType.ATACK;
        semiMove = 0;
    }

    private void selectAlgoritm() {
        // Выбрать сложность алгоритма ИИ
        int i = Util.inputInteger(MessageCode.MSG_DIFFICULTY_LEVEL.getText(), 1, 3);
        Gamer g = slotMachine.getGamers()[1];
        if (i == 1) {
            g.setStrategy(new StrategyRandom());
        } else {
            g.setStrategy(new StrategyRandom()); // TODO: 20.06.2021 заменить
        }
    }

    // Определить номер игрока начинающего игру
    private int numBegin(int min, int max) {
        int num = Util.inputInteger(MessageCode.MSG_WHO_BEGIN.getText(), min, max);
        if (num <= 2) {
            num--;
        } else {
            num = Util.random.nextInt(2);
        }
        return num;
    }


}
