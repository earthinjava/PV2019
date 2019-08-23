package com.duan.module.heatexchanger.sprialPlate.bean.structural;
/**
 * �м����
 * @author Administrator
 *
 */

import java.io.Serializable;

import com.duan.meterial.Meterial;

public class BufflePlate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3158937142527668032L;
	// �������������巽��Ϊ����
	private double length;
	// �������巽��һ��Ϊ���
	private double width;
	private double calThick;
	private double nThick;
	private Meterial meterial;
	private double allowStress;

	public BufflePlate(SpiralCoil hotCoil, SpiralCoil coldCoil) {
		double w1 = 2 * hotCoil.getSpiralPlate().getRollRadius() - hotCoil.getInChannelSpacing()
				+ hotCoil.getSpiralPlate().getNThick();
		double w2 = 2 * coldCoil.getSpiralPlate().getRollRadius() - coldCoil.getInChannelSpacing()
				+ coldCoil.getSpiralPlate().getNThick();
		length = w1 >= w2 ? w1 : w2;
		width = coldCoil.getSpiralPlate().getWidth();
	}

	// ������
	public double getWidth() {
		return width;

	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getCalThick() {
		return calThick;
	}

	public void setCalThick(double calThick) {
		this.calThick = calThick;
	}

	public double getnThick() {
		return nThick;
	}

	public void setnThick(double nThick) {
		this.nThick = nThick;
	}

	public Meterial getMeterial() {
		return meterial;
	}

	public void setMeterial(Meterial meterial) {
		this.meterial = meterial;
	}

	public double getAllowStress() {
		return allowStress;
	}

	public void setAllowStress(double allowStress) {
		this.allowStress = allowStress;
	}
}
