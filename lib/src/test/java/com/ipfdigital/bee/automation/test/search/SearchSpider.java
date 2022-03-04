package com.ipfdigital.bee.automation.test.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

import com.ipfdigital.bee.automation.test.global.generator.Scorecard;
import com.ipfdigital.bee.automation.test.global.generator.ScorecardGroup;
import com.ipfdigital.bee.automation.test.global.generator.ScorecardVariable;
import com.ipfdigital.bee.automation.test.mx.engine.Field;
import com.ipfdigital.bee.automation.test.global.generator.ScorecardDictionary;

public class SearchSpider {
	private ArrayList<ScorecardGroup> scorecardGroups = new ArrayList<>();
	private int dictionaryConstant = -1;
	private Stack<ActionUnit> history = new Stack<>();
	private ArrayList<Field> failHistory = new ArrayList<>();
	
	public SearchSpider(ScorecardDictionary dictionary) {
		this.dictionaryConstant = dictionary.getConstant();
		dictionary.asStream().forEach(entry -> this.scorecardGroups.add(new ScorecardGroup(entry.getKey(), entry.getValue())));
	}
	

	public boolean findTarget(int target) {
		target = target - dictionaryConstant;
		int allGroupsCount = scorecardGroups.stream().mapToInt(group -> 1).sum();
		
		while (true) {
			if (getCurrentScore() == target) {
				return true;
			}
			
			setBiggestSuitable(target);
			
			
			if (failHistory.size() == allGroupsCount) {
				System.out.println(history);
				System.out.println(failHistory);
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
		
		if (suitables.stream().mapToInt(ActionUnit::getStep).sum() == 0) {
			ActionUnit historyStart = history.get(0);
			
			// clear all
			history.clear();
			for (ScorecardGroup scorecardGroup : scorecardGroups) {
				scorecardGroup.setActive(0);
			}
			
			// entire group variables fails
			if (historyStart.getBecomeIndex() == 0) {
				failHistory.add(historyStart.getGroupName());
				return;
			}
			
			scorecardGroups.stream().filter(x -> x.getName().equals(historyStart.getGroupName())).findFirst().get().setActive(historyStart.getWasIndex());
			Integer wasScore = scorecardGroups.stream().filter(x -> x.getName().equals(historyStart.getGroupName())).findFirst().get().getScore();
			
			scorecardGroups.stream().filter(x -> x.getName().equals(historyStart.getGroupName())).findFirst().get().setActive(historyStart.getBecomeIndex() - 1);
			Integer becomeScore = scorecardGroups.stream().filter(x -> x.getName().equals(historyStart.getGroupName())).findFirst().get().getScore();
			
			historyStart.setStep(becomeScore - wasScore);
			historyStart.setBecomeIndex(historyStart.getBecomeIndex() - 1);
			
			suitables.clear();
			suitables.add(historyStart);
			history.add(historyStart);
		}
		
		
		Collections.sort(suitables, Comparator.comparing(ActionUnit::getStep));
		
		if (history.size() == 0 && failHistory.size() != 0) {
			int difference = suitables.size() - failHistory.size();
			for (int i = 0; i < difference; i++) {
				suitables.remove(suitables.size() - 1);
			}
		} 
		
		setActive(suitables.get(suitables.size() - 1));
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
