package com.duan.utils;

import java.awt.Graphics;

public class GraphicsUtils {
	/**
	 * 根据圆点坐标和半径画出一个圆
	 * 
	 * @param x
	 * @param y
	 * @param r
	 */
	public static void drawCircle(double x, double y, double r, double ratio, Graphics g) {
		int xv = CoordinateUtils.convertCircleRelativeX(x, r, ratio, Constant.BEUTUBEARRAY_WIDETH);
		int yv = CoordinateUtils.convertCircleRelativeY(y, r, ratio, Constant.BEUTUBEARRAY_HEIGHT);
		int dr = (int) Math.round(2.0 * r * ratio);
		g.drawArc(xv, yv, dr, dr, 0, 360);
	}

	/**
	 * 输入圆点坐标和半径r1,r2。画出一个圆环。
	 * 
	 * 
	 * @param x
	 * @param y
	 * @param r1
	 * @param r2
	 * @param ratio
	 * @param g
	 */
	public static void drawCircleRing(double x, double y, double r1, double r2, double ratio, Graphics g) {
		double dr = 0.1 / ratio;
		for (; r1 <= r2; r1 += dr) {
			int lx = CoordinateUtils.convertCircleRelativeX(x, r1, ratio, Constant.BEUTUBEARRAY_WIDETH);
			int ly = CoordinateUtils.convertCircleRelativeY(y, r1, ratio, Constant.BEUTUBEARRAY_HEIGHT);
			int lr = (int) Math.round(2.0 * r1 * ratio);
			g.drawArc(lx, ly, lr, lr, 0, 360);
		}
	}

}
