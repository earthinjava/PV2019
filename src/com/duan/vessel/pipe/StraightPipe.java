package com.duan.vessel.pipe;

import com.duan.meterial.Meterial;
import com.duan.vessel.designCondition.DesignCondition;

public class StraightPipe implements Pipe {
	private static final long serialVersionUID = -8660610281299399595L;
	private double interDia;
	private Meterial meterial;
	private double allowStress;
	private double eff;
	private double c1;
	private double c2;
	private double calculateThickness;
	private double minThickness;
	private double nThickness;
	private double outDia;
	private DesignCondition designCondition;
	private boolean safety;
	private double maxAllowWokrPressure;
	private double usefullThickness;

	public StraightPipe(double id, double nThickness, Meterial m, double allowStress, double e, double c1,
			DesignCondition designCondition) {
		this.interDia = id;
		this.nThickness = nThickness;
		this.meterial = m;
		this.allowStress = allowStress;
		this.eff = e;
		this.c1 = c1;
		this.c2 = nThickness * 0.1;
		this.designCondition = designCondition;
		calculateByID();
	}

	private void calculateByID() {
		double p = designCondition.getDesignPress();
		if (p >= 0) {
			calculateThickness = p * interDia / (2.0 * getAllowStress() * eff - p);			
			minThickness = calculateThickness + c1 + c2;
			outDia = interDia + 2.0 * nThickness;
			usefullThickness = nThickness - c1 - c2;
			if (minThickness <= nThickness) {
				safety = true;
			} else {
				safety = false;
			}
			maxAllowWokrPressure = (2.0 * usefullThickness * getAllowStress() * eff / (interDia + usefullThickness));			
		} 
	}

	public double getCalculateThickness() {
		return calculateThickness;
	}

	public double getMinThickness() {
		return minThickness;
	}

	@Override
	public void setNThick(double nthick) {
		// TODO Auto-generated method stub
		this.nThickness = nthick;
		calculateByID();
	}

	@Override
	public double getNThick() {
		// TODO Auto-generated method stub
		return nThickness;
	}

	public double getOutDia() {
		return outDia;
	}

	public double getInterDia() {
		return interDia;
	}

	public Meterial getMeterial() {
		return meterial;
	}

	public void setAllowStress(double preAllowStress) {
		this.allowStress = preAllowStress;
		calculateByID();
	}

	public double getAllowStress() {
		return allowStress;
	}

	public double getEff() {
		return eff;
	}

	public double getC1() {
		return c1;
	}

	public double getC2() {
		return c2;
	}

	public DesignCondition getDesignCondition() {
		return designCondition;
	}

	public void setDesignCondition(DesignCondition designCondition) {
		this.designCondition = designCondition;
		calculateByID();
	}

	public void setInterDia(double interDia) {
		this.interDia = interDia;
		calculateByID();
	}

	public boolean isSafety() {
		return safety;
	}

	public double getMaxAllowWokrPressure() {
		return maxAllowWokrPressure;
	}

	public double getUsefullThickness() {
		return usefullThickness;
	}

}
