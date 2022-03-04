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
	
	public Field setGroupName(Field groupName) {
		return this.groupName = groupName;
	}
	
	public int getWasIndex() {
		return wasIndex;
	}
	
	public void setWasIndex(int wasIndex) {
		this.wasIndex = wasIndex;
	}
	
	public int getBecomeIndex() {
		return becomeIndex;
	}
	
	public void setBecomeIndex(int becomeIndex) {
		this.becomeIndex = becomeIndex;
	}
	
	public int getStep() {
		return step;
	}
	
	public void setStep(int step) {
		this.step = step;
	}
	
	@Override
	public String toString() {
		return "{" + groupName + "|" + "step: " + getStep() + "}" + "\n";
	}

}
