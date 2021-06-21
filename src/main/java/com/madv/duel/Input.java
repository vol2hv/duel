package com.madv.duel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.System.exit;

public class Input {
    public static String inputString(BufferedReader in, String prompt) {
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

    public static Integer inputInteger(BufferedReader in, String promptp, Integer minp, Integer maxp) {
        boolean ok = false;
        Integer result = null;
        String prompt = (promptp == null)?"Введите пустую строку для завершения работы.":promptp;
        Integer min = (minp == null)?Integer.MIN_VALUE:minp;
        Integer max = (maxp == null)?Integer.MAX_VALUE:maxp;

        do {
            try {
                result = Integer.valueOf(inputString(in, prompt));
                if ((result >= min) && (result <= max)) {
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

    public static Integer inputMove(BufferedReader in, String promptp, Desk<Integer> desk) {
        boolean ok = false;
        Integer result = null;
        String prompt = (promptp == null)?"Введите пустую строку для завершения работы.":promptp;

        do {
            try {
                result = Integer.valueOf(inputString(in, prompt));
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
}




