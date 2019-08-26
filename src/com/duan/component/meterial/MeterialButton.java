package com.duan.component.meterial;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.duan.component.PureNumField;
import com.duan.meterial.Meterial;
import com.duan.utils.Constant;
import com.duan.utils.FontUtils;
import com.duan.utils.FrameUtils;
import com.duan.utils.LabelAndFieldUtils;

public class MeterialButton extends JButton {

	private static final long serialVersionUID = 1L;
	private PureNumField stressField;// 许用应力文字域
	private Meterial selectedMeterial;// 所选择的材料
	private JLabel densityLabel;// 密度标签
	private JLabel nThickLabel;// 名义厚度标签
	private PureNumField nThickField;// 名义厚度文字域
	private PureNumField designTempField;// 设计温度文字域
	private int firstStandardType;// 首选标准类型
	private PureNumField shellDesignTempField;// 壳侧设计温度文字域
	private PureNumField tubeDesignTempField;// 管侧设计温度文字域
	private StressActionPerformed stressActionPerformed;// 许用应力执行的操作

	/**
	 * 材料选择按钮，可获得材料的基本属性和许用应力
	 */
	public MeterialButton() {
		setText("请选择");
		setBackground(SystemColor.control);
		setSize(86, 22);
		densityLabel = new JLabel();
		nThickLabel = new JLabel();
		stressField = new PureNumField();
		nThickField = new PureNumField();
		designTempField = new PureNumField();
		stressField.setColumns(10);
		FontUtils.setDefaultFont(this);
		setHorizontalAlignment(SwingConstants.CENTER);
		stressActionPerformed = new StressActionPerformed();
		addActionListener(stressActionPerformed);
	}

	/**
	 * 许用应力执行的操作
	 * 
	 * @author Administrator
	 *
	 */
	class StressActionPerformed implements ActionListener, Serializable {
		private static final long serialVersionUID = 6290658729157340225L;

		@Override
		public void actionPerformed(ActionEvent e) {
			new SelectMeterialFrame((MeterialButton) e.getSource());
		}

	}

	/**
	 * 换热管与管板等的材料选择按钮，,可设置许用应力，设定温度高的为材料许用应力选择条件
	 * 
	 * @param shellDesignTempField
	 * @param tubeDesignTempField
	 * @param nThickField
	 */
	public MeterialButton(PureNumField shellDesignTempField, PureNumField tubeDesignTempField) {
		this();
		this.shellDesignTempField = shellDesignTempField;
		this.tubeDesignTempField = tubeDesignTempField;
		removeActionListener(stressActionPerformed);
		addActionListener(new HeatActionPerformed());
	}

	/**
	 * 换热设备用的监听器
	 * 
	 * @author Administrator
	 *
	 */
	class HeatActionPerformed implements ActionListener, Serializable {
		private static final long serialVersionUID = 6290658729157340225L;

		@Override
		public void actionPerformed(ActionEvent e) {
			double t1 = shellDesignTempField.getDoubleCanNull();
			double t2 = tubeDesignTempField.getDoubleCanNull();
			SelectMeterialFrame meterialFrame;
			if (t1 == Constant.ERROR_DOUBLE && t2 != Constant.ERROR_DOUBLE) {
				designTempField = tubeDesignTempField;
			} else if (t2 == Constant.ERROR_DOUBLE && t1 != Constant.ERROR_DOUBLE) {
				designTempField = shellDesignTempField;
			} else if (t2 == Constant.ERROR_DOUBLE && t1 == Constant.ERROR_DOUBLE) {
				return;
			} else {
				if (t1 > t2) {
					designTempField = shellDesignTempField;
				} else {
					designTempField = tubeDesignTempField;
				}
			}
			meterialFrame = new SelectMeterialFrame((MeterialButton) e.getSource());
			meterialFrame.start();
			// 打开时锁定主窗体
			FrameUtils.clockAndUnclockFatherFrame(shellDesignTempField, meterialFrame);
		}

	}

	/**
	 * 获得名义厚度，根据nThickLabel与nThickField判断
	 * 
	 * @return
	 */
	public double getNThick() {
		double nThick = LabelAndFieldUtils.getDouble(nThickLabel);
		if (nThick != Constant.ERROR_DOUBLE) {
			return nThick;
		}
		nThick = nThickField.getDoubleCanNull();
		if (nThick != Constant.ERROR_DOUBLE) {
			return nThick;
		}
		return Constant.ERROR_DOUBLE;
	}

	public Meterial getSelectedMeterial() {
		return selectedMeterial;
	}

	/**
	 * 设置选择的材料
	 * 
	 * @param meterial
	 */
	public void setSelectedMeterial(Meterial meterial) {
		this.selectedMeterial = meterial;
		if (meterial == null) {
			return;
		}
		setText(meterial.getName());
	}

	public PureNumField getStressField() {
		return stressField;
	}

	public void setStressField(PureNumField stressField) {
		this.stressField = stressField;
	}

	public JLabel getDensityLabel() {
		return densityLabel;
	}

	public void setDensityLabel(JLabel densityLabel) {
		this.densityLabel = densityLabel;
	}

	public PureNumField getnThickField() {
		return nThickField;
	}

	public JLabel getnThickLabel() {
		return nThickLabel;
	}

	public PureNumField getDesignTempField() {
		return designTempField;
	}

	public void setDesignTempField(PureNumField designTempField) {
		this.designTempField = designTempField;
	}

	public int getFirstStandardType() {
		return firstStandardType;
	}

	public void setFirstStandardType(int firstStandardType) {
		this.firstStandardType = firstStandardType;
	}
}
