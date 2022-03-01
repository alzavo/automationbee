package com.ipfdigital.bee.automation.test.global.generator;

import com.ipfdigital.bee.automation.test.mx.engine.Field;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public interface ScorecardDictionary {

    Stream<Map.Entry<Field, List<ScorecardVariable>>> asStream();

    int getConstant();

    int getMinScore();

    int getMaxScore();
}
