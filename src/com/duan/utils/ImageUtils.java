package com.duan.utils;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImageUtils {
	/**
	 * 将图片有边框的居中画到panel中
	 * 
	 * @param imgPath
	 * @param jPanel
	 * @param g
	 */
	public static void drawImageCenter(String imgPath, JPanel jPanel, Graphics g) {
		ImageIcon icon = new ImageIcon(imgPath);
		Image img = icon.getImage();
		double iconHeigt = icon.getIconHeight();
		double iconWidth = icon.getIconWidth();
		double panelHeight = jPanel.getHeight();
		double panelWidth = jPanel.getWidth();
		double ratio;
		if (iconHeigt < panelHeight && iconWidth < panelWidth) {
			ratio = panelHeight / iconHeigt > panelWidth / iconWidth ? panelHeight / iconHeigt : panelWidth / iconWidth;
		} else {
			ratio = panelHeight / iconHeigt > panelWidth / iconWidth ? panelWidth / iconWidth : panelHeight / iconHeigt;
		}
		int iconH = (int) Math.round(iconHeigt * ratio - 5.0);
		int iconW = (int) Math.round(iconWidth * ratio - 5.0);
		int x = (int) Math.round((panelWidth - iconW) / 2.0);
		int y = (int) Math.round((panelHeight - iconH) / 2.0);
		g.drawImage(img, x, y, iconW, iconH, jPanel);
	}

	/**
	 * 将图片无边框的居中画到panel中
	 * 
	 * @param imgPath
	 * @param jPanel
	 * @param g
	 */
	public static void drawImageCenterWithoutSide(String imgPath, JPanel jPanel, Graphics g) {
		ImageIcon icon = new ImageIcon(imgPath);
		Image img = icon.getImage();
		double iconHeigt = icon.getIconHeight();
		double iconWidth = icon.getIconWidth();
		double panelHeight = jPanel.getHeight();
		double panelWidth = jPanel.getWidth();
		double ratio;
		if (iconHeigt < panelHeight && iconWidth < panelWidth) {
			ratio = panelHeight / iconHeigt > panelWidth / iconWidth ? panelHeight / iconHeigt : panelWidth / iconWidth;
		} else {
			ratio = panelHeight / iconHeigt > panelWidth / iconWidth ? panelWidth / iconWidth : panelHeight / iconHeigt;
		}
		int iconH = (int) Math.round(iconHeigt * ratio);
		int iconW = (int) Math.round(iconWidth * ratio);
		int x = (int) Math.round((panelWidth - iconW) / 2.0);
		int y = (int) Math.round((panelHeight - iconH) / 2.0);
		if (g == null) {
			return;
		}
		g.drawImage(img, x, y, iconW, iconH, jPanel);
	}

	/**
	 * 输入一个图片地址，获得指定宽和高的图片
	 * 
	 * @param path
	 * @param width
	 * @param height
	 * @return
	 */
	public static ImageIcon getImageIcon(String path, int width, int height) {
		ImageIcon icon = new ImageIcon(path);
		if (width == 0 || height == 0) {
			return new ImageIcon(icon.getClass().getResource(path));
		}
		icon.setImage(icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		return icon;
	}

}
