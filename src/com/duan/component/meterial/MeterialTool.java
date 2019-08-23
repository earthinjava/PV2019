package com.duan.component.meterial;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import com.duan.meterial.MeterialDao;
import com.duan.utils.Constant;
import com.duan.utils.FileUtils;
import com.duan.utils.FontUtils;

public class MeterialTool {

	private JComboBox<String> meterialTypeBox;// 材料类型箱子
	private MeterialStandardBox meterialStandardsBox;// 所有的材料标准箱子
	private ConformStandardMeterialsBox conformStandardMeterialsBox;// 符合材料标准的所有材料箱子
	private JList<String> conformStandardMeterialslist;// 符合材料标准的所有材料列表
	private JScrollPane meterialsScrollPane;// 材料显示卷轴面板
	private JLabel nameLabel; // 材料名称标签
	private JLabel typeLabel;// 材料类型标签
	private JLabel meterialComponentLabel;// 材料组分标签

	/**
	 * 创建一个材料选择按钮
	 * 
	 * @param firstStandType 首选项，1先显示管，2先显示锻件，其他先显示板材
	 */
	public MeterialTool(int firstStandType) {
		nameLabel = new JLabel();
		typeLabel = new JLabel();
		meterialComponentLabel = new JLabel();
		if (firstStandType < 0 || firstStandType >= Constant.METERIALTYPES.length) {
			firstStandType = 0;
		}
		// 材料类型箱子
		meterialTypeBox = new JComboBox<String>();
		meterialTypeBox.setModel(new DefaultComboBoxModel<String>(Constant.METERIALTYPES));
		meterialTypeBox.setSelectedIndex(firstStandType);
		FontUtils.setDefaultFont(meterialTypeBox);
		// 材料标准箱子
		meterialStandardsBox = new MeterialStandardBox(nameLabel, typeLabel, meterialComponentLabel,
				meterialTypeBox.getSelectedIndex());
		// 符合材料标准的箱子
		conformStandardMeterialsBox = new ConformStandardMeterialsBox(meterialStandardsBox.getSelectedStand());
		// 材料列表
		conformStandardMeterialslist = creatNewJList();
		// 材料滚轴
		meterialsScrollPane = new JScrollPane();
		meterialsScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		meterialsScrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		meterialsScrollPane.setViewportView(conformStandardMeterialslist);
		// 材料类型该表，则该表材料标准箱内容
		meterialTypeBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				meterialStandardsBox.changeType(meterialTypeBox.getSelectedIndex());
			}
		});
		// 材料标准改变则该表材料内容
		meterialStandardsBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				conformStandardMeterialsBox.setMeterialStandard(meterialStandardsBox.getSelectedStand());
				conformStandardMeterialslist = creatNewJList();
				meterialsScrollPane.setViewportView(conformStandardMeterialslist);
			}
		});

	}

	/**
	 * 
	 * @return
	 */
	private JList<String> creatNewJList() {
		JList<String> list = new JList<String>(new MylistModel());
		FontUtils.setDefaultFont(list);
		DefaultListCellRenderer renderer = new DefaultListCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.RIGHT);
		list.setCellRenderer(renderer);
		list.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		return list;
	}

	public JScrollPane getMeterialsScrollPane() {
		return meterialsScrollPane;
	}

	public MeterialStandardBox getMeterialStandardsBox() {
		return meterialStandardsBox;
	}

	public ConformStandardMeterialsBox getConformStandardMeterialsBox() {
		return conformStandardMeterialsBox;
	}

	public JComboBox<String> getMeterialTypeBox() {
		return meterialTypeBox;
	}

	public JList<String> getConformStandardMeterialslist() {
		return conformStandardMeterialslist;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}

	public JLabel getTypeLabel() {
		return typeLabel;
	}

	public void setTypeLabel(JLabel typeLabel) {
		this.typeLabel = typeLabel;
	}

	public JLabel getMeterialComponentLabel() {
		return meterialComponentLabel;
	}

	public void setMeterialComponentLabel(JLabel meterialComponentLabel) {
		this.meterialComponentLabel = meterialComponentLabel;
	}

	/**
	 * 根据选择的材料标准显示材料的列表模式
	 * 
	 * @author Administrator
	 *
	 */
	class MylistModel extends AbstractListModel<String> {

		private static final long serialVersionUID = 1L;

		@Override
		public String getElementAt(int index) {
			// TODO Auto-generated method stub
			return conformStandardMeterialsBox.getConformStandardMeterials().get(index).getName() + "--"
					+ FileUtils.getLastModifiedTime(
							new MeterialDao(conformStandardMeterialsBox.getConformStandardMeterials().get(index))
									.getFilePath());
		}

		@Override
		public int getSize() {
			// TODO Auto-generated method stub
			if (conformStandardMeterialsBox.getConformStandardMeterials() != null) {
				return conformStandardMeterialsBox.getConformStandardMeterials().size();
			}
			return 0;
		}

	}
}
