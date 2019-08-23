package com.duan.vessel.head;

public class EHB extends Head {	
	
	private static final long serialVersionUID = 8519669119037385772L;
	private double weight;
	private double inletVolume;
	private double inletHeight;
	private double outletHeight;

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		double a = (getLongID()+2*getFormingThick())/ 2.0;
		double b = (getShortID()+2*getFormingThick()) / 2.0;
		double x = (a - getFormingThick()) * (a - getFormingThick());
		double p = getMeterial().getDensity();
		double pi = Math.PI;
		double h = getStrLength();
		double s1 = 2.0 / 3.0 * a * a * b + a * a * h;
		double s2 = 2.0 / 3.0 * (x) * (b - getFormingThick()) + x * h;
		weight = p * pi * (s1 - s2) / 1000000.0;		
		return weight;
	}

	@Override
	public double getInletVolume() {
		// TODO Auto-generated method stub
		double a = (getLongID()+2*getFormingThick()) / 2.0;
		double b = (getShortID()+2*getFormingThick()) / 2.0;
		double x = (a - getFormingThick()) * (a - getFormingThick());
		double s1 = 2.0 / 3.0 * Math.PI * x * (b - getFormingThick());		
		double s2 = Math.PI * x * getStrLength();
		inletVolume = (s1 + s2) / 1000000000.0;	
		return inletVolume;
	}

	@Override
	public double getInletHeight() {
		inletHeight = getOutletHeight() - getFormingThick();
		return inletHeight;
	}

	@Override
	public double getOutletHeight() {
		// TODO Auto-generated method stub
		outletHeight = getStrLength() + (getShortID()+2*getFormingThick()) / 2.0;
		return outletHeight;
	}

	@Override
	public double[][] getHeightsAndVolumesByLevelHeigt(double levelHeigt, boolean isHorizontal) {
		return null;
	}

	@Override
	public double getVolumesByHeigt(double height, boolean isHorizontal) {
		return 0;
	}

	
	

}
