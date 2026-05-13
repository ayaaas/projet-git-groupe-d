package com.groupd.git_project.service.tax;

import org.springframework.stereotype.Component;

@Component
public class TaxCalculator {

    private TaxStrategy strategy;

    public TaxCalculator(TaxStrategy strategy) {
        this.strategy = strategy;
    }

    public TaxCalculator() {
        this.strategy = new StandardTaxStrategy();
    }

    public void setStrategy(TaxStrategy strategy) {
        this.strategy = strategy;
    }

    public double computeTTC(double prixHT) {
        return this.strategy.calculate(prixHT);
    }

    public String getCurrentStrategyLabel() {
        return this.strategy.getLabel();
    }
}