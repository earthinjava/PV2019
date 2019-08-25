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
	private PureNumField stressField;
	private Meterial meterial;
	private JLabel densityLabel;
	private JLabel nThickLabel;
	private PureNumField nThickField;
	private PureNumField designTempField;
	private int firstStandardType;
	private PureNumField shellDesignTempField;
	private PureNumField tubeDesignTempField;
	private StressActionPerformed stressActionPerformed;

	/**
	 * 材料选择按钮，可获得材料的基本属性和许用应力
	 */
	public MeterialButton() {
		// TODO 自动生成的构造函数存根
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
		stressActionPerformed=new StressActionPerformed();
		addActionListener(stressActionPerformed);
	}

	/**
	 * 
	 * @author Administrator
	 *
	 */
	class StressActionPerformed implements ActionListener, Serializable {
		private static final long serialVersionUID = 6290658729157340225L;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			new SlectMeterialFrame((MeterialButton) e.getSource());
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
			// TODO Auto-generated method stub
			double t1 = shellDesignTempField.getDoubleCanNull();
			double t2 = tubeDesignTempField.getDoubleCanNull();
			SlectMeterialFrame meterialFrame;
			if (t1 > t2) {
				designTempField = shellDesignTempField;
				meterialFrame = new SlectMeterialFrame((MeterialButton) e.getSource());
				meterialFrame.start();
			} else {
				designTempField = tubeDesignTempField;
				meterialFrame = new SlectMeterialFrame((MeterialButton) e.getSource());
				meterialFrame.start();
			}
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

	public Meterial getMeterial() {
		return meterial;
	}

	public void setMeterial(Meterial meterial) {
		this.meterial = meterial;
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
