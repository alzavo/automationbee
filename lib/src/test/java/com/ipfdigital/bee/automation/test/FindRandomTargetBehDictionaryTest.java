package com.ipfdigital.bee.automation.test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Timeout;

import com.ipfdigital.bee.automation.test.global.generator.Scorecard;
import com.ipfdigital.bee.automation.test.mx.generator.BehScorecardDictionaryMX;
import com.ipfdigital.bee.automation.test.search.SearchSpider;

public class FindRandomTargetBehDictionaryTest {
	
	@RepeatedTest(10)
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	void findTargetTest() {		
		SearchSpider searchSpider = new SearchSpider(new BehScorecardDictionaryMX());
		int score = (int) Math.round(Math.random() * (348 - 119) + 119);
		try {
			Scorecard result = searchSpider.findTarget(score);
			System.out.println("FOUND: " + result);
		} catch (NoSuchElementException e) {
			System.out.println("NOT FOUND: " + score);
		}
	}
}
