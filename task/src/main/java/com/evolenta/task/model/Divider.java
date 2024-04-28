package com.evolenta.task.model;

import org.springframework.stereotype.Component;

@Component("Divider")
public class Divider implements Operation{
    @Override
    public double getResult(double a, double b) {
        return (a/b);
    }
}
