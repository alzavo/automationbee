package com.ipfdigital.bee.automation.test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import com.ipfdigital.bee.automation.test.global.generator.Scorecard;
import com.ipfdigital.bee.automation.test.mx.generator.BehScorecardDictionaryMX;
import com.ipfdigital.bee.automation.test.search.SearchSpider;

public class FindAllTargetsFromMinToMaxBehDictionaryTest {
	@Test
	@Timeout(value = 1, unit = TimeUnit.SECONDS)
	void findTargetsTest() {
		for (int i = 119; i <= 348; i++) {
			SearchSpider searchSpider = new SearchSpider(new BehScorecardDictionaryMX());
			try {
				Scorecard result = searchSpider.findTarget(i);
				System.out.println("FOUND: " + result);
			} catch (NoSuchElementException e) {
				System.out.println("NOT FOUND: " + i); 
			}
		}
	}
}
