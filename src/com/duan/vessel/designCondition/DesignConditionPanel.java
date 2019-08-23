package com.duan.vessel.designCondition;

import com.duan.component.PureNumField;

public interface DesignConditionPanel {

	public void apply();

	public boolean isSucessApply();

	public DesignCondition getDsgcon();
	
	public PureNumField getDesignTempField();
}
