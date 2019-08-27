package com.duan.meterialstandard;

import java.io.Serializable;
import java.util.Date;

import com.duan.utils.DateUtils;

public class MeterialStandard implements Serializable {

	private static final long serialVersionUID = 1L;
	private String standardNum;
	private String name;
	private Date date;
	private int meterialType;
	private MeterialStandardProperty property;

	@Override
	/**
	 * 标准号及标准日期相同，则说明标准相同
	 */
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof MeterialStandard) {
			MeterialStandard m = (MeterialStandard) obj;
			if (m.getStandardNum().equals(standardNum) && DateUtils.parseDateToStringMonth(date)
					.equals(DateUtils.parseDateToStringMonth(m.getImplementationDate()))) {
				return true;
			}
		}
		return false;
	}

	public Date getImplementationDate() {
		return date;
	}

	public int getMeterialType() {
		return meterialType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMeterialType(int type) {
		this.meterialType = type;
	}

	public void setImplementationDate(Date date) {
		this.date = date;
	}

	public String getStandardNum() {
		return standardNum;
	}

	public void setStandardNum(String standardNum) {
		this.standardNum = standardNum;
	}

	public void setProperty(MeterialStandardProperty property) {
		// TODO Auto-generated method stub
		this.property = property;
	}

	public MeterialStandardProperty getProperty() {
		return property;
	}

}
