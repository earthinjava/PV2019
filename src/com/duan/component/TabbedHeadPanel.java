package com.duan.component;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.duan.module.calculate.HaveNeedSavePanel;
import com.duan.utils.Constant;
import com.duan.utils.FontUtils;
import com.duan.utils.ImageUtils;
import com.duan.utils.JOptionPaneUtils;
import com.duan.utils.SerializeUtils;

/**
 * 选项卡头部，头部中添加了一个图片，点击此图片时，先提示是否保存到数据库，再关闭选项卡
 * 
 * @author Administrator
 *
 */
public class TabbedHeadPanel extends JPanel {

	private static final long serialVersionUID = -6880820187304313380L;
	private HaveNeedSavePanel needSavePanel;
	private JLabel nameLable;

	/**
	 * 添加一个可关闭的选项卡头部
	 * 
	 * @param name              要显示的选项卡名称
	 * @param jTabbedPane       总选项卡
	 * @param moduleJPanel      选项卡对应的内容panel
	 * @param HaveNeedSavePanel 需要序列化的面板，若为空则不序列化操作
	 */
	public TabbedHeadPanel(String name, JTabbedPane jTabbedPane, JPanel moduleJPanel, HaveNeedSavePanel needSavePanel) {
		setLayout(new FlowLayout(FlowLayout.LEADING, 5, 0));
		setOpaque(false);
		this.needSavePanel = needSavePanel;
		nameLable = new JLabel(name);
		FontUtils.setDefaultFont(nameLable);
		add(nameLable);
		// 子标题添加一个图片
		JPanel closePanel = new JPanel() {
			private static final long serialVersionUID = -8914246977293170671L;

			@Override
			public void paint(Graphics g) {
				// TODO 自动生成的方法存根
				super.paint(g);
				ImageUtils.drawImageCenterWithoutSide(Constant.TABBED_CLOSEIMG, this, g);
			}

		};
		// 设置背景完全透明
		closePanel.setOpaque(false);
		add(closePanel);
		// 设定点击选项卡头部关闭图片，先弹出对话框提示是否保存到数据库，再关闭 选项卡对应的内容panel
		closePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				// 若为空，说明此模块不需要序列化保存，直接退出
				if (needSavePanel == null) {
					jTabbedPane.remove(moduleJPanel);
					return;
				}
				// 模块没有任何输入，直接退出
				if (!needSavePanel.isNeedSave()) {
					jTabbedPane.remove(moduleJPanel);
					return;
				}
				// 模块需要保存且有输入值
				if (JOptionPaneUtils.selectMess(moduleJPanel, "是否保存到数据库？")) {
					if (seriallized()) {
						JOptionPaneUtils.warningMess(moduleJPanel, "已添加到数据库中");
						jTabbedPane.remove(moduleJPanel);
					} else {
						JOptionPaneUtils.warningMess(moduleJPanel, "未添加到数据库中");
					}
				} else {
					jTabbedPane.remove(moduleJPanel);
				}
			}
		});
	}

	/**
	 * 将对象序列化保存
	 * 
	 * @param serializableObject
	 */
	private boolean seriallized() {
		return SerializeUtils.seriallized(needSavePanel, needSavePanel, needSavePanel.getChiName(),
				needSavePanel.getLastName());
	}
}
