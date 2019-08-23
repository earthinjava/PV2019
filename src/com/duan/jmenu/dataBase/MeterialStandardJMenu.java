package com.duan.jmenu.dataBase;

import javax.swing.JFrame;
import javax.swing.JMenu;

import com.duan.jmenu.NewFrameModuleItem;
import com.duan.module.meterialStandard.DelMeterialStandardFrame;
import com.duan.module.meterialStandard.NewMeterialStandardFrame;
import com.duan.utils.FontUtils;

public class MeterialStandardJMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	public MeterialStandardJMenu(JFrame mainFrame) {
		// TODO Auto-generated constructor stub
		setText("标准");
		FontUtils.setDefaultFont(this);
		add(new NewFrameModuleItem("新建", NewMeterialStandardFrame.class.getName(), mainFrame));
		add(new NewFrameModuleItem("查询", DelMeterialStandardFrame.class.getName(), mainFrame));
	}

}
