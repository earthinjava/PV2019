package com.duan.module.weightAndVolume;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import com.duan.vessel.shell.CylinderShell;

public class CylinderShellMessPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private PureNumField iDTextField;
	private PureNumField formingThickTextField;
	private JComboBox<String> typeComboBox;
	private JLabel totalWeightLable;
	private JLabel interVolumeLable;
	private JLabel densityLable;
	private PureNumField lengthField;
	private PureNumField levelHeightField;
	private CylinderShell cylinderShell;
	private MeterialButton meterialButton;

	public CylinderShellMessPanel(CylinderShellTablePanel cylinderShellTablePanel) {

		setBackground(SystemColor.menu);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setSize(215, 315);
		setToolTipText("\u5C01\u5934\u91CD\u91CF");
		setLayout(null);

		JLabel label = new JLabel("\u5185\u5F84");
		label.setBounds(10, 70, 66, 20);
		add(label);

		JLabel label_1 = new JLabel("\u6210\u578B\u539A\u5EA6");
		label_1.setBounds(10, 130, 66, 20);
		add(label_1);

		JLabel label_2 = new JLabel("\u5185\u5BB9\u79EF");
		label_2.setBounds(10, 220, 66, 20);
		add(label_2);

		JLabel label_3 = new JLabel("\u6750\u6599\u5BC6\u5EA6");
		label_3.setBounds(10, 190, 66, 20);
		add(label_3);

		JLabel label_4 = new JLabel("\u603B\u91CD");
		label_4.setBounds(10, 250, 66, 20);
		add(label_4);

		iDTextField = new PureNumField();
		iDTextField.setBounds(74, 70, 81, 20);
		add(iDTextField);

		formingThickTextField = new PureNumField();
		formingThickTextField.setBounds(74, 130, 81, 20);
		add(formingThickTextField);

		JButton button = new JButton("\u8BA1\u7B97");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isHorizontal;
				if (typeComboBox.getSelectedIndex() == 0) {
					isHorizontal = true;
				} else {
					isHorizontal = false;
				}
				Meterial meterial = meterialButton.getMeterial();
				if (meterial == null) {
					JOptionPaneUtils.warningMess(button, "请先选择材料");
					return;
				}
				double id = iDTextField.getDoubleNoNull("请输入筒体内径");
				if (id == Constant.ERROR_DOUBLE) {
					return;
				}
				double length = lengthField.getDoubleNoNull("请输入筒体长度");
				if (length == Constant.ERROR_DOUBLE) {
					return;
				}
				double formingThick = formingThickTextField.getDoubleNoNull("请输入筒体成型厚度");
				if (formingThick == Constant.ERROR_DOUBLE) {
					return;
				}
				double levelHeigt = levelHeightField.getDoubleNoNull("请输入间隔高度");
				if (levelHeigt == Constant.ERROR_DOUBLE) {
					return;
				}
				cylinderShell = new CylinderShell(id, formingThick, meterial, length, isHorizontal);
				LabelAndFieldUtils.showDoublePointTwo(densityLable, cylinderShell.getMeterial().getDensity());
				LabelAndFieldUtils.showDoublePointTwo(interVolumeLable, cylinderShell.getTotalVolume());
				LabelAndFieldUtils.showDoublePointTwo(totalWeightLable, cylinderShell.getWeight());
				cylinderShellTablePanel.showVolumeTable(levelHeigt, cylinderShell);
			}
		});

		button.setBounds(10, 280, 195, 23);
		add(button);

		JLabel label_5 = new JLabel("\u578B\u5F0F");
		label_5.setBounds(10, 10, 66, 20);
		add(label_5);

		JLabel label_6 = new JLabel("mm");
		label_6.setBounds(165, 70, 28, 20);
		add(label_6);

		JLabel label_7 = new JLabel("mm");
		label_7.setBounds(165, 130, 28, 20);
		add(label_7);

		JLabel lblKg = new JLabel("kg");
		lblKg.setBounds(165, 250, 18, 20);
		add(lblKg);

		JLabel lblM = new JLabel("m\u00B3");
		lblM.setBounds(165, 220, 18, 20);
		add(lblM);

		JLabel lblTm = new JLabel("t/m\u00B3");
		lblTm.setBounds(165, 190, 28, 20);
		add(lblTm);

		typeComboBox = new JComboBox<String>();
		typeComboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "\u5367\u5F0F", "\u7ACB\u5F0F" }));
		typeComboBox.setBounds(74, 10, 81, 20);
		add(typeComboBox);

		JLabel label_8 = new JLabel("\u7B52\u4F53\u6750\u6599");
		label_8.setBounds(10, 40, 66, 20);
		add(label_8);

		meterialButton = new MeterialButton();
		meterialButton.setBounds(74, 40, 81, 20);
		add(meterialButton);

		densityLable = meterialButton.getDensityLabel();
		densityLable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		densityLable.setBounds(74, 190, 81, 20);
		add(densityLable);

		interVolumeLable = new JLabel("");
		interVolumeLable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		interVolumeLable.setBounds(74, 220, 81, 20);
		add(interVolumeLable);

		totalWeightLable = new JLabel("");
		totalWeightLable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		totalWeightLable.setBounds(74, 250, 81, 20);
		add(totalWeightLable);

		JLabel label_11 = new JLabel("\u957F\u5EA6");
		label_11.setBounds(10, 100, 66, 20);
		add(label_11);

		lengthField = new PureNumField();
		lengthField.setBounds(74, 100, 81, 20);
		add(lengthField);

		JLabel label_12 = new JLabel("mm");
		label_12.setBounds(165, 100, 28, 20);
		add(label_12);

		JLabel label_9 = new JLabel("\u95F4\u9694\u9AD8\u5EA6");
		label_9.setBounds(10, 160, 66, 20);
		add(label_9);

		levelHeightField = new PureNumField();
		levelHeightField.setBounds(74, 160, 81, 20);
		add(levelHeightField);

		JLabel label_10 = new JLabel("mm");
		label_10.setBounds(165, 160, 28, 20);
		add(label_10);
		PanelUtils.setAllComFont(this);
	}

}
