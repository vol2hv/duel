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
            throw new RuntimeException("Программа завершена по требованию пользователя.");
        }
        return result;
    }

    public static Integer inputInteger(BufferedReader in, String prompt) {
        boolean ok = false;
        Integer result = null;
        do {
            try {
                result = Integer.valueOf(inputString(in, prompt));
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели неправильное число. Повторите ввод");
                result = Integer.valueOf(inputString(in, prompt));
            }
        } while (ok);
        return result;
    }
}




