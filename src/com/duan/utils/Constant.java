package com.duan.utils;

import java.awt.Font;

public class Constant {
	// BEU换热器画布尺寸
	public static final int BEUTUBEARRAY_WIDETH = 520;
	public static final int BEUTUBEARRAY_HEIGHT = 520;
	// BEU换热管布管方式
	public final static String[] TUBEARRAY_TYPE = { "正方形", "转角正方形", "正三角形", "转角正三角形" };
	// 换热管与管板连接方式
	public final static String[] TUBECONTACTPALTE_TYPE = { "强度胀接", "强度焊接", "强度胀加密封焊", "强度焊加贴胀", "内孔焊" };
	// 用来标记所返回的double为错误值
	public static final double ERROR_DOUBLE = 12345654321.12345654321;
	// 标准文件库文件地址
	public final static String METERIALSTANDDARDS_FILEPATH = "src/data/meterial/standardList.xls";
	// 标准文件库文件夹地址
	public final static String METERIALSTANDDARDS_FOLDERPATH = "src/data/meterial";
	// 介质文件库文件夹地址
	public final static String MEDIUM_FOLDERPATH = "src/data/medium";
	// 材料标准型号
	public final static String METERIALTYPE_PLATE = "板材";
	public final static String METERIALTYPE_TUBE = "管材";
	public final static String METERIALTYPE_FORGING = "锻件";
	public final static String[] METERIALTYPES = { METERIALTYPE_PLATE, METERIALTYPE_TUBE, METERIALTYPE_FORGING };
	// GB150许用应力温度表头值
	public final static int[] ALLOWSTRESS_TEMPS = { 20, 100, 150, 200, 250, 300, 350, 400, 425, 450, 475, 500, 525, 550,
			575, 600 };
	public final static String[] STRESSTABLE_HEADER = { "厚度下限mm", "厚度上限mm", "抗拉强度Mpa", "屈服强度Mpa",
			ALLOWSTRESS_TEMPS[0] + "℃", ALLOWSTRESS_TEMPS[1] + "℃", ALLOWSTRESS_TEMPS[2] + "℃",
			ALLOWSTRESS_TEMPS[3] + "℃", ALLOWSTRESS_TEMPS[4] + "℃", ALLOWSTRESS_TEMPS[5] + "℃",
			ALLOWSTRESS_TEMPS[6] + "℃", ALLOWSTRESS_TEMPS[7] + "℃", ALLOWSTRESS_TEMPS[8] + "℃",
			ALLOWSTRESS_TEMPS[9] + "℃", ALLOWSTRESS_TEMPS[10] + "℃", ALLOWSTRESS_TEMPS[11] + "℃",
			ALLOWSTRESS_TEMPS[12] + "℃", ALLOWSTRESS_TEMPS[13] + "℃", ALLOWSTRESS_TEMPS[14] + "℃",
			ALLOWSTRESS_TEMPS[15] + "℃" };
	// 材质分类
	public final static String METERIALCOMPONONT_CARBONSTEEL = "碳钢和低合金钢";
	public final static String METERIALCOMPONONT_STAINLESSSTEEL = "高合金钢";
	public final static String METERIALCOMPONONT_COPPER = "铜";
	public final static String METERIALCOMPONONT_TI = "钛";
	public final static String[] METERIALCOMPONENT = { METERIALCOMPONONT_CARBONSTEEL, METERIALCOMPONONT_STAINLESSSTEEL,
			METERIALCOMPONONT_COPPER, METERIALCOMPONONT_TI };
	// beu换热器B值相关
	public final static String[] BEUDIVIDEPLATE_TYPE = { "三边固定", "长边固定", "短边固定" };
	public final static String[] BEUDIVIDEPLATE_TYPE_IMGPATH = { "src/img/HeatExchanger/dividePlateType-A.png",
			"src/img/HeatExchanger/dividePlateType-B.png", "src/img/HeatExchanger/dividePlateType-C.png" };
	// beu隔板尺寸B
	public static final double[] BEUTYPE1_X = { 0.25, 0.50, 0.75, 1.0, 1.5, 2.0, 3.0 };
	public static final double[] BEUTYPE1_Y = { 0.02, 0.081, 0.173, 0.307, 0.539, 0.657, 0.718 };
	public static final double[] BEUTYPE2_X = { 1.0, 1.2, 1.4, 1.6, 1.8, 2.0 };
	public static final double[] BEUTYPE2_Y = { 0.4182, 0.4626, 0.4860, 0.4968, 0.4971, 0.4973 };
	public static final double[] BEUTYPE3_X = { 1.0, 1.2, 1.4, 1.6, 1.8, 2.0 };
	public static final double[] BEUTYPE3_Y = { 0.4182, 0.5208, 0.5988, 0.6540, 0.6912, 0.7146 };
	// 介质毒性
	public final static String[] MEDIUM_LETHALPROPERTY = new String[] { "无毒", "轻度", "中度", "高度", "极度" };
	// 介质爆炸性
	public final static String[] MEDIUM_BURNPROPERTY = new String[] { "不易爆", "易爆" };
	// 月份
	public final static String[] MOTHS = new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
			"11", "12" };
	// tabbed的关闭图片
	public static final String TABBED_CLOSEIMG = "src/img/menu/tabbedClose.png";
	// 警告对话框图标
	public static final String JOPTIONPANE_WARING = "src/img/menu/warning.png";
	// 询问对话框图标
	public static final String JOPTIONPANE_ASK = "src/img/menu/ask.png";
	// 微信二维码
	public static final String WEIXIN_IMGPATH = "src/img/mess/weixin.jpg";
	// 封头种类
	public static final String[] HEAD_TYPES = new String[] { "EHA", "EHB" };
	// 默认的字体
	public static final Font DEFAULT_FONT = new Font("宋体", Font.PLAIN, 12);
	// 默认的字体
	public static final Font FONT_SONG12 = new Font("宋体", Font.PLAIN, 12);
	// 序列化文件父目录
	public static final String SERIALIZEFOLDER_PATH = "src/data/serialize";
	// 计算模式的中文与英文名称
	public final static String[] MODULE_CHINAME = new String[] { "开孔补强", "U型管换热器", "螺旋板换热器", "容积及重量计算" };
}
