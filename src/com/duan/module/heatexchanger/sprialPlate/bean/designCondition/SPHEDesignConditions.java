package com.duan.module.heatexchanger.sprialPlate.bean.designCondition;

import java.io.Serializable;

public class SPHEDesignConditions implements Serializable{
	
	private static final long serialVersionUID = 7039349485252628477L;
	private SPHEHotDesignCondition hotDesignCondition;
	private SPHEColdDesignCondition coldDesignCondition;
	private double temperatureDifferenceCorrectionFactorR;
	private double temperatureDifferenceCorrectionFactorP;
	private boolean isDownStream;
	private boolean isHotOut;
	private int heatExchangerType;

	public SPHEDesignConditions(SPHEHotDesignCondition hotDesignCondition, SPHEColdDesignCondition coldDesignCondition,
			boolean isDownStream, boolean isHotOut, int heatExchangerType) {
		// TODO Auto-generated constructor stub
		this.hotDesignCondition = hotDesignCondition;
		this.coldDesignCondition = coldDesignCondition;
		this.isDownStream = isDownStream;
		this.isHotOut = isHotOut;
		this.setHeatExchangerType(heatExchangerType);
	}

	public SPHEDesignCondition getColdDesignCondition() {
		return coldDesignCondition;
	}

	public SPHEDesignCondition getHotDesignCondition() {
		return hotDesignCondition;
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

	public boolean isHotOut() {
		return isHotOut;
	}

	public int getsetHeatExchangerType() {
		return heatExchangerType;
	}

	public void setHeatExchangerType(int heatExchangerType) {
		this.heatExchangerType = heatExchangerType;
	}

}
