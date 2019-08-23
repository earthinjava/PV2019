
package com.duan.utils;

public class ArrayUtils {

	/**
	 * 	获得差值
	 * @param x
	 * @param y
	 * @param x1
	 * @return
	 */
	public static double getMidByTwoArrays(double[] x, double[] y, double x1) {
		if(x==null||y==null) {
			return Constant.ERROR_DOUBLE;
		}
		int len = x.length;
		if (x1 <= x[len - 1] && x1 >= x[0]) {
			int lowX = 0;
			int bigX = 0;
			for (int i = 0; i <= len - 1 && x1 >= x[i]; i++) {
				lowX = i;
				bigX = i + 1;
			}
			double y1 = (y[bigX] - y[lowX]) / (x[bigX] - x[lowX]) * (x1 - x[lowX]) + y[lowX];
			return y1;
		}
		return Constant.ERROR_DOUBLE;
	}

	/**
	 * 	获得差值
	 * @param array
	 * @param x1
	 * @return
	 */
	public static double getMindByTwoArrays(double[][] array, double x1) {
		if (array == null) {
			return Constant.ERROR_DOUBLE;
		}
		int l = array[0].length;
		if (l != 2) {
			return Constant.ERROR_DOUBLE;
		}
		int r = array.length;
		double[] x = new double[r];
		double[] y = new double[r];
		for (int i = 0; i < r; i++) {
			x[i] = array[i][0];
			y[i] = array[i][1];
		}
		return getMidByTwoArrays(x, y, x1);
	}
}
