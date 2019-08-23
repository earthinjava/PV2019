package com.duan.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class StreamUtils {
	/**
	 * 关闭工作簿流
	 * 
	 * @param workbook
	 */
	public static void close(HSSFWorkbook workbook) {
		if (workbook != null) {
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ObjectInputStream ois) {
		if (ois != null) {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭流
	 * 
	 * @param close
	 */
	public static void close(Closeable close) {
		if (close != null) {
			try {
				close.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
