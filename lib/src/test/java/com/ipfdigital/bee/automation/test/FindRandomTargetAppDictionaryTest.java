package com.ipfdigital.bee.automation.test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Timeout;

import com.ipfdigital.bee.automation.test.global.generator.Scorecard;
import com.ipfdigital.bee.automation.test.mx.generator.AppScorecardDictionaryMX;
import com.ipfdigital.bee.automation.test.search.SearchSpider;

public class FindRandomTargetAppDictionaryTest {
	@RepeatedTest(10)
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	void findTargetTest() {		
		SearchSpider searchSpider = new SearchSpider(new AppScorecardDictionaryMX());
		int score = (int) Math.round(Math.random() * (293 - 98) + 98);
		try {
			Scorecard result = searchSpider.findTarget(score);
			System.out.println("FOUND: " + result);
		} catch (NoSuchElementException e) {
			System.out.println("NOT FOUND: " + score);
		}
	} 
}
