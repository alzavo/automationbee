package com.ipfdigital.bee.automation.test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import com.ipfdigital.bee.automation.test.global.generator.Scorecard;
import com.ipfdigital.bee.automation.test.mx.generator.AppScorecardDictionaryMX;
import com.ipfdigital.bee.automation.test.mx.generator.BehScorecardDictionaryMX;
import com.ipfdigital.bee.automation.test.search.SearchSpider;

public class MainTest {
	
	@RepeatedTest(10)
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void appConcreteTargetTest() {		
		SearchSpider searchSpider = new SearchSpider(new AppScorecardDictionaryMX());
		int score = (int) Math.round(Math.random() * (293 - 98) + 98);
		try {
			Scorecard result = searchSpider.findTarget(score);
			System.out.println("FOUND: " + result);
		} catch (NoSuchElementException e) {
			System.out.println("NOT FOUND: " + score);
		}
	}
	
	@Test
	@Timeout(value = 1, unit = TimeUnit.SECONDS)
	void appFromMinToMaxTest() {
		for (int i = 98; i <= 293; i++) {
			SearchSpider searchSpider = new SearchSpider(new AppScorecardDictionaryMX());
			try {
				Scorecard result = searchSpider.findTarget(i);
				System.out.println("FOUND: " + result);
			} catch (NoSuchElementException e) {
				System.out.println("NOT FOUND: " + i);
			}
		}
	}
	
	@RepeatedTest(10)
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void behConcreteTargetTest() {		
		SearchSpider searchSpider = new SearchSpider(new BehScorecardDictionaryMX());
		int score = (int) Math.round(Math.random() * (348 - 119) + 119);
		try {
			Scorecard result = searchSpider.findTarget(score);
			System.out.println("FOUND: " + result);
		} catch (NoSuchElementException e) {
			System.out.println("NOT FOUND: " + score);
		}
	}
	
	@Test
	@Timeout(value = 1, unit = TimeUnit.SECONDS)
	void behFromMinToMaxTest() {
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
