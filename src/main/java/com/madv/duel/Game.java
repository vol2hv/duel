package com.madv.duel;

import lombok.NoArgsConstructor;

import java.util.Random;

/**
 * Игра
 */

@NoArgsConstructor
public class Game {
    static int MAX_CARDS = 12;   // Количество карт в колоде (0 -11)
    private final Random random = new Random(System.currentTimeMillis());
    private final GameTable gameTable = new GameTable();

    // Инициализация программы
    public void initProgram() {
        gameTable.init();
        String name = Input.inputString(MessageCode.MSG_GAMER_NAME.getText());
        Gamer g = gameTable.getGamers()[0];
        g.setName(name);
        g.setStrategy(new StrategyHuman());
    }

    // провести цикл игр
    public void loopGame() {
        while (true) {
            gameTable.reinstall();
            selectBeginer();
            // выбрать силу игры конпьютера
            selectAlgoritm();
            // сыграть очередную игру
            playCurentGame();
            // вопрос о продолжение игры
            // При вводе пустой строки программа завершиться
            Input.inputString(MessageCode.MSG_CONTINUE_GAME.getText());
        }
    }

    //-----------------------------------------
    // Сыграть текущую игру
    private void playCurentGame() {
        while (true) {
            // сделать спаренный ход
            makePhase();
            // если в колоде осталась только одна карта
            int num = gameTable.getCurGamer();
            Desk<Integer> desk = gameTable.getGamers()[num].getDesk();
            if (desk.size() == 1) {
                Desk<Integer> desk1 = gameTable.getGamers()[((num +1) % 2)].getDesk();
                endPhase(desk1.getFirst(), desk.getFirst());
                break;
            }
        }
        // Подвести итоги игры
        gameOverInformation();
    }

    // Информация о завершении игры
    private void gameOverInformation() {
        String[] name = new String[2];
        int[] pp = {0, 0};
        Gamer g = gameTable.getGamers()[gameTable.getCurGamer()];
        for (int i = 0; i < 2; i++) {
            g = gameTable.getGamers()[i];
            name[i] = gameTable.getGamers()[i].getName();
            pp[i] = gameTable.getGamers()[i].getPenaltyPoints();
        }
        System.out.printf(MessageCode.MSG_GAME_END_INFORMATION.getText(),
                name[0], pp[0], name[1], pp[1]);
    }

    // выбрать начинающего
    private void selectBeginer() {
        // опредилиться с правом первого хода
        int i = Input.inputInteger(MessageCode.MSG_WHO_BEGIN.getText(), 1, 3);
        int num = 0;
        if (i == 1) {
            num = 0;
        } else if (i == 2) {
            num = 1;
        } else {
            num = random.nextInt(2);
        }
        gameTable.setCurGamer(num);
        gameTable.setCurMoveType(MoveType.ATACK);
    }

    // Выбрать сложность алготитма
    private void selectAlgoritm() {
        // Выбрать сложность алгоритма ИИ
        int i = Input.inputInteger(MessageCode.MSG_DIFFICULTY_LEVEL.getText(), 1, 2);
        if (i == 1) {
            gameTable.getGamers()[1].setStrategy(new StrategyRandom());
        } else {
            gameTable.getGamers()[1].setStrategy(new StrategyRandom()); // TODO: 20.06.2021 заменить
        }
    }
    // ---------------------------------------

    // сделать одиночный полуход и подготовить рабочий стол к следующему ходу
    private int makeMove() {
        int result, num;
        MoveType tmp;
        num = gameTable.getCurGamer();
        Gamer g = gameTable.getGamers()[num];
        Desk<Integer> desk = g.getDesk();
        result = gameTable.getGamers()[num].getStrategy().makeAttackingMove(desk, desk);
        gameTable.nextMove(result);
        return result;
    }

    // Ваполнить фазу (атака + защита)
    private void makePhase() {
        int atackMove, protMove;

        // сделать ход за атакующего
        atackMove = makeMove();
        // сделать ход за зашитника
        protMove = makeMove();

        endPhase(atackMove, protMove);
    }

    // завершить фазу
    private void endPhase(int atackMove, int protMove) {
        // подвести итоги  фазы игры
        int pp = atackMove - protMove;
        pp = (pp > 0) ? pp : 0;
        int num = gameTable.getCurGamer();
        Gamer g = gameTable.getGamers()[(num + 1) % 2];
        pp += g.getPenaltyPoints();
        g.setPenaltyPoints(pp);

        // Иформация о завершении фазы
        int num1 = (num + 1) % 2;
        Desk<Integer> desk = gameTable.getGamers()[num].getDesk();
        Desk<Integer> desk1 = gameTable.getGamers()[num1].getDesk();
        System.out.printf(MessageCode.MSG_PHASE_END_INFORMATION.getText(),
                atackMove, protMove, pp, desk, desk1);
    }


}
