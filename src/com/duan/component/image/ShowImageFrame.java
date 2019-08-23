package com.duan.component.image;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.duan.component.CanStartFrame;
import com.duan.utils.FrameUtils;

/**
 * 按图片实际尺寸显示的窗体
 * 
 * @author Administrator
 *
 */
public class ShowImageFrame extends CanStartFrame {

	private static final long serialVersionUID = 1L;
	private JPanel preImagePanel;

	/**
	 * 
	 * @param imgPath                  图片地址
	 * @param wantLockFrameOfComponent 打开后想要锁定的窗体的组件,父窗体
	 */
	public ShowImageFrame(String imgPath, Component wantLockFrameOfComponent) {
		super(0, 0);
		ImageIcon icon = new ImageIcon(imgPath);
		int imgHeight = icon.getIconHeight();
		int imgWide = icon.getIconWidth();
		setSize(imgWide + 20, imgHeight + 20);
		FrameUtils.setFrameAtScreenCenter(this, imgWide, imgHeight);
		preImagePanel = new ShowImageCenterPanel(this.getWidth(), this.getHeight(), imgPath, false);		
		// 本窗口打开则锁定主窗口,本窗口关闭则解锁主窗口
		FrameUtils.clockAndUnclockFatherFrame(wantLockFrameOfComponent, this);
		// 鼠标点击或移除界面，则关闭本窗口
		addMouseListener(new MyMouseAdapter());
		setContentPane(preImagePanel);
	}
	
	/**
	 * 
	 * @author Administrator
	 *
	 */
	class MyMouseAdapter extends MouseAdapter implements Serializable{

		private static final long serialVersionUID = -5439281228876634842L;

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseClicked(e);
			dispose();
		}
	
	}

}
