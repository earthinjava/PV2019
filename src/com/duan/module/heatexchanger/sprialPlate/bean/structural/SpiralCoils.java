package com.duan.module.heatexchanger.sprialPlate.bean.structural;

import java.io.Serializable;

import com.duan.utils.DoubleUtils;

public class SpiralCoils implements Serializable{
	
	private static final long serialVersionUID = 7124445775918222035L;
	// �Ȳ�������
	private SpiralCoil hotSpiralCoil;
	// ���������
	private SpiralCoil coldSpiralCoil;
	// ������ʵѡ�����⾶mm
	private double actruallongAxisOd;
	// �����廻����Ч�����⾶�����ڼ��㵱��ֱ��
	private double heatEfflongAxisOd;
	// ��ֹ���Ƿ��������ƽ��
	private boolean isCutOffParallelBaffle;
	// ������ʵ����Ч�������
	private double actrualEffArea;
	// ������ʵ�����
	private double actrualArea;
	// ������������軻��Ȧ��
	private double preReNumberCoils;
	// ����������Ч����Ly
	private double preEffLength;
	// ������ЧȦ��
	private double preNumEffCoils;
	// �������ͺ� 0:I���������� 1:I��Բͬ���� 2:II�ɲ����� 3:III�����ͨ��
	private int heatType;

	// �������������
	public SpiralCoils(SpiralCoil coldSpiralCoil, SpiralCoil hotSpiralCoil, double preReArea, int heatType) {
		// �ж����������ͨ��������Ȳ�ͨ�������Ϊbig
		this.hotSpiralCoil = hotSpiralCoil;
		this.coldSpiralCoil = coldSpiralCoil;
		this.heatType = heatType;
		preEffLength = preReArea * 1000000 / (2 * coldSpiralCoil.getSpiralPlate().getEffWidth());
	}

	// ���� �������賤�� �������������Ч����Ȧ��Nyp ��ֵΪ0.5������
	public double getPreReNumberEffectiveCoils() {
		double a = coldSpiralCoil.getInChannelSpacing() / 2 + hotSpiralCoil.getInChannelSpacing() / 2
				- coldSpiralCoil.getSpiralPlate().getRollRadius() * 2;
		double d = coldSpiralCoil.getInChannelSpacing() + hotSpiralCoil.getInChannelSpacing()
				+ 2 * coldSpiralCoil.getSpiralPlate().getNThick();
		double b = a * a + 4 * preEffLength * d / 3.14;
		double c = Math.sqrt(b);
		preNumEffCoils = (a + c) / d;
		// ����0.5����Բ��
		// С�ڵ���0.5ȡ0.5
		// 1.����ȡ��
		int floorInt = (int) Math.floor(preNumEffCoils);
		double pointDouble = preNumEffCoils - floorInt;
		double p;
		if (pointDouble <= 0.5) {
			p = 0.5;
		} else {
			p = 1;
		}
		preNumEffCoils = floorInt + p;
		return preNumEffCoils;
	}

	// �������������Ȧ��Nb
	public double getReNumberCoils() {
		getPreReNumberEffectiveCoils();
		if (heatType == 0) {// ����Ȧ��
			preReNumberCoils = preNumEffCoils;
		} else if (heatType == 1) {// �а�ԲͲ��
			preReNumberCoils = preNumEffCoils + 0.5;
		} else {// ��û��
			preReNumberCoils = preNumEffCoils + 1;
		}
		return preReNumberCoils;
	}

	// ������������ʵ��Ȧ��
	public void setHotAandColdSpiralCoilActualNum(double coilNum) {
		hotSpiralCoil.setNumberCoils(coilNum);
		coldSpiralCoil.setNumberCoils(coilNum);
		if (heatType == 0) {// ����Ȧ��
			hotSpiralCoil.setNumberEffCoils(coilNum);
			coldSpiralCoil.setNumberEffCoils(coilNum);
		} else if (heatType == 1) {// �а�ԲͲ��
			hotSpiralCoil.setNumberEffCoils(coilNum - 0.5);
			coldSpiralCoil.setNumberEffCoils(coilNum - 0.5);
		} else {// ��û��
			hotSpiralCoil.setNumberEffCoils(coilNum - 1);
			coldSpiralCoil.setNumberEffCoils(coilNum - 1);
		}
	}

	// ������ʵ����Ч����Ȧ��Ny
	public double getNumberEffCoils() {
		return hotSpiralCoil.getNumberEffCoils();
	}

	public SpiralCoil getHotSpiralCoil() {
		return hotSpiralCoil;
	}

	public SpiralCoil getColdSpiralCoil() {
		return coldSpiralCoil;
	}

	// ���ʵ����Ч�������
	public double getActrualEffArea() {
		double ly1 = hotSpiralCoil.getActrualCalLength();
		double ly2 = coldSpiralCoil.getActrualEffHeatLength();
		double hy = coldSpiralCoil.getSpiralPlate().getEffWidth();
		actrualEffArea = (ly1 + ly2) * hy / 1000000;
		return actrualEffArea;
	}

	// ���������ʵ����������ڼ��㶨�������
	public double getActrualArea() {
		double ly1 = hotSpiralCoil.getActrualCalLength();
		double ly2 = coldSpiralCoil.getActrualCalLength();
		double hy = coldSpiralCoil.getSpiralPlate().getEffWidth();
		actrualArea = (ly1 + ly2) * hy / 1000000;
		return actrualArea;
	}

	// �����峤���⾶
	public double getActruallongAxisOd() {
		double nb = getNumberEffCoils();
		double d1 = coldSpiralCoil.getSpiralPlate().getRollRadius() * 2;
		double d2 = hotSpiralCoil.getSpiralPlate().getRollRadius() * 2;
		double b1 = coldSpiralCoil.getInChannelSpacing();
		double b2 = hotSpiralCoil.getInChannelSpacing();
		double t = coldSpiralCoil.getSpiralPlate().getNThick();
		double e1 = coldSpiralCoil.getEccentricity();
		double e2 = hotSpiralCoil.getEccentricity();
		// �ж�NB��Ϊ����
		if (DoubleUtils.isInteger(nb)) {
			isCutOffParallelBaffle = true;
			actruallongAxisOd = (d1 - b1 + t) + nb * (b1 + b2 + 2 * t);
		} else if (DoubleUtils.isEven(nb - 0.5)) {// ��Ϊż��
			isCutOffParallelBaffle = false;
			double a1 = (d1 / 2 + t) + (nb + 0.5) / 2 * (b1 + b2 + 2 * t);
			actruallongAxisOd = 2 * Math.sqrt(a1 * a1 - e1 * e1);
		} else {
			isCutOffParallelBaffle = false;
			double a1 = (d1 / 2 + t) + (nb + 0.5) / 2 * (b2 + t) + (nb - 1.5) / 2 * (b1 + t);
			double a2 = (d2 / 2 + t) + (nb + 0.5) / 2 * (b1 + t) + (nb - 1.5) / 2 * (b2 + t);
			actruallongAxisOd = Math.sqrt(a1 * a1 - e1 * e1) + Math.sqrt(a2 * a2 - e2 * e2);
		}
		return actruallongAxisOd;
	}

	public boolean isCutOffParallelBaffle() {
		return isCutOffParallelBaffle;
	}

	// �����廻����Ч�⾶�����ڼ��㵱��ֱ��
	public double getHeatEfflongAxisOd() {
		double ny = coldSpiralCoil.getNumberEffCoils();
		double d1 = coldSpiralCoil.getSpiralPlate().getRollRadius() * 2;
		double d2 = hotSpiralCoil.getSpiralPlate().getRollRadius() * 2;
		double b1 = coldSpiralCoil.getInChannelSpacing();
		double b2 = hotSpiralCoil.getInChannelSpacing();
		double t = coldSpiralCoil.getSpiralPlate().getNThick();
		double e1 = coldSpiralCoil.getEccentricity();
		double e2 = hotSpiralCoil.getEccentricity();
		// �ж�NB��Ϊ����
		if (DoubleUtils.isInteger(ny)) {
			heatEfflongAxisOd = (d1 - b1 + t) + ny * (b1 + b2 + 2 * t);
		} else if (DoubleUtils.isEven(ny - 0.5)) {// ��Ϊż��
			double a1 = (d1 / 2 + t) + (ny + 0.5) / 2 * (b1 + b2 + 2 * t);
			heatEfflongAxisOd = 2 * Math.sqrt(a1 * a1 - e1 * e1);
		} else {
			double a1 = (d1 / 2 + t) + (ny + 0.5) / 2 * (b2 + t) + (ny - 1.5) / 2 * (b1 + t);
			double a2 = (d2 / 2 + t) + (ny + 0.5) / 2 * (b1 + t) + (ny - 1.5) / 2 * (b2 + t);
			heatEfflongAxisOd = Math.sqrt(a1 * a1 - e1 * e1) + Math.sqrt(a2 * a2 - e2 * e2);
		}
		return heatEfflongAxisOd;
	}

}
