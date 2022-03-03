package com.ipfdigital.bee.automation.test.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

import com.ipfdigital.bee.automation.test.global.generator.Scorecard;
import com.ipfdigital.bee.automation.test.global.generator.ScorecardGroup;
import com.ipfdigital.bee.automation.test.global.generator.ScorecardVariable;
import com.ipfdigital.bee.automation.test.global.generator.ScorecardDictionary;

public class SearchSpider {
	private ArrayList<ScorecardGroup> scorecardGroups = new ArrayList<>();
	private int dictionaryConstant = -1;
	private Stack<ActionUnit> history = new Stack<>();
	
	public SearchSpider(ScorecardDictionary dictionary) {
		this.dictionaryConstant = dictionary.getConstant();
		dictionary.asStream().forEach(entry -> this.scorecardGroups.add(new ScorecardGroup(entry.getKey(), entry.getValue())));
	}
	

	public boolean findTarget(int target) {
		System.out.println("target: " + target);
		target = target - dictionaryConstant;
		int stepCounter = 0;
		
		System.out.println("target: " + target);
		
		while (true) {
			stepCounter++;
			
			if (getCurrentScore() == target) {
				return true;
			}
			
			System.out.println(getCurrentScore());
			setBiggestSuitable(target);
			System.out.println(getCurrentScore());
			
//			setBiggestSuitable(target);
			
			
			if (stepCounter == 20) {
				System.out.println(history);
				return false;
			}
		}
	}
	

	private void setBiggestSuitable(int target) {
		ArrayList<ActionUnit> suitables = new ArrayList<>();
		
		for (ScorecardGroup scorecardGroup : scorecardGroups) {
			for (int i = scorecardGroup.getSize() - 1; i > -1; i--) {
				ScorecardVariable variable = scorecardGroup.getValues().get(i);
				int activeScore = scorecardGroup.getActive().getScore();
				int currentScore = variable.getScore();
				int step = currentScore - activeScore;
				
				// both negative
				if (getCurrentScore() < 0 && target < 0) {
					if (step <= Math.abs(Math.abs(target) - Math.abs(getCurrentScore()))) {
						suitables.add(new ActionUnit(scorecardGroup.getName(), scorecardGroup.getActiveIndex(), i, step));
						break;
					}
				}
				
				// current negative, target positive
				if (getCurrentScore() <= 0 && target >= 0) {
					if (step <= target + Math.abs(getCurrentScore())) {
						suitables.add(new ActionUnit(scorecardGroup.getName(), scorecardGroup.getActiveIndex(), i, step));
						break;
					}
				}
			
				// current positive, target negative
				if (getCurrentScore() > 0 && target < 0) {
					throw new IllegalStateException();
				}
				
				// both positive
				if (getCurrentScore() > 0 && target > 0) {
					if (step <= target - getCurrentScore()) {
						suitables.add(new ActionUnit(scorecardGroup.getName(), scorecardGroup.getActiveIndex(), i, step));
						break;
					}
				}
				
			}
		}
		
		// if sum of steps in suitables is 0, then choose another thing
		int check = suitables.stream().mapToInt(ActionUnit::getStep).sum();
		// create history where will be hold first action unit of current search
		// then fail => add first action unit and start new search from other variable
		// also can see how much difference between current search and target, then check for this step among groups
		
		Collections.sort(suitables, Comparator.comparing(ActionUnit::getStep));
		
		setActive(suitables.get(suitables.size() - 1));
		
		System.out.println(suitables);
	}
	
	private void setActive(ActionUnit unit) {
		for (ScorecardGroup scorecardGroup : scorecardGroups) {
			if (scorecardGroup.getName().equals(unit.getGroupName())) {
				scorecardGroup.setActive(unit.getBecomeIndex());
				history.add(unit);
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
