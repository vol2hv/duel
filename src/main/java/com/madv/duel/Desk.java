package com.madv.duel;

import java.util.Iterator;
import java.util.TreeSet;

public class Desk  extends TreeSet<Integer> {

    public void init(){
        fillDesk(0, Game.MAX_CARDS -1);
    };

    public void reinstall(){
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
    public  int getMin(){
        return this.first();
    }

    // получить максимальный элемент
    public int getMax(){
        return this.last();
    }

    public int getMEmax(Desk deskForeign) {
        Integer res = this.ceiling(deskForeign.last());
        return (res == null)?this.last():res;
    }

// получить карту в колоде по номеру. Нумерация карт начинается с 0.
    int getItem(int n){
        Iterator<Integer> iter = this.iterator();
        int i = 0;
        int res;
        while(iter.hasNext()){
            res = iter.next();
            if (i++ == n){
                return res;
            }
        }
        return -1;
    }

    int getRandomCard(int nMax){
        return getItem(Util.random.nextInt(nMax));
    }
}
