package com.ipfdigital.bee.automation.test.global.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import com.ipfdigital.bee.automation.test.mx.engine.Field;

public class Scorecard {

	  private final List<ScorecardGroup> scorecard = new ArrayList<>();
	  private final ScorecardDictionary dictionary;
	 
	  public Scorecard(ScorecardDictionary scorecardDictionary) {
		  this.dictionary = scorecardDictionary;
	  }

	  public Integer getScore() {
	    return scorecard.stream().mapToInt(ScorecardGroup::getScore).sum() + dictionary.getConstant();
	  }

	  public Map<Field, String> getScorecardData() {
	    return scorecard.stream().collect(Collectors.toMap(ScorecardGroup::getName, ScorecardGroup::getValue));
	  }

	  public Map<Field, Integer> getScores() {
	    return scorecard.stream().collect(Collectors.toMap(ScorecardGroup::getName, ScorecardGroup::getScore));
	  }

	  private ScorecardGroup getScorecardGroup(Integer number) {
	    return scorecard.get(number);
	  }

	  private Integer getSize() {
	    return scorecard.size();
	  }

	  private void setStatus(Map<Field, Integer> status) {
	    scorecard.forEach(group -> group.setActive(status.get(group.getName())));
	  }

	  public Scorecard copy() {
	    Scorecard copy = new Scorecard(dictionary);
	    copy.setStatus(scorecard.stream().collect(Collectors.toMap(ScorecardGroup::getName, ScorecardGroup::getActiveIndex)));
	    return copy;
	  }

	  public void changeRandomScorecardGroup() {
	    int scorecardGroup = ThreadLocalRandom.current().nextInt(getSize() - 1);
	    getScorecardGroup(scorecardGroup).changeUpActive();
	  }

	  public void shuffle() {
	    scorecard.forEach(group -> group.setActive(ThreadLocalRandom.current().nextInt(group.getSize())));
	  }
}