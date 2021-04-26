package com.company.Task5;

public class Calculus implements Evaluable {

    @Override
    public Double calculate(Double x) {
        return Math.sin(x) * Math.cos(x) + Math.exp(x);
    }
}
