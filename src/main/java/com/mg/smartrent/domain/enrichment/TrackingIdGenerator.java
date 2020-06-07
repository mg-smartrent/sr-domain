package com.mg.smartrent.domain.enrichment;

import java.util.UUID;

public final class TrackingIdGenerator {

    private TrackingIdGenerator() {

    }

    /**
     * Generates a unique identifier.
     *
     * @return - unique identifier
     */
    public static synchronized String generateUnique() {
        return UUID.randomUUID().toString();
    }

}
