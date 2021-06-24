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

    private final Gamer[] gamers = new Gamer[2]; //0-human 1-computer

    private int curNumGamer;    // номер игрока который должен выполнить полуход
    private MoveType moveType;  // тип текущего полухода
    private int semiMove;   // номер полухода в ходе 0, 1

    public void init() {
        Game game = new Game();
        for (int i = 0; i < 2; i++) {
            gamers[i] = new Gamer();
            gamers[i].init();
            if (i == 0) { //human
                gamers[i].setName(Util.inputString(MessageCode.MSG_GAMER_NAME.getText()));
                gamers[i].setStrategy(new StrategyHuman());
                gamers[i].setGamerType(GamerType.HUMAN);
            }  else {
                gamers[i].setName("justGenius");
                gamers[i].setStrategy(new StrategyRandom());
                gamers[i].setGamerType(GamerType.COMPUTER);
            }
        }
    }

    // Инициализация очередного цикла игры
    protected void initCurrentGame() {
        // выбрать силу игры конпьютера
        selectAlgoritm();

        // определьть право первого хода
        curNumGamer = selectBeginer(1, 4);

        moveType = MoveType.ATACK;
        semiMove = 0;
        
        // сбросить состояние игроков в начальное
        for (Gamer g : gamers) {
            g.reinstall();
        }
        gamers[0].setStrategy(new StrategyHuman());
    }

    // провести цикл игр
    public void playGame() {
        while (true) {
            initCurrentGame();
            // сыграть очередную игру
            playCurentGame();
            // вопрос о продолжение игры
            // При вводе пустой строки программа завершиться
            Util.inputString(MessageCode.MSG_CONTINUE_GAME.getText());
        }
    }

    // сделать ход
    public void makeMove() {
        endPhase(makeSemiMove(), makeSemiMove());
    }

    // сделать полу-ход
    private int makeSemiMove() {
        int move;
        int num = (curNumGamer + 1) % 2;
        Gamer g = gamers[curNumGamer];
        Desk desk = g.getDesk();
        Desk desk1 = gamers[num].getDesk();
        if ((desk.size() == 1) &&(curNumGamer == 0)) {
            // последний ход за человека делает компьютер
            move = desk.getMin();
        } else {
            if (moveType == MoveType.ATACK) {
                move = g.getStrategy().makeAttackingMove(desk, desk1);
            } else {
                move = g.getStrategy().makeDefensiveMove(desk, desk1);
            }
        }

        g.getDesk().remove(move);
        if (semiMove != 1) {   // последний полуход хода
            curNumGamer = (curNumGamer + 1) % 2;
        }
        moveType = (moveType.equals(MoveType.ATACK)) ? MoveType.PROTECTION : MoveType.ATACK;
        semiMove = (semiMove + 1) % 2;
        return move;
    }

    private void endPhase(int atackMove, int protMove) {
        // подвести итоги  фазы игры
        int pp = atackMove - protMove;
        pp = (pp > 0) ? pp : 0;

        Gamer pGamer = gamers[curNumGamer];
        Gamer aGamer = gamers[(curNumGamer + 1) % 2];

        // Иформация о завершении фазы
        pGamer.setPenaltyPoint(pp + pGamer.getPenaltyPoint());
        System.out.printf(MessageCode.MSG_PHASE_END_INFORMATION.getText(),
               aGamer.getName(), atackMove, protMove, pp, aGamer.getDesk(), pGamer.getDesk());
    }

    // Сыграть текущую игру
    private void playCurentGame() {
        while (true) {
            // сделать спаренный ход
            makeMove();
            if (gamers[curNumGamer].getDesk().size() == 0) {
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
        for (int i = 0; i < 2; i++) {
            Gamer g = gamers[i];
            name[i] = g.getName();
            pp[i] = g.getPenaltyPoint();
        }
        System.out.printf(MessageCode.MSG_GAME_END_INFORMATION.getText(),
                name[0], pp[0], name[1], pp[1]);
    }

    private void selectAlgoritm() {
        // Выбрать сложность алгоритма ИИ
        int i = Util.inputInteger(MessageCode.MSG_DIFFICULTY_LEVEL.getText(), 1, 3);
        Gamer g = gamers[1];
        if (i == 1) {
            g.setStrategy(new StrategyRandom());
        } else {
            g.setStrategy(new StrategyBest());
        }
    }

    // Определить номер игрока начинающего игру
    private int selectBeginer(int min, int max) {
        int num = Util.inputInteger(MessageCode.MSG_WHO_BEGIN.getText(), min, max);
        if (num <= 2) {
            num--;
        } else {
            num = Util.random.nextInt(2);
        }
        return num;
    }
}

