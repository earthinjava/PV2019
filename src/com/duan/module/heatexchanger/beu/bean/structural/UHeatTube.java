package com.duan.module.heatexchanger.beu.bean.structural;

import java.awt.Graphics;
import java.io.Serializable;

import com.duan.meterial.Meterial;
import com.duan.utils.Constant;
import com.duan.utils.DoubleUtils;
import com.duan.utils.GraphicsUtils;
import com.duan.vessel.designCondition.DesignCondition;

public class UHeatTube implements Serializable{
	
	private static final long serialVersionUID = 8348440043411127507L;
	// 内径
	private double interDia;
	// 直管长度
	private double strLength;
	// 弯曲半径
	private double bendR;
	// 管等级
	private String tubeClass;
	// 外径偏差
	private double odOffset;
	// 弯曲前厚度
	private double beforeBendThick;
	// 材料
	private Meterial meterial;
	// 许用应力
	private double allowStress;
	// 厚度负偏差
	private double c2;
	// 计算厚度
	private double calculateThickness;
	// 最小厚度
	private double minThickness;
	// 名义厚度
	private double nThickness;
	// 外径
	private double outDia;
	// 设计条件
	private DesignCondition designCondition;
	// 是否安全
	private boolean safety;
	// 有效厚度
	private double usefullThickness;
	// 在管板上的位置坐标x
	private double x;
	// 在管板上的位置坐标y
	private double y;
	// 是否被应用，false表示布管没有用到
	private boolean isUsed;
	// 总长度
	private double length;
	// 重量
	private double weight;
	// 换热面积，包括U型段
	private double heatAreaU;
	// 换热面积，不含U型段
	private double heatArea;

	public UHeatTube(double od, double nThickess, double stress, Meterial m, String tubeClass,
			DesignCondition designCondition) {
		outDia = od;
		meterial = m;
		this.setStrLength(strLength);
		this.allowStress = stress;
		this.nThickness = nThickess;
		interDia = od - 2 * nThickess;
		this.designCondition = designCondition;
		this.setTubeClass(tubeClass);
		calculateByID();
		setOdOffset();
	}

	public UHeatTube(double x, double y, double od, double strLth) {
		this.x = x;
		this.y = y;
		this.outDia = od;
		this.bendR = Math.abs(y);
		isUsed = true;
		this.strLength = strLth;
		length = (2.0 * strLth + Math.PI * bendR);
		heatAreaU = Math.PI * od * (2.0 * strLth + Math.PI * bendR);
		heatArea = Math.PI * od * 2.0 * strLth;
	}

	public void setOdOffset() {
		switch (meterial.getMeterialStandard().getProperty().getMeterialComponent()) {
		case Constant.METERIALCOMPONONT_CARBONSTEEL:
			if (tubeClass.equals("II")) {
				if (outDia <= 25) {
					odOffset = 0.10;
				} else if (outDia <= 38) {
					odOffset = 0.15;
				} else if (outDia <= 50) {
					odOffset = 0.20;
				} else {
					odOffset = 0.25;
				}
			} else {
				if (outDia <= 25) {
					odOffset = 0.15;
				} else if (outDia <= 38) {
					odOffset = 0.20;
				} else if (outDia <= 50) {
					odOffset = 0.25;
				} else {
					odOffset = 0.40;
				}
			}
			break;
		case Constant.METERIALCOMPONONT_STAINLESSSTEEL:
			if (tubeClass.equals("II")) {
				if (outDia <= 25) {
					odOffset = 0.10;
				} else if (outDia <= 38) {
					odOffset = 0.15;
				} else if (outDia <= 50) {
					odOffset = 0.20;
				} else {
					odOffset = 0.25;
				}
			} else {
				if (outDia <= 25) {
					odOffset = 0.15;
				} else if (outDia <= 38) {
					odOffset = 0.20;
				} else if (outDia <= 50) {
					odOffset = 0.25;
				} else {
					odOffset = 0.40;
				}
			}
			break;
		case Constant.METERIALCOMPONONT_COPPER:
			if (outDia <= 15) {
				odOffset = 0.05;
			} else if (outDia <= 25) {
				odOffset = 0.06;
			}
			break;
		case Constant.METERIALCOMPONONT_TI:
			if (outDia <= 15) {
				odOffset = 0.1;
			} else if (outDia <= 25) {
				odOffset = 0.13;
			}
			break;
		default:
			break;
		}

	}

	private void calculateByID() {
		bendR = getBendR(outDia);
		double p = designCondition.getDesignPress();
		calculateThickness = p * interDia / (2.0 * getAllowStress() - p);
		beforeBendThick = calculateThickness * (1.0 + outDia / 4.0 / bendR);

		if (beforeBendThick < calculateThickness + c2) {
			minThickness = calculateThickness + c2;
		} else {
			minThickness = calculateThickness + c2;
		}

		usefullThickness = nThickness - c2;
		if (minThickness <= nThickness && beforeBendThick <= nThickness - c2) {
			safety = true;
		} else {
			safety = false;
		}
	}

	public double getBendR(double od) {
		if (od == 10) {
			return 20;
		} else if (od == 12) {
			return 24;
		} else if (od == 14) {
			return 30;
		} else if (od == 16) {
			return 32;
		} else if (od == 19) {
			return 40;
		} else if (od == 20) {
			return 40;
		} else if (od == 22) {
			return 45;
		} else if (od == 25) {
			return 50;
		} else if (od == 30) {
			return 60;
		} else if (od == 32) {
			return 65;
		} else if (od == 35) {
			return 70;
		} else if (od == 38) {
			return 76;
		} else if (od == 45) {
			return 90;
		} else if (od == 50) {
			return 100;
		} else if (od == 55) {
			return 110;
		} else if (od == 57) {
			return 115;
		} else {
			return od * 2;
		}
	}

	public void draw(Graphics g, double ratio) {
		if (isUsed) {
			GraphicsUtils.drawCircle(x, y, outDia / 2.0, ratio, g);
		}
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public double getWeight() {
		double density = meterial.getDensity();
		double area = Math.PI * (outDia * outDia - interDia * interDia) / 4.0;
		double volume = area * length;
		weight = volume * density / 1000000.0;
		return weight;
	}

	public double getLength() {
		return DoubleUtils.doubleSavePointTwo(length);
	}

	public double getHeatAreaU() {
		return heatAreaU;
	}

	public double getHeatArea() {
		return heatArea;
	}

	public double getCalculateThickness() {
		return calculateThickness;
	}

	public double getMinThickness() {
		calculateByID();
		return minThickness;
	}

	public void setNThick(double nthick) {
		this.nThickness = nthick;
		interDia = outDia - 2.0 * nthick;
	}

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

	public void setAllowStress(double allowStress) {
		this.allowStress = allowStress;
	}

	public double getAllowStress() {
		return allowStress;
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

	public boolean isSafety() {
		return safety;
	}

	public double getUsefullThickness() {
		return usefullThickness;
	}

	public String getTubeClass() {
		return tubeClass;
	}

	public void setTubeClass(String tubeClass) {
		this.tubeClass = tubeClass;
	}

	public double getOdOffset() {
		return odOffset;
	}

	public double getBeforeBendThick() {
		return beforeBendThick;
	}

	public double getBendR() {
		return bendR;
	}

	public double getStrLength() {
		return strLength;
	}

	public void setStrLength(double strLength) {
		this.strLength = strLength;
	}

	public void setMeterial(Meterial meterial) {
		this.meterial = meterial;
	}

	public double getArea() {
		return Math.PI * (outDia * outDia - interDia * interDia) / 4.0;
	}

}
