package com.ipfdigital.bee.automation.test.global.generator;

public class ScorecardVariable {

    private final int score;
    private final String value;
    private final boolean causeRejection;

    public ScorecardVariable(String value, int score, boolean causeRejection) {
        this.score = score;
        this.value = value;
        this.causeRejection = causeRejection;
    }

    public ScorecardVariable(String value, int score) {
        this(value, score, false);
    }

    public int getScore() {
        return score;
    }

    public boolean causeRejection() {
        return causeRejection;
    }

    public String getValue() {
        return value;
    }
    
    @Override
    public String toString() {
    	
    	return "{value: " + value + " |score: " + getScore() + "}";
    }
}
