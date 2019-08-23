package com.duan.medium;

import java.io.Serializable;

public interface Medium extends Serializable{
	public String getName();

	public boolean isGass();

	public boolean isLiquid();

	public boolean isLethal();

	public boolean isExplosive();

	public double getDensity();

	public double getViscosity();

	public double getSpecificHeatCapacity();

	public double getThermalConductivity();

	public double getTemperature();

}
