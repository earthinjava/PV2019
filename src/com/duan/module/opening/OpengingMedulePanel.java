package com.duan.module.opening;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JPanel;

import com.duan.component.image.ShowImageCenterPanel;
import com.duan.module.calculate.HaveNeedSavePanel;
import com.duan.module.opening.bean.Openging;
import com.duan.utils.Constant;
import com.duan.utils.PanelUtils;

public class OpengingMedulePanel extends HaveNeedSavePanel {

	private static final long serialVersionUID = 1L;
	private Openging openging = new Openging();
	private JPanel pane;
	private OpeningDesignContionPanel openingDesignContionPanel;
	private ShellPanel shellPanel;
	private PipePanel pipePanel;
	private OpeningPanel openingPanel;
	private ShowImageCenterPanel imgPanel;

	public OpengingMedulePanel() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		pane = new JPanel();
		pane.setSize(2000, 2000);
		pane.setToolTipText("\u7B52\u4F53\u6570\u636E");
		pane.setLayout(null);
		pane.setBackground(Color.white);
		add(pane);

		openingDesignContionPanel = new OpeningDesignContionPanel(openging, "设计条件");
		openingDesignContionPanel.setLocation(5, 5);
		pane.add(openingDesignContionPanel);
		openingDesignContionPanel.setBackground(SystemColor.menu);
		openingDesignContionPanel.hideApplyButton();

		shellPanel = new ShellPanel(openging, openingDesignContionPanel);
		shellPanel.setLocation(5, 205);
		pane.add(shellPanel);
		shellPanel.setBackground(SystemColor.menu);

		pipePanel = new PipePanel(openging, openingDesignContionPanel);
		pipePanel.setLocation(180, 205);
		pane.add(pipePanel);
		pipePanel.setBackground(SystemColor.menu);

		imgPanel = new ShowImageCenterPanel(385, 200, "src/img/opening/showA.png", true);
		imgPanel.setBounds(180, 5, 385, 200);
		pane.add(imgPanel);

		openingPanel = new OpeningPanel(openingDesignContionPanel, shellPanel, pipePanel, openging, imgPanel);
		openingPanel.setLocation(355, 205);
		openingPanel.setBackground(SystemColor.menu);
		pane.add(openingPanel);
	}
	
	/**
	 * 判断输入条件是否为空，为空则不需保存
	 */
	@Override
	public boolean isNeedSave() {
		// 若没有输入返回null
		if (!PanelUtils.isHaveInput(openingDesignContionPanel) && !PanelUtils.isHaveInput(shellPanel)
				&& !PanelUtils.isHaveInput(pipePanel) && !PanelUtils.isHaveInput(openingPanel)) {
			return false;
		}
		// 若不为空，返回此对象用于序列化
		return true;
	}

	/**
	 * 返回模块的中文名称
	 */
	@Override
	public String getChiName() {
		// TODO 自动生成的方法存根
		return Constant.MODULE_CHINAME[0];
	}

}
