package com.duan.module.weightAndVolume;

import javax.swing.JPanel;

import com.duan.utils.PanelUtils;

import java.awt.Color;

public class HeadShowPanel extends JPanel {

	private static final long serialVersionUID = -2351081368213541860L;
	private HeadMessPanel headMessPanel;

	public HeadShowPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		headMessPanel = new HeadMessPanel();
		headMessPanel.setLocation(5, 5);
		add(headMessPanel);
		PanelUtils.setAllComFont(this);
	}

	public HeadMessPanel getHeadMessPanel() {
		return headMessPanel;
	}
}
