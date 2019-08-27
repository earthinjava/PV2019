package com.duan.medium;

import java.io.Serializable;

public class Medium implements Serializable {

	private static final long serialVersionUID = -5666484084385983234L;
	private String name;// 介质名称
	private String state;// 状态：气态或液态
	private String lethal;// 毒性 ：轻度，中毒，重度，极度
	private boolean isExplosive;// 是否易爆
	private double density;// 密度
	private double viscosity;
	private double specificHeatCapacity;
	private double thermalConductivity;
	private double temperature;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGass() {
		return isGass;
	}

	public boolean isLiquid() {
		return isLiquid;
	}

	public boolean isLethal() {
		return isLethal;
	}

	public boolean isExplosive() {
		return isExplosive;
	}

	public double getDensity() {
		return density;
	}

	public double getViscosity() {
		return viscosity;
	}

	public double getSpecificHeatCapacity() {
		return specificHeatCapacity;
	}

	public double getThermalConductivity() {
		return thermalConductivity;
	}

	public double getTemperature() {
		return temperature;
	}

}
