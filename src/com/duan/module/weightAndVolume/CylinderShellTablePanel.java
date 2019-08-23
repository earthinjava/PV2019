package com.duan.module.weightAndVolume;

import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

import com.duan.utils.FontUtils;
import com.duan.utils.PanelUtils;
import com.duan.vessel.shell.CylinderShell;

public class CylinderShellTablePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	public CylinderShellTablePanel() {
		setBackground(SystemColor.menu);
		setLayout(null);
		setSize(450, 315);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

	}

	// 显示表格
	public void showVolumeTable(double levelHeigt, CylinderShell cylinderShell) {
		removeAll();
		// 根据高度间隔，获得容积数组
		Double[][] hvs = cylinderShell.getHeightsAndVolumesByLevelHeigt(levelHeigt);
		String[] tableTitle = { "液位高度mm", "容积m³", "充满率%" };		
		table = new JTable(hvs, tableTitle);
		FontUtils.setDefaultFont(table.getTableHeader());
		FontUtils.setDefaultFont(table);
		JScrollPane jScrollPane = new JScrollPane(table);
		FontUtils.setDefaultFont(table.getTableHeader());
		FontUtils.setDefaultFont(table);
		jScrollPane.setBounds(0, 0, 449, 314);
		jScrollPane.setBackground(SystemColor.menu);
		add(jScrollPane);
		this.repaint();
		PanelUtils.setAllComFont(this);
	}
}
