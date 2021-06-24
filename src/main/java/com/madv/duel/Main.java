package com.madv.duel;

import lombok.extern.log4j.Log4j2;

// TODO: 15.06.2021  из всего ввода вывода сделать подобие MVC
@Log4j2
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.init();
        game.playGame();

        // программа завершается по вводу пользователем пустой строки в любом из диалогов
    }
}
