package com.duan.utils;

public class DoubleUtils {
	/**
	 * 保留double的四舍五入两位小数值
	 * 
	 * @param d
	 * @return
	 */
	public static double doubleSavePointTwo(double d) {
		return (double) Math.round(d * 100) / 100;
	}

	/**
	 * 判断是否为0.5的整数倍
	 * 
	 * @param d
	 * @return
	 */
	public static boolean isPoint5PCount(double d) {
		int tmp = (int) (d * 10);
		if (tmp % 5 == 0 && (d * 10 - tmp) <= 0.000001) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断double是否为整数
	 * 
	 * @param d
	 * @return
	 */
	public static boolean isInteger(double d) {
		double eps = 1e-10; // double的精度
		return d - Math.floor(d) < eps;
	}

	/**
	 * 判断double是否为偶数
	 * 
	 * @param d
	 * @return
	 */
	public static boolean isEven(double d) {
		if (isInteger(d)) {
			return d % 2 == 0;
		} else {
			return false;
		}
	}

	/**
	 * 保存double的四舍五入五为小数值
	 * 
	 * @param d
	 * @return
	 */
	public static double doubleSavePointFive(double d) {
		return (double) Math.round(d * 100000) / 100000;
	}

	/**
	 * 获得差值x的y对应值
	 * 
	 * @param x1
	 * @param x2
	 * @param y1
	 * @param y2
	 * @param x
	 * @return
	 */
	public static double getMidY(double x1, double x2, double y1, double y2, double x) {
		if (x >= x1 && x <= x2) {
			double r = (y2 - y1) / (x2 - x1);
			double y = (x - x1) * r + y1;
			return y;
		} else {
			return Constant.ERROR_DOUBLE;
		}
	}
}
