package com.duan.jmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.duan.component.TabbedHeadPanel;
import com.duan.module.calculate.HaveNeedSavePanel;
import com.duan.utils.FontUtils;
import com.duan.utils.ImageUtils;

/**
 * 创建一个带最终显示选项的子选项，当点击此选项时显示子选项，点击子选项时，生成tabbedpanel选项卡
 * 
 * @author Administrator
 *
 */
public class NewTabPanelModuleMenu extends JMenu {

	private static final long serialVersionUID = 5318601462729058434L;
	private JTabbedPane jTabbedPane;
	private JPanel contentPanel;

	/**
	 * 
	 * @param jTabbedPane  主选项卡
	 * @param contentPanel 选项卡的显示容器面板
	 */
	public NewTabPanelModuleMenu(JTabbedPane jTabbedPane, JPanel contentPanel) {
		// 设置此选项的显示图片
		ImageIcon icon = ImageUtils.getImageIcon("src/img/menu/" + this.getClass().getSimpleName() + ".png", 15, 15);
		setIcon(icon);
		FontUtils.setDefaultFont(this);
		this.jTabbedPane = jTabbedPane;
		this.contentPanel = contentPanel;
	}

	/**
	 * 添加最终选项选项和显示tab界面
	 * 
	 * @param showPanelClassName 最终选项的显示面板类名称
	 * @param itemAndTabName     最终选项名称和tab的名称
	 */
	public void addItemAndShowTab(String showPanelClassName, String itemAndTabName) {
		// 创建最终选项名称
		JMenuItem item = new JMenuItem(itemAndTabName);
		FontUtils.setDefaultFont(item);
		add(item);
		// 点击最终选项，添加tab界面
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					contentPanel.add(jTabbedPane);
					Object object = Class.forName(showPanelClassName).getConstructor().newInstance();
					// 模块界面
					JPanel moduleJPanel = (JPanel) object;
					HaveNeedSavePanel haveNeedSavePanel = null;
					// 判断panel是否实现了HaveNeedSavePanel，若果实现了将其序列化对象传到序列化程序中
					if (object instanceof HaveNeedSavePanel) {
						haveNeedSavePanel = (HaveNeedSavePanel) object;
					}
					// 添加一个选项卡
					jTabbedPane.addTab(itemAndTabName, null, moduleJPanel, null);
					FontUtils.setDefaultFont(jTabbedPane);
					// 设置选项卡头部和显示面板的对应关系
					jTabbedPane.setTabComponentAt(jTabbedPane.indexOfComponent(moduleJPanel),
							new TabbedHeadPanel(itemAndTabName, jTabbedPane, moduleJPanel, haveNeedSavePanel));
					// 自动跳到新添加的选项面板
					jTabbedPane.setSelectedIndex(jTabbedPane.getTabCount() - 1);
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException
						| ClassNotFoundException e) {
					e.printStackTrace();
				}

			}
		});
	}

}
