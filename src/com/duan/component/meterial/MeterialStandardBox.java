package com.duan.component.meterial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import com.duan.meterialstandard.MeterialStandard;
import com.duan.meterialstandard.MeterialStandardDAO;
import com.duan.utils.DateUtils;
import com.duan.utils.FontUtils;

public class MeterialStandardBox extends JComboBox<String> {

	private static final long serialVersionUID = 1L;
	private MeterialStandard selectedStand;
	private ArrayList<MeterialStandard> meterialStandards;
	private JLabel nameLabel;
	private JLabel typeLabel;
	private JLabel meterialComponentLabel;

	/**
	 * 
	 * @param nameLabel              标准名称
	 * @param typeLabel              标准类型，板，管，锻件
	 * @param meterialComponentLabel 材料组分，碳钢，铜，钛等
	 * @param showType               显示模式，0，显示板，1显示管件，2显示锻件
	 * @param firstType              最先显示的模式 ：2，先显示管件，3先显示锻件，1及先显示板材 其他先显示板材
	 */
	public MeterialStandardBox(JLabel nameLabel, JLabel typeLabel, JLabel meterialComponentLabel, int showType) {
		setModel(new DefaultComboBoxModel<String>());
		setSize(150, 20);
		FontUtils.setDefaultFont(this);
		this.nameLabel = nameLabel;
		this.typeLabel = typeLabel;
		this.meterialComponentLabel = meterialComponentLabel;
		addItems(showType);
		showNameAndType();
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showNameAndType();
			}
		});
	}

	/**
	 * 获得当前所选择的材料标准
	 * 
	 * @return
	 */
	public MeterialStandard getSelectedStand() {
		int i = getSelectedIndex();
		if (meterialStandards != null && i >= 0) {
			selectedStand = meterialStandards.get(i);
			return selectedStand;
		}
		return null;
	}

	/**
	 * 显示标准名称，类型，材料组分
	 */
	private void showNameAndType() {
		if (nameLabel != null && getSelectedStand() != null) {
			nameLabel.setText(getSelectedStand().getName());
		} else if (nameLabel != null) {
			nameLabel.setText("");
		}
		if (typeLabel != null && getSelectedStand() != null) {
			typeLabel.setText(new MeterialStandardDAO(getSelectedStand()).getTypeString());
		} else if (typeLabel != null) {
			typeLabel.setText("");
		}
		if (meterialComponentLabel != null && getSelectedStand() != null) {
			meterialComponentLabel.setText(getSelectedStand().getProperty().getMeterialComponent());
		} else if (meterialComponentLabel != null) {
			meterialComponentLabel.setText("");
		}
	}

	/**
	 * 
	 * @param showType 1，返回板材 2返回管材，3返回锻件,大于3返回所有
	 */
	void addItems(int showType) {
		removeAllItems();
		meterialStandards = MeterialStandardDAO.getConformTypeMeterialStandards(this, showType);
		if (meterialStandards != null && meterialStandards.size() > 0) {
			int l = 0;
			for (MeterialStandard m : meterialStandards) {// 找到文字长度最长的标准
				int size = m.getStandardNum().length();
				if (size > l) {
					l = size;
				}
			}
			for (MeterialStandard m : meterialStandards) {
				int thisSize = m.getStandardNum().length();
				String space = " ";
				String s = " ";
				for (int i = 0; i < l - thisSize; i++) {// 若果比最长的短，则添加空格
					space += s;
				}
				addItem(m.getStandardNum() + space + DateUtils.parseDateToStringMonth(m.getImplementationDate()));
			}
		}
	}

}
