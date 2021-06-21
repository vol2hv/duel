package com.madv.duel;

import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.TreeSet;

public class Desk<E> extends TreeSet {
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
    // получить последний элемент коллекции
    public E getLast(){
        return (E)this.iterator().next();
    }


}
