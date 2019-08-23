package com.duan.meterial;

import java.io.Serializable;

import javax.swing.JTable;

import com.duan.meterialstandard.MeterialStandard;

public interface Meterial extends Serializable{	

	double getDensity();

	void setDensity(double density);

	boolean isSteel();

	double getThermalConductivity();

	void setThermalConductivity(double thermalConductivity);

	String getName();

	void setName(String name);

	MeterialStandard getMeterialStandard();

	public void setMeterialStandard(MeterialStandard meterialStandard);

	public JTable getAllowStressTable();

	public void setAllowStressTable(JTable allowStressTable);

	public double getModulus();

	public void setModulus(double modulus);

	public double getExpansion();

	public void setExpansion(double expansion);
	
	double getMinAllowTemp();

	void setMinAllowTemp(double minTemp);	
}
