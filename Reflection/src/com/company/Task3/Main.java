package com.company.Task3;


import com.company.Task3.FunctionNotFoundException;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, FunctionNotFoundException {
        Adder ad = new Adder();
        Task3.invoke(ad, "getSum",1,2);
    }
}

