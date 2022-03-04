package run;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import com.ipfdigital.bee.automation.test.mx.generator.AppScorecardDictionaryMX;
import com.ipfdigital.bee.automation.test.mx.generator.BehScorecardDictionaryMX;
import com.ipfdigital.bee.automation.test.search.SearchSpider;

public class MainTest {
	
	@RepeatedTest(10)
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void appConcreteTargetTest() {		
		SearchSpider searchSpider = new SearchSpider(new AppScorecardDictionaryMX());
		int score = (int) Math.round(Math.random() * (293 - 98) + 98);
		boolean result = searchSpider.findTarget(score);
		if (result) {
			System.out.println("FOUND: " + score);
		} else {
			System.out.println("NOT: " + score);
		}
	}
	
	@Test
	@Timeout(value = 1, unit = TimeUnit.SECONDS)
	void appFromMinToMaxTest() {
		for (int i = 98; i <= 293; i++) {
			SearchSpider searchSpider = new SearchSpider(new AppScorecardDictionaryMX());
			boolean result = searchSpider.findTarget(i);
			if (result) {
				System.out.println("FOUND: " + i);
			} else {
				System.out.println("NOT: " + i);
			}
		}
	}
	
	@RepeatedTest(10)
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	void behConcreteTargetTest() {		
		SearchSpider searchSpider = new SearchSpider(new BehScorecardDictionaryMX());
		int score = (int) Math.round(Math.random() * (348 - 119) + 119);
		boolean result = searchSpider.findTarget(score);
		if (result) {
			System.out.println("FOUND: " + score);
		} else {
			System.out.println("NOT: " + score);
		}
	}
	
	@Test
	@Timeout(value = 1, unit = TimeUnit.SECONDS)
	void behFromMinToMaxTest() {
		for (int i = 119; i <= 348; i++) {
			SearchSpider searchSpider = new SearchSpider(new BehScorecardDictionaryMX());
			boolean result = searchSpider.findTarget(i);
			if (result) {
				System.out.println("FOUND: " + i);
			} else {
				System.out.println("NOT: " + i);
			}
		}
	}
}
