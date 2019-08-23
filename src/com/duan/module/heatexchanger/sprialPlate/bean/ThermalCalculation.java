package com.duan.module.heatexchanger.sprialPlate.bean;

import java.io.Serializable;

import com.duan.module.heatexchanger.sprialPlate.bean.designCondition.SPHEDesignConditions;
import com.duan.module.heatexchanger.sprialPlate.bean.structural.StructuralDesign;
import com.duan.utils.Constant;

public class ThermalCalculation implements Serializable {

	private static final long serialVersionUID = 989618983224426005L;
	private SPHEDesignConditions designConditions;
	private StructuralDesign structuralDesign;
	private double logarithmicTemperatureDifference;
	private double heat;
	private double hotDE;
	private double coldDE;
	private double hotRe;
	private double coldRe;
	private boolean isHotRapids;
	private boolean isColdRapids;
	private double hotFoulingResistance;
	private double coldFoulingResistance;
	private double hotPr;
	private double coldPr;
	private double hotHeat;
	private double coldHeat;
	private double spiralPlateThermal;
	private double totalHeat;
	private double heatTransferArea;
	private double hotPressureDrop;
	private double coldPressureDrop;
	private double areaMargin;
	private double actualHeatArea;
	private double hotRollD;
	private double coldRollD;

	public ThermalCalculation(PreThermalCalculation preThermalCalculation, StructuralDesign structuralDesign) {
		// TODO Auto-generated constructor stub
		this.structuralDesign = structuralDesign;
		this.designConditions = preThermalCalculation.getDesignConditions();
		actualHeatArea = structuralDesign.getSpiralCoils().getActrualArea();
		logarithmicTemperatureDifference = preThermalCalculation.getLogarithmicTemperatureDifference();
		heat = designConditions.getHotDesignCondition().getHeat();
		hotRollD = structuralDesign.getSpiralCoils().getHotSpiralCoil().getSpiralPlate().getRollRadius() * 2;
		coldRollD = structuralDesign.getSpiralCoils().getColdSpiralCoil().getSpiralPlate().getRollRadius() * 2;
	}

	// ��ö����²�
	public double getLogarithmicTemperatureDifference() {
		return logarithmicTemperatureDifference;
	}

	// ����Ȳ൱��ֱ��m
	public double getHotDE() {
		// �ж��Ȳ��Ƿ�Ϊ������
		if (designConditions.getHotDesignCondition().isSpiralFlow()) {
			// �Ȳ�ͨ�����
			double hs = structuralDesign.getSpiralCoils().getHotSpiralCoil().getInChannelSpacing();
			// ��������Ч���
			double effWide = structuralDesign.getSpiralCoils().getHotSpiralCoil().getSpiralPlate().getEffWidth();
			hotDE = 2 * effWide * hs / (effWide + hs) / 1000;
		} else {
			// �Ȳ�ͨ�����
			double hs = structuralDesign.getSpiralCoils().getHotSpiralCoil().getInChannelSpacing();
			// ��������Ч���
			double effWide = structuralDesign.getSpiralCoils().getHotSpiralCoil().getSpiralPlate().getEffWidth();
			hotDE = 2 * effWide * hs / (effWide + hs) / 1000;
		}

		return hotDE;
	}

	// �����൱��ֱ��m
	public double getColdDE() {
		if (designConditions.getColdDesignCondition().isSpiralFlow()) {
			// �Ȳ�ͨ�����
			double cs = structuralDesign.getSpiralCoils().getColdSpiralCoil().getInChannelSpacing();
			// ��������Ч���
			double effWide = structuralDesign.getSpiralCoils().getColdSpiralCoil().getSpiralPlate().getEffWidth();
			coldDE = 2 * effWide * cs / (effWide + cs) / 1000;
		} else {
			// �Ȳ�ͨ�����
			double hs = structuralDesign.getSpiralCoils().getHotSpiralCoil().getInChannelSpacing();
			// ��������Ч���
			double effWide = structuralDesign.getSpiralCoils().getHotSpiralCoil().getSpiralPlate().getEffWidth();
			hotDE = 2 * effWide * hs / (effWide + hs) / 1000;
		}
		return coldDE;
	}

	// ����Ȳ���ŵ��
	public double getHotRe() {
		// �Ȳ��������
		double v = structuralDesign.getSpiralCoils().getHotSpiralCoil()
				.getChannelVelocity(structuralDesign.getSpiralCoils());
		// �Ȳ൱��ֱ��
		double d = getHotDE();
		// �Ȳ�����ܶ�
		double p = designConditions.getHotDesignCondition().getMedium().getDensity();
		// �Ȳ����ճ��
		double u = designConditions.getHotDesignCondition().getMedium().getViscosity();
		hotRe = d * v * p / u;
		return hotRe;
	}

	// ��������ŵ��
	public double getColdRe() {
		// ��������
		double v = structuralDesign.getSpiralCoils().getColdSpiralCoil()
				.getChannelVelocity(structuralDesign.getSpiralCoils());
		// ����ֱ��
		double d = getColdDE();
		// �����ܶ�
		double p = designConditions.getColdDesignCondition().getMedium().getDensity();
		// ����ճ��
		double u = designConditions.getColdDesignCondition().getMedium().getViscosity();
		coldRe = d * v * p / u;
		return coldRe;
	}

	// 判断热侧是否为湍流
	public boolean isHotRapids() {
		if (getHotRe() > 6000) {
			isHotRapids = true;
		} else {
			isHotRapids = false;
		}
		return isHotRapids;
	}

	// 冷侧是否为湍流
	public boolean isColdRapids() {
		if (getColdRe() > 6000) {
			isColdRapids = true;
		} else {
			isColdRapids = false;
		}
		return isColdRapids;
	}

	// �Ȳ��۹�����
	public void setHotFoulingResistance(double hotFoulingResistance) {
		this.hotFoulingResistance = hotFoulingResistance;
	}

	// ����۹�����
	public void setColdFoulingResistance(double coldFoulingResistance) {
		this.coldFoulingResistance = coldFoulingResistance;
	}

	// �Ȳ���������
	public double getHotPr() {
		// ����
		double c = designConditions.getHotDesignCondition().getMedium().getSpecificHeatCapacity();
		// ����ճ��
		double u = designConditions.getHotDesignCondition().getMedium().getViscosity();
		// ���ʵ���
		double d = designConditions.getHotDesignCondition().getMedium().getThermalConductivity();
		hotPr = c * u / 1000 / d * 1000;
		return hotPr;
	}

	// �����������
	public double getColdPr() {
		// ����
		double c = designConditions.getColdDesignCondition().getMedium().getSpecificHeatCapacity();
		// ����ճ��
		double u = designConditions.getColdDesignCondition().getMedium().getViscosity();
		// ���ʵ���
		double d = designConditions.getColdDesignCondition().getMedium().getThermalConductivity();
		coldPr = c * u / 1000 / d * 1000;
		return coldPr;
	}

	public double getHotHeat() {
		double r = designConditions.getHotDesignCondition().getMedium().getThermalConductivity();
		double d = getHotDE();
		double pd = structuralDesign.getSpiralCoils().getHeatEfflongAxisOd();
		double dm = hotRollD;
		double re = getHotRe();
		double pr = getHotPr();
		if (designConditions.getHotDesignCondition().isSpiralFlow() && re >= 6000) {
			hotHeat = 0.023 * r / d * (1 + 3.54 * d / (0.5 * (dm + pd) / 1000)) * Math.pow(re, 0.8) * Math.pow(pr, 0.4);
		} else if (!designConditions.getHotDesignCondition().isSpiralFlow() && re > 10000) {
			hotHeat = 0.023 * r / d * Math.pow(re, 0.8) * Math.pow(pr, 0.3333333333333);
		} else {
			hotHeat = Constant.ERROR_DOUBLE;
		}
		return hotHeat;
	}

	public double getColdHeat() {
		double r = designConditions.getColdDesignCondition().getMedium().getThermalConductivity();
		double d = getColdDE();
		double pd = structuralDesign.getSpiralCoils().getHeatEfflongAxisOd();
		double dm = coldRollD;
		double re = getColdRe();
		double pr = getColdPr();
		if (designConditions.getColdDesignCondition().isSpiralFlow() && re >= 6000) {
			coldHeat = 0.023 * r / d * (1 + 3.54 * d / (0.5 * (dm + pd) / 1000)) * Math.pow(re, 0.8)
					* Math.pow(pr, 0.4);
		} else if (!designConditions.getColdDesignCondition().isSpiralFlow() && re > 10000) // Ϊ������
		{
			coldHeat = 0.023 * r / d * Math.pow(re, 0.8) * Math.pow(pr, 0.3333333333333);
		} else {
			coldHeat = Constant.ERROR_DOUBLE;
		}

		return coldHeat;
	}

	// �����嵼��ϵ��
	public void setSpiralPlateThermal(double spiralPlateThermal) {
		this.spiralPlateThermal = spiralPlateThermal;
	}

	// �ܴ���ϵ��
	public double getTotalHeat() {
		double k1 = 1 / getHotHeat();
		double k2 = 1 / getColdHeat();
		double k3 = structuralDesign.getSpiralCoils().getHotSpiralCoil().getSpiralPlate().getNThick()
				/ spiralPlateThermal / 1000;
		double k4 = hotFoulingResistance;
		double k5 = coldFoulingResistance;
		totalHeat = 1 / (k1 + k2 + k3 + k4 + k5);
		return totalHeat;
	}

	// �ܻ������
	public double getHeatTransferArea() {
		heatTransferArea = heat / logarithmicTemperatureDifference / getTotalHeat();
		return heatTransferArea;
	}

	// �Ȳ�ѹ����
	public double getHotPressureDrop() {
		// ��ŵ��
		double re = getHotRe();
		double sl = structuralDesign.getSpiralCoils().getHotSpiralCoil().getSpiralChannelActrualLength() / 1000;
		double d = getHotDE();
		double v = structuralDesign.getSpiralCoils().getHotSpiralCoil()
				.getChannelVelocity(structuralDesign.getSpiralCoils());
		double den = designConditions.getHotDesignCondition().getMedium().getDensity();
		double h = structuralDesign.getSpiralCoils().getHotSpiralCoil().getSpiralPlate().getEffWidth();
		// �����������٣�����ֱ��δУ��
		if (designConditions.getHotDesignCondition().isSpiralFlow() && re > 4000 && re < 200000) {
			double d1 = sl / d * (0.365 / (Math.pow(re, 0.25)));
			double d2 = 0.0153 * structuralDesign.getPillars().getPillarNumEveryM() * sl;
			double d3 = den * v * v * 0.5;
			hotPressureDrop = (d1 + d2 + 4) * d3 / 1000000;
		} else if (!designConditions.getHotDesignCondition().isSpiralFlow() && re > 10000) // Ϊ������
		{
			hotPressureDrop = (0.184 * h / d * (Math.pow(re, -0.2) + 4)) * den * v * v / 2 / 1000000;
		} else {
			hotPressureDrop = 0;
		}
		return hotPressureDrop;
	}

	public double getColdPressureDrop() {
		double re = getColdRe();
		double sl = structuralDesign.getSpiralCoils().getColdSpiralCoil().getSpiralChannelActrualLength() / 1000;
		double d = getColdDE();
		double v = structuralDesign.getSpiralCoils().getColdSpiralCoil()
				.getChannelVelocity(structuralDesign.getSpiralCoils());
		double den = designConditions.getColdDesignCondition().getMedium().getDensity();
		double h = structuralDesign.getSpiralCoils().getColdSpiralCoil().getSpiralPlate().getEffWidth();
		if (designConditions.getColdDesignCondition().isSpiralFlow() && re > 4000 && re < 200000) {
			double d1 = sl / d * (0.365 / (Math.pow(re, 0.25)));
			double d2 = 0.0153 * structuralDesign.getPillars().getPillarNumEveryM() * sl;
			double d3 = den * v * v * 0.5;
			coldPressureDrop = (d1 + d2 + 4) * d3 / 1000000;
		} else if (!designConditions.getColdDesignCondition().isSpiralFlow() && re > 10000)// Ϊ������
		{
			coldPressureDrop = (0.184 * h / d * (Math.pow(re, -0.2) + 4)) * den * v * v / 2 / 1000000;
		} else {
			coldPressureDrop = 0;
		}
		return coldPressureDrop;
	}

	/**
	 * 面积余量
	 * 
	 * @return
	 */
	public double getAreaMargin() {
		double a1 = actualHeatArea;
		double a2 = getHeatTransferArea();
		areaMargin = (a1 - a2) / a2 * 100;
		return areaMargin;
	}

	// �����Ȳ�ѹ����ԣ��
	public double getHotPressDropMargin() {
		return getHotPressureDrop() / designConditions.getHotDesignCondition().getDesignPress() * 100;
	}

	// �����Ȳ�ѹ����ԣ��
	public double getColdPressDropMargin() {
		return getColdPressureDrop() / designConditions.getColdDesignCondition().getDesignPress() * 100;
	}

}
