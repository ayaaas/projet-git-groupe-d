package com.groupd.git_project.service.tax;

import org.springframework.stereotype.Component;

@Component
public class TaxStrategyFactory {

    public TaxStrategy getStrategy(String categorie) {
        return switch (categorie.toLowerCase()) {
            case "alimentaire", "epicerie", "frais" -> new ReducedTaxStrategy();
            case "exonere", "export", "medical"     -> new ExemptTaxStrategy();
            default                                  -> new StandardTaxStrategy();
        };
    }
}