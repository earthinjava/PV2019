package com.duan.module.heatexchanger.sprialPlate.jpanel;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.duan.component.PureNumField;
import com.duan.component.ShowImgButton;
import com.duan.module.heatexchanger.sprialPlate.bean.PreThermalCalculation;
import com.duan.module.heatexchanger.sprialPlate.bean.SprialPlateHeatExchanger;
import com.duan.module.heatexchanger.sprialPlate.bean.designCondition.SPHEDesignConditions;
import com.duan.utils.Constant;
import com.duan.utils.LabelAndFieldUtils;
import com.duan.utils.PanelUtils;

public class PreThermalCalculationJPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private SprialPlateHeatExchanger sprialHeat;
	private JPanel contentPane;
	private PureNumField temperatureDifferenceCorrectionFactorField;
	private PureNumField preKField;
	private PureNumField surfaceAllowanceOfHeatTransferField;
	private JLabel RLabel;
	private JLabel PLabel;
	private JLabel logarithmicTemperatureDifferenceLabel;
	private JLabel preAreaLabel;
	private HeatMessPanel heatJPanel;

	/**
	 * Create the panel.
	 */
	public PreThermalCalculationJPanel(SprialPlateHeatExchanger sprialHeat) {
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
		heatJPanel.setLocation(5, 5);
		heatJPanel.setSize(327, 285);
		contentPane.add(heatJPanel);

		JPanel preJPanel = new JPanel();
		preJPanel.setLayout(null);
		preJPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		preJPanel.setBackground(SystemColor.menu);
		preJPanel.setBounds(337, 5, 443, 285);
		contentPane.add(preJPanel);

		JLabel label_4 = new JLabel("\u9519\u6D41\u6E29\u5DEE\u4FEE\u6B63\u7CFB\u6570");
		label_4.setBounds(10, 99, 136, 20);
		preJPanel.add(label_4);

		temperatureDifferenceCorrectionFactorField = new PureNumField();
		temperatureDifferenceCorrectionFactorField.setText("1.0");
		temperatureDifferenceCorrectionFactorField.setBounds(156, 98, 66, 20);
		preJPanel.add(temperatureDifferenceCorrectionFactorField);

		JLabel label_9 = new JLabel("\u5BF9\u6570\u6E29\u5DEE");
		label_9.setBounds(10, 130, 110, 20);
		preJPanel.add(label_9);

		logarithmicTemperatureDifferenceLabel = new JLabel("");
		logarithmicTemperatureDifferenceLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		logarithmicTemperatureDifferenceLabel.setBounds(156, 129, 66, 20);
		preJPanel.add(logarithmicTemperatureDifferenceLabel);

		JLabel label_30 = new JLabel("\u2103");
		label_30.setBounds(227, 129, 29, 20);
		preJPanel.add(label_30);

		JLabel label_31 = new JLabel("\u9884\u8BBE\u4F20\u70ED\u7CFB\u6570");
		label_31.setBounds(10, 160, 110, 20);
		preJPanel.add(label_31);

		preKField = new PureNumField();
		preKField.setText("2000");
		preKField.setBounds(156, 159, 66, 20);
		preJPanel.add(preKField);

		ShowImgButton sprialPlateHeatExchangerKButton = new ShowImgButton(
				PreThermalCalculation.getPreSprialPlateHeatExchangerKFigPathString());
		sprialPlateHeatExchangerKButton.setBounds(325, 160, 108, 20);
		preJPanel.add(sprialPlateHeatExchangerKButton);

		JLabel lblWm_2 = new JLabel("W/(m\u00B2\u00B7\u2103)");
		lblWm_2.setBounds(227, 159, 75, 20);
		preJPanel.add(lblWm_2);

		JLabel label_33 = new JLabel("\u8BBE\u5B9A\u9762\u79EF\u88D5\u91CF");
		label_33.setBounds(10, 191, 110, 20);
		preJPanel.add(label_33);

		surfaceAllowanceOfHeatTransferField = new PureNumField();
		surfaceAllowanceOfHeatTransferField.setText("10");
		surfaceAllowanceOfHeatTransferField.setBounds(156, 190, 66, 20);
		preJPanel.add(surfaceAllowanceOfHeatTransferField);

		JLabel label_34 = new JLabel("%");
		label_34.setBounds(227, 189, 29, 20);
		preJPanel.add(label_34);

		JLabel label_35 = new JLabel("\u521D\u7B97\u6362\u70ED\u9762\u79EF");
		label_35.setBounds(10, 222, 110, 20);
		preJPanel.add(label_35);

		preAreaLabel = new JLabel("");
		preAreaLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		preAreaLabel.setBounds(156, 221, 66, 20);
		preJPanel.add(preAreaLabel);

		JLabel label_37 = new JLabel("\u33A1");
		label_37.setBounds(227, 221, 29, 20);
		preJPanel.add(label_37);

		JButton preThermalCalButton = new JButton("\u8BA1\u7B97");
		preThermalCalButton.setBounds(10, 252, 423, 25);
		preJPanel.add(preThermalCalButton);
		preThermalCalButton.addActionListener(this);

		JLabel lblP = new JLabel("P");
		lblP.setBounds(10, 69, 21, 20);
		preJPanel.add(lblP);

		PLabel = new JLabel("");
		PLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		PLabel.setBounds(156, 69, 66, 20);
		preJPanel.add(PLabel);

		JLabel lblR = new JLabel("R");
		lblR.setBounds(10, 39, 21, 20);
		preJPanel.add(lblR);

		RLabel = new JLabel("");
		RLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		RLabel.setBounds(156, 39, 66, 20);
		preJPanel.add(RLabel);

		ShowImgButton temperatureDifferenceCorrectionFactorButton = new ShowImgButton(
				PreThermalCalculation.getTemperatureDifferenceCorrectionFactorFigPathString());
		temperatureDifferenceCorrectionFactorButton.setBounds(325, 99, 108, 20);
		preJPanel.add(temperatureDifferenceCorrectionFactorButton);

		JLabel label_14 = new JLabel("\u6362\u70ED\u521D\u7B97\uFF1A");
		label_14.setBounds(10, 10, 82, 20);
		preJPanel.add(label_14);

		PanelUtils.setAllComFont(preJPanel);

	}

	public void preDisplay() {
		SPHEDesignConditions designConditions = sprialHeat.getSpheDesignConditions();
		if (designConditions != null) {
			heatJPanel.display();
			LabelAndFieldUtils.showDoublePointTwo(RLabel,
					sprialHeat.getSpheDesignConditions().getTemperatureDifferenceCorrectionFactorR());
			LabelAndFieldUtils.showDoublePointTwo(PLabel,
					sprialHeat.getSpheDesignConditions().getTemperatureDifferenceCorrectionFactorP());
		}
	}

	public void apply() {
		double f = temperatureDifferenceCorrectionFactorField.getDoubleNoNull("请输入错流温差纠正系数");
		if (f == Constant.ERROR_DOUBLE) {
			return;
		}
		double preK = preKField.getDoubleNoNull("请输入预设总传热系数");
		if (preK == Constant.ERROR_DOUBLE) {
			return;
		}
		double surfaceAllowanceOfHeatTransfer = surfaceAllowanceOfHeatTransferField.getDoubleCanNull();
		if (surfaceAllowanceOfHeatTransfer == Constant.ERROR_DOUBLE) {
			surfaceAllowanceOfHeatTransfer = 0;
			surfaceAllowanceOfHeatTransferField.setText("0");
		}
		surfaceAllowanceOfHeatTransfer /= 100;
		PreThermalCalculation thermalCalculation = new PreThermalCalculation(sprialHeat.getSpheDesignConditions());
		sprialHeat.setPreThermalCalculation(thermalCalculation);
		thermalCalculation.setTemperatureDifferenceCorrectionFactor(f);
		thermalCalculation.setPreHeatTransferCoefficient(preK);
		thermalCalculation.setSurfaceAllowanceOfHeatTransfer(surfaceAllowanceOfHeatTransfer);
		LabelAndFieldUtils.showDoublePointTwo(logarithmicTemperatureDifferenceLabel,
				thermalCalculation.getLogarithmicTemperatureDifference());
		LabelAndFieldUtils.showDoublePointTwo(preAreaLabel, thermalCalculation.getPreHeatTransferArea());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		apply();
	}
}
