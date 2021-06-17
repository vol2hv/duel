package com.madv.duel;

import lombok.Getter;

import java.util.Scanner;

/**
 * Игра
 */
// TODO: 15.06.2021 сообщения в константы и построители строк

public class Game {
    private static String END_PROGRAM = "Введите 'Q' для завершения программы.\n";
    private static String WELCOME = "Предлагаме Вам сыграть в интелектуальную игру...\n";
    // Устройсто ввода
    private Scanner in;
    // игроки
    private  Gamer[] gamers = new Gamer[]{new Gamer(), new Gamer()};
    private int firstMoveRight;
    private String name;

    // TODO: 15.06.2021  убрать параметр ???
    public Game(Scanner in) {
        this.in = in;
    }

    public void beforeStart(){
        System.out.println("Введите Ваше имя: ");
        name = in.nextLine();
    }
    public void start() {
        System.out.println("Кто начинает игру (1 - ВЫ 2 - компьютер: ");
        int nGamer = in.nextInt();
        nGamer--;

    }

    public void play() {

    }

}
