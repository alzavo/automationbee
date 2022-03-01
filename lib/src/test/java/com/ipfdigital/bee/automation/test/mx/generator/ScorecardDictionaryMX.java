package com.ipfdigital.bee.automation.test.mx.generator;

import com.ipfdigital.bee.automation.test.global.generator.ScorecardDictionary;

public abstract class ScorecardDictionaryMX implements ScorecardDictionary {

    private String type;

    ScorecardDictionaryMX() {}

    String getType() {
        return type;
    }
}
