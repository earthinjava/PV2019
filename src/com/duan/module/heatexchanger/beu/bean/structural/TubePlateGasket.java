package com.duan.module.heatexchanger.beu.bean.structural;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import com.duan.utils.GraphicsUtils;

public class TubePlateGasket implements Serializable{
	
	private static final long serialVersionUID = 4972226730595205525L;
	private double id;
	private double od;
	private double sealOd;
	private double sealId;
	private double b0;
	private double b;
	// 作用圆直径
	private double fd;

	public double getB0() {
		return b0;
	}

	public double getB() {
		return b;
	}

	public TubePlateGasket(double id, double od, double sealId, double sealOd) {
		// TODO Auto-generated constructor stub
		this.setId(id);
		this.setOd(od);
		this.setSealId(sealId);
		this.setSealOd(sealOd);
		b0 = sealOd / 2 - sealId / 2;
		if (b0 <= 6) {
			b = b0;
			fd = sealId / 2 + sealOd / 2;
		} else {
			b = 2.5 * Math.sqrt(b0);
			fd = sealOd - 2 * b;
		}
	}

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public double getOd() {
		return od;
	}

	public void setOd(double od) {
		this.od = od;
	}

	public double getFd() {
		return fd;
	}

	public void draw(Graphics g, double ratio) {
		Color color = g.getColor();
		g.setColor(Color.BLUE);	
		GraphicsUtils.drawCircleRing(0, 0, id/2, od/2, ratio, g);		
		g.setColor(color);
	}

	public double getSealOd() {
		return sealOd;
	}

	public void setSealOd(double sealOd) {
		this.sealOd = sealOd;
	}

	public double getSealId() {
		return sealId;
	}

	public void setSealId(double sealId) {
		this.sealId = sealId;
	}

}
