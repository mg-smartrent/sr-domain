package com.mg.smartrent.domain.enrichment;

import com.mg.smartrent.domain.models.BizItem;

import java.util.Date;

public final class ModelEnricher {

    private ModelEnricher() {
    }

    /**
     * Enriches the Model object.
     *
     * @param model - model to be enriched
     */
    public static void enrich(final BizItem model) {
        if (model.getCreatedDate() == null) {
            model.setCreatedDate(new Date(System.currentTimeMillis()));
        }
        model.setModifiedDate(new Date(System.currentTimeMillis()));
    }
}
