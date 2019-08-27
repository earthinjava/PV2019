package com.duan.meterial;

import java.io.Serializable;

import javax.swing.JTable;

import com.duan.meterialstandard.MeterialStandard;

public class Meterial implements Serializable {
	
	private static final long serialVersionUID = 1L;
	// 材料名称
	private String name;
	// 材料执行标准
	private MeterialStandard meterialStandard;
	// 密度t/m³
	private double density;
	// 导热系数w/(M.K)
	private double thermalConductivity;
	// 弹性模量10³MPa
	private double modulus;
	// 线膨胀系数mm/m.k
	private double expansion;
	// 许用应力
	private JTable allowStressTable;
	// 最低使用温度
	private double minAllowTemp;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDensity() {
		return density;
	}

	public boolean isSteel() {
		if (getMeterialStandard().getProperty().isNonferrous()) {
			return false;
		}	
		return true;
	}

	public double getThermalConductivity() {
		return thermalConductivity;
	}

	public MeterialStandard getMeterialStandard() {
		return meterialStandard;
	}

	public void setMeterialStandard(MeterialStandard meterialStandard) {
		this.meterialStandard = meterialStandard;
	}

	public JTable getAllowStressTable() {
		return allowStressTable;
	}

	public void setAllowStressTable(JTable allowStressTable) {
		this.allowStressTable = allowStressTable;
	}

	public double getModulus() {
		return modulus;
	}

	public void setModulus(double modulus) {
		this.modulus = modulus;
	}

	public double getExpansion() {
		return expansion;
	}

	public void setExpansion(double expansion) {
		this.expansion = expansion;
	}

	public void setDensity(double density) {
		this.density = density;
	}

	public void setThermalConductivity(double thermalConductivity) {
		this.thermalConductivity = thermalConductivity;
	}

	public double getMinAllowTemp() {
		return minAllowTemp;
	}

	public void setMinAllowTemp(double minTemp) {
		this.minAllowTemp = minTemp;
	}

}
