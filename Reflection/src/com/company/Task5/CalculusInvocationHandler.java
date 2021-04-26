package com.company.Task5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class CalculusInvocationHandler implements InvocationHandler {
        private Calculus calculus;
        public CalculusInvocationHandler(Calculus calculus) {
            this.calculus = calculus;
        }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        long startTime = System.nanoTime();
        result = method.invoke(calculus, args);
        long endTime = System.nanoTime();
        System.out.println(method.getName() + " took " + (endTime - startTime) + "ns");
        System.out.print("invocation of " + method.getName() + "(");
        Parameter[] parameters = method.getParameters();
        for(Parameter p:parameters) {
            System.out.print(p.getType().getTypeName() + " " + p.getName() + ",");
        }
        System.out.println(") returns " + result);
        return result;
    }
}
