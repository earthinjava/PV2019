package com.duan.component;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import com.duan.utils.Constant;
import com.duan.utils.LabelAndFieldUtils;

/**
 * 输入实际值和所需值，计算余量，当实际值小于所需值时，将显示为不合格，并设为红色字体。
 * 
 * @author Administrator
 *
 */
public class ResultLabel extends JLabel {

	private static final long serialVersionUID = -155539411363709249L;
	private JLabel actualLabel;
	private JTextField actualField;
	private JLabel requiredLabel;
	private JLabel exJLabel;

	/**
	 * 
	 * @param actualcompentComponent
	 *            实际值容器
	 * @param requiredLabel
	 *            所需值标签
	 * @param exJLabel
	 *            余量标签
	 */
	public ResultLabel() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setSize(66, 20);
		actualLabel = new JLabel();
		actualField = new JTextField();
		requiredLabel = new JLabel();
		exJLabel = new JLabel();
	}

	/**
	 * 显示结果
	 * 
	 * @param actual
	 * @param required
	 */
	public void showResult() {
		double required = LabelAndFieldUtils.getDouble(requiredLabel);
		double labelActual = LabelAndFieldUtils.getDouble(actualLabel);
		double fieldActual = LabelAndFieldUtils.getDouble(actualField);	
		if (required == Constant.ERROR_DOUBLE) {
			return;
		}

		if (labelActual == Constant.ERROR_DOUBLE && fieldActual == Constant.ERROR_DOUBLE) {
			return;
		}
		double actual;
		if (labelActual == Constant.ERROR_DOUBLE) {
			actual = fieldActual;
		} else {
			actual = labelActual;
		}	
		LabelAndFieldUtils.showDoublePointTwo(exJLabel, 100 * actual / required - 100);		
		if (actual >= required) {
			setForeground(Color.BLUE);
			setText("合格");
			LabelAndFieldUtils.setTextColorOK(exJLabel);
			LabelAndFieldUtils.setTextColorOK(actualField);
		} else {
			setForeground(Color.RED);
			setText("不合格");
			LabelAndFieldUtils.setTextColorNotOK(exJLabel);
			LabelAndFieldUtils.setTextColorNotOK(actualField);
		}
	}

	public JLabel getActualLabel() {
		return actualLabel;
	}

	public JTextField getActualField() {
		return actualField;
	}

	public JLabel getRequiredLabel() {
		return requiredLabel;
	}

	public JLabel getExJLabel() {
		return exJLabel;
	}

	public void setActualField(JTextField actualField) {
		this.actualField = actualField;
	}
}
