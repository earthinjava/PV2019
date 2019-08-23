package com.duan.utils;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelUtils {
	/**
	 * 设置面板中所有组件的字体为指定值，当时jbutton和combox时，大小设为12
	 * 
	 * @param panel
	 */
	public static void setAllComFont(JPanel panel) {
		int n = panel.getComponentCount();
		for (int i = 0; i < n; i++) {
			if (panel.getComponent(i) instanceof JComboBox<?>) {
				String name = Constant.DEFAULT_FONT.getName();
				int style = Constant.DEFAULT_FONT.getStyle();
				panel.getComponent(i).setFont(new Font(name, style, 12));
			} else if (panel.getComponent(i) instanceof JButton) {
				String name = Constant.DEFAULT_FONT.getName();
				int style = Constant.DEFAULT_FONT.getStyle();
				panel.getComponent(i).setFont(new Font(name, style, 12));
			} else {
				FontUtils.setDefaultFont(panel.getComponent(i));
			}
		}
	}

	/**
	 * 判断一个面板中是否有文字域输入
	 * 
	 * @param contentPanel
	 * @return
	 */
	public static boolean isHaveInput(JPanel contentPanel) {
		Component[] com = contentPanel.getComponents();
		for (Component c : com) {
			if (c instanceof JTextField) {
				JTextField ctf = (JTextField) c;
				if (ctf.getText() != null && !ctf.getText().trim().equals("")) {
					return true;
				}
			}
		}
		return false;
	}

}
