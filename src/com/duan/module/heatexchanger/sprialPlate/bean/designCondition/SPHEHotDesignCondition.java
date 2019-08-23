package com.duan.module.heatexchanger.sprialPlate.bean.designCondition;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.duan.medium.Medium;

public class SPHEHotDesignCondition implements SPHEDesignCondition, Serializable {
	
	private static final long serialVersionUID = 4834513532935393915L;
	// 设计压力
	private double designPress;
	// 进口温度
	private double inletTemp;
	// 出口温度
	private double outletTemp;
	// 介质
	private Medium medium;
	// 质量流量 kg/s
	private double massFlow;
	// 体积流量 m³/s
	private double volumnFlow;
	// 换热量 w
	private double heat;
	// 设计温度
	private double designTemp;
	// 是否为螺旋流
	private boolean isSpiralFlow;

	public SPHEHotDesignCondition(double designPress, double inletTemp, double outletTemp, String mediumName,
			double massFlow, double designTemp, boolean isSpiralFlow) {
		try {
			this.isSpiralFlow = isSpiralFlow;
			this.designTemp = designTemp;
			this.designPress = designPress;
			this.setInletTemp(inletTemp);
			this.setOutletTemp(outletTemp);
			this.setMassFlow(massFlow);
			if (mediumName.equals("水")) {
				mediumName = "H2O";
			} else {
				mediumName = "H2O";
			}
			double temp = (inletTemp + outletTemp) / 2;
			Class<?> class1 = Class.forName("com.duan.medium." + mediumName);
			Constructor<?> constructor = class1.getConstructor(double.class);
			medium = (Medium) constructor.newInstance(temp);
			setVolumnFlow(massFlow / medium.getDensity());
			heat = (inletTemp - outletTemp) * medium.getSpecificHeatCapacity() * massFlow;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public double getDesignTemp() {
		return designTemp;
	}

	public double getDesignPress() {
		return designPress;
	}

	public void setDesignPress(double designPress) {
		this.designPress = designPress;
	}

	public Medium getMedium() {
		return medium;
	}

	public double getInletTemp() {
		return inletTemp;
	}

	public void setInletTemp(double inletTemp) {
		this.inletTemp = inletTemp;
	}

	public double getOutletTemp() {
		return outletTemp;
	}

	public void setOutletTemp(double outletTemp) {
		this.outletTemp = outletTemp;
	}

	public double getHeat() {
		return heat;
	}

	public void setHeat(double heat) {
		this.heat = heat;
	}

	public double getMassFlow() {
		return massFlow;
	}

	public void setMassFlow(double massFlow) {
		this.massFlow = massFlow;
	}

	public double getVolumnFlow() {
		return volumnFlow;
	}

	public void setVolumnFlow(double volumnFlow) {
		this.volumnFlow = volumnFlow;
	}

	public boolean isSpiralFlow() {
		return isSpiralFlow;
	}

}
