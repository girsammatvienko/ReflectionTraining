package com.company.Task2;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InvocationTargetException {
        A a = new A(3,4);
        String s = new String("string");
        Task2.getState(a);

    }
}
