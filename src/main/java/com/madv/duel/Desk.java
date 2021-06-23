package com.madv.duel;

import java.util.NavigableSet;
import java.util.TreeSet;

public class Desk  extends TreeSet<Integer> {
    private NavigableSet<Integer> desk = new TreeSet<>();

    public void init(){
        fillDesk(0, Game.MAX_CARDS -1);
    };
    public void install(){
        this.clear();
        init();
    }

    // заполнить колоду карт
    public void fillDesk(int min, int max) {
        for (int i = min; i <= max; i++) {
            this.add(i);
        }
    }
    // получить следующий элемент коллекции
    public  int getNext(){
        return this.iterator().next();
    }

}
