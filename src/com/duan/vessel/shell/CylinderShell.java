package com.duan.vessel.shell;

import com.duan.meterial.Meterial;
import com.duan.utils.Constant;
import com.duan.utils.DoubleUtils;
import com.duan.vessel.designCondition.DesignCondition;

public class CylinderShell implements Shell {	
	private static final long serialVersionUID = 88759894131924964L;
	// 内径
	private double interDia;
	// 材料
	private Meterial meterial;
	// 许用应力
	private double allowStress;
	// 接头系数
	private double eff;
	// 腐蚀裕量
	private double c1;
	// 负偏差
	private double c2;
	// 计算厚度
	private double calculateThickness;
	// 最小成型厚度
	private double minThickness;
	// 名义厚度
	private double nThickness;
	// 外径
	private double outDia;
	// 设计条件
	private DesignCondition designCondition;
	// 结果
	private boolean safety;
	// 最大允许工作压力
	private double maxAllowWokrPressure;
	// 有效厚度
	private double usefullThickness;
	// 长度
	private double length;
	// 总容积 m³
	private double totalVolume;
	// 立式还是卧式
	private boolean isHorizontal;
	// 重量
	private double weight;

	// 用于计算厚度
	public CylinderShell(double id, double nThickess, Meterial m, double pStress, double e, double c1, double c2,
			DesignCondition designCondition) {
		// TODO Auto-generated constructor stub
		interDia = id;
		meterial = m;
		allowStress = pStress;
		eff = e;
		this.nThickness = nThickess;
		this.c1 = c1;
		this.c2 = c2;
		this.designCondition = designCondition;		
	}

	// 用于容积及重量的计算
	public CylinderShell(double id, double nThickess, Meterial m, double length, boolean isHorizontal) {
		// TODO Auto-generated constructor stub
		interDia = id;
		meterial = m;
		this.nThickness = nThickess;
		this.length = length;
		this.isHorizontal = isHorizontal;
	}

	public Double[][] getHeightsAndVolumesByLevelHeigt(double levelHeigt) {
		double h = levelHeigt;
		double upHeigth = isHorizontal ? interDia : length;
		int i = 0;
		while (h < upHeigth) {
			i++;
			h += levelHeigt;
		}
		i++;
		Double[][] heightsAndVolumes = new Double[i][3];
		int j = 0;
		h = levelHeigt;
		while (j < i) {
			if (h > upHeigth) {
				h = upHeigth;
			}
			heightsAndVolumes[j][0] = h;
			double v = getVolumeByHeigt(h);
			if (v != Constant.ERROR_DOUBLE) {
				heightsAndVolumes[j][1] = DoubleUtils.doubleSavePointTwo(getVolumeByHeigt(h));
				heightsAndVolumes[j][2] = DoubleUtils.doubleSavePointTwo(getVolumeByHeigt(h) / totalVolume * 100);
				h += levelHeigt;
				j++;
			} else {
				return null;
			}
		}
		return heightsAndVolumes;
	}

	// 获得重量
	public double getWeight() {
		// 计算体积
		double r1 = interDia / 2.0;
		double r2 = r1 + nThickness;
		double s = Math.PI * (r2 * r2 - r1 * r1);
		double v = s * length;
		// 计算重量
		weight = v * meterial.getDensity() / 1000000.00;
		return weight;
	}

	// 获得总容积
	public double getTotalVolume() {
		totalVolume = Math.PI * interDia * interDia / 4.0 * length / 1000000000.0;
		return totalVolume;
	}

	/**
	 * 
	 * @param height       液位高度mm
	 * @param isHorizontal 是否为立式
	 * @return 容积m³
	 */
	public double getVolumeByHeigt(double height) {
		if (!isHorizontal) {
			// 是立式
			return Math.PI * interDia * interDia / 4.0 * height / 1000000000.0;
		} else {
			// 是卧式
			// 判断高度是否大于半径
			if (height <= interDia / 2.0) {
				// 求出弦长
				double r = interDia / 2.0;
				double h = r - height;
				double l = 2.0 * Math.sqrt(r * r - h * h);
				// 求出圆心角
				double a = 2.0 * Math.asin(l / 2.0 / r);
				// 计算扇形面积
				double s1 = r * r * a / 2.0;
				// 计算三角形面积
				double s2 = l * h / 2.0;
				return (s1 - s2) * length / 1000000000.0;
			} else if (height > interDia / 2.0 && height <= interDia) {
				// 求出弦长
				double r = interDia / 2.0;
				double h = height - r;
				double l = 2.0 * Math.sqrt(r * r - h * h);
				// 求出圆心角
				double a = 2.0 * Math.PI - 2.0 * Math.asin(l / 2.0 / r);
				// 计算扇形面积
				double s1 = r * r * a / 2.0;
				// 计算三角形面积
				double s2 = l * h / 2.0;
				return (s1 + s2) * length / 1000000000.0;
			} else {
				return Constant.ERROR_DOUBLE;
			}
		}
	}

	private void calculateByID() {
		double p = designCondition.getDesignPress();
		if (p >= 0) {
			// 正压计算
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
		} else {
			// 负压计算
		}
	}

	public double getCalculateThickness() {
		calculateByID();
		return calculateThickness;
	}

	public double getMinThickness() {
		calculateByID();
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
		calculateByID();
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
		calculateByID();
		return safety;
	}

	public double getMaxAllowWokrPressure() {
		calculateByID();
		return maxAllowWokrPressure;
	}

	public double getUsefullThickness() {
		calculateByID();
		return usefullThickness;
	}

	public boolean isHorizontal() {
		return isHorizontal;
	}

	public double getLength() {
		return length;
	}

}
