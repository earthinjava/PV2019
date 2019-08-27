package com.duan.meterialstandard;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.duan.utils.ComponentUtils;
import com.duan.utils.Constant;
import com.duan.utils.DateUtils;
import com.duan.utils.ExcelUtils;
import com.duan.utils.FileUtils;
import com.duan.utils.JOptionPaneUtils;
import com.duan.utils.StreamUtils;

public class MeterialStandardDAO {

	public MeterialStandard meterialStandard;

	public MeterialStandardDAO(MeterialStandard meterialStandard) {
		this.meterialStandard = meterialStandard;
	}

	/**
	 * 获得材料属性对象
	 * 
	 * @param messComponent
	 * @return
	 */
	private MeterialStandardProperty getProperty(Component messComponent) {
		InputStream ins = null;
		HSSFWorkbook workbook = null;
		try {
			MeterialStandardProperty property = new MeterialStandardProperty();
			ins = new FileInputStream(getPropertyPath());
			workbook = new HSSFWorkbook(ins);
			HSSFSheet sheet = workbook.getSheetAt(0);
			int n = sheet.getLastRowNum();
			if (n >= 0) {
				String meterial = ExcelUtils.getCellStringValueAtRowAndCellNum(sheet, 0, 1);
				property.setMeterialComponent(meterial);
				return property;
			}
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPaneUtils.warningMess(messComponent, "材料标准文件无法读取");
			e.printStackTrace();
		} finally {
			StreamUtils.close(workbook);
			StreamUtils.close(ins);
		}
		return null;
	}

	/**
	 * 获得材料属性excel表地址
	 * 
	 * @return
	 */
	private String getPropertyPath() {
		return getFilePath() + "/standardproperty.xls";
	}

	/**
	 * 将材料标准的属性文档写入excel中，若存在直接覆盖，若不存在则创建。
	 * 
	 * @param messComponent
	 * @return
	 */
	private boolean writeStandardPropertyInExcel(Component messComponent) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		// 创建GB713默认标准
		HSSFRow row = sheet.createRow(0);
		ExcelUtils.createAndSetCellStringValue(row, 0, "材质");
		ExcelUtils.createAndSetCellStringValue(row, 1, meterialStandard.getProperty().getMeterialComponent());
		// 写入standsList.xls文件
		return ExcelUtils.writeWorkbookInExcel(workbook, getPropertyPath(),
				ComponentUtils.getRootComponent(messComponent), true);

	}

	/**
	 * 初始化标准文件夹 1.创建standsList.xls文件 2.创建src/data/meterial文件夹
	 */
	private static void initialize() {
		// TODO Auto-generated method stub
		// 创建src/data/meterial文件夹
		FileUtils.creatFolder(Constant.METERIALSTANDDARDS_FOLDERPATH);
		// 创建standsList.xls文件
		File file = new File(Constant.METERIALSTANDDARDS_FILEPATH);
		try {
			file.createNewFile();
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet();
			// 创建GB713默认标准
			HSSFRow row = sheet.createRow(0);
			ExcelUtils.createAndSetCellStringValue(row, 0, "GB713");
			ExcelUtils.createAndSetCellStringValue(row, 1, "2014-06");
			ExcelUtils.createAndSetCellStringValue(row, 2, "锅炉和压力容器用钢板");
			ExcelUtils.createAndSetCellStringValue(row, 3, Constant.METERIALTYPE_PLATE);
			// 写入standsList.xls文件
			if (ExcelUtils.writeWorkbookInExcel(workbook, Constant.METERIALSTANDDARDS_FILEPATH, null, true)) {
				MeterialStandard meterialStandard = new MeterialStandard();
				meterialStandard.setImplementationDate(DateUtils.parseStringToDate("2014-06"));
				meterialStandard.setMeterialType(0);
				meterialStandard.setName("锅炉和压力容器用钢板");
				meterialStandard.setStandardNum("GB713");
				MeterialStandardProperty standardProperty = new MeterialStandardProperty();
				standardProperty.setMeterialComponent(Constant.METERIALCOMPONONT_CARBONSTEEL);
				meterialStandard.setProperty(standardProperty);
				// 创建标准GB713-20109-01文件夹
				if (!FileUtils.creatFolder(new MeterialStandardDAO(meterialStandard).getFilePath())) {
					FileUtils.deleteFile(Constant.METERIALSTANDDARDS_FILEPATH);
					return;
				}
				// 写入属性文档
				if (!new MeterialStandardDAO(meterialStandard).writeStandardPropertyInExcel(null)) {
					FileUtils.deleteFile(Constant.METERIALSTANDDARDS_FILEPATH);
					FileUtils.deleteDirectory(new MeterialStandardDAO(meterialStandard).getFilePath());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获得标准文件夹位置，如：c:/src/data/meterial/GB713-2016-06
	 * 
	 * @return
	 */
	public String getFilePath() {
		String standNum = meterialStandard.getStandardNum();
		if (standNum == null) {// 标准号没输入，直接返回
			return null;
		}
		standNum = standNum.replace('/', '1');// 将非法字符串替换掉
		Date date = meterialStandard.getImplementationDate();
		if (date == null) {// 日期错误直接返回
			return null;
		}
		String dateString = DateUtils.parseDateToStringMonth(date);
		if (dateString == null) {
			return null;
		}
		return Constant.METERIALSTANDDARDS_FOLDERPATH + "/" + standNum + "-" + dateString;
	}

	/**
	 * 从excel文件读取标准加入到MeterialStandard集合�?
	 * 
	 * @param messComponent 提示信息弹出地方
	 * @return
	 */
	public static ArrayList<MeterialStandard> getAllMeterialStandardsFromExcel(Component messComponent) {
		ArrayList<MeterialStandard> meterialStandards = new ArrayList<MeterialStandard>();
		File file = new File(Constant.METERIALSTANDDARDS_FILEPATH);
		// 文件目录不存在，将创建初始化standard.xls文件
		if (!file.exists()) {
			// 材料标准文件不存在，直接执行初始化，创建新的标准目录
			initialize();
		}
		InputStream ins = null;
		HSSFWorkbook workbook = null;
		try {
			ins = new FileInputStream(file);
			workbook = new HSSFWorkbook(ins);
			HSSFSheet sheet = workbook.getSheetAt(0);
			int n = sheet.getLastRowNum();
			if (n >= 0) {
				for (int i = 0; i <= n; i++) {
					String standardNum = ExcelUtils.getCellStringValueAtRowAndCellNum(sheet, i, 0);
					Date date = DateUtils.parseStringToDate(ExcelUtils.getCellStringValueAtRowAndCellNum(sheet, i, 1));
					String name = ExcelUtils.getCellStringValueAtRowAndCellNum(sheet, i, 2);
					String type = ExcelUtils.getCellStringValueAtRowAndCellNum(sheet, i, 3);
					int typeNum = 0;
					if (type.equals(Constant.METERIALTYPE_PLATE)) {
						typeNum = 0;
					} else if (type.equals(Constant.METERIALTYPE_TUBE)) {
						typeNum = 1;
					} else if (type.equals(Constant.METERIALTYPE_FORGING)) {
						typeNum = 2;
					}
					MeterialStandard generalMeterialStandard = new MeterialStandard();
					meterialStandards.add(generalMeterialStandard);
					// 设置标准基本属性
					generalMeterialStandard.setStandardNum(standardNum);
					generalMeterialStandard.setName(name);
					generalMeterialStandard.setMeterialType(typeNum);
					generalMeterialStandard.setImplementationDate(date);
					// 设置标准property属性
					generalMeterialStandard
							.setProperty(new MeterialStandardDAO(generalMeterialStandard).getProperty(messComponent));
				}
				return meterialStandards;
			}
			return null;
		} catch (IOException e) {
			JOptionPaneUtils.warningMess(messComponent, "材料标准文件无法读取");
			e.printStackTrace();
		} finally {
			StreamUtils.close(workbook);
			StreamUtils.close(ins);
		}
		return null;
	}

	/**
	 * 获得符合材料标准的材料
	 * 
	 * @param messComponent
	 * @param meterialType  1，返回板材 2返回管材，3返回锻件,大于3返回所有
	 * @return
	 */
	public static ArrayList<MeterialStandard> getConformTypeMeterialStandards(Component messComponent,
			int meterialType) {
		ArrayList<MeterialStandard> meterialStandards = getAllMeterialStandardsFromExcel(messComponent);
		ArrayList<MeterialStandard> finishMeterialStandards = new ArrayList<MeterialStandard>();
		if (meterialStandards != null) {
			if (meterialType <= 2) {
				for (int i = 0; i < meterialStandards.size(); i++) {
					if (meterialStandards.get(i).getMeterialType() == meterialType) {
						finishMeterialStandards.add(meterialStandards.get(i));
					}
				}
			} else {
				finishMeterialStandards = meterialStandards;
			}
			return finishMeterialStandards;
		} else {
			return null;
		}
	}

	/**
	 * 添加材料标准
	 * 
	 * @param messComponent
	 * @return
	 */
	public boolean creat(Component messComponent) {
		// 创建标准文件夹
		boolean isCreated = FileUtils.creatFolder(getFilePath());
		if (isCreated) {
			// 判断标准是否重复，重复直接退出
			ArrayList<MeterialStandard> meterialStandards = getAllMeterialStandardsFromExcel(messComponent);
			if (meterialStandards != null) {
				for (MeterialStandard m : meterialStandards) {
					// 若相同说明已存在，不在创建直接退出
					if (m.equals(meterialStandard)) {
						JOptionPaneUtils.warningMess(messComponent, "标准已存在");
						return true;
					}
				}
			}
			// 写入材料属性
			if (!writeStandardPropertyInExcel(messComponent)) {
				FileUtils.deleteDirectory(getFilePath());
				return false;
			}
			// 若材料添加失败则进行回滚操作，删除已添加的文件夹
			if (!addMeterialStandardInExcel(messComponent)) {
				FileUtils.deleteDirectory(getFilePath());
				return false;
			}
			JOptionPaneUtils.warningMess(messComponent, "标准创建成功");
			return true;
		}
		return false;
	}

	/**
	 * 将材料标准集写到excel�?
	 * 
	 * @param meterialStandards 材料标准�?
	 */
	private boolean writeMeterialStandardsInExcel(ArrayList<MeterialStandard> meterialStandards,
			Component messCompent) {
		// 将meterialStandards创建�?个workbook，并覆盖standard.xls文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		for (int i = 0; i < meterialStandards.size(); i++) {
			MeterialStandard m = meterialStandards.get(i);
			HSSFRow row = sheet.createRow(i);
			ExcelUtils.createAndSetCellStringValue(row, 0, m.getStandardNum());
			ExcelUtils.createAndSetCellStringValue(row, 1, DateUtils.parseDateToStringMonth(m.getImplementationDate()));
			ExcelUtils.createAndSetCellStringValue(row, 2, m.getName());
			ExcelUtils.createAndSetCellStringValue(row, 3, new MeterialStandardDAO(m).getTypeString());
		}
		return ExcelUtils.writeWorkbookInExcel(workbook, Constant.METERIALSTANDDARDS_FILEPATH, messCompent, true);
	}

	/**
	 * 添加材料标准集到excel�?
	 * 
	 * @param generalMeterialStandard 要添加的材料标准
	 */
	private boolean addMeterialStandardInExcel(Component messCompent) {
		ArrayList<MeterialStandard> meterialStandards = getAllMeterialStandardsFromExcel(messCompent);
		if (meterialStandards == null) {
			meterialStandards = new ArrayList<MeterialStandard>();
		}
		meterialStandards.add(meterialStandard);
		return writeMeterialStandardsInExcel(meterialStandards, messCompent);
	}

	/**
	 * 获得标准的代号和日期 GB713 2014-09
	 * 
	 * @return
	 */
	public String getStandardNumAndDate() {
		return meterialStandard.getStandardNum() + " "
				+ DateUtils.parseDateToStringMonth(meterialStandard.getImplementationDate());
	}

	/**
	 * 获得材料的类型
	 * 
	 * @return
	 */
	public String getTypeString() {
		if (meterialStandard.getMeterialType() == 0) {
			return Constant.METERIALTYPE_PLATE;
		}
		if (meterialStandard.getMeterialType() == 1) {
			return Constant.METERIALTYPE_TUBE;
		}
		if (meterialStandard.getMeterialType() == 2) {
			return Constant.METERIALTYPE_FORGING;
		}
		return "未知";
	}

	/**
	 * 删除材料标准
	 * 
	 * @param meterialStandard
	 * @param messCompent
	 * @return
	 */
	public boolean del(Component messComponent) {
		// 删除excel前，保存其内容。
		ArrayList<MeterialStandard> saveMeterialStandards = getAllMeterialStandardsFromExcel(messComponent);
		if (JOptionPaneUtils.selectMess(messComponent, "确认删除" + meterialStandard.getStandardNum() + "及其所有材料数据?")) {
			// 1.删除材料目录
			boolean isSuccess1 = delMeterialStandardInExcel(messComponent);
			// 2.删除材料excel中的值
			if (isSuccess1) {
				boolean isSuccess2 = FileUtils.deleteDirectory(getFilePath());
				// 若标准文件夹删除失败则进行回滚操作，将保存的标准重新添加到excel中
				if (!isSuccess2) {
					writeMeterialStandardsInExcel(saveMeterialStandards, messComponent);
					return false;
				}
				JOptionPaneUtils.warningMess(messComponent, "标准删除成功");
				return true;
			}
			return false;
		}
		return false;
	}

	/**
	 * 刪除材料標準
	 * 
	 * @param meterialStandard 要删除的材料标准
	 * @param messCompent
	 * @return
	 */
	private boolean delMeterialStandardInExcel(Component messCompent) {
		ArrayList<MeterialStandard> meterialStandards = getAllMeterialStandardsFromExcel(messCompent);
		if (meterialStandards != null) {
			for (int i = 0; i < meterialStandards.size(); i++) {
				// 若相同则删除
				if (meterialStandards.get(i).equals(meterialStandard)) {
					meterialStandards.remove(i);
				}
			}
		}
		return writeMeterialStandardsInExcel(meterialStandards, messCompent);
	}
}
