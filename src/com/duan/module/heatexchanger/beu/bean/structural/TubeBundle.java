package com.duan.module.heatexchanger.beu.bean.structural;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;

import com.duan.meterial.Meterial;
import com.duan.utils.Constant;

public class TubeBundle implements Serializable{
	
	private static final long serialVersionUID = -8785546938063609784L;
	// 管线集合
	private ArrayList<HeatTubeLine> heatTubeLines;
	// 管板预设厚度
	private double preTubePlateThick;
	// 布管限定元
	private TubeLimitCircle tubeLimitCircle;
	// 换热管外径
	private double tubeOd;
	// 换热管间距
	private double tubeDis;
	// 分程间距
	private double divideDis;
	// 直管段长度
	private double strlength;
	// 换热管总数
	private int heatTubesTotalNumber;
	// 实际布管总数
	private int usedTubesNum;
	// 重量
	private double weight;
	// 含U段，换热面积
	private double heatAreaU;
	// 不含U段，换热面积
	private double heatArea;
	// 布管方式
	private String tubeArrayType;
	// 管程
	private int tubesPass;

	public TubeBundle(TubeLimitCircle tubeLimitCircle, double tubeOd, double strlength, double tubePlateThick,
			String tubesType, double tubeDis, double divideDis, int tubesPass) {
		// TODO Auto-generated constructor stub
		this.preTubePlateThick = tubePlateThick;
		this.tubeLimitCircle = tubeLimitCircle;
		this.tubeOd = tubeOd;
		this.tubesPass = tubesPass;
		if (tubeDis == 0) {
			this.tubeDis = calTubesDis(tubeOd);
		} else {
			this.tubeDis = tubeDis;
		}
		if (divideDis == 0) {
			this.divideDis = calPassDis(tubeOd, "U");
		} else {
			this.divideDis = divideDis;
		}
		this.strlength = strlength;
		this.tubeArrayType = tubesType;
		creatTubes();
	}

	public ArrayList<HeatTubeLine> getHeatTubeLines() {
		return heatTubeLines;
	}

	public TubeLimitCircle getTubeLimitCircle() {
		return tubeLimitCircle;
	}

	private void creatTubes() {		
		heatTubeLines = new ArrayList<HeatTubeLine>();
		double r = tubeLimitCircle.getD() / 2.0 - tubeOd / 2.0;
		double angle;
		double tubeDistance;
		double dx;
		double dy;
		if (tubeArrayType.equals(Constant.TUBEARRAY_TYPE[1])) {
			angle = Math.toRadians(45);
			dx = tubeDis * (Math.sin(angle));
			dy = tubeDis * (Math.cos(angle));
			tubeDistance = dx * 2.0;
		} else if (tubeArrayType.equals(Constant.TUBEARRAY_TYPE[2])) {
			angle = Math.toRadians(30);
			dx = tubeDis * (Math.sin(angle));
			dy = tubeDis * (Math.cos(angle));
			tubeDistance = tubeDis;
		} else if (tubeArrayType.equals(Constant.TUBEARRAY_TYPE[3])) {
			angle = Math.toRadians(60);
			dx = tubeDis * (Math.sin(angle));
			dy = tubeDis * (Math.cos(angle));
			tubeDistance = dx * 2.0;
		} else {
			angle = Math.toRadians(0);
			dx = tubeDis * (Math.sin(angle));
			dy = tubeDis * (Math.cos(angle));
			tubeDistance = tubeDis;
		}
		int i = 1;
		for (double y = divideDis / 2.0; y <= r; y += dy, i++) {
			double fistTubesX;
			if (tubesPass == 2) {
				fistTubesX = 0;
			} else {
				fistTubesX = divideDis / 2.0;
			}
			double secondTubesX = fistTubesX + dx;
			double lx = Math.sqrt(r * r - y * y);
			if (fistTubesX <= lx) {
				HeatTubeLine htl = new HeatTubeLine(i, y);
				heatTubeLines.add(htl);
				for (; fistTubesX <= lx; fistTubesX += tubeDistance) { 
					UHeatTube heatTube = new UHeatTube(fistTubesX, y, tubeOd, strlength);
					htl.getHeatTubes().add(heatTube);
					heatTubesTotalNumber++;
					if (fistTubesX != 0) {
						heatTube = new UHeatTube(0 - fistTubesX, y, tubeOd, strlength);
						htl.getHeatTubes().add(heatTube);
						heatTubesTotalNumber++;
					}
				}
			}
			y += dy;
			i++;
			lx = Math.sqrt(r * r - y * y);
			if (secondTubesX <= lx) {
				HeatTubeLine htl2 = new HeatTubeLine(i, y);
				heatTubeLines.add(htl2);
				for (; secondTubesX <= lx; secondTubesX += tubeDistance) {
					UHeatTube heatTube = new UHeatTube(secondTubesX, y, tubeOd, strlength);
					htl2.getHeatTubes().add(heatTube);
					heatTubesTotalNumber++;
					// Y�᾵��
					if (secondTubesX != 0) {
						heatTube = new UHeatTube(0 - secondTubesX, y, tubeOd, strlength);
						htl2.getHeatTubes().add(heatTube);
						heatTubesTotalNumber++;
					}

				}
			}

		}
		usedTubesNum = heatTubesTotalNumber;
	}

	public void addTwoTubesAtLineNumbe(int lineNumber, Graphics g) {
		for (HeatTubeLine htl : heatTubeLines) {
			if (htl.getLineNum() == lineNumber) {
				htl.addTwoTubes();
			}
		}
	}

	public void removeTwoTubesAtLineNumber(int lineNumber, Graphics g) {
		g.clearRect(0, 0, 600, 600);
		for (HeatTubeLine htl : heatTubeLines) {
			if (htl.getLineNum() == lineNumber) {
				htl.removeTwoTubes();
			}
		}
	}

	public void draw(Graphics g, Double ratio) {
		for (HeatTubeLine htl : heatTubeLines) {
			htl.draw(g, ratio);
		}
	}

	public static int calTubesDis(double tubeOd) {
		if (tubeOd == 10) {
			return 14;
		} else if (tubeOd == 12) {
			return 16;
		} else if (tubeOd == 14) {
			return 19;
		} else if (tubeOd == 16) {
			return 22;
		} else if (tubeOd == 19) {
			return 25;
		} else if (tubeOd == 20) {
			return 26;
		} else if (tubeOd == 22) {
			return 28;
		} else if (tubeOd == 25) {
			return 32;
		} else if (tubeOd == 30) {
			return 38;
		} else if (tubeOd == 32) {
			return 40;
		} else if (tubeOd == 35) {
			return 44;
		} else if (tubeOd == 38) {
			return 48;
		} else if (tubeOd == 45) {
			return 57;
		} else if (tubeOd == 50) {
			return 64;
		} else if (tubeOd == 55) {
			return 70;
		} else if (tubeOd == 57) {
			return 72;
		} else {
			return (int) Math.ceil(1.25 * tubeOd);
		}
	}

	public static int calPassDis(double tubeOd, String type) {
		if (type.equals("U")) {
			if (tubeOd == 10) {
				return 2 * 20;
			} else if (tubeOd == 12) {
				return 2 * 24;
			} else if (tubeOd == 14) {
				return 2 * 30;
			} else if (tubeOd == 16) {
				return 2 * 32;
			} else if (tubeOd == 19) {
				return 2 * 40;
			} else if (tubeOd == 20) {
				return 2 * 40;
			} else if (tubeOd == 22) {
				return 2 * 45;
			} else if (tubeOd == 25) {
				return 2 * 50;
			} else if (tubeOd == 30) {
				return 2 * 60;
			} else if (tubeOd == 32) {
				return 2 * 65;
			} else if (tubeOd == 35) {
				return 2 * 70;
			} else if (tubeOd == 38) {
				return 2 * 76;
			} else if (tubeOd == 45) {
				return 2 * 90;
			} else if (tubeOd == 50) {
				return 2 * 100;
			} else if (tubeOd == 55) {
				return 2 * 110;
			} else if (tubeOd == 57) {
				return 2 * 115;
			}
			return (int) Math.ceil(4 * tubeOd);
		} else {
			if (tubeOd == 10) {
				return 28;
			} else if (tubeOd == 12) {
				return 30;
			} else if (tubeOd == 14) {
				return 32;
			} else if (tubeOd == 16) {
				return 35;
			} else if (tubeOd == 19) {
				return 38;
			} else if (tubeOd == 20) {
				return 40;
			} else if (tubeOd == 22) {
				return 42;
			} else if (tubeOd == 25) {
				return 44;
			} else if (tubeOd == 30) {
				return 50;
			} else if (tubeOd == 32) {
				return 52;
			} else if (tubeOd == 35) {
				return 56;
			} else if (tubeOd == 38) {
				return 60;
			} else if (tubeOd == 45) {
				return 68;
			} else if (tubeOd == 50) {
				return 76;
			} else if (tubeOd == 55) {
				return 78;
			} else if (tubeOd == 57) {
				return 80;
			}

		}
		return (int) Math.ceil(4 * tubeOd);

	}

	public double getTubeDis() {
		return tubeDis;
	}

	public double getDivideDis() {
		return divideDis;
	}

	public int getHeatTubesTotalNumber() {
		return heatTubesTotalNumber;
	}

	public int getUsedTubesNum() {
		usedTubesNum = 0;
		for (HeatTubeLine htl : heatTubeLines) {
			usedTubesNum += htl.getIsUsedNum();
		}
		return usedTubesNum;
	}

	public double getWeight() {
		weight = 0;
		for (HeatTubeLine htl : heatTubeLines) {
			weight += htl.getLineWeight();
		}
		return weight;
	}

	public double getHeatAreaU() {
		heatAreaU = 0;
		for (HeatTubeLine htl : heatTubeLines) {
			heatAreaU += htl.getHeatAreaU();
		}
		heatAreaU -= Math.PI * tubeOd * preTubePlateThick * getUsedTubesNum() * 2;
		return heatAreaU;
	}

	public double getHeatArea() {
		heatArea = 0;
		for (HeatTubeLine htl : heatTubeLines) {
			heatArea += htl.getHeatArea();
		}
		heatArea -= Math.PI * tubeOd * preTubePlateThick * getUsedTubesNum() * 2;
		return heatArea;
	}

	public String getTubeArrayType() {
		return tubeArrayType;		
	}

	public void setNthickAndMeterialOfAll(double nThick, Meterial meterial, double allowStress) {
		for (HeatTubeLine heatLine : heatTubeLines) {
			if (heatLine.getHeatTubes().size() != 0) {
				for (int i = 0; i < heatLine.getHeatTubes().size(); i++) {
					heatLine.getHeatTubes().get(i).setNThick(nThick);
					heatLine.getHeatTubes().get(i).setMeterial(meterial);
					heatLine.getHeatTubes().get(i).setAllowStress(allowStress);
				}
			}
		}
	}

	public int getOtherN() {
		int OtherN = 0;
		int size = heatTubeLines.size();
		for (int i = 0; i < size; i++) {
			if (heatTubeLines.get(i).getIsUsedNum() > OtherN) {
				OtherN = heatTubeLines.get(i).getIsUsedNum();
			}
		}
		return OtherN;
	}

	public double getPreTubePlateThick() {
		return preTubePlateThick;
	}
}
