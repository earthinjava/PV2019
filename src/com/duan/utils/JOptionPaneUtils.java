package com.duan.utils;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class JOptionPaneUtils {
	/**
	 * 将输入的文件名返回
	 * 
	 * @param messComponent
	 * @return
	 */
	public static String inPutFileNameMess(Component messComponent) {
		messComponent = ComponentUtils.getRootComponent(messComponent);
		if (messComponent != null) {
			UIManager.put("OptionPane.messageFont", new Font("宋体", Font.PLAIN, 13));
			return JOptionPane.showInputDialog(messComponent, "请输入文件名", "", JOptionPane.PLAIN_MESSAGE);
		}
		return null;
	}

	/**
	 * 弹出一个提示对话框
	 * 
	 * @param messComponent
	 * @param mess
	 */
	public static void warningMess(Component messComponent, String mess) {
		messComponent = ComponentUtils.getRootComponent(messComponent);
		if (messComponent != null) {
			UIManager.put("OptionPane.messageFont", new Font("宋体", Font.PLAIN, 13));
			JOptionPane.showMessageDialog(messComponent, mess, "提示", JOptionPane.WARNING_MESSAGE,
					ImageUtils.getImageIcon(Constant.JOPTIONPANE_WARING, 40, 40));
		}
	}

	/**
	 * 弹出选择对话框，选择是返回true
	 * 
	 * @param messComponent
	 * @param mess
	 * @return
	 */
	public static boolean selectMess(Component messComponent, String mess) {
		messComponent = ComponentUtils.getRootComponent(messComponent);
		if (messComponent != null) {
			UIManager.put("OptionPane.messageFont", new Font("宋体", Font.PLAIN, 13));
			int selected = JOptionPane.showConfirmDialog(messComponent, mess, "确认", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, ImageUtils.getImageIcon(Constant.JOPTIONPANE_ASK, 40, 40));
			if (JOptionPane.OK_OPTION == selected) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

}
