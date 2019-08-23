package com.duan.utils;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.duan.component.PureNumField;

public class LabelAndFieldUtils {
	
	/**
	 * 获得标签中的数值double
	 * @param field
	 * @return
	 */
	public static double getDouble(JTextField field) {
		if (field == null) {
			return Constant.ERROR_DOUBLE;
		}
		String s = field.getText();
		if (!s.trim().equals("") && s != null) {
			return Double.parseDouble(s);
		}
		return Constant.ERROR_DOUBLE;
	}
	
	/**
	 * 获得标签中的数值double
	 * @param label
	 * @return
	 */
	public static double getDouble(JLabel label) {
		if (label == null) {
			return Constant.ERROR_DOUBLE;
		}
		String s = label.getText();
		if (!s.trim().equals("") && s != null) {
			return Double.parseDouble(s);
		}
		return Constant.ERROR_DOUBLE;
	}

	/**
	 * 标签仅保留两位小数点
	 * 
	 * @param showLabel
	 * @param showDouble
	 */
	public static void showDoublePointTwo(JLabel showLabel, double showDouble) {
		if (showDouble != Constant.ERROR_DOUBLE && showLabel != null) {
			double d = DoubleUtils.doubleSavePointTwo(showDouble);
			showLabel.setText(d + "");
		}
	}

	public static void showDoublePointTwo(PureNumField jTextField, double showDouble) {
		if (showDouble != Constant.ERROR_DOUBLE && jTextField != null) {
			double d = DoubleUtils.doubleSavePointTwo(showDouble);
			jTextField.setText(d + "");
		}
	}

	/**
	 * 标签仅保留五位小数点
	 * 
	 * @param showLabel
	 * @param showDouble
	 */
	public static void showDoublePointFive(JLabel showLabel, double showDouble) {
		if (showDouble != Constant.ERROR_DOUBLE) {
			double d = DoubleUtils.doubleSavePointFive(showDouble);
			showLabel.setText(d + "");
		}
	}

	public static void setTextColorOK(JTextField jTextField) {
		if (jTextField != null) {
			jTextField.setForeground(Color.BLACK);
		}

	}

	public static void setTextColorNotOK(JTextField jTextField) {
		if (jTextField != null) {
			jTextField.setForeground(Color.RED);
		}

	}

	public static void setTextColorOK(JLabel label) {
		if (label != null) {
			label.setForeground(Color.BLACK);
		}

	}

	public static void setTextColorNotOK(JLabel label) {
		if (label != null) {
			label.setForeground(Color.RED);
		}

	}

}
