package com.duan.module.message;

import java.awt.Color;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.duan.component.ChildFrame;
import com.duan.utils.DateUtils;
import com.duan.utils.PanelUtils;

public class VersionFrame extends ChildFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public VersionFrame() {
		super( 200, 100);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel verJLabel = new JLabel("当前版本日期:" + DateUtils.parseDateToStringDay(new Date()));
		add(verJLabel);
		
		PanelUtils.setAllComFont(contentPane);
	}

}
