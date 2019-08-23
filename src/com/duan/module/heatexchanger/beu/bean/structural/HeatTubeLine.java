package com.duan.module.heatexchanger.beu.bean.structural;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;

public class HeatTubeLine implements Serializable{
	
	private static final long serialVersionUID = 4680492993353354707L;
	// 第几行
	private int lineNum;
	// 弯曲半径
	private double r;
	// 换热管集合
	private ArrayList<UHeatTube> heatTubes;
	// 实际布管根数
	private int isUsedNum;
	// 通过个总长
	private double lineLength;
	// 同规格总重
	private double lineWeight;
	// 含U 换热面积
	private double heatAreaU;
	// 不含U 换热面积
	private double heatArea;

	public HeatTubeLine(int lineNum, double r) {
		// TODO Auto-generated constructor stub
		this.setLineNum(lineNum);
		this.r = r;
		setHeatTubes(new ArrayList<UHeatTube>());
	}

	public ArrayList<UHeatTube> getHeatTubes() {
		return heatTubes;
	}

	public void setHeatTubes(ArrayList<UHeatTube> heatTubes) {
		this.heatTubes = heatTubes;
	}

	public int getLineNum() {
		return lineNum;
	}

	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}

	public double getR() {
		return r;
	}

	public int getIsUsedNum() {
		isUsedNum = 0;
		for (UHeatTube h : heatTubes) {
			if (h.isUsed()) {
				isUsedNum++;
			}
		}
		return isUsedNum;
	}

	public double getLineLength() {
		lineLength = heatTubes.get(0).getLength() * getIsUsedNum();
		return lineLength;
	}

	public double getLineWeight() {
		lineWeight = heatTubes.get(0).getWeight() * getIsUsedNum();
		return lineWeight;
	}


	public void removeTwoTubes() {
		// TODO Auto-generated method stub
		int tubeNum = heatTubes.size();
		int x = 0;
		for (int i = tubeNum - 1; i >= 0; i--) {
			if (heatTubes.get(i).isUsed() && x <= 1) {
				heatTubes.get(i).setUsed(false);
				x++;
			}
		}

	}


	public void addTwoTubes() {
		// TODO Auto-generated method stub
		int tubeNum = heatTubes.size();
		int x = 0;
		for (int i = 0; i < tubeNum; i++) {
			if (!heatTubes.get(i).isUsed() && x <= 1) {
				heatTubes.get(i).setUsed(true);
				x++;
			}
		}

	}

	public void draw(Graphics g, double ratio) {
		double tubeOd = heatTubes.get(0).getOutDia();
		for (int i = 0; i < heatTubes.size(); i++) {
			if (heatTubes.get(i).isUsed()) {
				heatTubes.get(i).draw(g, ratio);			
				new UHeatTube(heatTubes.get(i).getX(), 0 - heatTubes.get(i).getY(), tubeOd, 0).draw(g, ratio);
			}

		}

	}

	public double getHeatAreaU() {
		heatAreaU = heatTubes.get(0).getHeatAreaU() * getIsUsedNum();
		return heatAreaU;
	}

	public double getHeatArea() {
		heatArea = heatTubes.get(0).getHeatArea() * getIsUsedNum();
		return heatArea;
	}

}
