package com.company.Task2;

import javax.print.DocFlavor;

public class A {
    private int x = 0;
    private int y = 0;
    public A(int x, int y) {
         this.x = x;
         this.y = y;
    }
    public void getSum() {
        System.out.println(x + y);
    }
    public double divideUp() {
        System.out.println(x / y);
        return x/y;
    }
    public void setData(int x,int y) {
        this.x = x;
        this.y = y;
    }
    public void getNumbers() {
        System.out.println(x + " " + y);
    }

}
