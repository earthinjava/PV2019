package com.duan.module.heatexchanger.sprialPlate.jpanel;

import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import com.duan.module.heatexchanger.sprialPlate.bean.SprialPlateHeatExchanger;
import com.duan.module.heatexchanger.sprialPlate.bean.designCondition.SPHEDesignConditions;
import com.duan.utils.LabelAndFieldUtils;
import com.duan.utils.PanelUtils;


public class HeatMessPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SprialPlateHeatExchanger sprialHeat;
	private JLabel hotCalTempLabel;
	private JLabel coldCalTempLabel;
	private JLabel massFlowHotLabel;
	private JLabel massFlowColdLabel;
	private JLabel volumeFlowHotLabel;
	private JLabel volumeFlowColdLabel;
	private JLabel densityHotLabel;
	private JLabel densityColdLabel;
	private JLabel viscosityHotLabel;
	private JLabel viscosityColdLabel;
	private JLabel specificHeatCapacityHotLabel;
	private JLabel specificHeatCapacityColdLabel;
	private JLabel thermalConductivityHotLabel;
	private JLabel thermalConductivityColdLabel;
	private JLabel heatLabel;

	public HeatMessPanel(SprialPlateHeatExchanger sprialHeat) {
		this.sprialHeat = sprialHeat;

		setLayout(null);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setBackground(SystemColor.menu);
		setBounds(10, 10, 295, 316);

		JLabel label_11 = new JLabel("\u5B9A\u6027\u6E29\u5EA6");
		label_11.setBounds(10, 40, 60, 20);
		add(label_11);

		JLabel label_17 = new JLabel("\u70ED\u4FA7\u4ECB\u8D28");
		label_17.setBounds(86, 10, 60, 20);
		add(label_17);

		JLabel label_18 = new JLabel("\u51B7\u4FA7\u4ECB\u8D28");
		label_18.setBounds(156, 10, 60, 20);
		add(label_18);

		hotCalTempLabel = new JLabel("");
		hotCalTempLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hotCalTempLabel.setBounds(80, 40, 66, 20);
		add(hotCalTempLabel);

		coldCalTempLabel = new JLabel("");
		coldCalTempLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		coldCalTempLabel.setBounds(156, 40, 66, 20);
		add(coldCalTempLabel);

		JLabel label_24 = new JLabel("\u2103");
		label_24.setBounds(227, 40, 29, 20);
		add(label_24);

		JLabel label_5 = new JLabel("\u8D28\u91CF\u6D41\u91CF");
		label_5.setBounds(10, 70, 60, 20);
		add(label_5);

		massFlowHotLabel = new JLabel("");
		massFlowHotLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		massFlowHotLabel.setBounds(80, 70, 66, 20);
		add(massFlowHotLabel);

		massFlowColdLabel = new JLabel("");
		massFlowColdLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		massFlowColdLabel.setBounds(156, 70, 66, 20);
		add(massFlowColdLabel);

		JLabel lblKgs = new JLabel("kg/s");
		lblKgs.setBounds(227, 73, 29, 20);
		add(lblKgs);

		JLabel label_12 = new JLabel("\u4F53\u79EF\u6D41\u91CF");
		label_12.setBounds(10, 100, 60, 20);
		add(label_12);

		volumeFlowHotLabel = new JLabel("");
		volumeFlowHotLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		volumeFlowHotLabel.setBounds(80, 100, 66, 20);
		add(volumeFlowHotLabel);

		volumeFlowColdLabel = new JLabel("");
		volumeFlowColdLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		volumeFlowColdLabel.setBounds(156, 100, 66, 20);
		add(volumeFlowColdLabel);

		JLabel lblMh = new JLabel("m\u00B3/h");
		lblMh.setBounds(227, 103, 29, 20);
		add(lblMh);

		JLabel label_16 = new JLabel("\u4ECB\u8D28\u5BC6\u5EA6");
		label_16.setBounds(10, 130, 60, 20);
		add(label_16);

		densityHotLabel = new JLabel("");
		densityHotLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		densityHotLabel.setBounds(80, 130, 66, 20);
		add(densityHotLabel);

		densityColdLabel = new JLabel("");
		densityColdLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		densityColdLabel.setBounds(156, 130, 66, 20);
		add(densityColdLabel);

		JLabel lblKgm = new JLabel("kg/m\u00B3");
		lblKgm.setBounds(227, 133, 43, 20);
		add(lblKgm);

		JLabel label_23 = new JLabel("\u4ECB\u8D28\u7C98\u5EA6");
		label_23.setBounds(10, 160, 60, 20);
		add(label_23);

		viscosityHotLabel = new JLabel("");
		viscosityHotLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		viscosityHotLabel.setBounds(80, 160, 66, 20);
		add(viscosityHotLabel);

		viscosityColdLabel = new JLabel("");
		viscosityColdLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		viscosityColdLabel.setBounds(156, 160, 66, 20);
		add(viscosityColdLabel);

		JLabel lblPas = new JLabel("pa\u00B7s");
		lblPas.setBounds(227, 163, 43, 20);
		add(lblPas);

		JLabel label_28 = new JLabel("\u6BD4\u70ED\u5BB9");
		label_28.setBounds(10, 190, 60, 20);
		add(label_28);

		specificHeatCapacityHotLabel = new JLabel("");
		specificHeatCapacityHotLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		specificHeatCapacityHotLabel.setBounds(80, 190, 66, 20);
		add(specificHeatCapacityHotLabel);

		specificHeatCapacityColdLabel = new JLabel("");
		specificHeatCapacityColdLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		specificHeatCapacityColdLabel.setBounds(156, 190, 66, 20);
		add(specificHeatCapacityColdLabel);

		JLabel lblKjkg = new JLabel("kJ/kg.\u2103");
		lblKjkg.setBounds(227, 193, 58, 20);
		add(lblKjkg);

		JLabel label_32 = new JLabel("\u5BFC\u70ED\u7CFB\u6570");
		label_32.setBounds(10, 220, 60, 20);
		add(label_32);

		thermalConductivityHotLabel = new JLabel("");
		thermalConductivityHotLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		thermalConductivityHotLabel.setBounds(80, 220, 66, 20);
		add(thermalConductivityHotLabel);

		thermalConductivityColdLabel = new JLabel("");
		thermalConductivityColdLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		thermalConductivityColdLabel.setBounds(156, 220, 66, 20);
		add(thermalConductivityColdLabel);

		JLabel lblWm = new JLabel("W/m\u00B7\u2103");
		lblWm.setBounds(227, 223, 68, 20);
		add(lblWm);

		JLabel label_21 = new JLabel("\u6362\u70ED\u91CF");
		label_21.setBounds(10, 250, 60, 20);
		add(label_21);

		heatLabel = new JLabel("");
		heatLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		heatLabel.setBounds(80, 250, 142, 20);
		add(heatLabel);

		JLabel lblW = new JLabel("W");
		lblW.setBounds(227, 250, 68, 20);
		add(lblW);
		PanelUtils.setAllComFont(this);
	}

	public void display() {
		SPHEDesignConditions designConditions = sprialHeat.getSpheDesignConditions();
		if (designConditions != null) {
			LabelAndFieldUtils.showDoublePointTwo(hotCalTempLabel,
					designConditions.getHotDesignCondition().getMedium().getTemperature());
			LabelAndFieldUtils.showDoublePointTwo(coldCalTempLabel,
					designConditions.getColdDesignCondition().getMedium().getTemperature());
			LabelAndFieldUtils.showDoublePointTwo(massFlowHotLabel, designConditions.getHotDesignCondition().getMassFlow());
			LabelAndFieldUtils.showDoublePointTwo(massFlowColdLabel, designConditions.getColdDesignCondition().getMassFlow());
			LabelAndFieldUtils.showDoublePointTwo(volumeFlowHotLabel,
					designConditions.getHotDesignCondition().getVolumnFlow() * 3600);
			LabelAndFieldUtils.showDoublePointTwo(volumeFlowColdLabel,
					designConditions.getColdDesignCondition().getVolumnFlow() * 3600);
			LabelAndFieldUtils.showDoublePointTwo(densityHotLabel,
					designConditions.getHotDesignCondition().getMedium().getDensity());
			LabelAndFieldUtils.showDoublePointTwo(densityColdLabel,
					designConditions.getColdDesignCondition().getMedium().getDensity());
			LabelAndFieldUtils.showDoublePointFive(viscosityHotLabel,
					designConditions.getHotDesignCondition().getMedium().getViscosity());
			LabelAndFieldUtils.showDoublePointFive(viscosityColdLabel,
					designConditions.getColdDesignCondition().getMedium().getViscosity());
			LabelAndFieldUtils.showDoublePointTwo(specificHeatCapacityHotLabel,
					designConditions.getHotDesignCondition().getMedium().getSpecificHeatCapacity() / 1000);
			LabelAndFieldUtils.showDoublePointTwo(specificHeatCapacityColdLabel,
					designConditions.getColdDesignCondition().getMedium().getSpecificHeatCapacity() / 1000);
			LabelAndFieldUtils.showDoublePointTwo(thermalConductivityHotLabel,
					designConditions.getHotDesignCondition().getMedium().getThermalConductivity());
			LabelAndFieldUtils.showDoublePointTwo(thermalConductivityColdLabel,
					designConditions.getColdDesignCondition().getMedium().getThermalConductivity());
			LabelAndFieldUtils.showDoublePointTwo(heatLabel, designConditions.getHotDesignCondition().getHeat());
		}
	}

	public void clearDisplay() {
		LabelAndFieldUtils.showDoublePointTwo(hotCalTempLabel, 0);
		LabelAndFieldUtils.showDoublePointTwo(coldCalTempLabel, 0);
		LabelAndFieldUtils.showDoublePointTwo(massFlowHotLabel, 0);
		LabelAndFieldUtils.showDoublePointTwo(massFlowColdLabel, 0);
		LabelAndFieldUtils.showDoublePointTwo(volumeFlowHotLabel, 0);
		LabelAndFieldUtils.showDoublePointTwo(volumeFlowColdLabel, 0);
		LabelAndFieldUtils.showDoublePointTwo(densityHotLabel, 0);
		LabelAndFieldUtils.showDoublePointTwo(densityColdLabel, 0);
		LabelAndFieldUtils.showDoublePointFive(viscosityHotLabel, 0);
		LabelAndFieldUtils.showDoublePointFive(viscosityColdLabel, 0);
		LabelAndFieldUtils.showDoublePointTwo(specificHeatCapacityHotLabel, 0);
		LabelAndFieldUtils.showDoublePointTwo(specificHeatCapacityColdLabel, 0);
		LabelAndFieldUtils.showDoublePointTwo(thermalConductivityHotLabel, 0);
		LabelAndFieldUtils.showDoublePointTwo(thermalConductivityColdLabel, 0);
		LabelAndFieldUtils.showDoublePointTwo(heatLabel, 0);
	}

}
