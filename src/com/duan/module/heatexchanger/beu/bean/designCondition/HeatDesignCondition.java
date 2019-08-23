package com.duan.module.heatexchanger.beu.bean.designCondition;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.duan.medium.Medium;
import com.duan.vessel.designCondition.DesignCondition;

public class HeatDesignCondition implements DesignCondition, Serializable {
	
	private static final long serialVersionUID = 5710670891843980279L;
	// 设计压力mpa
	private double designPress;
	// 进口温度
	private double inletTemp;
	// 出口温度
	private double outletTemp;
	// 设计温度
	private double designTemp;
	// 介质
	private Medium medium;
	// 介质质量流量 kg/s
	private double massFlow;
	// 体积流量 m³/s
	private double volumnFlow;
	// 换热量 w
	private double heat;
	// 介质位置 true为管程
	private boolean isInTube;

	/**
	 * 创建冷侧介质需要换热量
	 * 
	 * @param designPress 设计压力 Mpa
	 * @param inletTemp   进口温度
	 * @param outletTemp  出口温度
	 * @param designTemp  设计温度
	 * @param mediumName  介质名称
	 * @param heat        换热量w
	 */
	public HeatDesignCondition(double designPress, double inletTemp, double outletTemp, double designTemp,
			String mediumName, Double heat, boolean isInTube) {
		try {
			this.designPress = designPress;
			this.setInletTemp(inletTemp);
			this.setOutletTemp(outletTemp);
			this.designTemp = designTemp;
			if (mediumName.equals("水")) {
				mediumName = "H2O";
			} else {
				mediumName = "H2O";
			}
			double temp = (inletTemp + outletTemp) / 2;
			Class<?> class1 = Class.forName("com.duan.medium." + mediumName);
			// 调用输入温度的构造器
			Constructor<?> constructor = class1.getConstructor(double.class);
			medium = (Medium) constructor.newInstance(temp);
			// 介质流量
			this.heat = heat;
			massFlow = heat / (outletTemp - inletTemp) / medium.getSpecificHeatCapacity();
			setVolumnFlow(massFlow / medium.getDensity());
			// 是否在管程
			this.isInTube = isInTube;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 创建热侧介质需要质量流量
	 * 
	 * @param designPress    设计压力 Mpa
	 * @param inletTemp      进口温度
	 * @param outletTemp     出口温度
	 * @param designTemp     设计温度
	 * @param mediumName     介质名称
	 * @param mediumMassFlow 介质质量流量 kg/s
	 */
	public HeatDesignCondition(double designPress, double inletTemp, double outletTemp, double designTemp,
			String mediumName, double mediumMassFlow, boolean isInTube) {
		try {
			this.designPress = designPress;
			this.setInletTemp(inletTemp);
			this.setOutletTemp(outletTemp);
			this.designTemp = designTemp;
			if (mediumName.equals("水")) {
				mediumName = "H2O";
			} else {
				mediumName = "H2O";
			}
			double temp = (inletTemp + outletTemp) / 2;
			Class<?> class1 = Class.forName("com.duan.medium." + mediumName);
			// 调用输入温度的构造器
			Constructor<?> constructor = class1.getConstructor(double.class);
			medium = (Medium) constructor.newInstance(temp);
			// 介质流量
			massFlow = mediumMassFlow;
			heat = (inletTemp - outletTemp) / medium.getSpecificHeatCapacity() * mediumMassFlow;
			setVolumnFlow(massFlow / medium.getDensity());
			// 是否在管程
			this.isInTube = isInTube;
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

	public double getDesignTemp() {
		return designTemp;
	}

	public boolean isInTube() {
		return isInTube;
	}

}
