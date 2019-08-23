package com.duan.meterialstandard;

import java.io.Serializable;
import java.util.Date;

public interface MeterialStandard extends Serializable{
	Date getImplementationDate();

	int getMeterialType();

	String getName();

	void setName(String name);

	void setMeterialType(int type);

	void setImplementationDate(Date date);

	String getStandardNum();

	void setStandardNum(String standardNum);

	void setProperty(MeterialStandardProperty property);

	MeterialStandardProperty getProperty();
}
