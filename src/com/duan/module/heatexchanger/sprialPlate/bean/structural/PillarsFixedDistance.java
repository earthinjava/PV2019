package com.duan.module.heatexchanger.sprialPlate.bean.structural;

import java.io.Serializable;

public class PillarsFixedDistance implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1918068986954851194L;
	// ��������ʽ0 ͼ8 1 ͼ9 2ͼ 10 3ͼ11
	private int type;
	// ����������
	private int numbers;
	// ����סX���mm
	private double xSpacing;
	// ����סX���mm
	private double ySpacing;
	// ÿƽ�׶���������
	private double numEveryM;
	// �������
	private double area;

	public PillarsFixedDistance(int type, double xSpacing, double ySpacing, double area) {
		this.type = type;
		this.xSpacing = xSpacing;
		this.ySpacing = ySpacing;
		this.area = area;
	}

	// ����ÿƽ�׶���������
	public double getPillarNumEveryM() {
		if (type <= 1) {
			numEveryM = 1 / (xSpacing * ySpacing * 4 / 1000000);
		} else {
			numEveryM = 1 / (xSpacing * ySpacing / 1000000);
		}
		return numEveryM;
	}

	// ���㶨��������
	public int getNumbers() {
		numbers = (int) Math.ceil(getPillarNumEveryM() * area);
		return numbers;
	}

}
