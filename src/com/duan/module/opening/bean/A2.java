package com.duan.module.opening.bean;

import java.io.Serializable;

import com.duan.vessel.pipe.Pipe;
import com.duan.vessel.shell.Shell;

public class A2 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double h1;
	private double h2;
	private double pipeUsefullThick;
	private double pipeCalThick;
	private double pipeC1;
	private double fr;
	private double value;
	private double outLegth;
	private double intLegth;

	public A2(Shell shell, Pipe pipe, double outLegth, double intLegth) {
		// TODO Auto-generated constructor stub
		double ha = Math.sqrt(pipe.getNThick() * (pipe.getInterDia() + 2 * pipe.getC2() + 2 * pipe.getC1()));
		this.outLegth = outLegth;
		this.intLegth = intLegth;
		this.h1 = outLegth <= ha ? outLegth : ha;
		this.h2 = intLegth <= ha ? intLegth : ha;
		pipeUsefullThick = pipe.getUsefullThickness();
		pipeCalThick = pipe.getCalculateThickness();
		pipeC1 = pipe.getC1();
		fr = pipe.getAllowStress() / shell.getAllowStress();
		value = 2 * this.h1 * (pipeUsefullThick - pipeCalThick) * fr + 2 * this.h2 * (pipeUsefullThick - pipeC1) * fr;
	}

	public double getValue() {
		return value;
	}

	public double getH1() {
		return h1;
	}

	public double getH2() {
		return h2;
	}

	public double getOutLegth() {
		return outLegth;
	}

	public double getIntLegth() {
		return intLegth;
	}
}
