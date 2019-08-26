package com.duan.meterial;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import com.duan.meterialstandard.MeterialStandard;
import com.duan.meterialstandard.MeterialStandardDAO;
import com.duan.utils.ArrayUtils;
import com.duan.utils.Constant;
import com.duan.utils.DateUtils;
import com.duan.utils.ExcelUtils;
import com.duan.utils.FileUtils;
import com.duan.utils.JOptionPaneUtils;
import com.duan.utils.StreamUtils;

public class MeterialDao {

	private Meterial meterial;

	public MeterialDao(Meterial meterial) {
		this.meterial = meterial;
	}

	/**
	 * 将bean中的stresstable写入到sheet中
	 * 
	 * @param jtable 数据地址
	 * @param sheet  存放到的新地
	 */
	public void writeFromBeanStressJTableToSheet(HSSFSheet sheet) {
		int rows = meterial.getAllowStressTable().getRowCount();// 行数
		int cols = meterial.getAllowStressTable().getColumnCount();// 列数
		// 获得header
		JTableHeader jTableHeader = meterial.getAllowStressTable().getTableHeader();
		HSSFRow row0 = sheet.createRow(0);
		for (int i = 0; i < cols; i++) {
			String value = (String) jTableHeader.getColumnModel().getColumn(i).getHeaderValue();
			ExcelUtils.createAndSetCellStringValue(row0, i, value);
		}
		// 读取allowStressTable数据
		for (int rs = 0; rs < rows; rs++) {// �?
			HSSFRow row = sheet.createRow(rs + 1);
			for (int ls = 0; ls < cols; ls++) {
				String value = (String) meterial.getAllowStressTable().getValueAt(rs, ls);
				ExcelUtils.createAndSetCellStringValue(row, ls, value);
			}

		}
	}

	/**
	 * 把bean中的属性写到sheet中
	 * 
	 * @param sheet
	 */
	public void writeFromBeanPropertyToSheet(HSSFSheet sheet) {
		String standardNum = meterial.getMeterialStandard().getStandardNum();
		double density = meterial.getDensity();
		double modulus = meterial.getModulus();
		double expansion = meterial.getExpansion();
		double thermal = meterial.getThermalConductivity();
		double tem = meterial.getMinAllowTemp();

		HSSFRow row = sheet.createRow(0);
		ExcelUtils.createAndSetCellStringValue(row, 0, "材料标准");
		ExcelUtils.createAndSetCellStringValue(row, 1, standardNum);

		row = sheet.createRow(1);
		ExcelUtils.createAndSetCellStringValue(row, 0, "密度kg/m³");
		ExcelUtils.createAndSetCellDoubleValue(row, 1, density);

		row = sheet.createRow(2);
		ExcelUtils.createAndSetCellStringValue(row, 0, "弹性模量10³MPa");
		ExcelUtils.createAndSetCellDoubleValue(row, 1, modulus);

		row = sheet.createRow(3);
		ExcelUtils.createAndSetCellStringValue(row, 0, "线膨胀系数mm/m.℃");
		ExcelUtils.createAndSetCellDoubleValue(row, 1, expansion);

		row = sheet.createRow(4);
		ExcelUtils.createAndSetCellStringValue(row, 0, "导热系数w/(M.K)");
		ExcelUtils.createAndSetCellDoubleValue(row, 1, thermal);

		row = sheet.createRow(5);
		ExcelUtils.createAndSetCellStringValue(row, 0, "最低许用温度℃");
		ExcelUtils.createAndSetCellDoubleValue(row, 1, tem);
	}

	/**
	 * 根据材料标准，获得符合此标准的所有材料
	 * 
	 * @param selMeterialStandard
	 * @return
	 */
	public static ArrayList<Meterial> getConformStandardMeterials(MeterialStandard meterialStandard) {
		if (meterialStandard == null) {// 材料标准不存在，直接返回
			return null;
		}
		String pathname = new MeterialStandardDAO(meterialStandard).getFilePath();
		File file = new File(pathname);
		String[] fileList = file.list();
		if (fileList == null) {// 材料标准中没有材料，返回空
			return null;
		}
		ArrayList<Meterial> meterials = new ArrayList<Meterial>();
		for (String f : fileList) {
			if (!f.equals("standardproperty.xls")) {
				String pn = pathname + "/" + f;
				Meterial meterial = getMeterialByPath(pn, meterialStandard);
				if (meterial != null) {
					meterials.add(meterial);
				}
			}
		}
		return meterials;
	}

	/**
	 * 根据地址获得meterial对象
	 * 
	 * @param meterialExcelPath
	 * @return
	 */
	public static Meterial getMeterialByPath(String meterialExcelPath, MeterialStandard meterialStandard) {
		Meterial meterial;
		InputStream inp = null;
		HSSFWorkbook workbook = null;
		try {
			inp = new FileInputStream(new File(meterialExcelPath));
			workbook = new HSSFWorkbook(inp);
			HSSFSheet stressSheet = workbook.getSheet("allowStress");
			HSSFSheet proSheet = workbook.getSheet("properties");
			meterial = new GeneralMeterial();
			meterial.setMeterialStandard(meterialStandard);
			String name = meterialExcelPath.substring(meterialExcelPath.lastIndexOf("/") + 1);
			name = name.substring(0, name.lastIndexOf("."));
			meterial.setName(name);
			double density = ExcelUtils.getCellDoubleValueAtRowCellNum(proSheet, 1, 1);
			meterial.setDensity(density);
			double expansion = ExcelUtils.getCellDoubleValueAtRowCellNum(proSheet, 3, 1);
			meterial.setExpansion(expansion);
			double modulus = ExcelUtils.getCellDoubleValueAtRowCellNum(proSheet, 2, 1);
			meterial.setModulus(modulus);
			double thermalConductivity = ExcelUtils.getCellDoubleValueAtRowCellNum(proSheet, 4, 1);
			meterial.setThermalConductivity(thermalConductivity);
			double minTemp = ExcelUtils.getCellDoubleValueAtRowCellNum(proSheet, 5, 1);
			meterial.setMinAllowTemp(minTemp);
			// 得到许用应力
			String[][] tableContentStrings = new String[20][20];
			JTable allowStressTable = new JTable(tableContentStrings, Constant.STRESSTABLE_HEADER);
			for (int i = 0; i < 4; i++) {
				allowStressTable.getColumnModel().getColumn(i).setPreferredWidth(135);
			}
			for (int i = 4; i < 20; i++) {
				allowStressTable.getColumnModel().getColumn(i).setPreferredWidth(70);
			}
			// 遍历
			int lastRowNum = stressSheet.getLastRowNum();
			if (lastRowNum >= 1) {
				for (int r = 1; r <= lastRowNum; r++) {
					for (int j = 0; j < 20; j++) {
						HSSFCell cell = stressSheet.getRow(r).getCell(j);
						if (cell != null) {
							if (cell.getCellType() == CellType.STRING) {
								String s = cell.getStringCellValue();
								if (s != null && s.trim() != "") {
									tableContentStrings[r - 1][j] = s;
								}
							} else if (cell.getCellType() == CellType.NUMERIC) {
								double s = cell.getNumericCellValue();
								tableContentStrings[r - 1][j] = s + "";
							}

						}
					}
				}
			}
			// 设置许用应力
			meterial.setAllowStressTable(allowStressTable);
			return meterial;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			StreamUtils.close(workbook);
			StreamUtils.close(inp);
		}
		return null;
	}

	/**
	 * 保存meterial对象到excel中
	 * 
	 * @return
	 */
	public boolean save() {
		if (meterial.getAllowStressTable().isEditing())
			meterial.getAllowStressTable().getCellEditor().stopCellEditing();
		// 创建表格
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet stressSheet = wb.createSheet("allowStress");
		HSSFSheet propertiesSheet = wb.createSheet("properties");
		// 读取allowStressTable数据到sheet中
		writeFromBeanStressJTableToSheet(stressSheet);
		// 读取properties数据到sheet中
		writeFromBeanPropertyToSheet(propertiesSheet);
		// 写到excel中
		boolean isSucess = ExcelUtils.writeWorkbookInExcel(wb, getFilePath(), meterial.getAllowStressTable(), false);
		if (isSucess) {
			JOptionPaneUtils.warningMess(meterial.getAllowStressTable(), "保存成功！");
		}
		return isSucess;
	}

	/**
	 * 删除一个材料
	 * 
	 * @param messComponent
	 * @return
	 */
	public boolean del(Component messComponent) {
		if (JOptionPaneUtils.selectMess(messComponent, "确认删除" + meterial.getName() + "？") && meterial != null) {
			boolean isDelSucess = FileUtils.deleteFile(getFilePath());
			if (isDelSucess == true) {
				JOptionPaneUtils.warningMess(messComponent, "文件删除成功");
				return true;
			} else {
				JOptionPaneUtils.warningMess(messComponent, "文件删除失败，文件可能正在被占用。");
				return false;
			}
		}
		return false;

	}

	/**
	 * 获得材料的最小使用厚度
	 * 
	 * @return
	 */
	public double getMinAllowThick(Component messPonet) {
		JTable stressTable = meterial.getAllowStressTable();
		String minThickString = (String) stressTable.getValueAt(0, 0);
		if (minThickString == null) {
			JOptionPaneUtils.warningMess(messPonet, "材料数据库中无法找到厚度下限信息，请检查是否为空！");
			return Constant.ERROR_DOUBLE;
		}
		if (Double.parseDouble(minThickString) < 0.0) {
			JOptionPaneUtils.warningMess(messPonet, "材料数据库中厚度下限信息错误，请检查是否为负值！");
			return Constant.ERROR_DOUBLE;
		}
		return Double.parseDouble(minThickString);
	}

	/**
	 * 获得材料的最大使用厚度
	 * 
	 * @return
	 */
	public double getMaxAllowThick(Component messPonet) {
		JTable stressTable = meterial.getAllowStressTable();
		int rows = stressTable.getRowCount();// 行数
		double maxThick = 0.0;
		for (int i = 0; i < rows; i++) {
			String thickString = (String) stressTable.getValueAt(i, 1);
			if (thickString != null) {
				double thick = Double.parseDouble(thickString);
				if (thick > maxThick) {
					maxThick = thick;
				}
			}
		}
		if (maxThick <= getMinAllowThick(messPonet)) {
			JOptionPaneUtils.warningMess(messPonet, "材料数据库中厚度上限信息错误，请检查！");
			return Constant.ERROR_DOUBLE;
		} else {
			return maxThick;
		}
	}

	/**
	 * 根据输入的材料厚度，获得材料的许用应力行
	 * 
	 * @param nThick
	 * @param messPonet
	 * @return
	 */
	public double[][] getAllowStressAndTempRowArray(double nThick, Component messPonet) {
		JTable stressTable = meterial.getAllowStressTable();
		// 获得最小厚度
		double minThick = getMinAllowThick(messPonet);
		if (minThick == Constant.ERROR_DOUBLE) {
			return null;
		}
		// 获得最大厚度
		double maxThick = getMaxAllowThick(messPonet);
		if (maxThick == Constant.ERROR_DOUBLE) {
			return null;
		}
		// 判断厚度是否超限
		if (nThick < minThick) {
			JOptionPaneUtils.warningMess(messPonet, "输入厚度小于最小许用厚度！");
			return null;
		}
		if (nThick > maxThick) {
			JOptionPaneUtils.warningMess(messPonet, "输入厚度大于最大许用厚度！");
			return null;
		}
		// 找到许用应力行
		int rows = stressTable.getRowCount();// 行数
		int rowNum = -1;
		for (int i = 0; i < rows; i++) {
			double downThick = 0.0;
			String downThickString = (String) stressTable.getValueAt(i, 0);
			if (downThickString != null) {
				downThick = Double.parseDouble(downThickString);
				if (downThick < 0) {
					JOptionPaneUtils.warningMess(messPonet, "数据库厚度下限存在错误值！");
					return null;
				}
			}
			double upThick = 0.0;
			String upThickString = (String) stressTable.getValueAt(i, 1);
			if (upThickString != null) {
				upThick = Double.parseDouble(upThickString);
				if (upThick <= 0) {
					JOptionPaneUtils.warningMess(messPonet, "数据库厚度上限存在错误值！");
					return null;
				}
			}
			if (upThick < downThick) {
				JOptionPaneUtils.warningMess(messPonet, "数据库厚度上限小于厚度下限错误！");
				return null;
			}
			if (nThick <= upThick && nThick > downThick) {
				rowNum = i;
			}
		}
		// 没找到符合要求的行
		if (rowNum == -1) {
			JOptionPaneUtils.warningMess(messPonet, "许用厚度不包含输入厚度，请检查材料数据库！");
			return null;
		}
		// 找到了行数
		int cols = stressTable.getColumnCount();// 列数
		// 遍历此行，添加许用应力
		double[][] tempAndStressArray = new double[cols - 4][2];
		for (int col = 4, i = 0; col < cols; i++, col++) {
			tempAndStressArray[i][0] = Constant.ALLOWSTRESS_TEMPS[i];
			String stressString = (String) stressTable.getValueAt(rowNum, col);
			double stress;
			if (stressString == null) {
				stress = Constant.ERROR_DOUBLE;
			} else {
				stress = Double.parseDouble(stressString);
				if (stress <= 0) {
					JOptionPaneUtils.warningMess(messPonet, "数据库许用应力存在错误值！");
					return null;
				}
				tempAndStressArray[i][1] = stress;
			}
		}
		return tempAndStressArray;
	}

	/**
	 * 输入温度和厚度，获得许用应力
	 * 
	 * @param designTemp
	 * @param nThick
	 */
	public double getAllowStressByTempAndThick(double designTemp, double nThick, Component messPonet) {
		// TODO Auto-generated method stub
		if (designTemp == Constant.ERROR_DOUBLE) {
			JOptionPaneUtils.warningMess(messPonet, "设计温度有误！");
			return Constant.ERROR_DOUBLE;
		}
		if (nThick == Constant.ERROR_DOUBLE) {
			JOptionPaneUtils.warningMess(messPonet, "名义厚度有误！");
			return Constant.ERROR_DOUBLE;
		}
		// 判断材料的最低使用温度
		double minTemp = meterial.getMinAllowTemp();
		if (designTemp < 20 && designTemp >= minTemp) {
			designTemp = 20;
		} else if (designTemp < minTemp) {
			JOptionPaneUtils.warningMess(messPonet, "超出材料最低使用温度范围！");
			return Constant.ERROR_DOUBLE;
		}
		// 获得符合厚度的许用应力行
		double[][] tempAndStressArray = getAllowStressAndTempRowArray(nThick, messPonet);
		// 获得中间差值
		return ArrayUtils.getMindByTwoArrays(tempAndStressArray, designTemp);
	}

	/**
	 * 获得材料excel文件的地址,如src/data/meterial/GB713-2019-02/Q345R.xls
	 * 
	 * @return
	 */
	public String getFilePath() {
		if (meterial == null) {
			return null;
		}
		String standNum = meterial.getMeterialStandard().getStandardNum().replace('/', '1');
		String filePath = Constant.METERIALSTANDDARDS_FOLDERPATH + "/" + standNum + "-"
				+ DateUtils.parseDateToStringMonth(meterial.getMeterialStandard().getImplementationDate()) + "/"
				+ meterial.getName() + ".xls";
		return filePath;
	}

}
