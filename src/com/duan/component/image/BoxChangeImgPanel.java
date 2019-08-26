package com.duan.component.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import com.duan.utils.FontUtils;
import com.duan.utils.ImageUtils;

public class BoxChangeImgPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	// 改变图片的箱子
	private JComboBox<String> box;
	// 图片的地址
	private String[] imgsPath;
	// 保存自己使其被监听器调用
	private JPanel selJPanel = this;

	/**
	 * 一个选择下拉箱控制显示图片的面板，可根据选择的不同显示不同的图片
	 * 
	 * @param boxItems 选项
	 * @param imgsPath 要显示的图片
	 * @param x        位置x
	 * @param y        位置y
	 * @param width    宽度
	 * @param height   高度
	 * @param isBiger  是否可放大
	 */
	public BoxChangeImgPanel(String[] boxItems, String[] imgsPath, int x, int y, int width, int height,
			boolean isBiger) {
		box = new JComboBox<>(boxItems);
		FontUtils.setDefaultFont(box);
		this.imgsPath = imgsPath;
		setLocation(x, y);
		setSize(width, height);
		setBackground(Color.WHITE);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(null);
		// 如果选择了放大操作，鼠标点击此面板则弹出放大窗体
		if (isBiger) {
			addMouseListener(new BigMouseAdapter());
		}
		// 选项改变时，显示不同的图片
		box.addActionListener(new ChangeActionListener());
	}

	/**
	 * 放大图片的监听器，实现序列化使其可序列化，从而反序列化后仍可使用
	 * 
	 * @author Administrator
	 *
	 */
	class BigMouseAdapter extends MouseAdapter implements Serializable {

		private static final long serialVersionUID = -3524104942627164488L;

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseClicked(e);			
			new ShowImgFrame(getImgPath(), selJPanel);
		}
	}

	/**
	 * 改变图片的监听器，实现序列化使其可序列化，从而反序列化后仍可使用
	 * 
	 * @author Administrator
	 *
	 */
	class ChangeActionListener implements ActionListener, Serializable {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			selJPanel.repaint();
		}

	}

	/**
	 * 根据选择项画出图片
	 */
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		ImageUtils.drawImageCenter(getImgPath(), this, g);
	}

	/**
	 * 返回一個可控制此面板图片的选择箱
	 * 
	 * @return
	 */
	public JComboBox<String> getBox() {
		return box;
	}
	
	private String getImgPath() {
		int index = box.getSelectedIndex();
		if (index < 0) {
			return null;
		}
		if (imgsPath == null || imgsPath.length <= 0) {
			return null;
		}
		if (index > imgsPath.length - 1) {
			return null;
		}
		return imgsPath[index];
	}

}
