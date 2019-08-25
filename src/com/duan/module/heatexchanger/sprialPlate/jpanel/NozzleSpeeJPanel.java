package com.duan.module.heatexchanger.sprialPlate.jpanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.duan.component.PureNumField;
import com.duan.module.heatexchanger.sprialPlate.bean.SprialPlateHeatExchanger;
import com.duan.module.heatexchanger.sprialPlate.bean.structural.Nozzle;
import com.duan.utils.Constant;
import com.duan.utils.LabelAndFieldUtils;
import com.duan.utils.PanelUtils;

public class NozzleSpeeJPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SprialPlateHeatExchanger sprialHeat;
	private PureNumField hotInletIDField;
	private PureNumField coldInletIDField;
	private PureNumField coldOutletIDField;
	private PureNumField hotOutletIDField;
	private JLabel hotInletVelocityLabel;
	private JLabel hotOutletVelocityLabel;
	private JLabel coldInletVelocityLabel;
	private JLabel coldOutletVelocityLabel;

	/**
	 * Create the panel.
	 */
	public NozzleSpeeJPanel(SprialPlateHeatExchanger sprialHeat) {
		this.setSprialHeat(sprialHeat);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setFont(new Font("����", Font.PLAIN, 12));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 370, 170);

		add(panel);

		JLabel label = new JLabel("\u8FDB\u53E3\u5185\u5F84");
		label.setFont(new Font("����", Font.PLAIN, 14));
		label.setBounds(10, 40, 60, 20);
		panel.add(label);

		JLabel label_7 = new JLabel("\u51FA\u53E3\u5185\u5F84");
		label_7.setFont(new Font("����", Font.PLAIN, 14));
		label_7.setBounds(10, 70, 60, 20);
		panel.add(label_7);

		JLabel lblMm = new JLabel("mm");
		lblMm.setFont(new Font("����", Font.PLAIN, 14));
		lblMm.setBounds(278, 70, 29, 20);
		panel.add(lblMm);

		hotInletIDField = new PureNumField();
		hotInletIDField.setBounds(133, 40, 66, 20);
		panel.add(hotInletIDField);

		hotInletIDField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				double volumeFlow = sprialHeat.getSpheDesignConditions().getHotDesignCondition().getVolumnFlow();
				double id = hotInletIDField.getDoubleCanNull();
				if (id == Constant.ERROR_DOUBLE) {
					LabelAndFieldUtils.showDoublePointTwo(hotInletVelocityLabel, 0.00);
					return;
				}
				Nozzle nozzle = new Nozzle(id, volumeFlow);
				sprialHeat.setHotInletNozzle(nozzle);
				LabelAndFieldUtils.showDoublePointTwo(hotInletVelocityLabel, nozzle.getVelocity());
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				double volumeFlow = sprialHeat.getSpheDesignConditions().getHotDesignCondition().getVolumnFlow();
				double id = hotInletIDField.getDoubleCanNull();
				if (id == Constant.ERROR_DOUBLE) {
					LabelAndFieldUtils.showDoublePointTwo(hotInletVelocityLabel, 0.00);
					return;
				}
				Nozzle nozzle = new Nozzle(id, volumeFlow);
				sprialHeat.setHotInletNozzle(nozzle);
				LabelAndFieldUtils.showDoublePointTwo(hotInletVelocityLabel, nozzle.getVelocity());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});

		coldInletIDField = new PureNumField();
		coldInletIDField.setBounds(209, 39, 66, 20);
		panel.add(coldInletIDField);

		coldInletIDField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				double volumeFlow = sprialHeat.getSpheDesignConditions().getColdDesignCondition().getVolumnFlow();
				double id = coldInletIDField.getDoubleCanNull();
				if (id == Constant.ERROR_DOUBLE) {
					LabelAndFieldUtils.showDoublePointTwo(coldInletVelocityLabel, 0.00);
					return;
				}
				Nozzle nozzle = new Nozzle(id, volumeFlow);
				sprialHeat.setColdInletNozzle(nozzle);
				LabelAndFieldUtils.showDoublePointTwo(coldInletVelocityLabel, nozzle.getVelocity());
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				double volumeFlow = sprialHeat.getSpheDesignConditions().getColdDesignCondition().getVolumnFlow();
				double id = coldInletIDField.getDoubleCanNull();
				if (id == Constant.ERROR_DOUBLE) {
					LabelAndFieldUtils.showDoublePointTwo(coldInletVelocityLabel, 0.00);
					return;
				}
				Nozzle nozzle = new Nozzle(id, volumeFlow);
				sprialHeat.setColdInletNozzle(nozzle);
				LabelAndFieldUtils.showDoublePointTwo(coldInletVelocityLabel, nozzle.getVelocity());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel label_1 = new JLabel("\u70ED\u4FA7\u7BA1");
		label_1.setFont(new Font("����", Font.PLAIN, 14));
		label_1.setBounds(139, 10, 60, 20);
		panel.add(label_1);

		JLabel label_2 = new JLabel("\u51B7\u4FA7\u7BA1");
		label_2.setFont(new Font("����", Font.PLAIN, 14));
		label_2.setBounds(215, 10, 60, 20);
		panel.add(label_2);

		JLabel label_10 = new JLabel("mm");
		label_10.setFont(new Font("����", Font.PLAIN, 14));
		label_10.setBounds(278, 40, 29, 20);
		panel.add(label_10);

		coldOutletIDField = new PureNumField();
		coldOutletIDField.setBounds(209, 70, 66, 20);
		panel.add(coldOutletIDField);

		coldOutletIDField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				double volumeFlow = sprialHeat.getSpheDesignConditions().getColdDesignCondition().getVolumnFlow();
				double id = coldOutletIDField.getDoubleCanNull();
				if (id == Constant.ERROR_DOUBLE) {
					LabelAndFieldUtils.showDoublePointTwo(coldOutletVelocityLabel, 0.00);
					return;
				}
				Nozzle nozzle = new Nozzle(id, volumeFlow);
				sprialHeat.setColdOutletNozzle(nozzle);
				LabelAndFieldUtils.showDoublePointTwo(coldOutletVelocityLabel, nozzle.getVelocity());
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				double volumeFlow = sprialHeat.getSpheDesignConditions().getColdDesignCondition().getVolumnFlow();
				double id = coldOutletIDField.getDoubleCanNull();
				if (id == Constant.ERROR_DOUBLE) {
					LabelAndFieldUtils.showDoublePointTwo(coldOutletVelocityLabel, 0.00);
					return;
				}
				Nozzle nozzle = new Nozzle(id, volumeFlow);
				sprialHeat.setColdOutletNozzle(nozzle);
				LabelAndFieldUtils.showDoublePointTwo(coldOutletVelocityLabel, nozzle.getVelocity());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});

		hotOutletIDField = new PureNumField();
		hotOutletIDField.setBounds(133, 71, 66, 20);
		panel.add(hotOutletIDField);

		hotOutletIDField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				double volumeFlow = sprialHeat.getSpheDesignConditions().getHotDesignCondition().getVolumnFlow();
				double id = hotOutletIDField.getDoubleCanNull();
				if (id == Constant.ERROR_DOUBLE) {
					LabelAndFieldUtils.showDoublePointTwo(hotOutletVelocityLabel, 0.00);
					return;
				}
				Nozzle nozzle = new Nozzle(id, volumeFlow);
				sprialHeat.setHotOutletNozzle(nozzle);
				LabelAndFieldUtils.showDoublePointTwo(hotOutletVelocityLabel, nozzle.getVelocity());
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				double volumeFlow = sprialHeat.getSpheDesignConditions().getHotDesignCondition().getVolumnFlow();
				double id = hotOutletIDField.getDoubleCanNull();
				if (id == Constant.ERROR_DOUBLE) {
					LabelAndFieldUtils.showDoublePointTwo(hotOutletVelocityLabel, 0.00);
					return;
				}
				Nozzle nozzle = new Nozzle(id, volumeFlow);
				sprialHeat.setHotOutletNozzle(nozzle);
				LabelAndFieldUtils.showDoublePointTwo(hotOutletVelocityLabel, nozzle.getVelocity());

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel label_13 = new JLabel("\u8FDB\u53E3\u6D41\u901F");
		label_13.setFont(new Font("����", Font.PLAIN, 14));
		label_13.setBounds(10, 100, 60, 20);
		panel.add(label_13);

		hotInletVelocityLabel = new JLabel("");
		hotInletVelocityLabel.setFont(new Font("����", Font.PLAIN, 14));
		hotInletVelocityLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hotInletVelocityLabel.setBounds(133, 100, 66, 20);
		panel.add(hotInletVelocityLabel);

		coldInletVelocityLabel = new JLabel("");
		coldInletVelocityLabel.setFont(new Font("����", Font.PLAIN, 14));
		coldInletVelocityLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		coldInletVelocityLabel.setBounds(209, 100, 66, 20);
		panel.add(coldInletVelocityLabel);

		JLabel label_19 = new JLabel("m/s");
		label_19.setFont(new Font("����", Font.PLAIN, 14));
		label_19.setBounds(278, 100, 29, 20);
		panel.add(label_19);

		JLabel label_3 = new JLabel("\u51FA\u53E3\u6D41\u901F");
		label_3.setFont(new Font("����", Font.PLAIN, 14));
		label_3.setBounds(10, 130, 60, 20);
		panel.add(label_3);

		hotOutletVelocityLabel = new JLabel("");
		hotOutletVelocityLabel.setFont(new Font("����", Font.PLAIN, 14));
		hotOutletVelocityLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hotOutletVelocityLabel.setBounds(133, 130, 66, 20);
		panel.add(hotOutletVelocityLabel);

		coldOutletVelocityLabel = new JLabel("");
		coldOutletVelocityLabel.setFont(new Font("����", Font.PLAIN, 14));
		coldOutletVelocityLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		coldOutletVelocityLabel.setBounds(209, 130, 66, 20);
		panel.add(coldOutletVelocityLabel);

		JLabel label_8 = new JLabel("m/s");
		label_8.setFont(new Font("����", Font.PLAIN, 14));
		label_8.setBounds(278, 130, 29, 20);
		panel.add(label_8);
		PanelUtils.setAllComFont(panel);

	}

	public SprialPlateHeatExchanger getSprialHeat() {
		return sprialHeat;
	}

	public void setSprialHeat(SprialPlateHeatExchanger sprialHeat) {
		this.sprialHeat = sprialHeat;
	}

}
