package com.duan.module.calculate;

import javax.swing.JPanel;

public abstract class HaveNeedSavePanel extends JPanel {

	private static final long serialVersionUID = 1L;


	public String getLastName() {
		return getClass().getSimpleName();
	}

	public String getEngName() {
		return getLastName();
	}	

	public abstract boolean isNeedSave();

	public abstract String getChiName();
	
}
