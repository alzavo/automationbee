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
		System.out.println("target: " + score);
		searchSpider.findTarget(score);
	}
	
	@Test
	void appFromMinToMaxTest() {
		SearchSpider searchSpider = new SearchSpider(new AppScorecardDictionaryMX());
		for (int i = 98; i <= 293; i++) {
			System.out.println("target: " + i);
			searchSpider.findTarget(i);
		}
	}
	
	@Test
	void behConcreteTargetTest() {		
		SearchSpider searchSpider = new SearchSpider(new AppScorecardDictionaryMX());
		int score = (int) Math.round(Math.random() * (348 - 119) + 119);
		System.out.println("target: " + score);
		searchSpider.findTarget(score);
	}
	
	@Test
	void behFromMinToMaxTest() {
		SearchSpider searchSpider = new SearchSpider(new BehScorecardDictionaryMX());
		for (int i = 119; i <= 348; i++) {
			System.out.println("target: " + i);
			searchSpider.findTarget(i);
		}
	}
}
