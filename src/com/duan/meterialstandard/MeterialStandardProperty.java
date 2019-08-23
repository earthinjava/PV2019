package com.duan.meterialstandard;

import java.io.Serializable;

import com.duan.utils.Constant;

public class MeterialStandardProperty implements Serializable{

	private static final long serialVersionUID = 1L;
	private String meterialComponent;
	private boolean isNonferrous;

	public void setMeterialComponent(String meterialComponent) {
		this.meterialComponent = meterialComponent;
	}

	/**
	 * 材料的组分，如：碳钢，不锈钢，铜，钛等
	 * 
	 * @return
	 */
	public String getMeterialComponent() {
		return meterialComponent;
	}

	/**
	 * 是否为有色金属，true表示是有色金属
	 * 
	 * @return
	 */
	public boolean isNonferrous() {
		if (meterialComponent.equals(Constant.METERIALCOMPONONT_CARBONSTEEL)
				|| meterialComponent.equals(Constant.METERIALCOMPONONT_STAINLESSSTEEL)) {
			isNonferrous = false;
		} else {
			isNonferrous = true;
		}
		return isNonferrous;
	}
}
