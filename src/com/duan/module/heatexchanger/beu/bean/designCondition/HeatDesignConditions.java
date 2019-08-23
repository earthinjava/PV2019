package com.duan.module.heatexchanger.beu.bean.designCondition;

import java.io.Serializable;

public class HeatDesignConditions implements Serializable{
	
	private static final long serialVersionUID = 7696201475484753096L;
	private HeatDesignCondition shellDesignCondition;
	private HeatDesignCondition tubeDesignCondition;
	private HeatDesignCondition hotDesignCondition;
	private HeatDesignCondition coldDesignCondition;
	private double temperatureDifferenceCorrectionFactorR;
	private double temperatureDifferenceCorrectionFactorP;
	private boolean isDownStream;

	public HeatDesignConditions(HeatDesignCondition hotDesignCondition, HeatDesignCondition coldDesignCondition,
			boolean isDownStream) {
		// TODO Auto-generated constructor stub
		this.setHotDesignCondition(hotDesignCondition);
		this.setColdDesignCondition(coldDesignCondition);
		if (hotDesignCondition.isInTube()) {
			tubeDesignCondition = hotDesignCondition;
			shellDesignCondition = coldDesignCondition;
		} else {
			tubeDesignCondition = coldDesignCondition;
			shellDesignCondition = hotDesignCondition;
		}
		this.isDownStream = isDownStream;
	}

	// �����²�����ϵ��Rֵ
	public double getTemperatureDifferenceCorrectionFactorR() {
		temperatureDifferenceCorrectionFactorR = hotDesignCondition.getInletTemp() - hotDesignCondition.getOutletTemp();
		temperatureDifferenceCorrectionFactorR = temperatureDifferenceCorrectionFactorR
				/ (coldDesignCondition.getOutletTemp() - coldDesignCondition.getInletTemp());
		return temperatureDifferenceCorrectionFactorR;
	}

	// �����²�����ϵ��Pֵ
	public double getTemperatureDifferenceCorrectionFactorP() {
		temperatureDifferenceCorrectionFactorP = coldDesignCondition.getOutletTemp()
				- coldDesignCondition.getInletTemp();
		temperatureDifferenceCorrectionFactorP = temperatureDifferenceCorrectionFactorP
				/ (hotDesignCondition.getInletTemp() - coldDesignCondition.getInletTemp());
		return temperatureDifferenceCorrectionFactorP;
	}

	public boolean isDownStream() {
		return isDownStream;
	}

	public HeatDesignCondition getShellDesignCondition() {
		return shellDesignCondition;
	}

	public void setShellDesignCondition(HeatDesignCondition shellDesignCondition) {
		this.shellDesignCondition = shellDesignCondition;
	}

	public HeatDesignCondition getTubeDesignCondition() {
		return tubeDesignCondition;
	}

	public void setTubeDesignCondition(HeatDesignCondition tubeDesignCondition) {
		this.tubeDesignCondition = tubeDesignCondition;
	}

	public HeatDesignCondition getHotDesignCondition() {
		return hotDesignCondition;
	}

	public void setHotDesignCondition(HeatDesignCondition hotDesignCondition) {
		this.hotDesignCondition = hotDesignCondition;
	}

	public HeatDesignCondition getColdDesignCondition() {
		return coldDesignCondition;
	}

	public void setColdDesignCondition(HeatDesignCondition colDesignCondition) {
		this.coldDesignCondition = colDesignCondition;
	}

	public double getTubePlateDesTemp() {
		return hotDesignCondition.getDesignTemp() > coldDesignCondition.getDesignTemp()
				? hotDesignCondition.getDesignTemp()
				: coldDesignCondition.getDesignTemp();
	}
}
