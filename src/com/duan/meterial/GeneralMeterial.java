package com.duan.meterial;

import javax.swing.JTable;

import com.duan.meterialstandard.MeterialStandard;

public class GeneralMeterial implements Meterial {
	
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

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double getDensity() {
		return density;
	}

	@Override
	public boolean isSteel() {
		if (getMeterialStandard().getProperty().isNonferrous()) {
			return false;
		}	
		return true;
	}

	@Override
	public double getThermalConductivity() {
		return thermalConductivity;
	}

	@Override
	public MeterialStandard getMeterialStandard() {
		return meterialStandard;
	}

	@Override
	public void setMeterialStandard(MeterialStandard meterialStandard) {
		this.meterialStandard = meterialStandard;
	}

	@Override
	public JTable getAllowStressTable() {
		return allowStressTable;
	}

	@Override
	public void setAllowStressTable(JTable allowStressTable) {
		this.allowStressTable = allowStressTable;
	}

	@Override
	public double getModulus() {
		return modulus;
	}

	@Override
	public void setModulus(double modulus) {
		this.modulus = modulus;
	}

	@Override
	public double getExpansion() {
		return expansion;
	}

	@Override
	public void setExpansion(double expansion) {
		this.expansion = expansion;
	}

	@Override
	public void setDensity(double density) {
		this.density = density;
	}

	@Override
	public void setThermalConductivity(double thermalConductivity) {
		this.thermalConductivity = thermalConductivity;
	}

	@Override
	public double getMinAllowTemp() {
		return minAllowTemp;
	}

	@Override
	public void setMinAllowTemp(double minTemp) {
		this.minAllowTemp = minTemp;
	}

}
