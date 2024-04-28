package com.evolenta.task.model;

import org.springframework.stereotype.Component;

@Component("Subtractor")
public class Subtractor implements Operation {
    @Override
    public double getResult(double a, double b) {
        return a-b;
    }
}
