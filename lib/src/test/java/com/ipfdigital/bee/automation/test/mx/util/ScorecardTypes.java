package com.ipfdigital.bee.automation.test.mx.util;

import com.ipfdigital.bee.automation.test.mx.engine.Field;

public enum ScorecardTypes implements Field {
    ASC("ASC"),
    BSC("BSC");

    private final String csvName;

    ScorecardTypes(String csvName) {
        this.csvName = csvName;
    }

    @Override
    public String getContextKey() {
        return csvName;
    }

}