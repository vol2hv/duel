package com.madv.duel;

import lombok.NoArgsConstructor;

import java.io.IOException;

public class QQ {
    public static void main(String[] args) throws IOException {
        int[] mm = new int[2];
        Child child = new Child(10, 20);

        System.out.println(child.a);
        System.out.println(child.b);
        for (int i = 0; i < 11; i++) {
            System.out.println(Util.random.nextInt(2));

        }
        }
}
@NoArgsConstructor
class Parent {
    protected int a, b;
    Parent(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
@NoArgsConstructor
class Child extends Parent {
    Integer[] mm = {33, 34};
    Child(int a, int b) {
        super(a, b);
    }
}
