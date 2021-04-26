package com.company.Task5;

import java.lang.reflect.Proxy;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculus calc = new Calculus();
        Evaluable proxyCalc = (Evaluable) Proxy.newProxyInstance(calc.getClass().getClassLoader(),
                calc.getClass().getInterfaces(),new CalculusInvocationHandler(calc));
        proxyCalc.calculate(3.0);

    }
}

