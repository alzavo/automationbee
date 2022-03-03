package com.ipfdigital.bee.automation.test.mx.generator;

import com.ipfdigital.bee.automation.test.global.generator.Scorecard;
import com.ipfdigital.bee.automation.test.global.generator.ScorecardDataGenerator;
import com.ipfdigital.bee.automation.test.mx.engine.Field;
import com.ipfdigital.bee.automation.test.mx.util.ScorecardTypes;
import com.ipfdigital.bee.automation.test.search.SearchSpider;

import java.util.Map;
import java.util.NoSuchElementException;

public class ScorecardDataGeneratorMX implements ScorecardDataGenerator {

    private static int MIN_SCORE;
    private static int MAX_SCORE;

    private final ScorecardDictionaryMX scorecardDictionary;

    public ScorecardDataGeneratorMX(ScorecardDictionaryMX dictionary) {
        if (dictionary.getType().equals(ScorecardTypes.BSC.name())) {
            this.scorecardDictionary = new BehScorecardDictionaryMX();
        } 
        else {
            this.scorecardDictionary = new AppScorecardDictionaryMX();
        }
        MIN_SCORE = this.scorecardDictionary.getMinScore();
        MAX_SCORE = this.scorecardDictionary.getMaxScore();
    }

    @Override
    public Map<Field, String> getScorecardDataByScore() {
        int score;

        if (scorecardDictionary.getClass() == BehScorecardDictionaryMX.class) {
            score = (int) Math.round(Math.random() * (348 - 119) + 119);
        } else {
            score = (int) Math.round(Math.random() * (293 - 98) + 98);
        }
        
        System.out.println("targetScore: " + score);
        
        return getScorecardByScore(score).getScorecardData();
    }

    private Scorecard getScorecardByScore(int score) {
        if (score <= 0) {
        	throw new IllegalStateException("Wrong score provided score = '" + score + "'");
        }
        
        SearchSpider searchSpider = new SearchSpider(scorecardDictionary); 
        try {
        	//return searchSpider.findTarget(normalizeInputScore(score));
        	return null;
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException();
		}

    }

    private static Integer normalizeInputScore(Integer score) {
        if (score < MIN_SCORE) {
            return MIN_SCORE;
        }
        if (score > MAX_SCORE) {
            return MAX_SCORE;
        }
        return score;
    }
}
