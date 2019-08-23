package com.duan.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	/**
	 * 
	 * @return 现在的年份
	 */
	public static int getThisYear() {
		Calendar date = Calendar.getInstance();
		return date.get(Calendar.YEAR);
	}

	/**
	 * 得到年月字符值
	 * @param date 需要转换的日期
	 * @return 例如：2018-02
	 */
	public static String parseDateToStringMonth(Date date) {		
		String partternString = "yyyy-MM";
		SimpleDateFormat sfDateFormat = new SimpleDateFormat(partternString);
		return sfDateFormat.format(date);
	}

	/**
	 * 把字符串日期转换为date对象，字符串日期应为以下格式：2018-02
	 * @param yeanAndMoth
	 * @return
	 */
	public static Date parseStringToDate(String yeanAndMoth) {
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM");
			return df.parse(yeanAndMoth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 得到年月日时分秒字符值
	 * @param date 需要转换的日期
	 * @return 例如：2018-02-02 12-30-30
	 */
	public static String parseDateToStringSecond(Date date) {		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(date);
		return dateString;
	}

	/**
	 * 得到年月日字符值
	 * @param date 需要转换的日期
	 * @return 例如：2018-02-02
	 */
	public static String parseDateToStringDay(Date date) {
		String partternString = "yyyy-MM-dd";
		SimpleDateFormat sfDateFormat = new SimpleDateFormat(partternString);
		return sfDateFormat.format(date);
	}
}
