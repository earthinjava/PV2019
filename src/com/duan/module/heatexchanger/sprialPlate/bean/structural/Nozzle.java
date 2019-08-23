package com.duan.module.heatexchanger.sprialPlate.bean.structural;

import java.io.Serializable;

public class Nozzle implements Serializable{
	
	private static final long serialVersionUID = -2602971684349284653L;
	// �ھ�
	private double id;
	// ���� m/s
	private double velocity;
	// �������
	private double volumeFlow;

	// ��������������ھ�����������
	public Nozzle(double id, double volumeFlow) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.volumeFlow = volumeFlow;
		calVelocity();
	}

	public void setId(double id) {
		this.id = id;
		calVelocity();
	}

	public double getVelocity() {
		return velocity;
	}

	private void calVelocity() {
		double s = Math.PI * id * id / 4 / 1000000;
		velocity = volumeFlow / s;
	}

}
