package com.duan.utils;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

import com.duan.component.ChildFrame;

public class FrameUtils {
	/**
	 * 设置窗口位置为屏幕居中
	 * 
	 * @param frame
	 * @param width
	 * @param height
	 */
	public static void setFrameAtScreenCenter(JFrame frame, int width, int height) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int w = dim.width;
		int h = dim.height;
		frame.setBounds(new Rectangle((w - width) / 2, (h - height) / 2, width, height));
		frame.setResizable(false);
	}

	/**
	 * 子窗口打开并获得焦点，同時锁定父窗口,隐藏父窗口。子窗口关闭时，解锁父窗口，显示父窗口。
	 * 
	 * @param mainFrame
	 * @param childFrame
	 */
	public static void clockAndUnclockFatherFrame(Component fatherComponet, JFrame childFrame) {
		if (childFrame instanceof ChildFrame) {
			((ChildFrame) childFrame).start();
		}
		childFrame.requestFocus();
		Component rootCom = ComponentUtils.getRootComponent(fatherComponet);
		if (rootCom instanceof JFrame) {
			JFrame fatherFrame = (JFrame) rootCom;
			if (fatherFrame != null) {
				fatherFrame.setEnabled(false);
				fatherFrame.setVisible(false);
			}
			childFrame.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent e) {
					if (fatherFrame != null) {
						fatherFrame.setEnabled(true);
						fatherFrame.setVisible(true);
						fatherFrame.requestFocus();
					}
				};
			});
		}

	}

	/**
	 * 子窗口打开并获得焦点，同時隐藏父窗口。子窗口关闭时，同时关闭父窗口。
	 * 
	 * @param mainFrame
	 * @param childFrame
	 */
	public static void hideAndcloseFatherFrame(Component fatherComponet, JFrame childFrame) {
		if (childFrame instanceof ChildFrame) {
			((ChildFrame) childFrame).start();
		}
		Component rootCom = ComponentUtils.getRootComponent(fatherComponet);
		if (rootCom instanceof JFrame) {
			JFrame fatherFrame = (JFrame) rootCom;
			if (fatherFrame != null) {
				fatherFrame.setVisible(false);
			}
			childFrame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent e) {
					super.windowClosed(e);
					if (fatherFrame != null) {
						fatherFrame.dispose();
					}
				}
			});
		}
	}

	
}
