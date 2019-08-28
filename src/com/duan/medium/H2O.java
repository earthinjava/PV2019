package com.duan.medium;

import com.duan.utils.ArrayUtils;

public class H2O extends Medium {
	
	private static final long serialVersionUID = -744629020440042543L;
	private final String name = "水";
	private final boolean isGass = false;
	private final boolean isLiquid = true;
	private final boolean isLethal = false;
	private final boolean isExplosive = false;
	private double density;
	private double viscosity;
	private double specificHeatCapacity;
	private double thermalConductivity;
	private double temperature;

	public H2O(double temperature) {
		this.temperature = temperature;
		density = getDensityByTemp(temperature);
		viscosity = getViscosityByTemp(temperature);
		specificHeatCapacity = getSpecificHeatCapacityByTemp(temperature);
		thermalConductivity = getThermalConductivityByTemp(temperature);
	}
	
	@Override
	public String getName() {
		return name;
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

	public double getDensityByTemp(double temp) {
		double[] temps = { 0, 4, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		double[] densitys = { 999.87, 1000, 999.73, 998.7, 995.7, 992.2, 988.1, 983.2, 977.8, 971.8, 965.3, 958.4 };
		return ArrayUtils.getMidByTwoArrays(temps, densitys, temp);
	}

	public double getViscosityByTemp(double temp) {
		double[] temps = { 0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		double[] viscositys = { 0.0017921, 0.0013077, 0.0010050, 0.0008007, 0.0006560, 0.0005494, 0.0004688, 0.0004061,
				0.0003565, 0.0003165, 0.0002838 };
		return ArrayUtils.getMidByTwoArrays(temps, viscositys, temp);
	}

	public double getSpecificHeatCapacityByTemp(double temp) {
		double[] temps = { 1, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		double[] specificHeatCapacitys = { 4.2248, 4.205, 4.1899, 4.1807, 4.1766, 4.1767, 4.1803, 4.1868, 4.1957,
				4.2065, 4.2192 };
		return ArrayUtils.getMidByTwoArrays(temps, specificHeatCapacitys, temp) * 1000;
	}

	public double getThermalConductivityByTemp(double temp) {
		double[] temps = { 0, 4, 20, 100 };
		double[] thermalConductivitys = { 0.55, 0.58, 0.599, 0.683 };
		return ArrayUtils.getMidByTwoArrays(temps, thermalConductivitys, temp);
	}
}
