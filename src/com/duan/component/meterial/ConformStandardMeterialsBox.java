package com.duan.component.meterial;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import com.duan.meterial.Meterial;
import com.duan.meterial.MeterialDao;
import com.duan.meterialstandard.MeterialStandard;
import com.duan.utils.FontUtils;

public class ConformStandardMeterialsBox extends JComboBox<String> {

	private static final long serialVersionUID = -8746963017253772432L;
	private ArrayList<Meterial> conformStandardMeterials;

	/**
	 * 显示符合材料标准的材料下拉选项
	 * 
	 * @param meterialStandard 所选择的材料标准
	 */
	public ConformStandardMeterialsBox(MeterialStandard meterialStandard) {
		setModel(new DefaultComboBoxModel<String>());
		setSize(150, 20);
		FontUtils.setDefaultFont(this);
		setMeterialStandard(meterialStandard);
	}

	/**
	 * 设置材料标准
	 * 
	 * @param meterialStandard
	 */
	public void setMeterialStandard(MeterialStandard meterialStandard) {
		removeAllItems();
		conformStandardMeterials = MeterialDao.getConformStandardMeterials(meterialStandard);
		if (conformStandardMeterials != null) {
			for (Meterial m : conformStandardMeterials) {
				if (m != null && m.getName() != null) {
					addItem(m.getName());
				}
			}
		}
	}

	/**
	 * 获得所选择的材料
	 * 
	 * @return
	 */
	public Meterial getSelctedMeterial() {
		int i = getSelectedIndex();
		if (conformStandardMeterials != null && i >= 0) {
			return conformStandardMeterials.get(i);
		}
		return null;
	}

	/**
	 * 获得符合所选定的材料标准的所有材料
	 * 
	 * @return
	 */
	public ArrayList<Meterial> getConformStandardMeterials() {
		return conformStandardMeterials;
	}

}
