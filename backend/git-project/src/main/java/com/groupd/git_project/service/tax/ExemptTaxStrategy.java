package com.groupd.git_project.service.tax;

import org.springframework.stereotype.Component;

@Component("exemptTax")
public class ExemptTaxStrategy implements TaxStrategy {

    @Override
    public double calculate(double prixHT) {
        return prixHT;
    }

    @Override
    public String getLabel() {
        return "Exonéré de TVA";
    }
}