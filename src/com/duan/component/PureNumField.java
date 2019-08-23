package com.duan.component;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import com.duan.utils.Constant;
import com.duan.utils.FontUtils;
import com.duan.utils.JOptionPaneUtils;

/**
 * 纯数字field
 * 
 * @author Administrator
 *
 */
public class PureNumField extends JTextField {
	private static final long serialVersionUID = 4963922314826215557L;

	public PureNumField() {
		super();
		setColumns(10);
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		FontUtils.setDefaultFont(this);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int keyChar = e.getKeyChar();
				if (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {
				} else if (keyChar == 46) {

				} else {
					e.consume();
				}

			}
		});

	}

	/**
	 * 转换string为数值double，数值错误弹出提示信息
	 * 
	 * @param mess
	 *            string值错误的提示信息
	 * @return
	 */
	public double getDoubleNoNull(String mess) {
		String s = getText().trim();
		if (s == null || s.equals("")) {
			JOptionPaneUtils.warningMess(this, mess);
		} else {
			return Double.parseDouble(s);
		}
		requestFocus();
		return Constant.ERROR_DOUBLE;
	}

	/**
	 * 转换string为数值double
	 * 
	 * @return
	 */
	public double getDoubleCanNull() {
		String s = getText().trim();
		if (s == null || s.trim().equals("")) {
			requestFocus();
			return Constant.ERROR_DOUBLE;
		} else {
			return Double.parseDouble(s);
		}
	}

	public void setText(double value) {
		setText(value + "");
	}
}
