package com.duan.module.heatexchanger.sprialPlate.jpanel;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.duan.module.calculate.HaveNeedSavePanel;
import com.duan.module.heatexchanger.sprialPlate.bean.SprialPlateHeatExchanger;
import com.duan.utils.Constant;
import com.duan.utils.FontUtils;

public class SprialPlateHeatExchangerJPanel extends HaveNeedSavePanel implements ChangeListener {

	private static final long serialVersionUID = 1L;
	private SprialPlateHeatExchanger sprialHeat = new SprialPlateHeatExchanger();
	private JTabbedPane tabbedPane;
	private SPHEDesignConditionJPanel designConditionJPanel;
	private PreThermalCalculationJPanel preThermalCalculationJPanel;
	private StructuralDesignJPanel structuralDesignJPanel;
	private ThermalCalculationJPanel thermalCalculationJPanel;

	public SprialPlateHeatExchangerJPanel() {
		setBackground(Color.WHITE);
		setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 0, 785, 720);
		FontUtils.setDefaultFont(tabbedPane);
		add(tabbedPane);

		designConditionJPanel = new SPHEDesignConditionJPanel(sprialHeat);
		addTabbedPane(designConditionJPanel, "设计条件");

		preThermalCalculationJPanel = new PreThermalCalculationJPanel(sprialHeat);
		addTabbedPane(preThermalCalculationJPanel, "换热初算");

		structuralDesignJPanel = new StructuralDesignJPanel(sprialHeat);
		addTabbedPane(structuralDesignJPanel, "结构设计");

		thermalCalculationJPanel = new ThermalCalculationJPanel(sprialHeat);
		addTabbedPane(thermalCalculationJPanel, "换热计算");

		tabbedPane.addChangeListener(this);

	}

	private void addTabbedPane(JPanel moduleJPanel, String meduleName) {
		moduleJPanel.setLocation(0, 0);
		tabbedPane.addTab(meduleName, null, moduleJPanel, null);
	}

	@Override
	public boolean isNeedSave() {
		// TODO 自动生成的方法存根
		return true;
	}

	@Override
	public String getChiName() {
		// TODO 自动生成的方法存根
		return Constant.MODULE_CHINAME[2];
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO 自动生成的方法存根
		int index = tabbedPane.getSelectedIndex();
		if (index == 1) {
			designConditionJPanel.apply();
			if (sprialHeat.getSpheDesignConditions() == null) {
				tabbedPane.setSelectedIndex(0);
			} else {
				preThermalCalculationJPanel.preDisplay();
			}
		} else if (index == 2) {
			designConditionJPanel.apply();
			if (sprialHeat.getSpheDesignConditions() == null) {
				tabbedPane.setSelectedIndex(0);
				return;
			}
			preThermalCalculationJPanel.apply();
			if (sprialHeat.getPreThermalCalculation() == null) {
				tabbedPane.setSelectedIndex(1);
			} else {
				structuralDesignJPanel.preDisplay();
			}

		} else if (index == 3) {
			designConditionJPanel.apply();
			if (sprialHeat.getSpheDesignConditions() == null) {
				tabbedPane.setSelectedIndex(0);
				return;
			}
			preThermalCalculationJPanel.apply();
			if (sprialHeat.getPreThermalCalculation() == null) {
				tabbedPane.setSelectedIndex(1);
			}
			structuralDesignJPanel.preCal();
			structuralDesignJPanel.actualCal();
			if (sprialHeat.getStructuralDesign() == null) {
				tabbedPane.setSelectedIndex(2);
			} else {
				thermalCalculationJPanel.preDisplay();
			}

		}
	}
}
