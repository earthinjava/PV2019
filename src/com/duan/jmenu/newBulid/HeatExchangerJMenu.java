package com.duan.jmenu.newBulid;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.duan.jmenu.NewTabPanelModuleMenu;
import com.duan.module.heatexchanger.beu.jpanel.BEUExchangerModulePanel;
import com.duan.module.heatexchanger.sprialPlate.jpanel.SprialPlateHeatExchangerJPanel;
import com.duan.utils.FontUtils;

public class HeatExchangerJMenu extends NewTabPanelModuleMenu {

	private static final long serialVersionUID = 1L;

	public HeatExchangerJMenu(JTabbedPane jTabbedPane, JPanel contentPanel) {
		// TODO Auto-generated constructor stub
		super(jTabbedPane, contentPanel);
		FontUtils.setDefaultFont(this);
		setText("换热器");
		addItemAndShowTab(BEUExchangerModulePanel.class.getName(), "BEU");
		addItemAndShowTab(SprialPlateHeatExchangerJPanel.class.getName(), "螺旋板");
	}

}
