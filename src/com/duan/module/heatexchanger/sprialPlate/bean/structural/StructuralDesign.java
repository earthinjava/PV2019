package com.duan.module.heatexchanger.sprialPlate.bean.structural;

import java.io.Serializable;

public class StructuralDesign implements Serializable{
	
	private static final long serialVersionUID = 4194091642770046380L;
	// �м����
	private BufflePlate bufflePlate;
	// ������
	private PillarsFixedDistance pillars;
	// ������
	private SpiralCoils spiralCoils;

	public StructuralDesign(BufflePlate bufflePlate, SpiralCoils spiralCoils) {
		// TODO Auto-generated constructor stub
		this.setBufflePlate(bufflePlate);
		this.setSpiralCoils(spiralCoils);
	}

	public BufflePlate getBufflePlate() {
		return bufflePlate;
	}

	public void setBufflePlate(BufflePlate bufflePlate) {
		this.bufflePlate = bufflePlate;
	}

	public PillarsFixedDistance getPillars() {
		return pillars;
	}

	public void setPillars(PillarsFixedDistance pillars) {
		this.pillars = pillars;
	}

	public SpiralCoils getSpiralCoils() {
		return spiralCoils;
	}

	public void setSpiralCoils(SpiralCoils spiralCoils) {
		this.spiralCoils = spiralCoils;
	}
}
