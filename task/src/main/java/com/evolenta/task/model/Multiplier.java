package com.evolenta.task.model;

import org.springframework.stereotype.Component;

@Component("Multiplier")
public class Multiplier implements Operation{
    @Override
    public double getResult(double a, double b) {
        return a*b;
    }
}
