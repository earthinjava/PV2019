package com.duan.utils;

public class CoordinateUtils {
	/**
	 * 获得坐标x的画布转换值
	 * @param x 笛卡尔坐标值
	 * @param r 半径
	 * @param ratio 缩放比例
	 * @param width 画布宽度
	 * @return
	 */
	public static int convertCircleRelativeX(double x, double r, double ratio, double canvasWidth) {
		return (int) Math.round((x - r) * ratio + canvasWidth / 2.0);
	}
	/**
	 * 获得坐标 y的画布转换值
	 * @param y 笛卡尔坐标值
	 * @param r 半径
	 * @param ratio 缩放比例
	 * @param width 画布宽度
	 * @return
	 */
	public static int convertCircleRelativeY(double y, double r, double ratio, double canvasWidth) {
		return (int) Math.round((canvasWidth / 2.0 - (y + r) * ratio));
	}
}
