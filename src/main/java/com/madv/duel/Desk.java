package com.madv.duel;

import java.util.TreeSet;

public class Desk<E> extends TreeSet {
    // заполнить колоду карт
    public void fillDesk (int min, int max) {
        for (int i = min; i <= max; i++) {
            this.add(i);
        }
    }
    // получить последний элемент коллекции
    public E getLast(){
        return (E)this.iterator().next();
    }

}
