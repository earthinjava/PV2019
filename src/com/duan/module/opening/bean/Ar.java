package com.duan.module.opening.bean;

import java.io.Serializable;

public class Ar implements Serializable{
	private static final long serialVersionUID = 1L;
	private double dop;
	private double shellCalTick;
	private double pipeUsefullThick;
	private double fr;
	private double value;

	public Ar(Openging openging) {
		// TODO Auto-generated constructor stub
		dop = openging.getPipe().getInterDia() + 2 * openging.getPipe().getC2() + 2 * openging.getPipe().getC1();
		shellCalTick = openging.getShell().getCalculateThickness();
		pipeUsefullThick = openging.getPipe().getNThick() - openging.getPipe().getC2() - openging.getPipe().getC1();
		fr = openging.getPipe().getAllowStress() / openging.getShell().getAllowStress();
		value = (dop * shellCalTick + 2 * shellCalTick * pipeUsefullThick * (1 - fr));
	}

	public double getValue() {
		return value;
	}
}
