package run;

import org.junit.jupiter.api.Test;

import com.ipfdigital.bee.automation.test.mx.generator.AppScorecardDictionaryMX;
import com.ipfdigital.bee.automation.test.mx.generator.BehScorecardDictionaryMX;
import com.ipfdigital.bee.automation.test.search.SearchSpider;

public class MainTest {
	
	@Test
	void appConcreteTargetTest() {		
		SearchSpider searchSpider = new SearchSpider(new AppScorecardDictionaryMX());
		int score = (int) Math.round(Math.random() * (293 - 98) + 98);
		score = 291;
		boolean result = searchSpider.findTarget(score);
		if (result) {
			System.out.println("FOUND: " + score);
		} else {
			System.out.println("NOT: " + score);
		}
	}
	
	@Test
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
	
	@Test
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
