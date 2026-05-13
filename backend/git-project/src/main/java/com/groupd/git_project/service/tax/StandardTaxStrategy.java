package com.groupd.git_project.service.tax;

import org.springframework.stereotype.Component;

@Component("standardTax")
public class StandardTaxStrategy implements TaxStrategy {
    private static final double TVA_RATE = 0.20;

    @Override
    public double calculate(double prixHT) {
        return prixHT * (1 + TVA_RATE);
    }

    @Override
    public String getLabel() {
        return "TVA 20%";
    }
}