package com.madv.duel;

import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Игра
 */

@NoArgsConstructor
public class Game {
    static int MAX_CARDS = 12;   // Количество карт в колоде (0 -11)

    // TODO: 17.06.2021  не мусорить потоками
    private final BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // Устройсто ввода
    private final GameTable gameTable = new GameTable();
    private final Gamer[] gamers = new Gamer[2]; // 0 - человек 1 - компьютер
    private AbstractStrategy computerStrategy;
    private final Random random = new Random(System.currentTimeMillis());

    // Инициализация программы
    public void initProgram() {
        AbstractStrategy humanStrategy = new StrategyHuman(gameTable, in);
        String name = Input.inputString(in, MessageCode.MSG_GAMER_NAME.getText());
        gamers[0] = new Gamer(name, GamerType.HUMAN, humanStrategy, gameTable, in);

        name = "coolThought";
        // computerStrategy будет выбрано позднее
        gamers[1] = new Gamer(name, GamerType.COMPUTER, computerStrategy, gameTable, in);
    }

    // провести цикл игр
    public void loopGame() {
        while (true) {
            setGame();
            // сыграть очередную игру
            playCurentGame();
            // вопрос о продолжение игры
            // При вводе пустой строки программа завершиться
            Input.inputString(in, MessageCode.MSG_CONTINUE_GAME.getText());
        }
    }

    // Подготовка к очердной игре цикла
    private void setGame() {
        prepareGameTable();
        // Выбрать сложность алгоритма ИИ
        int i = Input.inputInteger(in, MessageCode.MSG_DIFFICULTY_LEVEL.getText(), 1, 2);
        if (i == 1) {
            gamers[1].setStrategy(new StrategyRandom());
        } else {
            gamers[1].setStrategy(new StrategyRandom()); // TODO: 20.06.2021 заменить
        }
    }

    // Подготовить рабочий стол к очередной игре цикла
    private void prepareGameTable() {
        gameTable.init();
        // опредилиться с правом первого хода
        int i = Input.inputInteger(in, MessageCode.MSG_WHO_BEGIN.getText(), 1, 3);
        int num = 0;
        if (i == 1) {
            num = 0;
        } else if (i == 2) {
            num = 1;
        } else {
            num = random.nextInt(2);
        }
        gameTable.setNumGamerCurrentMove(num);
    }

    // Сыграть текущую игру
    private void playCurentGame() {
        while (true) {
            // сделать спаренный ход
            makePhase();
            // если в колоде осталась только одна карта
            if (gameTable.getDesks()[0].size() == 1)
            {
                int num = gameTable.getNumGamerCurrentMove();
                endPhase(gameTable.getDesks()[(++num%2)].getLast(),
                        gameTable.getDesks()[num].getLast());
                break;
            }
        }
        // Подвести итоги игры
        gameOverInformation();
    }

    // сделать одиночный ход и подготовить рабочий стол к следующему ходу
    private int makeMove (){
        int result, num;
        MoveType tmp;
        num = gameTable.getNumGamerCurrentMove();
        result = gamers[num].getStrategy().makeAttackingMove(gameTable);
        num = (++num)%2;
        gameTable.setNumGamerCurrentMove(num);
        tmp = gameTable.getMoveType();
        tmp = (tmp.equals(MoveType.ATACK)) ? MoveType.PROTECTION : MoveType.ATACK;
        gameTable.setMoveType(tmp);
        return result;
    }

    // Ваполнить фазу (атака + защита)
    private void makePhase() {
        int atackMove, protMove;

        // сделать ход за атакующего
        atackMove = makeMove ();
        // сделать ход за зашитника
        protMove = makeMove ();

        endPhase(atackMove, protMove);

    }

    // Информация о завершении игры
    private void gameOverInformation() {
        String[] name = new String[2];
        int[] pp = {0, 0};
        for (int i = 0; i <2; i++) {
            name[i] = gamers[i].getName();
            pp[i] = gameTable.getPenaltyPoints()[i];
        }
        System.out.printf(MessageCode.MSG_GAME_END_INFORMATION.getText(),
                name[0], pp[0], name[1], pp[1]);
    }

    // завершить фазу
    private void endPhase(int atackMove, int protMove) {
        // подвести итоги  фазы игры
        int pp = atackMove - protMove;
        pp = (pp > 0) ? pp: 0;
        int num = gameTable.getNumGamerCurrentMove();
        gameTable.getPenaltyPoints()[(++num)%2] += pp; // TODO: 20.06.2021 проверить
        //Удаление карт из коллекции
        gameTable.getDesks()[num].remove(atackMove);
        gameTable.getDesks()[(++num)%2].remove(protMove
        );

        // Иформация о завершении фазы
        int num1 = (++num)%2;
        System.out.printf(MessageCode.MSG_PHASE_END_INFORMATION.getText(), atackMove, protMove, pp,
                gameTable.getDesks()[num].toString(), gameTable.getDesks()[num1].toString());
    }

}
