package com.company.Task3;

public class Adder {
    private int a, b;
    public Adder(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public Adder() {
        a = 0;
        b = 0;
    }
    public void getSum(int a, int b) {
        System.out.println(a + b);
    }
}
