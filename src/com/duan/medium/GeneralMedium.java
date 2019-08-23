package com.duan.medium;

public class GeneralMedium implements Medium{	

	private static final long serialVersionUID = -5666484084385983234L;
	private final String name = "未知";
	private final boolean isGass = false;
	private final boolean isLiquid = true;
	private final boolean isLethal = false;
	private final boolean isExplosive = false;
	private double density;
	private double viscosity;
	private double specificHeatCapacity;
	private double thermalConductivity;
	private double temperature;

	
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isGass() {
		return isGass;
	}

	@Override
	public boolean isLiquid() {
		return isLiquid;
	}

	@Override
	public boolean isLethal() {
		return isLethal;
	}

	@Override
	public boolean isExplosive() {
		return isExplosive;
	}

	@Override
	public double getDensity() {
		return density;
	}

	@Override
	public double getViscosity() {
		return viscosity;
	}

	@Override
	public double getSpecificHeatCapacity() {
		return specificHeatCapacity;
	}

	@Override
	public double getThermalConductivity() {
		return thermalConductivity;
	}

	@Override
	public double getTemperature() {
		return temperature;
	}

}
