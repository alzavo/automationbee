package com.ipfdigital.bee.automation.test.global.generator;

import com.ipfdigital.bee.automation.test.mx.engine.Field;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScorecardGroup {
	private final Field name;
    private final List<ScorecardVariable> values;
    private int active = 0;

    public ScorecardGroup(Field name, List<ScorecardVariable> variables) {
    	this.name = name;
        this.values = variables;
        Collections.sort(this.values, Comparator.comparing(ScorecardVariable::getScore));
    }

    public Integer getScore() {
        return values.get(active).getScore();
    }

    public String getValue() {
        return values.get(active).getValue();
    }

    public Field getName() {
        return name;
    }
    
    public List<ScorecardVariable> getValues() {
        return values;
    }
    
    public void changeUpActive() {
        if (active < values.size() - 1) {
            active++;
        } else {
            active = values.size() - 1;
        }
    }
    
    public void changeDownActive() {
        if (active > 0) {
            active--;
        } else {
            active = 0;
        }
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getActive() {
        return active;
    }

    public int getSize() {
        return values.size();
    }
    
    public boolean isTheBiggestScore() {
    	return active == getSize() - 1;
    }
    
    public boolean isTheLowestScore() {
    	return active == 0;
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("[");
    	for (ScorecardVariable scorecardVariable : values) {
    		if (values.get(getSize() - 1).equals(scorecardVariable)) {
    			sb.append(scorecardVariable.getScore() + "]");
			} else {
				sb.append(scorecardVariable.getScore() + ", ");
			}
		}
    	
    	if (getSize() != 0) {
    		return "{" + getName() + " | active:" + getActive() + " | " + sb.toString() + "}\n";
		} else {
    		return "{" + getName() + " | active:" + getActive() + "}\n";
		}
    }
}
