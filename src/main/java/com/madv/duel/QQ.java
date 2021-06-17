package com.madv.duel;

import java.io.*;

public class QQ {
    public static void main(String[] args) throws IOException {
        // TODO: 17.06.2021  не мусорить потоками
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

//        String login = Input.inputString("Входите: \n Входите: ");
//        System.out.printf("Введено: %s длина %d \n", login, login.length() );
        int i = Input.inputInteger(in, "Число: ");
        System.out.printf("Введено: %d \n", i);
    }
}
