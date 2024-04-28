package com.evolenta.task.model;

import org.springframework.stereotype.Component;

@Component
public interface Operation {
    double getResult(double a, double b);
}
