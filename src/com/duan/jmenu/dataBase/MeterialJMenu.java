package com.duan.jmenu.dataBase;

import javax.swing.JFrame;
import javax.swing.JMenu;

import com.duan.component.meterial.SelectMeterialFrame;
import com.duan.jmenu.NewFrameModuleItem;
import com.duan.module.meterial.create.NewMeterialFrame;
import com.duan.module.meterial.delete.DeleteMeterialFrame;
import com.duan.utils.FontUtils;

public class MeterialJMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	public MeterialJMenu(JFrame mainFrame) {
		// TODO Auto-generated constructor stub
		setText("材料");
		FontUtils.setDefaultFont(this);
		add(new NewFrameModuleItem("新建", NewMeterialFrame.class.getName(), mainFrame));
		add(new NewFrameModuleItem("查询", SelectMeterialFrame.class.getName(), mainFrame));
		add(new NewFrameModuleItem("删除", DeleteMeterialFrame.class.getName(), mainFrame));
	}

}
