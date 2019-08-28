package com.duan.medium;

import java.io.Serializable;

public class Medium implements Serializable {

	private static final long serialVersionUID = -5666484084385983234L;
	private String name;// 介质名称
	private MediumState state;// 状态：气态或液态
	private MediumLethal lethal;// 毒性 ：轻度，中毒，重度，极度
	private boolean isExplosive;// 是否易爆
	private double standardDensity;// 标况密度
	private double viscosity; // 粘度
	private double specificHeatCapacity;// 比热容
	private double thermalConductivity;// 导热系数

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MediumState getState() {
		return state;
	}

	public void setState(MediumState state) {
		this.state = state;
	}

	public MediumLethal getLethal() {
		return lethal;
	}

	public void setLethal(MediumLethal lethal) {
		this.lethal = lethal;
	}

	public boolean isExplosive() {
		return isExplosive;
	}

	public void setExplosive(boolean isExplosive) {
		this.isExplosive = isExplosive;
	}

	public double getStandardDensity() {
		return standardDensity;
	}

	public void setStandardDensity(double standardDensity) {
		this.standardDensity = standardDensity;
	}

	public double getViscosity() {
		return viscosity;
	}

	public void setViscosity(double viscosity) {
		this.viscosity = viscosity;
	}

	public double getSpecificHeatCapacity() {
		return specificHeatCapacity;
	}

	public void setSpecificHeatCapacity(double specificHeatCapacity) {
		this.specificHeatCapacity = specificHeatCapacity;
	}

	public double getThermalConductivity() {
		return thermalConductivity;
	}

	public void setThermalConductivity(double thermalConductivity) {
		this.thermalConductivity = thermalConductivity;
	}

}
