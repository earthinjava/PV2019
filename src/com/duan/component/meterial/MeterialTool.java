package com.duan.component.meterial;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

import com.duan.meterial.Meterial;
import com.duan.meterial.MeterialDao;
import com.duan.meterialstandard.MeterialStandard;
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
		meterialTypeBox = new JComboBox<String>();// 材料类型箱子
		meterialTypeBox.setModel(new DefaultComboBoxModel<String>(Constant.METERIALTYPES));
		meterialTypeBox.setSelectedIndex(firstStandType);
		FontUtils.setDefaultFont(meterialTypeBox);
		meterialStandardsBox = new MeterialStandardBox(nameLabel, typeLabel, meterialComponentLabel,
				meterialTypeBox.getSelectedIndex()); // 材料标准箱子
		setSelectedStandard(meterialStandardsBox.getSelectedStand());
		meterialTypeBox.addActionListener(new ActionListener() {// 材料类型箱子改变，则改变材料标准箱内容
			@Override
			public void actionPerformed(ActionEvent e) {
				meterialStandardsBox.addItems(meterialTypeBox.getSelectedIndex());
			}
		});
		meterialStandardsBox.addActionListener(new ActionListener() { // 材料标准箱子改变，则改变材料内容
			@Override
			public void actionPerformed(ActionEvent e) {
				setSelectedStandard(meterialStandardsBox.getSelectedStand());
			}
		});

	}

	/**
	 * 设置所选择的材料标准
	 * 
	 * @param meterialStandard
	 * @return
	 */
	private void setSelectedStandard(MeterialStandard meterialStandard) {
		if (conformStandardMeterialsBox == null) {
			conformStandardMeterialsBox = new ConformStandardMeterialsBox(meterialStandardsBox.getSelectedStand());
		} else {
			conformStandardMeterialsBox.setMeterialStandard(meterialStandard);
		}
		if (conformStandardMeterialslist == null) {
			conformStandardMeterialslist = new JList<String>(new MylistModel());
			FontUtils.setDefaultFont(conformStandardMeterialslist);
			DefaultListCellRenderer renderer = new DefaultListCellRenderer();
			renderer.setHorizontalAlignment(SwingConstants.RIGHT);
			conformStandardMeterialslist.setCellRenderer(renderer);
			conformStandardMeterialslist.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
		if (meterialsScrollPane == null) {
			meterialsScrollPane = new JScrollPane(); // 材料列表滚轴
			meterialsScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			meterialsScrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		}
		meterialsScrollPane.setViewportView(conformStandardMeterialslist);
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
			ArrayList<Meterial> meterials = conformStandardMeterialsBox.getConformStandardMeterials();
			if (meterials == null) {
				return null;
			}
			Meterial meterial = meterials.get(index);
			if (meterial == null) {
				return null;
			}
			String filePath = new MeterialDao(meterial).getFilePath();
			if(filePath==null) {
				return null;
			}
			return meterial.getName() + "--" + FileUtils.getLastModifiedTime(filePath);
		}

		@Override
		public int getSize() {
			ArrayList<Meterial> meterials = conformStandardMeterialsBox.getConformStandardMeterials();
			if (meterials != null) {
				return meterials.size();
			}
			return 0;
		}

	}
}
