package com.duan.module.heatexchanger.sprialPlate.bean.designCondition;

import java.io.Serializable;

import com.duan.medium.Medium;

public interface SPHEDesignCondition extends  Serializable{
	public double getDesignPress();

	public void setDesignPress(double designPress);

	public Medium getMedium();

	public double getInletTemp();

	public void setInletTemp(double inletTemp);

	public double getOutletTemp();

	public void setOutletTemp(double outletTemp);

	public double getHeat();

	public void setHeat(double heat);

	public double getMassFlow();

	public void setMassFlow(double massFlow);

	public double getVolumnFlow();

	public void setVolumnFlow(double volumnFlow);

	public double getDesignTemp();

	boolean isSpiralFlow();

}
