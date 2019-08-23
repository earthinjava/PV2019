package com.duan.jmenu.newBulid;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.duan.jmenu.NewTabPanelModuleMenu;
import com.duan.module.opening.OpengingMedulePanel;
import com.duan.module.safetyValve.SafetyValvePanel;
import com.duan.module.weightAndVolume.WeightAndVolumetPanel;
import com.duan.utils.FontUtils;

public class PartJMenu extends NewTabPanelModuleMenu {

	private static final long serialVersionUID = 1L;

	public PartJMenu(JTabbedPane jTabbedPane, JPanel contentPanel) {
		// TODO Auto-generated constructor stub
		super(jTabbedPane, contentPanel);
		setText("零部件");
		FontUtils.setDefaultFont(this);
		addItemAndShowTab(OpengingMedulePanel.class.getName(), "开孔补强");
		addItemAndShowTab(SafetyValvePanel.class.getName(), "安全阀");
		addItemAndShowTab(WeightAndVolumetPanel.class.getName(), "容积和重量");
	}
}
