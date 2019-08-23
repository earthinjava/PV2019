package com.duan.module.calculate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;

import javax.swing.JTabbedPane;
import javax.swing.table.TableColumnModel;

import com.duan.component.TabbedHeadPanel;
import com.duan.component.tablebutton.MyJTable;
import com.duan.component.tablebutton.MyTableRenderAndEditor;
import com.duan.module.heatexchanger.beu.BEUExchangerModulePanel;
import com.duan.module.heatexchanger.sprialPlate.jpanel.SprialPlateHeatExchangerJPanel;
import com.duan.module.opening.OpengingMedulePanel;
import com.duan.module.weightAndVolume.HeadAndShellShowPanel;
import com.duan.utils.Constant;
import com.duan.utils.DateUtils;
import com.duan.utils.FileUtils;
import com.duan.utils.FontUtils;
import com.duan.utils.JOptionPaneUtils;
import com.duan.utils.SerializeUtils;

public class CalculateDao {
	/**
	 * 输入汉语名称，返回模式名称
	 * 
	 * @param chiName 汉语名称
	 * @return
	 */
	public static String getModulePanelName(String chiName) {
		if (chiName.equals(Constant.MODULE_CHINAME[0])) {
			return OpengingMedulePanel.class.getSimpleName();
		} else if (chiName.equals(Constant.MODULE_CHINAME[1])) {
			return BEUExchangerModulePanel.class.getSimpleName();
		} else if (chiName.equals(Constant.MODULE_CHINAME[2])) {
			return SprialPlateHeatExchangerJPanel.class.getSimpleName();
		} else if (chiName.equals(Constant.MODULE_CHINAME[3])) {
			return HeadAndShellShowPanel.class.getSimpleName();
		} else {
			return null;
		}
	}

	/**
	 * 获得所有的计算类型的文件夹名称
	 * 
	 * @return
	 */
	public static String[] getCalTypeList() {
		return new File(Constant.SERIALIZEFOLDER_PATH).list();
	}

	/**
	 * 获得输入的计算类型里的文件
	 * 
	 * @param calType
	 * @return
	 */
	public static String[] getCalFiles(String calType) {
		return new File(Constant.SERIALIZEFOLDER_PATH + "/" + calType).list();
	}

	/**
	 * 获得输入类型的计算文件table
	 * 
	 * @param calType
	 * @return
	 */
	public static MyJTable getCalTypeTable(String calType, SelectCalculateFrame frame, JTabbedPane tabbedPane) {
		String type = getModulePanelName(calType);
		if (type == null) {
			return null;
		}
		// 获得此计算类型的所有文件名称带后缀
		String[] files = getCalFiles(calType);
		String[][] tableContentStrings;
		MyJTable calsTable;
		String[] tableHeader = new String[] { "序号", "文件名称", "最后编辑日期", "", "" };
		if (files != null && files.length > 0) {
			tableContentStrings = new String[files.length][5];
			int i = 0;
			for (String f : files) {
				String fileName = f.substring(0, f.lastIndexOf("."));
				File file = new File(Constant.SERIALIZEFOLDER_PATH + "/" + calType + "/" + f);
				tableContentStrings[i][0] = i + 1 + "";
				tableContentStrings[i][1] = fileName;
				tableContentStrings[i][2] = DateUtils.parseDateToStringSecond(new Date(file.lastModified()));
				tableContentStrings[i][3] = i + 1 + "";
				tableContentStrings[i][4] = i + 1 + "";
				i++;
			}
			calsTable = new MyJTable(tableContentStrings, tableHeader);
			// 查询按钮
			MyTableRenderAndEditor queryButton = new MyTableRenderAndEditor("查询");
			queryButton.getButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					// 1.反序列化获得bean文件
					String fileName = calsTable.getValueAt(queryButton.getButton().getRow(), 1) + "";
					String filePath = Constant.SERIALIZEFOLDER_PATH + "/" + calType + "/" + fileName + "." + type;
					File file = new File(filePath);
					Object object = SerializeUtils.deSerializable(file, queryButton.getButton());
					HaveNeedSavePanel modulePanel = null;
					// 显示新窗体
					if (object instanceof OpengingMedulePanel) {
						modulePanel = (OpengingMedulePanel) object;
					} else if (object instanceof BEUExchangerModulePanel) {
						modulePanel = (BEUExchangerModulePanel) object;
					} else if (object instanceof HeadAndShellShowPanel) {
						modulePanel = (HeadAndShellShowPanel) object;
					} else if (object instanceof SprialPlateHeatExchangerJPanel) {
						modulePanel = (SprialPlateHeatExchangerJPanel) object;
					}
					// 设置panel
					String title = fileName + " 保存于:" + DateUtils.parseDateToStringDay(new Date(file.lastModified()));
					frame.dispose();
					// 添加一个选项卡
					tabbedPane.addTab(title, null, modulePanel, null);
					FontUtils.setDefaultFont(tabbedPane);
					// 设置选项卡头部和显示面板的对应关系
					tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(modulePanel),
							new TabbedHeadPanel(title, tabbedPane, modulePanel, modulePanel));
					// 自动跳到新添加的选项面板
					tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
				}
			});
			// 删除按钮
			MyTableRenderAndEditor delButton = new MyTableRenderAndEditor("删除");
			delButton.getButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String fileName = calsTable.getValueAt(delButton.getButton().getRow(), 1) + "";
					String filePath = Constant.SERIALIZEFOLDER_PATH + "/" + calType + "/" + fileName + "." + type;
					if (JOptionPaneUtils.selectMess(frame, "确认删除此文件？")) {
						FileUtils.deleteFile(filePath);
						frame.refreshTable(tabbedPane);
					}
				}
			});
			// 添加查询与删除按钮
			TableColumnModel tc = calsTable.getColumnModel();
			tc.getColumn(3).setCellEditor(queryButton);
			tc.getColumn(3).setCellRenderer(queryButton);
			tc.getColumn(4).setCellEditor(delButton);
			tc.getColumn(4).setCellRenderer(delButton);
			calsTable.setUneditable(new int[] { 0, 1, 2 });
		} else {
			tableContentStrings = new String[0][5];
			calsTable = new MyJTable(tableContentStrings, tableHeader);
		}
		calsTable.getColumnModel().getColumn(0).setPreferredWidth(8);
		calsTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		calsTable.getColumnModel().getColumn(2).setPreferredWidth(120);
		calsTable.getColumnModel().getColumn(3).setPreferredWidth(40);
		calsTable.getColumnModel().getColumn(4).setPreferredWidth(40);
		calsTable.setRowHeight(23);
		FontUtils.setDefaultFont(calsTable.getTableHeader());
		FontUtils.setDefaultFont(calsTable);
		return calsTable;
	}
}
