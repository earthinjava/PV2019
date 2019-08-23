package com.duan.module.weightAndVolume;

import java.awt.Color;

import javax.swing.JPanel;

import com.duan.utils.PanelUtils;

public class CylinderShellShowPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private CylinderShellTablePanel cylinderShellTablePanel;
	private CylinderShellMessPanel cylinderShellMessPanel;

	public CylinderShellShowPanel() {
		setBackground(Color.WHITE);
		setLayout(null);

		cylinderShellTablePanel = new CylinderShellTablePanel();
		cylinderShellTablePanel.setLocation(225, 5);
		add(cylinderShellTablePanel);

		cylinderShellMessPanel = new CylinderShellMessPanel(cylinderShellTablePanel);
		cylinderShellMessPanel.setLocation(5, 5);
		add(cylinderShellMessPanel);
		PanelUtils.setAllComFont(this);
	}

	public CylinderShellMessPanel getCylinderShellMessPanel() {
		return cylinderShellMessPanel;
	}
}
