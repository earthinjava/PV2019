package com.duan.jmenu.dataBase;

import javax.swing.JFrame;
import javax.swing.JMenu;

import com.duan.utils.FontUtils;

public class MediumJMenu extends JMenu {
	
	private static final long serialVersionUID = 1L;

	public MediumJMenu(JFrame mainFrame) {
		// TODO Auto-generated constructor stub
		setText("介质");
		FontUtils.setDefaultFont(this);		
	}
}