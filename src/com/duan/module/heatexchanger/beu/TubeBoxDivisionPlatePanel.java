package com.duan.module.heatexchanger.beu;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import com.duan.component.PureNumField;
import com.duan.component.ResultLabel;
import com.duan.component.image.BoxChangeImgPanel;
import com.duan.component.meterial.MeterialButton;
import com.duan.meterial.Meterial;
import com.duan.module.heatexchanger.beu.bean.BEUHeatExchanger;
import com.duan.module.heatexchanger.beu.bean.structural.TubeBoxDivisionPlate;
import com.duan.utils.Constant;
import com.duan.utils.JOptionPaneUtils;
import com.duan.utils.LabelAndFieldUtils;
import com.duan.utils.PanelUtils;

public class TubeBoxDivisionPlatePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private PureNumField c2Field;
	private PureNumField c1Field;
	private PureNumField sizeBField;
	private PureNumField sizeAField;
	private PureNumField nThickField;
	private PureNumField idField;
	private PureNumField diffPressField;
	private PureNumField stressField;
	private MeterialButton meterialButton;

	public TubeBoxDivisionPlatePanel(BEUHeatExchanger beuHeatExchanger, HeatDesignContionPanel heatDesignContionPanel) {

		setBackground(Color.WHITE);
		setToolTipText("");
		setBorder(null);
		setSize(779, 631);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(5, 5, 210, 430);
		add(panel);
		panel.setLayout(null);

		JLabel label_1 = new JLabel("\u9694\u677F\u56FA\u5B9A\u65B9\u5F0F");
		label_1.setBounds(10, 10, 89, 20);
		panel.add(label_1);

		JLabel label_2 = new JLabel("\u7BA1\u7BB1\u5185\u5F84");
		label_2.setBounds(10, 40, 74, 20);
		panel.add(label_2);

		JLabel label_3 = new JLabel("\u9694\u677F\u540D\u4E49\u539A\u5EA6");
		label_3.setBounds(10, 70, 89, 20);
		panel.add(label_3);

		JLabel lbla = new JLabel("\u5C3A\u5BF8a");
		lbla.setBounds(10, 100, 74, 20);
		panel.add(lbla);

		JLabel lblb = new JLabel("\u5C3A\u5BF8b");
		lblb.setBounds(10, 130, 74, 20);
		panel.add(lblb);

		JLabel label_6 = new JLabel("\u9694\u677F\u6750\u6599");
		label_6.setBounds(10, 160, 74, 20);
		panel.add(label_6);

		JLabel label_7 = new JLabel("\u9694\u677F\u8150\u8680\u88D5\u91CF");
		label_7.setBounds(10, 220, 97, 20);
		panel.add(label_7);

		JLabel label_8 = new JLabel("\u9694\u677F\u8D1F\u504F\u5DEE");
		label_8.setBounds(10, 250, 74, 20);
		panel.add(label_8);

		JLabel label_9 = new JLabel("\u9694\u677F\u8BB8\u7528\u5E94\u529B");
		label_9.setBounds(10, 280, 89, 20);
		panel.add(label_9);

		JLabel label_11 = new JLabel("\u9694\u677F\u6700\u5C0F\u539A\u5EA6");
		label_11.setBounds(10, 310, 89, 20);
		panel.add(label_11);

		JLabel label_12 = new JLabel("\u9694\u677F\u8BA1\u7B97\u539A\u5EA6");
		label_12.setBounds(10, 340, 97, 20);
		panel.add(label_12);

		JLabel label_13 = new JLabel("\u7ED3\u679C");
		label_13.setBounds(10, 370, 74, 20);
		panel.add(label_13);

		JButton button = new JButton("\u5E94\u7528");
		button.setBackground(SystemColor.menu);
		button.setBounds(10, 400, 190, 23);
		panel.add(button);

		JLabel calThickLabel = new JLabel("");
		calThickLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		calThickLabel.setBounds(109, 340, 66, 20);
		panel.add(calThickLabel);

		c2Field = new PureNumField();
		c2Field.setText("0.3");
		c2Field.setBounds(109, 250, 66, 20);
		panel.add(c2Field);

		c1Field = new PureNumField();
		c1Field.setText("1.0");
		c1Field.setBounds(109, 220, 66, 20);
		panel.add(c1Field);

		sizeBField = new PureNumField();
		sizeBField.setBounds(109, 130, 66, 20);
		panel.add(sizeBField);

		sizeAField = new PureNumField();
		sizeAField.setBounds(109, 100, 66, 20);
		panel.add(sizeAField);

		idField = new PureNumField();
		idField.setBounds(109, 40, 66, 20);
		panel.add(idField);

		BoxChangeImgPanel boxChangeImgPanel = new BoxChangeImgPanel(Constant.BEUDIVIDEPLATE_TYPE,
				Constant.BEUDIVIDEPLATE_TYPE_IMGPATH, 220, 5, 453, 430, false);
		add(boxChangeImgPanel);
		JComboBox<String> typeBox = boxChangeImgPanel.getBox();
		typeBox.setBounds(109, 10, 84, 20);
		panel.add(typeBox);

		JLabel label_17 = new JLabel("mm");
		label_17.setBounds(176, 40, 26, 20);
		panel.add(label_17);

		JLabel label_18 = new JLabel("mm");
		label_18.setBounds(176, 70, 26, 20);
		panel.add(label_18);

		JLabel label_19 = new JLabel("mm");
		label_19.setBounds(176, 100, 26, 20);
		panel.add(label_19);

		JLabel label_20 = new JLabel("mm");
		label_20.setBounds(176, 130, 26, 20);
		panel.add(label_20);

		JLabel label_21 = new JLabel("mm");
		label_21.setBounds(176, 220, 26, 20);
		panel.add(label_21);

		JLabel label_22 = new JLabel("mm");
		label_22.setBounds(176, 250, 26, 20);
		panel.add(label_22);

		JLabel label_23 = new JLabel("Mpa");
		label_23.setBounds(176, 280, 26, 20);
		panel.add(label_23);

		JLabel label_25 = new JLabel("mm");
		label_25.setBounds(176, 310, 26, 20);
		panel.add(label_25);

		JLabel label_26 = new JLabel("mm");
		label_26.setBounds(176, 340, 26, 20);
		panel.add(label_26);

		JLabel label_10 = new JLabel("\u9694\u677F\u4E24\u4FA7\u538B\u529B\u5DEE");
		label_10.setBounds(10, 190, 109, 20);
		panel.add(label_10);

		diffPressField = new PureNumField();
		diffPressField.setBounds(109, 190, 66, 20);
		panel.add(diffPressField);

		JLabel label_14 = new JLabel("Mpa");
		label_14.setBounds(176, 190, 26, 20);
		panel.add(label_14);

		meterialButton = new MeterialButton();
		meterialButton.setLocation(109, 160);
		panel.add(meterialButton);
		
		meterialButton.setDesignTempField(heatDesignContionPanel.getTubeDesignTempField());

		nThickField = meterialButton.getnThickField();
		nThickField.setBounds(109, 70, 66, 20);
		panel.add(nThickField);

		ResultLabel resultLabel = new ResultLabel();
		resultLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		resultLabel.setBounds(109, 370, 66, 20);
		resultLabel.setActualField(nThickField);
		panel.add(resultLabel);

		JLabel minThickLabel = resultLabel.getRequiredLabel();
		minThickLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		minThickLabel.setBounds(109, 310, 66, 20);
		panel.add(minThickLabel);

		stressField = meterialButton.getStressField();
		stressField.setBounds(109, 280, 66, 20);
		panel.add(stressField);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				beuHeatExchanger.setTubeBoxDivisionPlate(null);
				double id = idField.getDoubleNoNull("请输入内径");
				if (id == Constant.ERROR_DOUBLE) {
					return;
				}
				double nThick = nThickField.getDoubleNoNull("请输入名义厚度");
				if (nThick == Constant.ERROR_DOUBLE) {
					return;
				}
				double sizeA = sizeAField.getDoubleNoNull("请输入尺寸a");
				if (sizeA == Constant.ERROR_DOUBLE) {
					return;
				}
				double sizeB = sizeBField.getDoubleNoNull("请输入尺寸b");
				if (sizeB == Constant.ERROR_DOUBLE) {
					return;
				}
				double pressDifference = diffPressField.getDoubleNoNull("请输入设计压差");
				if (pressDifference == Constant.ERROR_DOUBLE) {
					return;
				}
				double c1 = c1Field.getDoubleNoNull("请输入腐蚀裕量");
				if (c1 == Constant.ERROR_DOUBLE) {
					return;
				}
				double c2 = c2Field.getDoubleNoNull("请输入厚度负偏差");
				if (c2 == Constant.ERROR_DOUBLE) {
					return;
				}
				double stress = stressField.getDoubleNoNull("请输入许用应力");
				if (stress == Constant.ERROR_DOUBLE) {
					return;
				}
				Meterial m = meterialButton.getMeterial();
				if (m == null) {
					JOptionPaneUtils.warningMess(button, "请选择材料");
					return;
				}
				int type = typeBox.getSelectedIndex();
				TubeBoxDivisionPlate tubeBoxDivisionPlate = new TubeBoxDivisionPlate(type, id, nThick, sizeA, sizeB, m,
						pressDifference, c1, c2, stress);
				beuHeatExchanger.setTubeBoxDivisionPlate(tubeBoxDivisionPlate);
				LabelAndFieldUtils.showDoublePointTwo(minThickLabel, tubeBoxDivisionPlate.getMinReThick());
				LabelAndFieldUtils.showDoublePointTwo(calThickLabel, tubeBoxDivisionPlate.getCalthick());
				if (tubeBoxDivisionPlate.getCalthick() == 0) {
					JOptionPaneUtils.warningMess(stressField, "计算厚度为0");
				}
				resultLabel.showResult();
			}
		});
		PanelUtils.setAllComFont(panel);
	}
}
