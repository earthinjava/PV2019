package com.duan.module.weightAndVolume;

import java.awt.Color;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.duan.component.TabbedHeadPanel;
import com.duan.module.calculate.HaveNeedSavePanel;
import com.duan.utils.FontUtils;
import com.duan.utils.PanelUtils;

public class WeightAndVolumetPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;

	public WeightAndVolumetPanel() {
		setBackground(Color.WHITE);
		setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 2000, 2000);
		add(tabbedPane);

		addTabbedPane(HeadShowPanel.class.getName(), "封头");
		addTabbedPane(CylinderShellShowPanel.class.getName(), "筒体");
		addTabbedPane(HeadAndShellShowPanel.class.getName(), "容器");

		PanelUtils.setAllComFont(this);
	}

	private void addTabbedPane(String showPanelClassName, String itemAndTabName) {
		try {
			Object object = Class.forName(showPanelClassName).getConstructor().newInstance();
			// 模块界面
			JPanel moduleJPanel = (JPanel) object;
			HaveNeedSavePanel haveSerializeableObject = null;
			// 判断panel是否实现了有序列化对象，若果实现了将其序列化对象传到序列化程序中
			if (object instanceof HaveNeedSavePanel) {
				haveSerializeableObject = (HaveNeedSavePanel) object;
			}
			// 添加一个选项卡
			tabbedPane.addTab(itemAndTabName, null, moduleJPanel, null);
			FontUtils.setDefaultFont(tabbedPane);
			// 设置选项卡头部和显示面板的对应关系
			tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(moduleJPanel),
					new TabbedHeadPanel(itemAndTabName, tabbedPane, moduleJPanel, haveSerializeableObject));
			// 自动跳到新添加的选项面板
			tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
