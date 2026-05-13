package com.groupd.git_project.service.tax;

import org.springframework.stereotype.Component;

@Component("reducedTax")
public class ReducedTaxStrategy implements TaxStrategy {
    private static final double TVA_RATE = 0.055;

    @Override
    public double calculate(double prixHT) {
        return prixHT * (1 + TVA_RATE);
    }

    @Override
    public String getLabel() {
        return "TVA réduite 5.5%";
    }
}
