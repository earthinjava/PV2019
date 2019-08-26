package com.duan.module.heatexchanger.sprialPlate.jpanel;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.duan.component.PureNumField;
import com.duan.component.image.ShowImageCenterPanel;
import com.duan.module.heatexchanger.sprialPlate.bean.SprialPlateHeatExchanger;
import com.duan.module.heatexchanger.sprialPlate.bean.designCondition.SPHEDesignConditions;
import com.duan.module.heatexchanger.sprialPlate.bean.structural.BufflePlate;
import com.duan.module.heatexchanger.sprialPlate.bean.structural.SpiralCoil;
import com.duan.module.heatexchanger.sprialPlate.bean.structural.SpiralCoils;
import com.duan.module.heatexchanger.sprialPlate.bean.structural.SpiralPlate;
import com.duan.module.heatexchanger.sprialPlate.bean.structural.StructuralDesign;
import com.duan.utils.Constant;
import com.duan.utils.DoubleUtils;
import com.duan.utils.JOptionPaneUtils;
import com.duan.utils.LabelAndFieldUtils;
import com.duan.utils.PanelUtils;

public class StructuralDesignJPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private SprialPlateHeatExchanger sprialHeat;
	private JPanel contentPane;
	private PureNumField sprialPlateWidthField;
	private PureNumField sprialPlateThickField;
	private PureNumField hotSpacingField;
	private PureNumField notWettedField;
	private PureNumField coldSpacingField;
	private PureNumField coldRollRadiusField;
	private PureNumField hotRollRadiusField;
	private PureNumField actualCoilField;
	private JLabel preAreaLabel;
	private JButton preCalButton;
	private JLabel reqCoilLabel;
	private JLabel effCoilLabel;
	private JLabel effWidthLabel;
	private JButton actualCalButton;
	private JLabel coldChannelSectionAreaLabel;
	private JLabel odActualLongAxisLabel;
	private JLabel spiralChannelLengthLabel;
	private JLabel actualAreaLabel;
	private JLabel coldEffHeatLengthLabel;
	private JLabel hotEffHeatLengthLabel;
	private JLabel coldChannelVelocityLabel;
	private JLabel hotChannelVelocityLabel;
	private JLabel baffleLengthLabel;
	private JLabel coldEccentricityLabel;
	private JLabel hotEccentricityLabel;
	private ShowImageCenterPanel preImagePanel;
	private JLabel actrualEffCoilsLabel;
	private JLabel hotChannelSectionAreaLabel;
	private JLabel hotCalLengthLabel;
	private JLabel coldCalLengthLabel;

	/**
	 * Create the panel.
	 */
	public StructuralDesignJPanel(SprialPlateHeatExchanger sprialHeat) {
		this.sprialHeat = sprialHeat;

		setBounds(new Rectangle(0, 0, 800, 800));
		setLayout(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBounds(new Rectangle(0, 0, 800, 800));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		add(contentPane);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(5, 5, 310, 465);
		contentPane.add(panel_1);

		JLabel label_4 = new JLabel("\u87BA\u65CB\u677F\u5BBD\u5EA6");
		label_4.setBounds(10, 10, 108, 20);
		panel_1.add(label_4);

		JLabel label_5 = new JLabel("\u87BA\u65CB\u677F\u8BA1\u7B97\u539A\u5EA6");
		label_5.setBounds(10, 40, 108, 20);
		panel_1.add(label_5);

		JLabel label_6 = new JLabel("mm");
		label_6.setBounds(281, 44, 29, 20);
		panel_1.add(label_6);

		sprialPlateWidthField = new PureNumField();
		sprialPlateWidthField.setText("1500");
		sprialPlateWidthField.setBounds(210, 10, 66, 20);
		panel_1.add(sprialPlateWidthField);

		JLabel label_12 = new JLabel("mm");
		label_12.setBounds(281, 14, 29, 20);
		panel_1.add(label_12);

		sprialPlateThickField = new PureNumField();
		sprialPlateThickField.setText("4");
		sprialPlateThickField.setBounds(210, 41, 66, 20);
		panel_1.add(sprialPlateThickField);

		JLabel label_14 = new JLabel("\u51B7\u4FA7\u901A\u9053\u95F4\u8DDD");
		label_14.setBounds(10, 70, 108, 20);
		panel_1.add(label_14);

		JLabel label_18 = new JLabel("\u70ED\u4FA7\u901A\u9053\u95F4\u8DDD");
		label_18.setBounds(10, 100, 108, 20);
		panel_1.add(label_18);

		JLabel label_27 = new JLabel("\u87BA\u65CB\u677F\u5BBD\u5EA6\u65B9\u5411\u672A\u6E7F\u6DA6\u5C3A\u5BF8");
		label_27.setBounds(10, 130, 190, 20);
		panel_1.add(label_27);

		hotSpacingField = new PureNumField();
		hotSpacingField.setText("14");
		hotSpacingField.setBounds(210, 100, 66, 20);
		panel_1.add(hotSpacingField);

		JLabel label_11 = new JLabel("mm");
		label_11.setBounds(281, 103, 29, 20);
		panel_1.add(label_11);

		notWettedField = new PureNumField();
		notWettedField.setText("30");
		notWettedField.setBounds(210, 131, 66, 20);
		panel_1.add(notWettedField);

		JLabel label_15 = new JLabel("mm");
		label_15.setBounds(281, 134, 29, 20);
		panel_1.add(label_15);

		coldSpacingField = new PureNumField();
		coldSpacingField.setText("14");
		coldSpacingField.setBounds(210, 71, 66, 20);
		panel_1.add(coldSpacingField);

		JLabel label_9 = new JLabel("mm");
		label_9.setBounds(281, 70, 29, 20);
		panel_1.add(label_9);

		JLabel label_21 = new JLabel("\u51B7\u4FA7\u5377\u8F8A\u534A\u5F84");
		label_21.setBounds(10, 160, 108, 20);
		panel_1.add(label_21);

		coldRollRadiusField = new PureNumField();
		coldRollRadiusField.setText("200");
		coldRollRadiusField.setBounds(210, 161, 66, 20);
		panel_1.add(coldRollRadiusField);

		JLabel label_22 = new JLabel("mm");
		label_22.setBounds(281, 164, 29, 20);
		panel_1.add(label_22);

		JLabel label_24 = new JLabel("\u70ED\u4FA7\u5377\u8F8A\u534A\u5F84");
		label_24.setBounds(10, 190, 108, 20);
		panel_1.add(label_24);

		hotRollRadiusField = new PureNumField();
		hotRollRadiusField.setText("200");
		hotRollRadiusField.setBounds(210, 191, 66, 20);
		panel_1.add(hotRollRadiusField);

		JLabel label_25 = new JLabel("mm");
		label_25.setBounds(281, 194, 29, 20);
		panel_1.add(label_25);

		JLabel label_16 = new JLabel("\u6362\u70ED\u521D\u7B97\u6240\u9700\u9762\u79EF");
		label_16.setBounds(10, 250, 136, 20);
		panel_1.add(label_16);

		preAreaLabel = new JLabel("");
		preAreaLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		preAreaLabel.setBounds(210, 250, 66, 20);
		panel_1.add(preAreaLabel);

		JLabel label_20 = new JLabel("\u33A1");
		label_20.setBounds(281, 250, 29, 20);
		panel_1.add(label_20);

		JLabel label_17 = new JLabel("\u521D\u7B97\u6240\u9700\u6709\u6548\u5708\u6570");
		label_17.setBounds(10, 280, 160, 20);
		panel_1.add(label_17);

		effCoilLabel = new JLabel("");
		effCoilLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		effCoilLabel.setBounds(210, 280, 66, 20);
		panel_1.add(effCoilLabel);

		JLabel label_26 = new JLabel("\u521D\u7B97\u6240\u9700\u6362\u70ED\u5708\u6570");
		label_26.setBounds(10, 310, 160, 20);
		panel_1.add(label_26);

		reqCoilLabel = new JLabel("");
		reqCoilLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		reqCoilLabel.setBounds(210, 310, 66, 20);
		panel_1.add(reqCoilLabel);

		JLabel label_51 = new JLabel("\u5708");
		label_51.setBounds(281, 282, 29, 20);
		panel_1.add(label_51);

		JLabel label_58 = new JLabel("\u5708");
		label_58.setBounds(281, 310, 29, 20);
		panel_1.add(label_58);

		preCalButton = new JButton("\u521D\u7B97");
		preCalButton.setBounds(10, 220, 290, 25);
		panel_1.add(preCalButton);

		JLabel label_47 = new JLabel("\u87BA\u65CB\u677F\u6709\u6548\u6362\u70ED\u5BBD\u5EA6");
		label_47.setBounds(10, 340, 160, 20);
		panel_1.add(label_47);

		effWidthLabel = new JLabel("");
		effWidthLabel.setBounds(210, 340, 66, 20);
		panel_1.add(effWidthLabel);
		effWidthLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel label_49 = new JLabel("mm");
		label_49.setBounds(281, 340, 29, 20);
		panel_1.add(label_49);

		JLabel label_10 = new JLabel("\u4E2D\u95F4\u9694\u677F\u5BBD\u5EA6");
		label_10.setBounds(10, 370, 108, 20);
		panel_1.add(label_10);

		baffleLengthLabel = new JLabel("");
		baffleLengthLabel.setBounds(210, 370, 66, 20);
		panel_1.add(baffleLengthLabel);
		baffleLengthLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel label_19 = new JLabel("mm");
		label_19.setBounds(281, 371, 29, 20);
		panel_1.add(label_19);

		actualCalButton = new JButton("\u5B9E\u7B97");
		actualCalButton.setBounds(10, 430, 290, 25);
		panel_1.add(actualCalButton);
		actualCalButton.setEnabled(false);

		JLabel label_31 = new JLabel("\u5B9E\u9009\u6362\u70ED\u5708\u6570");
		label_31.setBounds(10, 400, 160, 20);
		panel_1.add(label_31);

		actualCoilField = new PureNumField();
		actualCoilField.setBounds(210, 400, 66, 20);
		panel_1.add(actualCoilField);

		JLabel label_62 = new JLabel("\u5708");
		label_62.setBounds(281, 400, 29, 20);
		panel_1.add(label_62);
		
		actualCalButton.addActionListener(new ActualCalButtonActionListener());
		preCalButton.addActionListener(new PreCalButtonActionListener());

		JPanel actualPanel = new JPanel();
		actualPanel.setLayout(null);
		actualPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		actualPanel.setBackground(SystemColor.menu);
		actualPanel.setBounds(320, 5, 310, 465);
		contentPane.add(actualPanel);

		JLabel label_28 = new JLabel("\u51B7\u4FA7\u6709\u6548\u957F\u5EA6");
		label_28.setBounds(10, 100, 136, 20);
		actualPanel.add(label_28);

		JLabel label_30 = new JLabel("\u70ED\u4FA7\u6709\u6548\u957F\u5EA6");
		label_30.setBounds(10, 130, 136, 20);
		actualPanel.add(label_30);

		hotEffHeatLengthLabel = new JLabel("");
		hotEffHeatLengthLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hotEffHeatLengthLabel.setBounds(210, 130, 66, 20);
		actualPanel.add(hotEffHeatLengthLabel);

		coldEffHeatLengthLabel = new JLabel("");
		coldEffHeatLengthLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		coldEffHeatLengthLabel.setBounds(210, 100, 66, 20);
		actualPanel.add(coldEffHeatLengthLabel);

		JLabel label_48 = new JLabel("mm");
		label_48.setBounds(282, 100, 29, 20);
		actualPanel.add(label_48);

		JLabel label_56 = new JLabel("mm");
		label_56.setBounds(281, 130, 29, 20);
		actualPanel.add(label_56);

		JLabel label_61 = new JLabel("\u87BA\u65CB\u901A\u9053\u957F\u5EA6");
		label_61.setBounds(10, 220, 160, 20);
		actualPanel.add(label_61);

		spiralChannelLengthLabel = new JLabel("");
		spiralChannelLengthLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		spiralChannelLengthLabel.setBounds(210, 220, 66, 20);
		actualPanel.add(spiralChannelLengthLabel);

		JLabel label_63 = new JLabel("mm");
		label_63.setBounds(282, 220, 29, 20);
		actualPanel.add(label_63);

		JLabel label_64 = new JLabel("\u87BA\u65CB\u4F53\u957F\u8F74\u5916\u5F84");
		label_64.setBounds(10, 250, 136, 20);
		actualPanel.add(label_64);

		odActualLongAxisLabel = new JLabel("");
		odActualLongAxisLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		odActualLongAxisLabel.setBounds(210, 250, 66, 20);
		actualPanel.add(odActualLongAxisLabel);

		JLabel label_66 = new JLabel("mm");
		label_66.setBounds(282, 250, 29, 20);
		actualPanel.add(label_66);

		JLabel label_43 = new JLabel("\u51B7\u4FA7\u901A\u9053\u6D41\u901F");
		label_43.setBounds(10, 280, 136, 20);
		actualPanel.add(label_43);

		coldChannelVelocityLabel = new JLabel("");
		coldChannelVelocityLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		coldChannelVelocityLabel.setBounds(210, 280, 66, 20);
		actualPanel.add(coldChannelVelocityLabel);

		JLabel lblMs = new JLabel("m/s");
		lblMs.setBounds(282, 280, 29, 20);
		actualPanel.add(lblMs);

		JLabel label_44 = new JLabel("\u70ED\u4FA7\u901A\u9053\u6D41\u901F");
		label_44.setBounds(10, 310, 136, 20);
		actualPanel.add(label_44);

		hotChannelVelocityLabel = new JLabel("");
		hotChannelVelocityLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hotChannelVelocityLabel.setBounds(210, 310, 66, 20);
		actualPanel.add(hotChannelVelocityLabel);

		JLabel label_52 = new JLabel("m/s");
		label_52.setBounds(282, 310, 29, 20);
		actualPanel.add(label_52);

		JLabel label = new JLabel("\u51B7\u4FA7\u504F\u5FC3\u8DDD");
		label.setBounds(10, 340, 108, 20);
		actualPanel.add(label);

		JLabel label_1 = new JLabel("\u70ED\u4FA7\u504F\u5FC3\u8DDD");
		label_1.setBounds(10, 370, 108, 20);
		actualPanel.add(label_1);

		hotEccentricityLabel = new JLabel("");
		hotEccentricityLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hotEccentricityLabel.setBounds(210, 370, 66, 20);
		actualPanel.add(hotEccentricityLabel);

		coldEccentricityLabel = new JLabel("");
		coldEccentricityLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		coldEccentricityLabel.setBounds(210, 340, 66, 20);
		actualPanel.add(coldEccentricityLabel);

		JLabel label_7 = new JLabel("mm");
		label_7.setBounds(282, 340, 29, 20);
		actualPanel.add(label_7);

		JLabel label_8 = new JLabel("mm");
		label_8.setBounds(282, 373, 29, 20);
		actualPanel.add(label_8);

		JLabel label_32 = new JLabel("\u51B7\u4FA7\u901A\u9053\u622A\u9762\u79EF");
		label_32.setBounds(10, 40, 108, 20);
		actualPanel.add(label_32);

		coldChannelSectionAreaLabel = new JLabel("");
		coldChannelSectionAreaLabel.setBounds(210, 40, 66, 20);
		actualPanel.add(coldChannelSectionAreaLabel);
		coldChannelSectionAreaLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel label_54 = new JLabel("\u33A1");
		label_54.setBounds(281, 44, 29, 20);
		actualPanel.add(label_54);

		JLabel label_41 = new JLabel("\u70ED\u4FA7\u901A\u9053\u622A\u9762\u79EF");
		label_41.setBounds(10, 70, 108, 20);
		actualPanel.add(label_41);

		hotChannelSectionAreaLabel = new JLabel("");
		hotChannelSectionAreaLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hotChannelSectionAreaLabel.setBounds(210, 70, 66, 20);
		actualPanel.add(hotChannelSectionAreaLabel);

		JLabel label_45 = new JLabel("\u33A1");
		label_45.setBounds(281, 74, 29, 20);
		actualPanel.add(label_45);

		JLabel label_35 = new JLabel("\u51B7\u4FA7\u8BA1\u7B97\u957F\u5EA6");
		label_35.setBounds(10, 160, 136, 20);
		actualPanel.add(label_35);

		JLabel label_46 = new JLabel("\u70ED\u4FA7\u8BA1\u7B97\u957F\u5EA6");
		label_46.setBounds(10, 190, 136, 20);
		actualPanel.add(label_46);

		hotCalLengthLabel = new JLabel("");
		hotCalLengthLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hotCalLengthLabel.setBounds(210, 190, 66, 20);
		actualPanel.add(hotCalLengthLabel);

		coldCalLengthLabel = new JLabel("");
		coldCalLengthLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		coldCalLengthLabel.setBounds(210, 160, 66, 20);
		actualPanel.add(coldCalLengthLabel);

		JLabel label_55 = new JLabel("mm");
		label_55.setBounds(282, 160, 29, 20);
		actualPanel.add(label_55);

		JLabel label_57 = new JLabel("mm");
		label_57.setBounds(281, 190, 29, 20);
		actualPanel.add(label_57);

		JLabel label_59 = new JLabel("\u6709\u6548\u6362\u70ED\u9762\u79EF");
		label_59.setBounds(10, 400, 160, 20);
		actualPanel.add(label_59);

		actualAreaLabel = new JLabel("");
		actualAreaLabel.setBounds(210, 400, 66, 20);
		actualPanel.add(actualAreaLabel);
		actualAreaLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel label_60 = new JLabel("\u33A1");
		label_60.setBounds(282, 400, 29, 20);
		actualPanel.add(label_60);

		JLabel label_29 = new JLabel("\u6709\u6548\u5708\u6570");
		label_29.setBounds(10, 10, 160, 20);
		actualPanel.add(label_29);

		actrualEffCoilsLabel = new JLabel("");
		actrualEffCoilsLabel.setBounds(210, 10, 66, 20);
		actualPanel.add(actrualEffCoilsLabel);
		actrualEffCoilsLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel label_40 = new JLabel("\u5708");
		label_40.setBounds(281, 10, 29, 20);
		actualPanel.add(label_40);

		JPanel preStruImagePanel = new ShowImageCenterPanel(310, 195, 5, 475,
				"src/img/SprialPlateHeatExchanger/Structural.png", true);
		contentPane.add(preStruImagePanel);

		preImagePanel = new ShowImageCenterPanel(310, 195, 320, 475, "src/img/SprialPlateHeatExchanger/IsParallel.png",
				true);
		contentPane.add(preImagePanel);

		PanelUtils.setAllComFont(panel_1);
		PanelUtils.setAllComFont(actualPanel);
	}

	class ActualCalButtonActionListener implements ActionListener, Serializable {

		private static final long serialVersionUID = 5782970299939264665L;

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			preCal();
			actualCal();
		}

	}

	class PreCalButtonActionListener implements ActionListener, Serializable {
		private static final long serialVersionUID = 460078378492401157L;

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			preCal();
		}

	}

	public void preCal() {
		// TODO Auto-generated method stub
		actualCalButton.setEnabled(false);
		double sprialPlateWidth = sprialPlateWidthField.getDoubleNoNull("请输入螺旋板宽度");
		if (sprialPlateWidth == Constant.ERROR_DOUBLE) {
			return;
		}
		double sprialPlateThick = sprialPlateThickField.getDoubleNoNull("请输入螺旋板厚度");
		if (sprialPlateThick == Constant.ERROR_DOUBLE) {
			return;
		}
		double coldChannelSpacing = coldSpacingField.getDoubleNoNull("请输入冷侧通道间距");
		if (coldChannelSpacing == Constant.ERROR_DOUBLE) {
			return;
		}
		double hotChannelSpacing = hotSpacingField.getDoubleNoNull("请输入热侧通道间距");
		if (hotChannelSpacing == Constant.ERROR_DOUBLE) {
			return;
		}
		double notWetted = hotSpacingField.getDoubleNoNull("请输入螺旋板宽度方向未浸润尺寸");
		if (notWetted == Constant.ERROR_DOUBLE) {
			return;
		}
		double coldRollRadius = coldRollRadiusField.getDoubleNoNull("请输入冷侧卷辊半径");
		if (coldRollRadius == Constant.ERROR_DOUBLE) {
			return;
		}
		double hotRollRadius = hotRollRadiusField.getDoubleNoNull("请输入热侧卷辊半径");
		if (hotRollRadius == Constant.ERROR_DOUBLE) {
			return;
		}
		SpiralPlate hotSpiralPlate = new SpiralPlate(sprialPlateWidth, sprialPlateThick, notWetted, hotRollRadius);
		SpiralPlate coldSpiralPlate = new SpiralPlate(sprialPlateWidth, sprialPlateThick, notWetted, coldRollRadius);
		SpiralCoil hotSpiralCoil = new SpiralCoil(hotChannelSpacing, coldChannelSpacing, hotSpiralPlate,
				sprialHeat.getSpheDesignConditions().getHotDesignCondition());
		SpiralCoil coldSpiralCoil = new SpiralCoil(coldChannelSpacing, hotChannelSpacing, coldSpiralPlate,
				sprialHeat.getSpheDesignConditions().getColdDesignCondition());
		SpiralCoils spiralCoils = new SpiralCoils(coldSpiralCoil, hotSpiralCoil,
				sprialHeat.getPreThermalCalculation().getPreHeatTransferArea(),
				sprialHeat.getSpheDesignConditions().getsetHeatExchangerType());
		BufflePlate bufflePlate = new BufflePlate(hotSpiralCoil, coldSpiralCoil);
		StructuralDesign structuralDesign = new StructuralDesign(bufflePlate, spiralCoils);
		sprialHeat.setStructuralDesign(structuralDesign);
		double reqEffCoils = structuralDesign.getSpiralCoils().getPreReNumberEffectiveCoils();
		LabelAndFieldUtils.showDoublePointTwo(effCoilLabel, reqEffCoils);
		double reqCoils = structuralDesign.getSpiralCoils().getReNumberCoils();
		double effHeatWidth = structuralDesign.getSpiralCoils().getHotSpiralCoil().getSpiralPlate().getEffWidth();
		LabelAndFieldUtils.showDoublePointTwo(effWidthLabel, effHeatWidth);
		double baffleLength = structuralDesign.getBufflePlate().getLength();
		LabelAndFieldUtils.showDoublePointTwo(baffleLengthLabel, baffleLength);
		actualCalButton.setEnabled(true);
		String coilString = actualCoilField.getText();
		if (coilString.trim().equals("")) {
			actualCoilField.setText(reqCoils + "");
		}
	}

	public void actualCal() {
		double actualCoil = actualCoilField.getDoubleNoNull("请输入实际圈数");
		if (actualCoil == Constant.ERROR_DOUBLE) {
			return;
		}
		if (!DoubleUtils.isPoint5PCount(actualCoil)) {
			JOptionPaneUtils.warningMess(contentPane, "实际圈数应为0.5的整数倍");
			return;
		}
		StructuralDesign structuralDesign = sprialHeat.getStructuralDesign();
		structuralDesign.getSpiralCoils().setHotAandColdSpiralCoilActualNum(actualCoil);
		double actrualEffCoils = structuralDesign.getSpiralCoils().getNumberEffCoils();
		LabelAndFieldUtils.showDoublePointTwo(actrualEffCoilsLabel, actrualEffCoils);
		SpiralCoil hotSpiralCoil = structuralDesign.getSpiralCoils().getHotSpiralCoil();
		SpiralCoil coldSpiralCoil = structuralDesign.getSpiralCoils().getColdSpiralCoil();
		double outChannelSectionArea = coldSpiralCoil.getChannelSectionArea(structuralDesign.getSpiralCoils());
		LabelAndFieldUtils.showDoublePointTwo(coldChannelSectionAreaLabel, outChannelSectionArea);
		double inChannelSectionArea = hotSpiralCoil.getChannelSectionArea(structuralDesign.getSpiralCoils());
		LabelAndFieldUtils.showDoublePointTwo(hotChannelSectionAreaLabel, inChannelSectionArea);
		double inActrualEffHeatLength = hotSpiralCoil.getActrualEffHeatLength();
		LabelAndFieldUtils.showDoublePointTwo(hotEffHeatLengthLabel, inActrualEffHeatLength);
		double outActrualEffHeatLength = coldSpiralCoil.getActrualEffHeatLength();
		LabelAndFieldUtils.showDoublePointTwo(coldEffHeatLengthLabel, outActrualEffHeatLength);
		double outActualCalLength = coldSpiralCoil.getActrualCalLength();
		LabelAndFieldUtils.showDoublePointTwo(coldCalLengthLabel, outActualCalLength);
		double inActualCalLength = hotSpiralCoil.getActrualCalLength();
		LabelAndFieldUtils.showDoublePointTwo(hotCalLengthLabel, inActualCalLength);
		double spiralActualChannelLength = coldSpiralCoil.getSpiralChannelActrualLength();
		LabelAndFieldUtils.showDoublePointTwo(spiralChannelLengthLabel, spiralActualChannelLength);
		double odActualLongAxis = structuralDesign.getSpiralCoils().getActruallongAxisOd();
		LabelAndFieldUtils.showDoublePointTwo(odActualLongAxisLabel, odActualLongAxis);
		double inChannelVelocity = hotSpiralCoil.getChannelVelocity(structuralDesign.getSpiralCoils());
		LabelAndFieldUtils.showDoublePointTwo(hotChannelVelocityLabel, inChannelVelocity);
		double outChannelVelocity = coldSpiralCoil.getChannelVelocity(structuralDesign.getSpiralCoils());
		LabelAndFieldUtils.showDoublePointTwo(coldChannelVelocityLabel, outChannelVelocity);
		double outEccentricity = coldSpiralCoil.getEccentricity();
		LabelAndFieldUtils.showDoublePointTwo(coldEccentricityLabel, outEccentricity);
		double inEccentricity = hotSpiralCoil.getEccentricity();
		LabelAndFieldUtils.showDoublePointTwo(hotEccentricityLabel, inEccentricity);
		double actualArea = structuralDesign.getSpiralCoils().getActrualEffArea();
		LabelAndFieldUtils.showDoublePointTwo(actualAreaLabel, actualArea);
		if (structuralDesign.getSpiralCoils().isCutOffParallelBaffle()) {
			preImagePanel.setImgPath("src/img/SprialPlateHeatExchanger/IsParallel.png");
			preImagePanel.repaint();
		} else {
			preImagePanel.setImgPath("src/img/SprialPlateHeatExchanger/IsNotParallel.png");
			preImagePanel.repaint();
		}
		if (actualArea < sprialHeat.getPreThermalCalculation().getPreHeatTransferArea()) {
			actualAreaLabel.setForeground(Color.RED);
		} else {
			actualAreaLabel.setForeground(Color.BLUE);
		}
	}

	public void preDisplay() {
		SPHEDesignConditions designConditions = sprialHeat.getSpheDesignConditions();
		if (designConditions != null) {
			double area = sprialHeat.getPreThermalCalculation().getPreHeatTransferArea();
			LabelAndFieldUtils.showDoublePointTwo(preAreaLabel, area);
		}
	}
}
