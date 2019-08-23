package com.duan.vessel.head;

import java.io.Serializable;

import com.duan.meterial.Meterial;

public abstract class Head implements Serializable {

	private static final long serialVersionUID = -4749463978528442292L;
	private double longID;
	private double shortID;
	private double strLength;
	private double formingThick;
	private Meterial meterial;

	public double getLongID() {
		return longID;
	}

	public abstract double[][] getHeightsAndVolumesByLevelHeigt(double levelHeigt, boolean isHorizontal);

	public abstract double getVolumesByHeigt(double height, boolean isHorizontal);

	public void setLongID(double longID) {
		this.longID = longID;
	}

	public double getShortID() {
		return shortID;
	}

	public void setShortID(double shortID) {
		this.shortID = shortID;
	}

	public double getStrLength() {
		return strLength;
	}

	public void setStrLength(double strLength) {
		this.strLength = strLength;
	}

	public double getFormingThick() {
		return formingThick;
	}

	public void setFormingThick(double formingThick) {
		this.formingThick = formingThick;
	}

	public Meterial getMeterial() {
		return meterial;
	}

	public void setMeterial(Meterial meterial) {
		this.meterial = meterial;
	}

	public abstract double getInletVolume();

	public abstract double getInletHeight();

	public abstract double getOutletHeight();

	public abstract double getWeight();

}
