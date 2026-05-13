package com.groupd.git_project.service.tax;

public interface TaxStrategy {
    double calculate(double prixHT);
    String getLabel();
}