package com.duan.component.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import com.duan.utils.ImageUtils;

/**
 * 显示图片的panel 根据设定的panel大小，自动调整图片大小。
 * 
 * @author Administrator
 *
 */
public class ShowImageCenterPanel extends JPanel {

	private static final long serialVersionUID = -6436616760255173556L;
	private String imgPath;
	private ShowImageCenterPanel showImageCenterPanel = this;

	public ShowImageCenterPanel() {
		setBackground(Color.white);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(null);
	}

	
	public ShowImageCenterPanel(String imgPath) {		
		this.imgPath = imgPath;		
	}
	
	/**
	 * 
	 * @param width      设置面板宽度
	 * @param height     设置面板高度
	 * @param imgPath    设置面板所显示的图片的地址
	 * @param isCanBiger 设置面板点击后是否可放大
	 */
	public ShowImageCenterPanel(int width, int height, String imgPath, boolean isCanBiger) {
		this();
		this.imgPath = imgPath;
		setSize(width, height);

		// 可以放大，则添加放大窗体
		if (isCanBiger) {
			addMouseListener(new BigMouseAdapter());
		}
	}

	/**
	 * 放大图片的监听器，实现序列化使其可序列化，从而反序列化后仍可使用
	 * 
	 * @author Administrator
	 *
	 */
	class BigMouseAdapter extends MouseAdapter implements Serializable {

		private static final long serialVersionUID = 5346153552138610299L;

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseClicked(e);
			new ShowImageFrame(imgPath, showImageCenterPanel);
		}
	}

	/**
	 * 
	 * @param width   设置面板宽度
	 * @param height  设置面板高度
	 * @param x       设置面板位置
	 * @param y       设置面板位置
	 * @param imgPath 设置面板所显示的图片的地址
	 */
	public ShowImageCenterPanel(int width, int height, int x, int y, String imgPath) {
		this(width, height, imgPath, false);
		setLocation(x, y);
	}

	/**
	 * 
	 * @param width      设置面板宽度
	 * @param height     设置面板高度
	 * @param x          设置面板位置
	 * @param y          设置面板位置
	 * @param imgPath    设置面板所显示的图片的地址
	 * @param isCanBiger 设置面板点击后是否可放大
	 */
	public ShowImageCenterPanel(int width, int height, int x, int y, String imgPath, boolean isCanBiger) {
		this(width, height, imgPath, isCanBiger);
		setLocation(x, y);
	}

	/**
	 * 画出所设置的图片
	 */
	@Override
	public void paint(Graphics g) {
		// TODO 自动生成的方法存根
		super.paint(g);
		ImageUtils.drawImageCenter(imgPath, this, g);
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

}
