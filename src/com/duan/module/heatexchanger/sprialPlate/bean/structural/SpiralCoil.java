package com.duan.module.heatexchanger.sprialPlate.bean.structural;

import java.io.Serializable;

import com.duan.module.heatexchanger.sprialPlate.bean.designCondition.SPHEDesignCondition;

public class SpiralCoil implements Serializable{
	
	private static final long serialVersionUID = -6966368600440403631L;
	// �ڲ�ͨ�����mm
	private double inChannelSpacing;
	// ���ͨ�����mm
	private double outChannelSpacing;
	// ƫ�ľ�mm
	private double eccentricity;
	// ͨ�������m2
	private double channelSectionArea;
	// ��������
	private SPHEDesignCondition designCondition;
	// ���� m/s
	private double channelVelocity;
	// ������
	private SpiralPlate spiralPlate;
	// ������ʵѡȦ��
	private double numberCoils;
	// ʵ����ЧȦ��
	private double numberEffCoils;
	// ������ʵ����Ч����Ly
	private double actrualEffHeatLength;
	// ��������㳤�ȣ�ʵ�ʳ��ȣ�mm Lb
	private double actrualCalLength;
	// ����ͨ������mm Lt
	private double spiralChannelActrualLength;

	public SpiralCoil(double inChannelSpacing, double outChannelSpacing, SpiralPlate spiralPlate,
			SPHEDesignCondition designCondition) {
		// TODO Auto-generated constructor stub
		this.inChannelSpacing = inChannelSpacing;
		this.outChannelSpacing = outChannelSpacing;
		this.designCondition = designCondition;
		this.spiralPlate = spiralPlate;
		eccentricity = inChannelSpacing / 2 + spiralPlate.getNThick() / 2;
	}

	// ����ʵ��Ȧ��
	public void setNumberCoils(double numberCoils) {
		this.numberCoils = numberCoils;
	}

	// ����ʵ����ЧȦ��
	public void setNumberEffCoils(double numberEffCoils) {
		this.numberEffCoils = numberEffCoils;
	}

	public double getNumberEffCoils() {
		return numberEffCoils;
	}

	// ���ʵ����Ч����ly
	public double getActrualEffHeatLength() {
		double ny = numberEffCoils;
		double d1 = spiralPlate.getRollRadius() * 2;
		double t = spiralPlate.getNThick();
		double b1, b2;
		if (inChannelSpacing > outChannelSpacing) {
			b2 = inChannelSpacing;
			b1 = outChannelSpacing;
		} else {
			b2 = outChannelSpacing;
			b1 = inChannelSpacing;
		}
		double ly1 = Math.PI / 2 * ny * ((d1 + t) + (ny - 1) * (b1 / 2 + b2 / 2 + t));
		if (outChannelSpacing > inChannelSpacing) {// ֤��ΪСȦ
			actrualEffHeatLength = ly1;
		} else {
			actrualEffHeatLength = ly1 + Math.PI / 2 * ny * (b2 - b1);
		}
		return actrualEffHeatLength;
	}

	// ʵѡȦ��������㳤��Lb
	public double getActrualCalLength() {
		double nb = numberCoils;
		double d1 = spiralPlate.getRollRadius() * 2;
		double t = spiralPlate.getNThick();
		double b1, b2;
		if (inChannelSpacing > outChannelSpacing) {
			b2 = inChannelSpacing;
			b1 = outChannelSpacing;
		} else {
			b2 = outChannelSpacing;
			b1 = inChannelSpacing;
		}
		double lb1 = Math.PI / 2 * nb * ((d1 + t) + (nb - 1) * (b1 / 2 + b2 / 2 + t));
		if (outChannelSpacing > inChannelSpacing) {// ֤��ΪСȦ
			actrualCalLength = lb1;
		} else {
			actrualCalLength = lb1 + Math.PI / 2 * nb * (b2 - b1);
		}
		return actrualCalLength;
	}

	// ����ͨ������Lt
	public double getSpiralChannelActrualLength() {
		double ny = getNumberEffCoils();
		double ly = getActrualEffHeatLength();
		double t = spiralPlate.getNThick();
		double b2 = outChannelSpacing;
		spiralChannelActrualLength = ly + Math.PI / 2 * ny * (b2 + t);
		return spiralChannelActrualLength;
	}

	public SpiralPlate getSpiralPlate() {
		return spiralPlate;
	}

	// ���ͨ�����
	public double getInChannelSpacing() {
		return inChannelSpacing;
	}

	// ƫ�ľ�
	public double getEccentricity() {
		return eccentricity;
	}

	// ͨ�������
	public double getChannelSectionArea(SpiralCoils spiralCoils) {
		// �ж�������
		if (designCondition.isSpiralFlow()) {
			channelSectionArea = inChannelSpacing * spiralPlate.getEffWidth() / 1000000;
		} else {
			// �����������
			// ������Բ�����ȥ�������������ȥ����������2
			double d = spiralCoils.getHeatEfflongAxisOd();
			double b1 = spiralCoils.getColdSpiralCoil().getInChannelSpacing();
			double b2 = spiralCoils.getHotSpiralCoil().getInChannelSpacing();
			double t = spiralCoils.getColdSpiralCoil().getSpiralPlate().getNThick();
			double s = Math.PI * (d - b1 - t) * (d - b1 - t) / 4 / 2 + Math.PI * (d - b2 - t) * (d - b2 - t) / 4 / 2;
			double r1 = spiralCoils.getColdSpiralCoil().getSpiralPlate().getRollRadius();
			double r2 = spiralCoils.getHotSpiralCoil().getSpiralPlate().getRollRadius();
			double l1 = spiralCoils.getColdSpiralCoil().getActrualEffHeatLength();
			double l2 = spiralCoils.getHotSpiralCoil().getActrualEffHeatLength();
			channelSectionArea = (s - Math.PI * r1 * r1 - Math.PI * r2 * r2 - t * (l1 + l2)) / 2 / 1000000;
		}
		return channelSectionArea;
	}

	// ����������
	public SPHEDesignCondition getDesignCondition() {
		return designCondition;
	}

	// ��ȡͨ������
	public double getChannelVelocity(SpiralCoils spiralCoils) {
		double volumeFlow = designCondition.getVolumnFlow();
		channelVelocity = volumeFlow / getChannelSectionArea(spiralCoils);
		return channelVelocity;

	}
}
