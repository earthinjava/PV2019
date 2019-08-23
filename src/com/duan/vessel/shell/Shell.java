package com.duan.vessel.shell;

import java.io.Serializable;

import com.duan.meterial.Meterial;
import com.duan.vessel.designCondition.DesignCondition;

public interface Shell extends Serializable{
	abstract double getCalculateThickness();

	abstract double getMinThickness();

	void setNThick(double nthick);

	double getNThick();

	public Meterial getMeterial();

	public void setAllowStress(double preAllowStress);

	public double getAllowStress();

	abstract double getC2();

	abstract double getC1();

	public DesignCondition getDesignCondition();

	public double getInterDia();

	public boolean isSafety();

	public double getUsefullThickness();

	public double getOutDia();

	public double getMaxAllowWokrPressure();
	public double getEff() ;
}
