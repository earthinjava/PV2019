package com.duan.module.opening.bean;

import java.io.Serializable;

import com.duan.vessel.pipe.Pipe;
import com.duan.vessel.shell.Shell;

public class A1 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double b;
	private double dop;
	private double shellUsefullThick;
	private double shellCalTick;
	private double pipeUsefullThick;
	private double fr;
	private double value;

	public A1(Openging openging) {
		// TODO Auto-generated constructor stub
		Shell shell=openging.getShell();
		Pipe pipe=openging.getPipe();
		dop = pipe.getInterDia() + 2 * pipe.getC2() + 2 * pipe.getC1();
		double snt = shell.getNThick();
		double pnt = pipe.getNThick();
		b = 2 * dop > dop + 2 * (snt + pnt) ? 2 * dop : dop + 2 * (snt + pnt);
		shellUsefullThick = shell.getUsefullThickness();
		shellCalTick = shell.getCalculateThickness();
		pipeUsefullThick = pipe.getUsefullThickness();
		fr = pipe.getAllowStress() / shell.getAllowStress();
		value = (b - dop) * (shellUsefullThick - shellCalTick)
				- 2 * pipeUsefullThick * (shellUsefullThick - shellCalTick) * (1 - fr);		
	}

	public double getValue() {
		return value;
	}
	
}
