package com.ipfdigital.bee.automation.test.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

import com.ipfdigital.bee.automation.test.global.generator.Scorecard;
import com.ipfdigital.bee.automation.test.global.generator.ScorecardGroup;
import com.ipfdigital.bee.automation.test.global.generator.ScorecardVariable;
import com.ipfdigital.bee.automation.test.mx.engine.Field;
import com.ipfdigital.bee.automation.test.global.generator.ScorecardDictionary;

// step, think about step

public class SearchSpider {
	private ArrayList<ScorecardGroup> scorecardGroups = new ArrayList<>();
	private int dictionaryConstant = -1;
	private ArrayList<Field> usedFields = new ArrayList<>();
	
	public SearchSpider(ScorecardDictionary dictionary) {
		this.dictionaryConstant = dictionary.getConstant();
		dictionary.asStream().forEach(entry -> this.scorecardGroups.add(new ScorecardGroup(entry.getKey(), entry.getValue())));
	}
	

	public Scorecard findTarget(int target) {
		// THINK ABOUT LOGIC OF SEARCH || WHAT EXACTLY DO WE NEED TO FIND
		target = target - dictionaryConstant;
		int searchTarget = getCurrentScore() - target;
		int stepCounter = 0;
		
		System.out.println("searchTarget: " + searchTarget);
		
		boolean doSearch = true;
		while (doSearch) {
			stepCounter++;
			
			System.out.println("current score: " + getCurrentScore());
			
			HashMap<Field, ScorecardVariable> suitableVars = getSuitableVars(searchTarget);
			HashMap<Field, ScorecardVariable> theBiggestSuitable = getTheBiggestSuitable(suitableVars);
			setActiveVariable(theBiggestSuitable);
			
			System.out.println(theBiggestSuitable);
			System.out.println("current score: " + getCurrentScore());
			
			
			if (stepCounter == 1) {
				doSearch = false;
			}
			
		}
	
		return null;
	}
	
	private HashMap<Field, ScorecardVariable> getSuitableVars(int searchTarget) {
		HashMap<Field, ScorecardVariable> suitableVars = new HashMap<>();
		
		for (ScorecardGroup scorecardGroup : scorecardGroups) {
			for (int i = scorecardGroup.getValues().size() - 1; i > -1; i--) {
				ScorecardVariable currentVariable = scorecardGroup.getValues().get(i);
				
				int step = currentVariable.getScore() - scorecardGroup.getActive().getScore();
				
				if (step == 24) {
					System.out.println(scorecardGroup);
				}

				if (step <= searchTarget) {
					suitableVars.put(scorecardGroup.getName(), currentVariable);
					break;
				}
			}
		}
		
		return suitableVars;
	}
	
	private HashMap<Field, ScorecardVariable> getTheBiggestSuitable(HashMap<Field, ScorecardVariable> suitableVars) {
		Field field = suitableVars.keySet().iterator().next();
		ScorecardVariable variable = suitableVars.values().iterator().next();
		
		for (Entry<Field, ScorecardVariable> entry : suitableVars.entrySet()) {
			if (entry.getValue().getScore() > variable.getScore()) {
				variable = entry.getValue();
				field = entry.getKey();
			}
		}
		
		HashMap<Field, ScorecardVariable> result = new HashMap<>();
		result.put(field, variable);
		
		return result;
	}
	
	private void setActiveVariable(HashMap<Field, ScorecardVariable> theBiggestSuitable) {
		Field field = theBiggestSuitable.keySet().iterator().next();
		ScorecardVariable variable = theBiggestSuitable.values().iterator().next();
		
		for (ScorecardGroup scorecardGroup : scorecardGroups) {
			if (scorecardGroup.getName().equals(field)) {
				int index = scorecardGroup.getValues().indexOf(variable);
				scorecardGroup.setActive(index);
				break;
			}
		}
	}
	
	private int getCurrentScore() {
		int result = 0;
		
		for (ScorecardGroup scorecardGroup : scorecardGroups) {
			result += scorecardGroup.getScore();
		}
		
		return result;
	}
}
