package com.duan.module.heatexchanger.beu.bean.structural;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import com.duan.meterial.Meterial;
import com.duan.module.heatexchanger.beu.bean.designCondition.HeatDesignCondition;
import com.duan.utils.ArrayUtils;
import com.duan.utils.Constant;
import com.duan.utils.GraphicsUtils;
import com.duan.vessel.designCondition.DesignCondition;

public class TubePlate implements Serializable{
	
	private static final long serialVersionUID = -3927228782583227582L;
	// 分程处面积Ad
	private double areaDivide;
	// 布管区面积At
	private double areaTube;
	// 布管区当量直径Dt
	private double diaTubes;
	// ρt
	private double RhoTubes;
	// 计算半径R
	private double calR;
	// Cc系数
	private double Cc;
	// 布管形式 { "正方形", "转角正方形", "正三角形" ,"转角正三角形"};
	private String tubesType;
	// 沿管程一侧管根数n'
	private int OtherN;
	// 管束
	private TubeBundle tubeBundle;
	// 布管总数
	private int usedTubesNum;
	// 计算厚度
	private double calThick;
	// 强度削弱系数
	private double u = 0.4;
	// 许用应力
	private double allowStress;
	// 管板材料
	private Meterial meterial;
	// 换热管与管板连接形式 "强度胀接","强度焊接","强度胀加密封焊","强度焊加贴胀","内孔焊"
	private String conType;
	// 强度胀长度
	private double strExpLth;
	// 强度焊焊脚高度
	private double strWeldLth;
	// 管程腐蚀余量
	private double tubeC1;
	// 壳程腐蚀余量
	private double shellC1;
	// 管侧开槽深度
	private double tubeSoltDth;
	// 壳侧开槽深度
	private double shellSoltDth;
	// 最小厚度
	private double minThick;
	// 仅壳侧作用时轴向力
	private double axisalForceShellStress;
	// 仅管侧作用时轴向力
	private double axisalForceTubeStress;
	// 管程与壳程同时作用时轴向力
	private double axisalForceALLStress;
	// 最大轴向力
	private double maxAxisalStress;
	// 许用轴向力
	private double allowAxialStress;
	// 拉托力
	private double pullOutStress;
	// 许用拉托力
	private double allowPallOutForce;
	// 名义厚度
	private double nThick;
	// 管板外径
	private double od;
	// 管板台外径
	private double d2;
	// 画图比例
	private double drawRatio;
	// 壳侧设计条件
	private DesignCondition shellDesignCondition;
	// 管侧设计条件
	private DesignCondition tubeDesignCondition;
	// 计算压力Pd
	private double calPress;
	private TubePlateGasket tubePlateGasket;

	public TubePlate(HeatDesignCondition shellDesignCondition, HeatDesignCondition tubeDesignCondition,
			TubeBundle tubeBundle, TubePlateGasket tubePlateGasket) {
		// TODO Auto-generated constructor stub
		this.tubeBundle = tubeBundle;
		tubesType = tubeBundle.getTubeArrayType();
		usedTubesNum = tubeBundle.getUsedTubesNum();
		this.tubePlateGasket = tubePlateGasket;
		this.tubeBundle = tubeBundle;
		this.shellDesignCondition = shellDesignCondition;
		this.tubeDesignCondition = tubeDesignCondition;
		d2 = tubeBundle.getTubeLimitCircle().getShellId() - 2;
		OtherN = tubeBundle.getOtherN();
		calPress = shellDesignCondition.getDesignPress() >= tubeDesignCondition.getDesignPress()
				? shellDesignCondition.getDesignPress()
				: tubeDesignCondition.getDesignPress();
		nThick = tubeBundle.getPreTubePlateThick();
	}

	/**
	 * 画出管板
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		drawRatio = getDrawRatio();
		// 画出外径
		Color color = g.getColor();
		GraphicsUtils.drawCircle(0, 0, od / 2, drawRatio, g);
		// 画出凸台
		GraphicsUtils.drawCircle(0, 0, d2 / 2, drawRatio, g);
		// 画出中心线
		g.setColor(Color.red);
		g.drawLine(Constant.BEUTUBEARRAY_WIDETH / 2, 0, Constant.BEUTUBEARRAY_WIDETH / 2, Constant.BEUTUBEARRAY_HEIGHT);
		g.drawLine(0, Constant.BEUTUBEARRAY_HEIGHT / 2, Constant.BEUTUBEARRAY_WIDETH, Constant.BEUTUBEARRAY_HEIGHT / 2);
		g.setColor(color);
		tubeBundle.draw(g, drawRatio);
	}

	/**
	 * 获得管程处分程面积Ad
	 * 
	 * @return
	 */
	public double getAreaDivide() {
		double tubeDis = tubeBundle.getTubeDis();
		if (tubesType.equals(Constant.TUBEARRAY_TYPE[1])) {
			areaDivide = OtherN * (Math.sqrt(2) * tubeBundle.getDivideDis() * tubeDis - tubeDis * tubeDis);
		} else if (tubesType.equals(Constant.TUBEARRAY_TYPE[2])) {
			areaDivide = OtherN * (tubeBundle.getDivideDis() * tubeDis - Math.sqrt(3) / 2 * tubeDis * tubeDis);
		} else if (tubesType.equals(Constant.TUBEARRAY_TYPE[3])) {
			areaDivide = OtherN
					* (Math.sqrt(3) * tubeBundle.getDivideDis() * tubeDis - Math.sqrt(3) / 2 * tubeDis * tubeDis);
		} else {
			areaDivide = OtherN * (tubeBundle.getDivideDis() * tubeDis - tubeDis * tubeDis);
		}
		return areaDivide;
	}

	/**
	 * 获得管程处分程面积At
	 * 
	 * @return
	 */
	public double getAreaTube() {
		getAreaDivide();
		double tubeDis = tubeBundle.getTubeDis();
		if (tubesType.equals(Constant.TUBEARRAY_TYPE[0]) || tubesType.equals(Constant.TUBEARRAY_TYPE[1])) {
			areaTube = 2 * usedTubesNum * tubeDis * tubeDis + areaDivide;
		} else {
			areaTube = 1.732 * usedTubesNum * tubeDis * tubeDis + areaDivide;
		}
		return areaTube;
	}

	/**
	 * 获得管板当量直径Dt
	 * 
	 * @return
	 */
	public double getDiaTubes() {
		getAreaTube();
		diaTubes = Math.sqrt(4 * areaTube / Math.PI);
		return diaTubes;
	}

	/**
	 * 管板计算半径R
	 * 
	 * @return
	 */
	public double getCalR() {
		double dg = tubePlateGasket.getFd();
		calR = dg / 2;
		return calR;
	}

	/**
	 * ρt
	 * 
	 * @return
	 */
	public double getRhoTubes() {
		getDiaTubes();
		getCalR();
		RhoTubes = diaTubes / 2 / calR;
		return RhoTubes;
	}

	/**
	 * 系数Cc
	 * 
	 * @return
	 */
	public double getCc() {
		getRhoTubes();
		double[] x = { 0.5, 0.55, 0.6, 0.65, 0.7, 0.75, 0.8, 0.85, 0.9, 0.95, 1.0 };
		double[] y = { 0.2306, 0.2363, 0.2426, 0.2494, 0.2566, 0.2644, 0.2726, 0.2812, 0.2903, 0.2997, 0.3094 };
		if (Cc != Constant.ERROR_DOUBLE) {
			return Cc = ArrayUtils.getMidByTwoArrays(x, y, RhoTubes);
		} else {
			return Cc = Constant.ERROR_DOUBLE;
		}
	}

	/**
	 * 计算管板厚度
	 */
	public double getCalThick() {
		if (allowStress > 0) {
			double Cc = getCc();
			double Pd = calPress;
			double Dg = tubePlateGasket.getFd();
			return calThick = (0.82 * Dg * Math.sqrt(Cc * Pd / u / allowStress));
		}
		return calThick = Constant.ERROR_DOUBLE;
	}

	/**
	 * 获得最小厚度
	 */
	public double getMinThick() {
		getCalThick();
		double cs;
		double ct;
		if (shellSoltDth >= shellC1) {
			cs = shellSoltDth;
		} else {
			cs = shellC1;
		}
		ct = tubeC1 > tubeSoltDth ? tubeC1 : tubeSoltDth;
		if (calThick != Constant.ERROR_DOUBLE) {
			return minThick = calThick + cs + ct;
		}
		return minThick = Constant.ERROR_DOUBLE;
	}

	/**
	 * 获得壳程作用时的轴向力
	 * 
	 * @return
	 */
	public double getAxisalForceShellStress() {
		UHeatTube ht = tubeBundle.getHeatTubeLines().get(0).getHeatTubes().get(0);
		double a = Math.PI * ht.getNThick() * (ht.getOutDia() - ht.getNThick());
		double d = ht.getOutDia();
		double ps = shellDesignCondition.getDesignPress();
		axisalForceShellStress = ps * d * d * Math.PI / 4 / a;
		return axisalForceShellStress;
	}

	/**
	 * 获得管程作用时的轴向力
	 * 
	 * @return
	 */
	public double getAxisalForceTubeStress() {
		UHeatTube ht = tubeBundle.getHeatTubeLines().get(0).getHeatTubes().get(0);
		double a = Math.PI * ht.getNThick() * (ht.getOutDia() - ht.getNThick());
		double d = ht.getOutDia();
		double pt = tubeDesignCondition.getDesignPress();
		axisalForceTubeStress = pt * d * d * Math.PI / 4 / a - pt;
		return axisalForceTubeStress;
	}

	public double getAxisalForceALLStress() {
		UHeatTube ht = tubeBundle.getHeatTubeLines().get(0).getHeatTubes().get(0);
		double a = Math.PI * ht.getNThick() * (ht.getOutDia() - ht.getNThick());
		double d = ht.getOutDia();
		double pt = tubeDesignCondition.getDesignPress();
		double ps = shellDesignCondition.getDesignPress();
		return axisalForceALLStress = Math.abs(-(ps - pt) * d * d * Math.PI / 4 / a - pt);
	}

	/**
	 * 获得最大轴向力
	 * 
	 * @return
	 */
	public double getMaxAxisalStress() {
		getAxisalForceShellStress();
		getAxisalForceTubeStress();
		getAxisalForceALLStress();
		if (axisalForceShellStress > axisalForceTubeStress) {
			if (axisalForceShellStress > axisalForceALLStress) {
				maxAxisalStress = axisalForceShellStress;
			} else {
				maxAxisalStress = axisalForceALLStress;
			}
		} else {
			if (axisalForceTubeStress > axisalForceALLStress) {
				maxAxisalStress = axisalForceTubeStress;
			} else {
				maxAxisalStress = axisalForceALLStress;
			}
		}
		return maxAxisalStress;
	}

	/**
	 * 获得许用轴向力，即换热管的许用应力
	 * 
	 * @return
	 */
	public double getAllowAxialStress() {
		UHeatTube ht = tubeBundle.getHeatTubeLines().get(0).getHeatTubes().get(0);
		double tubeAllowStess = ht.getAllowStress();
		// 内孔焊
		if (conType.equals(Constant.TUBECONTACTPALTE_TYPE[4])) {
			return allowAxialStress = allowStress < tubeAllowStess ? allowStress : tubeAllowStess;
		}
		// 不是内孔焊
		return allowAxialStress = tubeAllowStess;
	}

	/**
	 * 计算最大拉托力
	 */
	public double getPullOutStress() {
		UHeatTube ht = tubeBundle.getHeatTubeLines().get(0).getHeatTubes().get(0);
		double a = Math.PI * ht.getNThick() * (ht.getOutDia() - ht.getNThick());
		double at = getMaxAxisalStress();
		double d = ht.getOutDia();
		double l = 0;
		if (conType.equals(Constant.TUBECONTACTPALTE_TYPE[0]) || conType.equals(Constant.TUBECONTACTPALTE_TYPE[2])) {
			l = strExpLth;
		} else if (conType.equals(Constant.TUBECONTACTPALTE_TYPE[1])
				|| conType.equals(Constant.TUBECONTACTPALTE_TYPE[3])) {
			l = strWeldLth;
		} else {
			// 内孔焊，返回0，不计算拉脱力
			return pullOutStress = 0;
		}
		if (l > 0 && l != Constant.ERROR_DOUBLE && at != Constant.ERROR_DOUBLE && d > 0 && d != Constant.ERROR_DOUBLE) {
			return pullOutStress = at * a / Math.PI / d / l;
		}
		return pullOutStress = Constant.ERROR_DOUBLE;
	}

	/**
	 * 获得许用拉托力
	 */
	public double getAllowPullOutForce() {
		UHeatTube ht = tubeBundle.getHeatTubeLines().get(0).getHeatTubes().get(0);
		// 1.判断是否是胀接
		if (conType.equals(Constant.TUBECONTACTPALTE_TYPE[0]) || conType.equals(Constant.TUBECONTACTPALTE_TYPE[2])) {
			// 是胀接
			if (ht.getMeterial().isSteel()) {// 钢管
				allowPallOutForce = 4;
			} else {// 有色金属
				allowPallOutForce = 3;
			}
		} else {// 是焊接
			allowPallOutForce = ht.getAllowStress() > allowStress ? 0.5 * allowStress : 0.5 * ht.getAllowStress();
		}
		return allowPallOutForce;
	}

	/**
	 * 判断拉托力是否安全
	 * 
	 * @return
	 */
	public boolean isSafePullOutForce() {
		getPullOutStress();
		getAllowPullOutForce();
		if (pullOutStress <= allowPallOutForce) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断轴向力是否安全
	 * 
	 * @return
	 */
	public boolean isSafeAxialStress() {
		getMaxAxisalStress();
		getAllowAxialStress();
		if (maxAxisalStress <= allowAxialStress) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 设置管板属性
	 * 
	 * @param conType      换热管与管板连接方式
	 * @param strExpLth    强度胀长度
	 * @param strWeldLth   强度焊焊脚高度
	 * @param tubeC1       管程腐蚀裕量
	 * @param shellC1      壳程腐蚀裕量
	 * @param tubeSoltDth  管侧开槽升读
	 * @param shellSoltDth 壳侧开槽深度
	 */
	public void setAll(String conType, double strExpLth, double strWeldLth, double tubeC1, double shellC1,
			double tubeSoltDth, double shellSoltDth) {
		this.conType = conType;
		this.strExpLth = strExpLth;
		this.strWeldLth = strWeldLth;
		this.tubeC1 = tubeC1;
		this.shellC1 = shellC1;
		this.tubeSoltDth = tubeSoltDth;
		this.shellSoltDth = shellSoltDth;
	}

	public double getnThick() {
		return nThick;
	}

	public int getOtherN() {
		return OtherN;
	}

	public TubeBundle getTubeBundle() {
		return tubeBundle;
	}

	public int getUsedTubesNum() {
		return usedTubesNum;
	}

	public double getU() {
		return u;
	}

	public String getConType() {
		return conType;
	}

	public double getStrExpLth() {
		return strExpLth;
	}

	public double getStrWeldLth() {
		return strWeldLth;
	}

	public double getTubeC1() {
		return tubeC1;
	}

	public double getShellC1() {
		return shellC1;
	}

	public double getTubeSoltDth() {
		return tubeSoltDth;
	}

	public double getShellSoltDth() {
		return shellSoltDth;
	}

	public double getD2() {
		return d2;
	}

	public DesignCondition getShellDesignCondition() {
		return shellDesignCondition;
	}

	public DesignCondition getTubeDesignCondition() {
		return tubeDesignCondition;
	}

	public double getAllowStress() {
		return allowStress;
	}

	public double getOd() {
		return od;
	}

	public void setOd(double od) {
		this.od = od;
	}

	public double getCalPress() {
		return calPress;
	}

	public void setCalPress(double calPress) {
		this.calPress = calPress;
	}

	public String getTubesType() {
		return tubesType;
	}

	public double getDrawRatio() {
		drawRatio = Constant.BEUTUBEARRAY_WIDETH / (od + 10.0);
		return drawRatio;
	}

	public boolean isSafeThick() {
		if (minThick <= nThick) {
			return true;
		} else {
			return false;
		}
	}

	public void setAllowStress(double allowStress) {
		this.allowStress = allowStress;
	}

	public void setMeterial(Meterial meterial) {
		this.meterial = meterial;
	}

	public Meterial getMeterial() {
		return meterial;
	}
}
