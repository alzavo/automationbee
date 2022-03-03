package com.ipfdigital.bee.automation.test.search;

import com.ipfdigital.bee.automation.test.mx.engine.Field;

public class ActionUnit {
	
	private Field groupName;
	private int wasIndex;
	private int becomeIndex;
	private int step;
	
	public ActionUnit(Field groupName, int wasIndex, int becomeIndex, int step) {
		this.groupName = groupName;
		this.wasIndex = wasIndex;
		this.becomeIndex = becomeIndex;
		this.step = step;
	}
	
	public Field getGroupName() {
		return groupName;
	}
	
	public int getWasIndex() {
		return wasIndex;
	}
	
	public int getBecomeIndex() {
		return becomeIndex;
	}
	
	public int getStep() {
		return step;
	}
	
	@Override
	public String toString() {
		return "{" + groupName + "|" + "step: " + getStep() + "}" + "\n";
	}

}
