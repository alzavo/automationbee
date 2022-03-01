package com.ipfdigital.bee.automation.test.search;

import java.util.ArrayList;

import com.ipfdigital.bee.automation.test.global.generator.Scorecard;
import com.ipfdigital.bee.automation.test.global.generator.ScorecardGroup;
import com.ipfdigital.bee.automation.test.global.generator.ScorecardVariable;
import com.ipfdigital.bee.automation.test.mx.engine.Field;
import com.ipfdigital.bee.automation.test.global.generator.ScorecardDictionary;

// check for all available scores
// choose the biggest suitable
// target - choice = target
// repeat 
// save story in cash, if fail to find, go back, and choose another path

// START WRITING CODE FROM THE BEGINNING 

public class SearchSpider {
	private ArrayList<ScorecardGroup> scorecardGroups = new ArrayList<>();
	private int dictionaryConstant = -1;
	private ArrayList<Field> usedFields = new ArrayList<>();
	
	public SearchSpider(ScorecardDictionary dictionary) {
		this.dictionaryConstant = dictionary.getConstant();
		dictionary.asStream().forEach(entry -> this.scorecardGroups.add(new ScorecardGroup(entry.getKey(), entry.getValue())));
	}
	

	public Scorecard findTarget(int target) {
		target = target - dictionaryConstant;
		int searchTarget = target;
		int stepCounter = 0;
		int currentScore = 0;
		
		boolean doSearch = true;
		while (doSearch) {
			stepCounter++;
			
			System.out.println("search target: " + searchTarget);
			
			currentScore = findBiggestSuitable(searchTarget);
			searchTarget -= currentScore;
			
			if (searchTarget == 0) {
				System.out.println("FOUND!");
				System.out.println(getCurrentScore());
				break;
			}

			if (stepCounter == 100) { 
				doSearch = false;
			}
			
		}
	
		return null;
	}
	
	private int findBiggestSuitable(int target) {
		Field suitableGroupName = null;
		int indexOfScore = 0;
		Integer biggestScore = null;
		
		for (ScorecardGroup scorecardGroup : scorecardGroups) {
			
			if (scorecardGroup.isTheBiggestScore() || usedFields.contains(scorecardGroup.getName())) {
				continue;
			}
			
			System.out.println(scorecardGroup.getName());
			
			int index = 1;
			while (scorecardGroup.getSize() - index >= 0) {
				ScorecardVariable variable = scorecardGroup.getValues().get(scorecardGroup.getSize() - index);
				
				if (biggestScore == null) {
					biggestScore = variable.getScore();
				}
				
//				System.out.println(variable.getScore() <= target && variable.getScore() >= score);
				
				if (variable.getScore() <= target && variable.getScore() >= biggestScore) {
					suitableGroupName = scorecardGroup.getName();
					usedFields.add(suitableGroupName);
					biggestScore = variable.getScore();
					indexOfScore = scorecardGroup.getValues().lastIndexOf(variable);
//					System.out.println(suitableGroupName);
//					System.out.println(score);
					break;
				}
				
				index++;
			}
		}
		
		if (suitableGroupName == null) {
			System.out.println("///////////////////////");
			System.out.println(usedFields);
			System.out.println(usedFields.size());
			System.out.println(suitableGroupName);
			System.out.println(biggestScore);
			throw new IllegalStateException();
		}
		
		
		for (ScorecardGroup scorecardGroup : scorecardGroups) {
			if (scorecardGroup.getName().equals(suitableGroupName)) {
				scorecardGroup.setActive(indexOfScore);
			}
		}
		
		return biggestScore;
	}
	
	
	
	private int getCurrentScore() {
		int result = 0;
		
		for (ScorecardGroup scorecardGroup : scorecardGroups) {
			result += scorecardGroup.getScore();
		}
		
		return result;
	}
}
