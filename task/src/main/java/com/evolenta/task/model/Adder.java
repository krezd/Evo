package com.evolenta.task.model;

import org.springframework.stereotype.Component;

@Component("Adder")
public class Adder implements Operation{
    @Override
    public double getResult(double a, double b) {
        return a+b;
    }
}
