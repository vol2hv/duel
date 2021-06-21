package com.madv.duel;

import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class QQ {
    public static void main(String[] args) throws IOException {

        Child child = new Child(10, 20);

        System.out.println(child.a);
        System.out.println(child.b);
        child.mm[0] += 5;
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
