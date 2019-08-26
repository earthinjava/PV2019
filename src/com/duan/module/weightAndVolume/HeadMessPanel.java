package com.duan.module.weightAndVolume;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import com.duan.component.PureNumField;
import com.duan.component.meterial.MeterialButton;
import com.duan.meterial.Meterial;
import com.duan.utils.Constant;
import com.duan.utils.JOptionPaneUtils;
import com.duan.utils.LabelAndFieldUtils;
import com.duan.utils.PanelUtils;
import com.duan.vessel.head.EHA;
import com.duan.vessel.head.Head;

public class HeadMessPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private PureNumField longAxisIDTextField;
	private PureNumField formingThickTextField;
	private JComboBox<String> headTypeComboBox;
	private JLabel weightLable;
	private JLabel interVolumeLable;
	private JLabel densityLable;
	private JLabel shortAxisIDJLabel;
	private JLabel strLengthJLabel;
	private JLabel outletHeightLabel;
	private JLabel inletHeightLabel;
	private JLabel shortlabel;
	private MeterialButton meterialButton;
	private JButton button;
	private JLabel longlabel;

	public HeadMessPanel() {		
		setLayout(null);
		setBackground(SystemColor.menu);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setSize(215, 380);
		setToolTipText("\u5C01\u5934\u91CD\u91CF");		

		longlabel = new JLabel("\u957F\u8F74\u5185\u5F84");
		longlabel.setBounds(10, 74, 66, 15);
		add(longlabel);

		JLabel label_1 = new JLabel("\u6210\u578B\u539A\u5EA6");
		label_1.setBounds(10, 158, 66, 15);
		add(label_1);

		JLabel label_2 = new JLabel("\u5185\u5BB9\u79EF");
		label_2.setBounds(10, 284, 66, 15);
		add(label_2);

		JLabel label_3 = new JLabel("\u6750\u6599\u5BC6\u5EA6");
		label_3.setBounds(10, 192, 66, 15);
		add(label_3);

		JLabel label_4 = new JLabel("\u91CD\u91CF");
		label_4.setBounds(10, 316, 66, 15);
		add(label_4);

		longAxisIDTextField = new PureNumField();
		longAxisIDTextField.setBounds(74, 71, 81, 20);
		add(longAxisIDTextField);

		formingThickTextField = new PureNumField();
		formingThickTextField.setBounds(74, 155, 81, 20);
		add(formingThickTextField);

		button = new JButton("\u8BA1\u7B97");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				apply();
			}
		});
		button.setBounds(10, 341, 195, 23);
		add(button);

		JLabel label_5 = new JLabel("\u5C01\u5934\u7C7B\u578B");
		label_5.setBounds(10, 13, 66, 15);
		add(label_5);

		JLabel label_6 = new JLabel("mm");
		label_6.setBounds(165, 74, 28, 15);
		add(label_6);

		JLabel label_7 = new JLabel("mm");
		label_7.setBounds(165, 158, 28, 15);
		add(label_7);

		JLabel lblKg = new JLabel("kg");
		lblKg.setBounds(165, 316, 18, 15);
		add(lblKg);

		JLabel lblM = new JLabel("m\u00B3");
		lblM.setBounds(165, 284, 18, 15);
		add(lblM);

		JLabel lblTm = new JLabel("t/m\u00B3");
		lblTm.setBounds(165, 192, 28, 15);
		add(lblTm);

		headTypeComboBox = new JComboBox<String>();
		headTypeComboBox.setModel(new DefaultComboBoxModel<String>(Constant.HEAD_TYPES));
		headTypeComboBox.setBounds(74, 9, 81, 20);
		add(headTypeComboBox);
		headTypeComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (headTypeComboBox.getSelectedIndex() == 1) {
					longlabel.setText("长轴外径");
					shortlabel.setText("短轴外径");
				} else if (headTypeComboBox.getSelectedIndex() == 0) {
					longlabel.setText("长轴内径");
					shortlabel.setText("短轴内径");
				}
			}
		});

		JLabel label_8 = new JLabel("\u5C01\u5934\u6750\u6599");
		label_8.setBounds(10, 42, 66, 15);
		add(label_8);

		meterialButton = new MeterialButton();
		meterialButton.setBounds(74, 38, 81, 20);
		add(meterialButton);

		densityLable =meterialButton.getDensityLabel();
		densityLable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		densityLable.setBounds(74, 186, 81, 20);
		add(densityLable);

		interVolumeLable = new JLabel("");
		interVolumeLable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		interVolumeLable.setBounds(74, 278, 81, 20);
		add(interVolumeLable);

		weightLable = new JLabel("");
		weightLable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		weightLable.setBounds(74, 309, 81, 20);
		add(weightLable);

		shortlabel = new JLabel("\u77ED\u8F74\u5185\u5F84");
		shortlabel.setBounds(10, 102, 66, 15);
		add(shortlabel);

		shortAxisIDJLabel = new JLabel();
		shortAxisIDJLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		shortAxisIDJLabel.setBounds(74, 99, 81, 20);
		add(shortAxisIDJLabel);

		JLabel label_10 = new JLabel("mm");
		label_10.setBounds(165, 102, 28, 15);
		add(label_10);

		JLabel label_11 = new JLabel("\u76F4\u8FB9\u957F\u5EA6");
		label_11.setBounds(10, 130, 66, 15);
		add(label_11);

		strLengthJLabel = new JLabel();
		strLengthJLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		strLengthJLabel.setBounds(74, 127, 81, 20);
		add(strLengthJLabel);

		JLabel label_12 = new JLabel("mm");
		label_12.setBounds(165, 130, 28, 15);
		add(label_12);

		JLabel label_13 = new JLabel("\u5185\u6DF1\u9AD8\u5EA6");
		label_13.setBounds(10, 220, 66, 15);
		add(label_13);

		JLabel label_14 = new JLabel("mm");
		label_14.setBounds(165, 220, 28, 15);
		add(label_14);

		JLabel label_15 = new JLabel("\u5916\u4F38\u9AD8\u5EA6");
		label_15.setBounds(10, 253, 66, 15);
		add(label_15);

		JLabel label_16 = new JLabel("mm");
		label_16.setBounds(165, 251, 28, 15);
		add(label_16);

		inletHeightLabel = new JLabel("");
		inletHeightLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		inletHeightLabel.setBounds(74, 216, 81, 20);
		add(inletHeightLabel);

		outletHeightLabel = new JLabel("");
		outletHeightLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		outletHeightLabel.setBounds(74, 246, 81, 20);
		add(outletHeightLabel);
		PanelUtils.setAllComFont(this);
	}
	
	public void apply() {

		try {
			String type = headTypeComboBox.getSelectedItem() + "";
			Meterial meterial = meterialButton.getSelectedMeterial();
			if (meterial == null) {
				JOptionPaneUtils.warningMess(button, "请先选择材料");
				return;
			}
			double longId = longAxisIDTextField.getDoubleNoNull("请输入" + longlabel.getText());
			if (longId == Constant.ERROR_DOUBLE) {
				return;
			}
			double strLength;
			double formingThick = formingThickTextField.getDoubleNoNull("请输入成型厚度");
			if (formingThick == Constant.ERROR_DOUBLE) {
				return;
			}
			Head head = (Head) Class.forName(EHA.class.getPackage().getName() + "." + type).getConstructor()
					.newInstance();
			if (longId > 2000) {
				strLength = 40;
			} else {
				strLength = 25;
			}					
			head.setFormingThick(formingThick);
			head.setMeterial(meterial);
			head.setStrLength(strLength);
			head.setLongID(longId);
			head.setShortID(longId / 2);					
			LabelAndFieldUtils.showDoublePointFive(interVolumeLable, head.getInletVolume());
			LabelAndFieldUtils.showDoublePointFive(inletHeightLabel, head.getInletHeight());
			LabelAndFieldUtils.showDoublePointFive(outletHeightLabel, head.getOutletHeight());
			LabelAndFieldUtils.showDoublePointFive(shortAxisIDJLabel, longId / 2);
			LabelAndFieldUtils.showDoublePointFive(strLengthJLabel, strLength);
			LabelAndFieldUtils.showDoublePointTwo(weightLable, head.getWeight());
			LabelAndFieldUtils.showDoublePointTwo(densityLable, meterial.getDensity());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (NoSuchMethodException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}

	
	}
}
