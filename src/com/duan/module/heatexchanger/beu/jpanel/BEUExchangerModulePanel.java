package com.duan.module.heatexchanger.beu.jpanel;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.duan.module.calculate.HaveNeedSavePanel;
import com.duan.module.heatexchanger.beu.bean.BEUHeatExchanger;
import com.duan.utils.Constant;
import com.duan.utils.FontUtils;

public class BEUExchangerModulePanel extends HaveNeedSavePanel implements ChangeListener {
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;
	private HeatDesignContionPanel heatDesignConJPanel;
	private ShellSideCylinderlPanel shellSideCylinderPanel;
	private UHeatTubePanel uheatTubePanel;
	private TubeBundleJPanel tubeBundleJPanel;
	private TubeBoxDivisionPlatePanel tubeBoxDivisionPlatePanel;
	private TubePlateGasketPanel tubePlateGasketPanel;
	private TubePlateJPanel tubePalteJPanel;
	private BEUHeatExchanger beuHeatExchanger = new BEUHeatExchanger();

	/**
	 * Create the panel.
	 */
	public BEUExchangerModulePanel() {
		setBackground(Color.WHITE);
		setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		FontUtils.setDefaultFont(tabbedPane);
		tabbedPane.setBounds(0, 0, 2000, 720);
		add(tabbedPane);

		heatDesignConJPanel = new HeatDesignContionPanel(beuHeatExchanger);
		addTabbedPane(heatDesignConJPanel, "设计条件");

		shellSideCylinderPanel = new ShellSideCylinderlPanel(beuHeatExchanger, heatDesignConJPanel);
		addTabbedPane(shellSideCylinderPanel, "壳程筒体");

		uheatTubePanel = new UHeatTubePanel(beuHeatExchanger, heatDesignConJPanel);
		addTabbedPane(uheatTubePanel, "U换热管");

		tubeBundleJPanel = new TubeBundleJPanel(beuHeatExchanger);
		addTabbedPane(tubeBundleJPanel, "换热管束");

		tubeBoxDivisionPlatePanel = new TubeBoxDivisionPlatePanel(beuHeatExchanger, heatDesignConJPanel);
		addTabbedPane(tubeBoxDivisionPlatePanel, "管箱隔板");

		tubePlateGasketPanel = new TubePlateGasketPanel(beuHeatExchanger);
		addTabbedPane(tubePlateGasketPanel, "管板垫片");

		tubePalteJPanel = new TubePlateJPanel(beuHeatExchanger, heatDesignConJPanel);
		addTabbedPane(tubePalteJPanel, "管板");

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
		return Constant.MODULE_CHINAME[1];
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		int index = tabbedPane.getSelectedIndex();
		if (index == 1) {
			heatDesignConJPanel.apply();
			if (beuHeatExchanger.getHeatDesignConditions() == null) {
				tabbedPane.setSelectedIndex(0);
				return;
			}
		}
		if (index == 2) {
			heatDesignConJPanel.apply();
			if (beuHeatExchanger.getHeatDesignConditions() == null) {
				tabbedPane.setSelectedIndex(0);
				return;
			}
		}
		if (index == 3) {
			heatDesignConJPanel.apply();
			if (beuHeatExchanger.getHeatDesignConditions() == null) {
				tabbedPane.setSelectedIndex(0);
				return;
			}
			shellSideCylinderPanel.apply();
			if (beuHeatExchanger.getShellSideCylinder() == null) {
				tabbedPane.setSelectedIndex(1);
				return;
			}
			uheatTubePanel.apply();
			if (beuHeatExchanger.getUHeatTube() == null) {
				tabbedPane.setSelectedIndex(2);
				return;
			}
			tubeBundleJPanel.autoFill();
		}
		if (index == 4) {
			heatDesignConJPanel.apply();
			if (beuHeatExchanger.getHeatDesignConditions() == null) {
				tabbedPane.setSelectedIndex(0);
				return;
			}
		}
		if (index == 6) {
			heatDesignConJPanel.apply();
			if (beuHeatExchanger.getHeatDesignConditions() == null) {
				tabbedPane.setSelectedIndex(0);
				return;
			}
			shellSideCylinderPanel.apply();
			if (beuHeatExchanger.getShellSideCylinder() == null) {
				tabbedPane.setSelectedIndex(1);
				return;
			}
			uheatTubePanel.apply();
			if (beuHeatExchanger.getUHeatTube() == null) {
				tabbedPane.setSelectedIndex(2);
				return;
			}
			tubeBundleJPanel.autoFill();
			tubeBundleJPanel.apply();
			if (beuHeatExchanger.getTubeBundle() == null) {
				tabbedPane.setSelectedIndex(3);
				return;
			}
			tubePlateGasketPanel.apply();
			if (beuHeatExchanger.getTubePlateGasket() == null) {
				tabbedPane.setSelectedIndex(5);
				return;
			}
			tubePalteJPanel.autoFill();
		}

	}

}
