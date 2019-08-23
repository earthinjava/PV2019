package com.duan.module.heatexchanger.beu.bean.structural;

import java.io.Serializable;

import com.duan.meterial.Meterial;
import com.duan.utils.ArrayUtils;
import com.duan.utils.Constant;

public class TubeBoxDivisionPlate implements Serializable{
	
	private static final long serialVersionUID = 2262402619212633534L;
	//形式 0三边固定 1长边固定 2短边固定
	private int type;
	private double sizeA;
	private double sizeB;
	private double pressDifference;
	private Meterial meterial;
	private double c1;
	private double c2 = 0.3;
	private double id;
	private double calthick;
	private double bigB;
	private double nThick;
	private double minReThick;
	private boolean isSafety;
	private double allowStress;

	public TubeBoxDivisionPlate(int type, double id, double nThick, double sizeA, double sizeB, Meterial m,
			double pressDifference, double c1, double c2, double stress) {
		// TODO Auto-generated constructor stub
		this.type = type;
		this.id = id;
		this.nThick = nThick;
		this.sizeA = sizeA;
		this.sizeB = sizeB;
		this.meterial = m;
		this.pressDifference = pressDifference;
		this.c1 = c1;
		this.c2 = c2;
		this.allowStress = stress;
	}

	public void calThick() {
		bigB = getB();
		calthick = sizeB * Math.sqrt(pressDifference * bigB / 1.5 / allowStress);
		setMinReThick();
	}

	private void setMinReThick() {
		switch (meterial.getMeterialStandard().getProperty().getMeterialComponent()) {
		case Constant.METERIALCOMPONONT_CARBONSTEEL:
			if (id <= 600) {
				minReThick = 10 - 2 - c2;
			} else if (id <= 1200) {
				minReThick = 12 - 2 - c2;
			} else if (id <= 1800) {
				minReThick = 14 - 2 - c2;
			} else if (id <= 2600) {
				minReThick = 16 - 2 - c2;
			} else if (id <= 3200) {
				minReThick = 18 - 2 - c2;
			} else if (id <= 4000) {
				minReThick = 20 - 2 - c2;
			}
			break;
		case Constant.METERIALCOMPONONT_STAINLESSSTEEL:
			if (id <= 600) {
				minReThick = 6 - 2 - c2;
			} else if (id <= 1200) {
				minReThick = 10 - 2 - c2;
			} else if (id <= 1800) {
				minReThick = 11 - 2 - c2;
			} else if (id <= 2600) {
				minReThick = 12 - 2 - c2;
			} else if (id <= 3200) {
				minReThick = 14 - 2 - c2;
			} else if (id <= 4000) {
				minReThick = 16 - 2 - c2;
			}
			break;
		default:
			if (id <= 600) {
				minReThick = 6 - 2 - c2;
			} else if (id <= 1200) {
				minReThick = 10 - 2 - c2;
			} else if (id <= 1800) {
				minReThick = 11 - 2 - c2;
			} else if (id <= 2600) {
				minReThick = 12 - 2 - c2;
			} else if (id <= 3200) {
				minReThick = 14 - 2 - c2;
			} else if (id <= 4000) {
				minReThick = 16 - 2 - c2;
			}
			break;
		}		
		minReThick = (minReThick > calthick ? minReThick : calthick) + 2 * c1 + c2;
	}

	public boolean isSafety() {
		// TODO Auto-generated method stub
		calThick();
		if (minReThick <= nThick) {
			isSafety = true;
		} else {
			isSafety = false;
		}
		return isSafety;
	}

	public double getB() {
		double x = sizeA / sizeB;
		double y;
		if (type == 0) {
			y = ArrayUtils.getMidByTwoArrays(Constant.BEUTYPE1_X, Constant.BEUTYPE1_Y, x);
		} else if (type == 1) {
			if (x > 2.0) {
				return 0.5;
			}
			y = ArrayUtils.getMidByTwoArrays(Constant.BEUTYPE2_X, Constant.BEUTYPE2_Y, x);
		} else {
			if (x > 2.0) {
				return 0.75;
			}
			y = ArrayUtils.getMidByTwoArrays(Constant.BEUTYPE3_X, Constant.BEUTYPE3_Y, x);
		}
		if (y == Constant.ERROR_DOUBLE) {
			return 0;
		}
		return y;
	}

	public double getLowerLimitX() {
		if (type == 0) {
			return 0.25;
		} else {
			return 1.0;
		}
	}

	public double getUpperLimitX() {
		if (type == 0) {
			return 3.0;
		}
		return 2.0;
	}

	public double getCalthick() {
		calThick();
		return calthick;
	}

	public double getMinReThick() {
		calThick();
		return minReThick;
	}

}
