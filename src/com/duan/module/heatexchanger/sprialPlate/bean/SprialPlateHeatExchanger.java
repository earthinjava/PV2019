package com.duan.module.heatexchanger.sprialPlate.bean;

import java.io.Serializable;

import com.duan.module.heatexchanger.sprialPlate.bean.designCondition.SPHEDesignConditions;
import com.duan.module.heatexchanger.sprialPlate.bean.structural.Nozzle;
import com.duan.module.heatexchanger.sprialPlate.bean.structural.StructuralDesign;

public class SprialPlateHeatExchanger implements Serializable{
	
	private static final long serialVersionUID = 3777414571455864255L;
	private SPHEDesignConditions spheDesignConditions;
	private PreThermalCalculation preThermalCalculation;
	private Nozzle hotInletNozzle;
	private Nozzle hotOutletNozzle;
	private Nozzle coldInletNozzle;
	private Nozzle coldOutletNozzle;
	private StructuralDesign structuralDesign;
	private ThermalCalculation thermalCalculation;

	public SPHEDesignConditions getSpheDesignConditions() {
		return spheDesignConditions;
	}

	public void setSpheDesignConditions(SPHEDesignConditions spheDesignConditions) {
		this.spheDesignConditions = spheDesignConditions;
	}

	public Nozzle getColdOutletNozzle() {
		return coldOutletNozzle;
	}

	public void setColdOutletNozzle(Nozzle coldOutletNozzle) {
		this.coldOutletNozzle = coldOutletNozzle;
	}

	public Nozzle getColdInletNozzle() {
		return coldInletNozzle;
	}

	public void setColdInletNozzle(Nozzle coldInletNozzle) {
		this.coldInletNozzle = coldInletNozzle;
	}

	public Nozzle getHotOutletNozzle() {
		return hotOutletNozzle;
	}

	public void setHotOutletNozzle(Nozzle hotOutletNozzle) {
		this.hotOutletNozzle = hotOutletNozzle;
	}

	public Nozzle getHotInletNozzle() {
		return hotInletNozzle;
	}

	public void setHotInletNozzle(Nozzle hotInletNozzle) {
		this.hotInletNozzle = hotInletNozzle;
	}

	public PreThermalCalculation getPreThermalCalculation() {
		return preThermalCalculation;
	}

	public void setPreThermalCalculation(PreThermalCalculation thermalCalculation) {
		this.preThermalCalculation = thermalCalculation;
	}

	public StructuralDesign getStructuralDesign() {
		return structuralDesign;
	}

	public void setStructuralDesign(StructuralDesign structuralDesign) {
		this.structuralDesign = structuralDesign;
	}

	public ThermalCalculation getThermalCalculation() {
		return thermalCalculation;
	}

	public void setThermalCalculation(ThermalCalculation thermalCalculation) {
		this.thermalCalculation = thermalCalculation;
	}
}
