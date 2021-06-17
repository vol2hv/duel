package com.madv.duel;

import lombok.extern.log4j.Log4j2;
import java.util.Scanner;

// TODO: 15.06.2021  из всего ввода вывода сделать подобие MVC
@Log4j2
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Game game = new Game(in);
//        log.info("Логи фунционируют нормально. {}  {}  {}", "Первый", 1111111.222, false);
    }
}
