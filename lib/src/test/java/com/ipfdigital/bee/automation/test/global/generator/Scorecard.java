package com.ipfdigital.bee.automation.test.global.generator;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

import com.ipfdigital.bee.automation.test.mx.engine.Field;

public class Scorecard {

	  private final ArrayList<ScorecardGroup> scorecard;
	  private final int constant;
	 
	  public Scorecard(ArrayList<ScorecardGroup> scorecard, int constant) {
		  this.scorecard = scorecard;
		  this.constant = constant;
	  }

	  public Integer getScore() {
	    return scorecard.stream().mapToInt(ScorecardGroup::getScore).sum() + constant;
	  }

	  public Map<Field, String> getData() {
	    return scorecard.stream().collect(Collectors.toMap(ScorecardGroup::getName, ScorecardGroup::getValue));
	  }

	  public Map<Field, Integer> getScores() {
	    return scorecard.stream().collect(Collectors.toMap(ScorecardGroup::getName, ScorecardGroup::getScore));
	  }

	  public Scorecard copy() {
	    Scorecard copy = new Scorecard(scorecard, constant);
	    return copy;
	  }
	  
	  @Override
	  public String toString() {
		  return "{" + getScore() + "}";
	  }
}