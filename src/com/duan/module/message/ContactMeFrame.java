package com.duan.module.message;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.duan.component.CanStartFrame;
import com.duan.component.image.ShowImageCenterPanel;
import com.duan.utils.Constant;

public class ContactMeFrame extends CanStartFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ContactMeFrame() {
		super( 372, 420);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel preImagePanel = new ShowImageCenterPanel(366, 392, 0, 0, Constant.WEIXIN_IMGPATH);
		contentPane.add(preImagePanel);
	}

}
