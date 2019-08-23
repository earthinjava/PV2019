package com.duan.module.heatexchanger.beu.bean.structural;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import com.duan.utils.Constant;
import com.duan.utils.GraphicsUtils;

public class TubeLimitCircle implements Serializable{
	
	private static final long serialVersionUID = 8983472992551916301L;
	private double d;
	private double ratio;
	private double shellId;

	public TubeLimitCircle(double shellId, double tubeOd) {
		// TODO Auto-generated constructor stub
		this.shellId = shellId;
		double b3 = 0.25 * tubeOd > 8 ? 0.25 * tubeOd : 8;
		ratio = 500 / shellId;
		d = shellId - 2 * b3;

	}

	public void draw(Graphics g) {
		Color color = g.getColor();
		g.setColor(Color.green);
		GraphicsUtils.drawCircle(0, 0, d / 2.0, ratio, g);
		g.setColor(Color.red);
		g.drawLine(Constant.BEUTUBEARRAY_WIDETH / 2, 0, Constant.BEUTUBEARRAY_WIDETH / 2, Constant.BEUTUBEARRAY_HEIGHT);
		g.drawLine(0, Constant.BEUTUBEARRAY_HEIGHT / 2, Constant.BEUTUBEARRAY_WIDETH, Constant.BEUTUBEARRAY_HEIGHT / 2);
		g.setColor(color);
	}

	public double getD() {
		return d;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

	public double getShellId() {
		return shellId;
	}

	public void setShellId(double shellId) {
		this.shellId = shellId;
	}

}
