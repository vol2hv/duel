package com.madv.duel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import static java.lang.System.exit;

public class Util {
    // TODO: 17.06.2021  не мусорить потоками
    private static BufferedReader reader;

    public static final Random random = new Random(System.currentTimeMillis());

    // Получить строку
    public static String inputString(String prompt) {
        BufferedReader in = getIn();
        String result = null;
        System.out.println(prompt);
        try {
            result = in.readLine();
        } catch (IOException e) {
            System.out.println("Программа завершилась аварийно.");
            exit(1);
        }
        if (result.length() == 0) {
            System.out.println("Программа завершена по требованию пользователя.");
            exit(0);
        }
        return result;
    }

    // Получить число в интервале [minp, maxp)
    public static Integer inputInteger(String promptp, Integer minp, Integer maxp) {
        BufferedReader in = getIn();
        boolean ok = false;
        Integer result = null;
        String prompt = (promptp == null)?"Введите пустую строку для завершения работы.":promptp;
        Integer min = (minp == null)?Integer.MIN_VALUE:minp;
        Integer max = (maxp == null)?12:maxp;

        do {
            try {
                result = Integer.valueOf(inputString(prompt));
                if ((result >= min) && (result < max)) {
                    ok = true;
                } else {
                    System.out.printf
                        ("Число должно быть в пределах от %d до %d . Повторите ввод.\n", min, max);
                    ok = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели неправильное число. Повторите ввод\n");
                ok = false;
            }

        } while (!ok);
        return result;
    }

    // Получить ход (элемент из колоды desk)
    public static Integer inputMove(String promptp, Desk desk) {
        boolean ok = false;
        Integer result = null;
        String prompt = (promptp == null)?"Введите пустую строку для завершения работы.":promptp;

        do {
            try {
                result = Integer.valueOf(inputString(prompt));
                if (desk.contains(result)) {
                    ok = true;
                } else {
                    System.out.printf
                            ("Карты %d нет в Вашей колоде. Повторите ввод.\n", result);
                    ok = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели неправильное число. Повторите ввод\n");
                ok = false;
            }

        } while (!ok);
        return result;
    }

    // Получить поток стандартного ввода (синглетон)
//    BufferedReader in = getIn();
    public static BufferedReader getIn(){
        if ( reader == null) {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }
        return reader ;

    }
}




