package com.duan.utils;

import java.awt.Component;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class ExcelUtils {
	/**
	 * 输入行位置和单元格位置，返回此位置的string值，若此值不为string或为空格，都将返回null
	 * 
	 * @param sheet
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public static String getCellStringValueAtRowAndCellNum(HSSFSheet sheet, int rowNum, int cellNum) {
		if(sheet==null) {
			return null;
		}
		HSSFRow row = sheet.getRow(rowNum);
		if(row==null) {
			return null;
		}
		HSSFCell cell = row.getCell(cellNum);
		if ( cell.getCellType() == CellType.STRING) {
			return cell.getStringCellValue();
		}
		return null;
	}
	/**
	 * 获得sheet指定位置的double数值
	 * @param sheet
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public static double getCellDoubleValueAtRowCellNum(HSSFSheet sheet, int rowNum, int cellNum) {
		if(sheet==null) {
			return Constant.ERROR_DOUBLE;
		}
		HSSFRow row = sheet.getRow(rowNum);
		if(row==null) {
			return Constant.ERROR_DOUBLE;
		}
		HSSFCell cell = row.getCell(cellNum);
		if (cell.getCellType() == CellType.NUMERIC) {
			return cell.getNumericCellValue();
		}
		return Constant.ERROR_DOUBLE;
	}

	/**
	 * 给一个已创建的行和想创建的单元格位置，创建此单元格，并设置String值
	 * 
	 * @param row
	 * @param cellNum
	 * @param cellValue
	 * @return
	 */
	public static void createAndSetCellStringValue(HSSFRow row, int cellNum, String cellValue) {
		if (row == null) {
			return;
		}
		HSSFCell cell = row.createCell(cellNum);
		if (cellValue == null || cellValue.trim().equals("")) {
			return;
		}
		cell.setCellType(CellType.STRING);
		cell.setCellValue(cellValue);
	}

	/**
	 * 给一个已创建的行和想创建的单元格位置，创建此单元格，并设置double值
	 * 
	 * @param row
	 * @param cellNum
	 * @param value
	 * @return
	 */
	public static void createAndSetCellDoubleValue(HSSFRow row, int cellNum, double value) {
		if (row == null) {
			return;
		}
		HSSFCell cell = row.createCell(cellNum);
		if (value == Constant.ERROR_DOUBLE) {
			return;
		}
		cell.setCellType(CellType.NUMERIC);
		cell.setCellValue(value);
	}

	/**
	 * 将工作表workbook写入到指定的文件excel中，若选择isCover为true，不存在则创建，若存在则直接覆盖
	 * 选择isCover为false，若不存在侧创建，若存在则弹出对话框确认是否覆盖
	 * 
	 * @param workbook      要读取的工作表对象
	 * @param excelFilePath 要存入的工作表excel地址
	 * @param messCompent   信息提示窗口容器
	 * @return
	 */
	public static boolean writeWorkbookInExcel(HSSFWorkbook workbook, String excelFilePath, Component messCompent,
			boolean isCover) {
		FileOutputStream fos = null;		
		File file = new File(excelFilePath);
		try {
			if (file.exists() && !isCover) {
				if (JOptionPaneUtils.selectMess(messCompent, "点击是将覆盖" + file.getName() + "文件")) {
					// 存在文件，且选择了覆盖确认
					fos = new FileOutputStream(file);
					fos.flush();
					workbook.write(fos);
					return true;
				} else {
					return false;
				}
			} else {
				fos = new FileOutputStream(file);
				fos.flush();
				workbook.write(fos);
				return true;
			}
		} catch (IOException e) {
			JOptionPaneUtils.warningMess(messCompent, "文件正在被占用，请先关闭");
			e.printStackTrace();
		} finally {
			StreamUtils.close(workbook);
			StreamUtils.close(fos);
		}
		return false;
	}

	/**
	 * 调用系统默认软件打开excel
	 * 
	 * @return
	 */
	public boolean openExcel(String excelPath, Component component) {
		// TODO 自动生成的方法存根
		try {
			File file = new File(excelPath);
			if (file.exists() && file.isFile()) {
				Desktop.getDesktop().open(file);
				return true;
			} else {
				JOptionPaneUtils.warningMess(component, "文件不存在！");
				return false;
			}
		} catch (IOException e1) {
			// TODO 自动生成的 catch 块、
			JOptionPaneUtils.warningMess(component, "文件正在被占用，请先关闭");
			e1.printStackTrace();
		}
		return false;
	}
}
