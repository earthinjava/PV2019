package com.duan.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;

import com.duan.component.image.ShowImageFrame;

public class ShowImgButton extends JButton implements Serializable, ActionListener {

	private static final long serialVersionUID = 512341272033145651L;
	private String imgPath;

	public ShowImgButton(String imgPath) {
		// TODO 自动生成的构造函数存根
		addActionListener(this);
		this.imgPath = imgPath;
		setText("查图");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		new ShowImageFrame(imgPath, this);
	}

}
