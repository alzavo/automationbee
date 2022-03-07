package com.ipfdigital.bee.automation.test.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Stack;

import com.ipfdigital.bee.automation.test.global.generator.Scorecard;
import com.ipfdigital.bee.automation.test.global.generator.ScorecardGroup;
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
	

	public Scorecard findTarget(int target) {
		target = target - dictionaryConstant;
		int allGroupsCount = scorecardGroups.stream().mapToInt(group -> 1).sum();
		
		while (true) {
			if (getCurrentScore() == target) {
				return new Scorecard(scorecardGroups, dictionaryConstant);
			}
			
			setBiggestSuitable(target);
			
			if (failHistory.size() == allGroupsCount) {
				throw new NoSuchElementException("Fail to find target.");
			}
		}
	}
	

	private void setBiggestSuitable(int target) {
		ArrayList<ActionUnit> suitables = new ArrayList<>();
		
		for (ScorecardGroup scorecardGroup : scorecardGroups) {
			for (int i = scorecardGroup.getSize() - 1; i > -1; i--) {
				int step = scorecardGroup.getValues().get(i).getScore() - scorecardGroup.getActive().getScore();
				boolean canAddVariable = false;
				
				if (getCurrentScore() < 0 && target < 0 && step <= Math.abs(Math.abs(target) - Math.abs(getCurrentScore()))) { 
					canAddVariable = true;
				} else if (getCurrentScore() <= 0 && target >= 0 && step <= target + Math.abs(getCurrentScore())) {
					canAddVariable = true;
				} else if (getCurrentScore() > 0 && target > 0 && step <= target - getCurrentScore()) {
					canAddVariable = true;
				}
				
				if (canAddVariable) {
					suitables.add(new ActionUnit(scorecardGroup.getName(), scorecardGroup.getActiveIndex(), i, step));
					break;
				}
				
			}
		}
		
		if (suitables.stream().mapToInt(ActionUnit::getStep).sum() == 0) {
			ActionUnit historyStart = history.get(0);
			
			clearAllData();
			
			if (checkIfGroupFails(historyStart)) {
				return;
			}
			
			setActiveInGroup(changeHistoryStart(historyStart));
			
		} else {
			Collections.sort(suitables, Comparator.comparing(ActionUnit::getStep));
			
			removeWaste(suitables);
			
			setActiveInGroup(suitables.get(suitables.size() - 1));
		}
	}
	
	private void removeWaste(ArrayList<ActionUnit> suitables) {
		if (history.size() == 0 && failHistory.size() != 0) {
			int difference = suitables.size() - failHistory.size();
			for (int i = 0; i < difference; i++) {
				suitables.remove(suitables.size() - 1);
			}
		} 
	}
	
	private boolean checkIfGroupFails(ActionUnit historyStart) {
		if (historyStart.getBecomeIndex() == 0) {
			failHistory.add(historyStart.getGroupName());
			return true;
		} else {
			return false;
		}
	}
	
	private void clearAllData() {
		history.clear();
		for (ScorecardGroup scorecardGroup : scorecardGroups) {
			scorecardGroup.setActive(0);
		}
	}
	
	private ActionUnit changeHistoryStart(ActionUnit historyStart) {
		ScorecardGroup startingGroup = scorecardGroups.stream()
				.filter(x -> x.getName().equals(historyStart.getGroupName()))
				.findFirst()
				.get();
		
		startingGroup.setActive(historyStart.getWasIndex());
		Integer wasScore = startingGroup.getScore();
		
		historyStart.setBecomeIndex(historyStart.getBecomeIndex() - 1);
		startingGroup.setActive(historyStart.getBecomeIndex());
		Integer becomeScore = startingGroup.getScore();
		
		historyStart.setStep(becomeScore - wasScore);
		
		return historyStart;
	}
	
	private void setActiveInGroup(ActionUnit unit) {
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
