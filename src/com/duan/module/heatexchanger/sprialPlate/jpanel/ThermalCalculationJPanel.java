package com.duan.module.heatexchanger.sprialPlate.jpanel;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.duan.component.PureNumField;
import com.duan.component.ShowImgButton;
import com.duan.component.image.BoxChangeImgPanel;
import com.duan.module.heatexchanger.sprialPlate.bean.SprialPlateHeatExchanger;
import com.duan.module.heatexchanger.sprialPlate.bean.ThermalCalculation;
import com.duan.module.heatexchanger.sprialPlate.bean.designCondition.SPHEDesignConditions;
import com.duan.module.heatexchanger.sprialPlate.bean.structural.PillarsFixedDistance;
import com.duan.utils.Constant;
import com.duan.utils.JOptionPaneUtils;
import com.duan.utils.LabelAndFieldUtils;
import com.duan.utils.PanelUtils;

public class ThermalCalculationJPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private SprialPlateHeatExchanger sprialHeat;
	private JPanel contentPane;
	private HeatMessPanel heatJPanel;
	private JLabel hotDELabel;
	private JLabel coldDELabel;
	private PureNumField hotFoulingResistanceField;
	private PureNumField coldFoulingResistanceField;
	private PureNumField spiralPlateThermalField;
	private JLabel hotReLabel;
	private JLabel coldReLabel;
	private JLabel hotPrLabel;
	private JLabel coldPrLabel;
	private JLabel isHotRapidsLable;
	private JLabel isColdRapidsLable;
	private JLabel hotHeatLabel;
	private JLabel coldHeatLabel;
	private JLabel actualAreaLabel;
	private JLabel totalHeatAreaLabel;
	private JLabel hotPressureDropLabel;
	private JLabel coldPressureDropLabel;
	private JLabel totalHeatLbel;
	private JLabel areaMarginLabel;
	private JButton calHeatButton;
	private final String metalThermalFigPath = "src/img/SprialPlateHeatExchanger/MetalThermal.png";
	private final String foulingResistanceFigPath = "src/img/SprialPlateHeatExchanger/FoulingResistance.png";
	private JLabel hotPressDropMarginLabel;
	private JLabel coldPressDropMarginLabe;
	private PureNumField pillarXSpacingField;
	private PureNumField pillarYSpacingField;
	private JComboBox<String> pillarBox;
	private String[] pillarImgPath = new String[] { "src/img/SprialPlateHeatExchanger/pillarI.png",
			"src/img/SprialPlateHeatExchanger/pillarII.png", "src/img/SprialPlateHeatExchanger/pillarIII.png",
			"src/img/SprialPlateHeatExchanger/pillarIIII.png" };
	private JLabel everyNumLabel;
	private JLabel totalNumLabel;
	private BoxChangeImgPanel imagePanel;

	public ThermalCalculationJPanel(SprialPlateHeatExchanger sprialHeat) {
		this.sprialHeat = sprialHeat;

		setBounds(new Rectangle(0, 0, 800, 800));
		setLayout(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBounds(new Rectangle(0, 0, 800, 800));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		add(contentPane);

		heatJPanel = new HeatMessPanel(sprialHeat);
		heatJPanel.setLocation(305, 5);
		heatJPanel.setSize(295, 285);
		contentPane.add(heatJPanel);

		JPanel jPanel = new JPanel();
		contentPane.add(jPanel);

		jPanel.setLayout(null);
		jPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel.setBackground(SystemColor.menu);
		jPanel.setBounds(5, 5, 295, 660);

		JLabel label_11 = new JLabel("\u5F53\u91CF\u76F4\u5F84");
		label_11.setBounds(10, 40, 60, 20);
		jPanel.add(label_11);

		hotDELabel = new JLabel("");
		hotDELabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hotDELabel.setBounds(80, 40, 66, 20);
		jPanel.add(hotDELabel);

		coldDELabel = new JLabel("");
		coldDELabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		coldDELabel.setBounds(156, 40, 66, 20);
		jPanel.add(coldDELabel);

		JLabel lblMm = new JLabel("m");
		lblMm.setBounds(232, 40, 75, 20);
		jPanel.add(lblMm);

		JLabel lblre = new JLabel("\u96F7\u8BFA\u6570");
		lblre.setBounds(10, 70, 60, 20);
		jPanel.add(lblre);

		hotReLabel = new JLabel("");
		hotReLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hotReLabel.setBounds(80, 70, 66, 20);
		jPanel.add(hotReLabel);

		coldReLabel = new JLabel("");
		coldReLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		coldReLabel.setBounds(156, 70, 66, 20);
		jPanel.add(coldReLabel);

		JLabel label = new JLabel("\u666E\u6717\u7279\u6570");
		label.setBounds(10, 100, 60, 20);
		jPanel.add(label);

		hotPrLabel = new JLabel("");
		hotPrLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hotPrLabel.setBounds(80, 100, 66, 20);
		jPanel.add(hotPrLabel);

		coldPrLabel = new JLabel("");
		coldPrLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		coldPrLabel.setBounds(156, 100, 66, 20);
		jPanel.add(coldPrLabel);

		JLabel label_6 = new JLabel("\u662F\u5426\u6E4D\u6D41");
		label_6.setBounds(10, 130, 60, 20);
		jPanel.add(label_6);

		isHotRapidsLable = new JLabel("");
		isHotRapidsLable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		isHotRapidsLable.setBounds(80, 130, 66, 20);
		jPanel.add(isHotRapidsLable);

		isColdRapidsLable = new JLabel("");
		isColdRapidsLable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		isColdRapidsLable.setBounds(156, 130, 66, 20);
		jPanel.add(isColdRapidsLable);

		JLabel label_9 = new JLabel("\u4F20\u70ED\u7CFB\u6570");
		label_9.setBounds(10, 160, 60, 20);
		jPanel.add(label_9);

		hotHeatLabel = new JLabel("");
		hotHeatLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hotHeatLabel.setBounds(80, 160, 66, 20);
		jPanel.add(hotHeatLabel);

		coldHeatLabel = new JLabel("");
		coldHeatLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		coldHeatLabel.setBounds(156, 160, 66, 20);
		jPanel.add(coldHeatLabel);

		JLabel lblW = new JLabel("W/(\u33A1\u00B7\u2103)");
		lblW.setBounds(232, 160, 63, 20);
		jPanel.add(lblW);

		JLabel label_1 = new JLabel("\u6C61\u57A2\u70ED\u963B");
		label_1.setBounds(10, 190, 60, 20);
		jPanel.add(label_1);

		hotFoulingResistanceField = new PureNumField();
		hotFoulingResistanceField.setText("0.000176");
		hotFoulingResistanceField.setBounds(80, 190, 66, 20);
		jPanel.add(hotFoulingResistanceField);

		coldFoulingResistanceField = new PureNumField();
		coldFoulingResistanceField.setText("0.000176");
		coldFoulingResistanceField.setBounds(156, 190, 66, 20);
		jPanel.add(coldFoulingResistanceField);

		JLabel label_13 = new JLabel("\u33A1.K/W");
		label_13.setBounds(232, 190, 53, 20);
		jPanel.add(label_13);

		ShowImgButton foulingResistanceButton = new ShowImgButton(foulingResistanceFigPath);			
		foulingResistanceButton.setBounds(80, 220, 142, 20);
		jPanel.add(foulingResistanceButton);

		JLabel label_14 = new JLabel("\u87BA\u65CB\u677F\u5BFC\u70ED\u7CFB\u6570");
		label_14.setBounds(10, 250, 136, 20);
		jPanel.add(label_14);

		spiralPlateThermalField = new PureNumField();
		spiralPlateThermalField.setText("14.3");
		spiralPlateThermalField.setBounds(156, 250, 66, 20);
		jPanel.add(spiralPlateThermalField);

		ShowImgButton spiralPlateThermalButton = new ShowImgButton(metalThermalFigPath);
		spiralPlateThermalButton.setBounds(80, 280, 142, 20);
		jPanel.add(spiralPlateThermalButton);

		JLabel lblWm = new JLabel("W/(m\u00B7\u2103)");
		lblWm.setBounds(232, 253, 63, 20);
		jPanel.add(lblWm);

		JLabel lblRe = new JLabel("Re");
		lblRe.setBounds(232, 70, 75, 20);
		jPanel.add(lblRe);

		JLabel lblPr = new JLabel("Pr");
		lblPr.setBounds(232, 103, 75, 20);
		jPanel.add(lblPr);

		hotPressureDropLabel = new JLabel("");
		hotPressureDropLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hotPressureDropLabel.setBounds(80, 465, 66, 20);
		jPanel.add(hotPressureDropLabel);

		coldPressureDropLabel = new JLabel("");
		coldPressureDropLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		coldPressureDropLabel.setBounds(156, 465, 66, 20);
		jPanel.add(coldPressureDropLabel);

		JLabel label_17 = new JLabel("\u538B\u529B\u964D");
		label_17.setBounds(10, 465, 60, 20);
		jPanel.add(label_17);

		JLabel label_20 = new JLabel("MPa");
		label_20.setBounds(232, 465, 75, 20);
		jPanel.add(label_20);

		JLabel label_3 = new JLabel("\u603B\u6362\u70ED\u7CFB\u6570");
		label_3.setBounds(10, 525, 75, 20);
		jPanel.add(label_3);

		totalHeatLbel = new JLabel("");
		totalHeatLbel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		totalHeatLbel.setBounds(80, 525, 142, 20);
		jPanel.add(totalHeatLbel);

		JLabel label_5 = new JLabel("\u8BA1\u7B97\u9762\u79EF");
		label_5.setBounds(10, 555, 66, 20);
		jPanel.add(label_5);

		JLabel label_7 = new JLabel("\u9762\u79EF\u88D5\u5EA6");
		label_7.setBounds(10, 615, 60, 20);
		jPanel.add(label_7);

		JLabel label_8 = new JLabel("\u5B9E\u9645\u9762\u79EF");
		label_8.setBounds(10, 585, 66, 20);
		jPanel.add(label_8);

		areaMarginLabel = new JLabel("");
		areaMarginLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		areaMarginLabel.setBounds(156, 615, 66, 20);
		jPanel.add(areaMarginLabel);

		actualAreaLabel = new JLabel("");
		actualAreaLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		actualAreaLabel.setBounds(80, 585, 142, 20);
		jPanel.add(actualAreaLabel);

		totalHeatAreaLabel = new JLabel("");
		totalHeatAreaLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		totalHeatAreaLabel.setBounds(80, 555, 142, 20);
		jPanel.add(totalHeatAreaLabel);

		JLabel label_18 = new JLabel("\u33A1");
		label_18.setBounds(232, 585, 75, 20);
		jPanel.add(label_18);

		JLabel label_19 = new JLabel("W/(\u33A1\u00B7\u2103)");
		label_19.setBounds(232, 525, 63, 20);
		jPanel.add(label_19);

		JLabel label_21 = new JLabel("%");
		label_21.setBounds(232, 615, 75, 20);
		jPanel.add(label_21);

		JLabel label_22 = new JLabel("\u33A1");
		label_22.setBounds(232, 555, 75, 20);
		jPanel.add(label_22);

		JLabel label_23 = new JLabel("\u70ED\u4FA7");
		label_23.setBounds(99, 10, 60, 20);
		jPanel.add(label_23);

		JLabel label_24 = new JLabel("\u51B7\u4FA7");
		label_24.setBounds(169, 10, 60, 20);
		jPanel.add(label_24);

		JLabel label_2 = new JLabel("\u538B\u529B\u964D\u88D5\u5EA6");
		label_2.setBounds(10, 495, 75, 20);
		jPanel.add(label_2);

		hotPressDropMarginLabel = new JLabel("");
		hotPressDropMarginLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hotPressDropMarginLabel.setBounds(80, 495, 66, 20);
		jPanel.add(hotPressDropMarginLabel);

		coldPressDropMarginLabe = new JLabel("");
		coldPressDropMarginLabe.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		coldPressDropMarginLabe.setBounds(156, 495, 66, 20);
		jPanel.add(coldPressDropMarginLabe);

		JLabel label_12 = new JLabel("%");
		label_12.setBounds(232, 495, 75, 20);
		jPanel.add(label_12);

		JLabel label_4 = new JLabel("\u5B9A\u8DDD\u7BA1\u5E03\u7F6E\u578B\u5F0F");
		label_4.setBounds(10, 311, 108, 20);
		jPanel.add(label_4);

		JLabel label_10 = new JLabel("\u5B9A\u8DDD\u7BA1\u95F4\u8DDD");
		label_10.setBounds(10, 341, 75, 20);
		jPanel.add(label_10);

		pillarXSpacingField = new PureNumField();
		pillarXSpacingField.setBounds(116, 341, 30, 20);
		jPanel.add(pillarXSpacingField);

		pillarYSpacingField = new PureNumField();
		pillarYSpacingField.setBounds(192, 341, 30, 20);
		jPanel.add(pillarYSpacingField);

		JLabel label_16 = new JLabel("X:");
		label_16.setBounds(99, 341, 19, 20);
		jPanel.add(label_16);

		JLabel label_26 = new JLabel("Y:");
		label_26.setBounds(176, 341, 27, 20);
		jPanel.add(label_26);

		JLabel label_27 = new JLabel("mm");
		label_27.setBounds(232, 341, 29, 20);
		jPanel.add(label_27);

		JLabel label_15 = new JLabel("\u5B9A\u8DDD\u67F1\u6570\u91CF");
		label_15.setBounds(10, 405, 136, 20);
		jPanel.add(label_15);

		JLabel label_31 = new JLabel("\u5B9A\u8DDD\u67F1\u603B\u6570");
		label_31.setBounds(10, 435, 136, 20);
		jPanel.add(label_31);

		everyNumLabel = new JLabel("");
		everyNumLabel.setBounds(156, 405, 66, 20);
		jPanel.add(everyNumLabel);
		everyNumLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		totalNumLabel = new JLabel("");
		totalNumLabel.setBounds(156, 435, 66, 20);
		jPanel.add(totalNumLabel);
		totalNumLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel label_29 = new JLabel("\u4E2A/\u33A1");
		label_29.setBounds(229, 405, 66, 20);
		jPanel.add(label_29);

		JLabel label_30 = new JLabel("\u4E2A");
		label_30.setBounds(232, 435, 14, 20);
		jPanel.add(label_30);

		calHeatButton = new JButton("\u8BA1\u7B97");
		calHeatButton.setBounds(10, 371, 275, 25);
		jPanel.add(calHeatButton);
		calHeatButton.setEnabled(false);

		JLabel label_25 = new JLabel("\u578B");
		label_25.setBounds(232, 311, 14, 20);
		jPanel.add(label_25);

		imagePanel = new BoxChangeImgPanel(new String[] { "1", "2", "3", "4" }, pillarImgPath, 305, 295, 295, 370,
				false);
		contentPane.add(imagePanel);

		pillarBox = imagePanel.getBox();
		pillarBox.setBounds(156, 310, 66, 23);
		jPanel.add(pillarBox);

		calHeatButton.addActionListener(this);
		PanelUtils.setAllComFont(jPanel);
	}

	public void preDisplay() {
		SPHEDesignConditions designConditions = sprialHeat.getSpheDesignConditions();
		if (designConditions != null) {
			calHeatButton.setEnabled(true);
			heatJPanel.display();
			LabelAndFieldUtils.showDoublePointTwo(actualAreaLabel,
					sprialHeat.getStructuralDesign().getSpiralCoils().getActrualEffArea());
			ThermalCalculation thermalCalculation = new ThermalCalculation(sprialHeat.getPreThermalCalculation(),
					sprialHeat.getStructuralDesign());
			sprialHeat.setThermalCalculation(thermalCalculation);
			LabelAndFieldUtils.showDoublePointFive(hotDELabel, thermalCalculation.getHotDE());
			LabelAndFieldUtils.showDoublePointFive(coldDELabel, thermalCalculation.getColdDE());
			LabelAndFieldUtils.showDoublePointTwo(hotReLabel, thermalCalculation.getHotRe());
			LabelAndFieldUtils.showDoublePointTwo(coldReLabel, thermalCalculation.getColdRe());
			LabelAndFieldUtils.showDoublePointTwo(hotPrLabel, thermalCalculation.getHotPr());
			LabelAndFieldUtils.showDoublePointTwo(coldPrLabel, thermalCalculation.getColdPr());
			if (thermalCalculation.isHotRapids()) {
				isHotRapidsLable.setText("湍流");
				isHotRapidsLable.setForeground(Color.black);
			} else {
				isHotRapidsLable.setText("层流");
				isHotRapidsLable.setForeground(Color.red);
			}
			if (thermalCalculation.isColdRapids()) {
				isColdRapidsLable.setText("湍流");
				isColdRapidsLable.setForeground(Color.black);
			} else {
				isColdRapidsLable.setText("层流");
				isColdRapidsLable.setForeground(Color.red);
			}

			if (thermalCalculation.getHotHeat() == Constant.ERROR_DOUBLE) {
				JOptionPaneUtils.warningMess(contentPane, "无法获得热侧换热系数");
				calHeatButton.setEnabled(false);
				return;
			}
			if (thermalCalculation.getColdHeat() == Constant.ERROR_DOUBLE) {
				JOptionPaneUtils.warningMess(contentPane, "无法获得冷侧换热系数");
				calHeatButton.setEnabled(false);
				return;
			}
			calHeatButton.setEnabled(true);
			LabelAndFieldUtils.showDoublePointTwo(hotHeatLabel, thermalCalculation.getHotHeat());
			LabelAndFieldUtils.showDoublePointTwo(coldHeatLabel, thermalCalculation.getColdHeat());
		} else {
			calHeatButton.setEnabled(false);
		}
	}

	public void calHeat() {
		double hotFoulingResistance = hotFoulingResistanceField.getDoubleNoNull("请输入热侧污垢热阻");
		if (hotFoulingResistance == Constant.ERROR_DOUBLE) {
			return;
		}
		double coldFoulingResistance = coldFoulingResistanceField.getDoubleNoNull("请输入冷侧污垢热阻");
		if (coldFoulingResistance == Constant.ERROR_DOUBLE) {
			return;
		}
		double spiralPlateThermal = spiralPlateThermalField.getDoubleNoNull("请输入螺旋板导热系数");
		if (spiralPlateThermal == Constant.ERROR_DOUBLE) {
			return;
		}
		ThermalCalculation thermalCalculation = sprialHeat.getThermalCalculation();
		thermalCalculation.setHotFoulingResistance(hotFoulingResistance);
		thermalCalculation.setColdFoulingResistance(coldFoulingResistance);
		thermalCalculation.setSpiralPlateThermal(spiralPlateThermal);
		int pillarType = pillarBox.getSelectedIndex();
		double pillarXSpacing = pillarXSpacingField.getDoubleNoNull("请输入定距柱X方向间距");
		if (pillarXSpacing == Constant.ERROR_DOUBLE) {
			return;
		}
		double pillarYSpacing = pillarYSpacingField.getDoubleNoNull("请输入定距柱Y方向间距");
		if (pillarYSpacing == Constant.ERROR_DOUBLE) {
			return;
		}
		PillarsFixedDistance pillar = new PillarsFixedDistance(pillarType, pillarXSpacing, pillarYSpacing,
				sprialHeat.getStructuralDesign().getSpiralCoils().getActrualArea());
		sprialHeat.getStructuralDesign().setPillars(pillar);
		double pillarNumEverM = pillar.getPillarNumEveryM();
		LabelAndFieldUtils.showDoublePointTwo(everyNumLabel, pillarNumEverM);
		double numberPillars = pillar.getNumbers();
		LabelAndFieldUtils.showDoublePointTwo(totalNumLabel, numberPillars);
		LabelAndFieldUtils.showDoublePointTwo(totalHeatAreaLabel, thermalCalculation.getHeatTransferArea());
		LabelAndFieldUtils.showDoublePointTwo(totalHeatLbel, thermalCalculation.getTotalHeat());
		LabelAndFieldUtils.showDoublePointFive(hotPressureDropLabel, thermalCalculation.getHotPressureDrop());
		LabelAndFieldUtils.showDoublePointFive(coldPressureDropLabel, thermalCalculation.getColdPressureDrop());
		LabelAndFieldUtils.showDoublePointTwo(areaMarginLabel, thermalCalculation.getAreaMargin());
		LabelAndFieldUtils.showDoublePointTwo(hotPressDropMarginLabel, thermalCalculation.getHotPressDropMargin());
		LabelAndFieldUtils.showDoublePointTwo(coldPressDropMarginLabe, thermalCalculation.getColdPressDropMargin());
		if (thermalCalculation.getAreaMargin() < 0) {
			areaMarginLabel.setForeground(Color.red);
			JOptionPaneUtils.warningMess(contentPane, "实际面积偏小");
		} else {
			areaMarginLabel.setForeground(Color.BLUE);
		}
		if (thermalCalculation.getHotPressDropMargin() > 20) {
			hotPressDropMarginLabel.setForeground(Color.red);
		} else if (thermalCalculation.getHotPressDropMargin() > 10) {
			hotPressDropMarginLabel.setForeground(Color.red);
		} else {
			hotPressDropMarginLabel.setForeground(Color.black);
		}
		if (thermalCalculation.getColdPressDropMargin() > 20) {
			coldPressDropMarginLabe.setForeground(Color.red);
		} else if (thermalCalculation.getColdPressDropMargin() > 10) {
			coldPressDropMarginLabe.setForeground(Color.red);
		} else {
			coldPressDropMarginLabe.setForeground(Color.black);
		}
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		calHeat();
	}
}
