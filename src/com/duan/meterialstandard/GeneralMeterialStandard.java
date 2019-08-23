package com.duan.meterialstandard;

import java.util.Date;

import com.duan.utils.DateUtils;

public class GeneralMeterialStandard implements MeterialStandard {

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

	@Override
	public Date getImplementationDate() {
		return date;
	}

	@Override
	public int getMeterialType() {
		return meterialType;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setMeterialType(int type) {
		this.meterialType = type;
	}

	@Override
	public void setImplementationDate(Date date) {
		this.date = date;
	}

	@Override
	public String getStandardNum() {
		return standardNum;
	}

	@Override
	public void setStandardNum(String standardNum) {
		this.standardNum = standardNum;
	}

	@Override
	public void setProperty(MeterialStandardProperty property) {
		// TODO Auto-generated method stub
		this.property = property;
	}

	@Override
	public MeterialStandardProperty getProperty() {
		return property;
	}

}
