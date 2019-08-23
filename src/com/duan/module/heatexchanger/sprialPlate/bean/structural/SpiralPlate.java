package com.duan.module.heatexchanger.sprialPlate.bean.structural;

import java.io.Serializable;

//������
public class SpiralPlate implements Serializable{
	
	private static final long serialVersionUID = -4315617192266254572L;
	// ��������
	private double width;
	// ������������
	private double nThick;
	// �������ȷ���δ����ߴ�
	private double unwettedSizeInWidth;
	// ����뾶mm
	private double rollRadius;
	// ��������Ч���
	private double effWidth;

	public SpiralPlate(double spiralPlateWidth, double spiralPlateThick, double unwettedSizeInWidth,
			double rollRadius) {
		this.nThick = spiralPlateThick;
		this.width = spiralPlateWidth;
		this.unwettedSizeInWidth = unwettedSizeInWidth;
		effWidth = (spiralPlateWidth - unwettedSizeInWidth);
		this.rollRadius = rollRadius;
	}

	// ����뾶
	public double getRollRadius() {
		return rollRadius;
	}

	public double getWidth() {
		return width;
	}

	public double getNThick() {
		return nThick;
	}

	public double getUnwettedSizeInWidth() {
		return unwettedSizeInWidth;
	}

	// ��������Ч���
	public double getEffWidth() {
		effWidth = (width - unwettedSizeInWidth);
		return effWidth;
	}

}
