package com.duan.module.opening.bean;

import java.io.Serializable;

public class A4 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double value;

	public A4(ReinforcementPlate reinforcementPlate) {
		// TODO Auto-generated constructor stub
		value = reinforcementPlate.getUsefullThick()
				* (reinforcementPlate.getOutDia() - reinforcementPlate.getIntDia());
	}

	public double getValue() {
		return value;
	}
}
