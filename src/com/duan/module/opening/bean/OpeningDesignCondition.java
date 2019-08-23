package com.duan.module.opening.bean;

import com.duan.vessel.designCondition.DesignCondition;

public class OpeningDesignCondition implements DesignCondition {

	private static final long serialVersionUID = 1L;
	private double designPress;
	private double designTemp;

	public OpeningDesignCondition(double designPress, double designTemp) {
		this.designPress = designPress;
		this.designTemp = designTemp;
	}

	@Override
	public double getDesignPress() {
		return designPress;
	}

	@Override
	public double getDesignTemp() {
		return designTemp;
	}

	
	


	
	
}
