package com.duan.module.opening.bean;

import java.io.Serializable;

import com.duan.meterial.Meterial;

public class ReinforcementPlate implements Serializable{

	private static final long serialVersionUID = 1L;
	private double outDia;
	private double intDia;
	private double thickness;
	private Meterial meterial;
	private double c2;
	private double usefullThick;	

	public ReinforcementPlate(double oDia, double iDia, double c2, double t, Meterial m) {
		// TODO Auto-generated constructor stub
		this.outDia = oDia;
		this.intDia = iDia;
		this.thickness = t;
		this.meterial = m;
		this.c2 = c2;
		usefullThick = (thickness - c2);
	}

	public double getOutDia() {
		return outDia;
	}

	public double getIntDia() {
		return intDia;
	}

	public double getThickness() {
		return thickness;
	}

	public Meterial getMeterial() {
		return meterial;
	}

	public double getC1() {
		return c2;
	}

	public double getUsefullThick() {
		return usefullThick;
	}

	public static double getStandardPlateOD(String rein) {
		if (rein.equals("DN600")) {
			return 980;
		}
		if (rein.equals("DN500")) {
			return 840;
		}
		if (rein.equals("DN450")) {
			return 760;
		}
		if (rein.equals("DN400")) {
			return 680;
		}
		if (rein.equals("DN350")) {
			return 620;
		}
		if (rein.equals("DN300")) {
			return 550;
		}
		if (rein.equals("DN250")) {
			return 480;
		}
		if (rein.equals("DN225")) {
			return 440;
		}
		if (rein.equals("DN200")) {
			return 400;
		}
		if (rein.equals("DN175")) {
			return 350;
		}
		if (rein.equals("DN150")) {
			return 300;
		}
		if (rein.equals("DN125")) {
			return 250;
		}
		if (rein.equals("DN100")) {
			return 200;
		}
		if (rein.equals("DN80")) {
			return 180;
		}
		if (rein.equals("DN65")) {
			return 160;
		}
		if (rein.equals("DN50")) {
			return 130;
		}
		return 0;

	}

}
