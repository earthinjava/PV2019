package com.duan.module.heatexchanger.beu.jpanel;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.duan.component.PureNumField;
import com.duan.component.image.BoxChangeImgPanel;
import com.duan.component.image.ShowImageCenterPanel;
import com.duan.module.heatexchanger.beu.bean.BEUHeatExchanger;
import com.duan.module.heatexchanger.beu.bean.designCondition.HeatDesignCondition;
import com.duan.module.heatexchanger.beu.bean.designCondition.HeatDesignConditions;
import com.duan.utils.Constant;
import com.duan.utils.JOptionPaneUtils;
import com.duan.utils.LabelAndFieldUtils;
import com.duan.utils.PanelUtils;

public class HeatDesignContionPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private BEUHeatExchanger beuHeatExchanger;
	private String downStreamImagePath = "src/img/SprialPlateHeatExchanger/Downstream.png";
	private String preImagePath = "src/img/HeatExchanger/beu.png";
	private String upStreamImagePath = "src/img/SprialPlateHeatExchanger/Upstream.png";
	private String[] streamType = new String[] { "逆流", "顺流" };
	private String[] streamImagePath = new String[] { upStreamImagePath, downStreamImagePath };
	private JPanel contentPane;
	private JPanel designConPanel;
	private JLabel maffFlowLabelCold;
	private PureNumField inletTemHotField;
	private PureNumField designPressHotField;
	private PureNumField inletTemColdField;
	private PureNumField designPressColdField;
	private PureNumField maffFlowFieldHot;
	private PureNumField outletTemHotField;
	private PureNumField outletTemColdField;
	private PureNumField hotDesignTempField;
	private PureNumField coldDesignTempField;
	private JComboBox<String> streamBox;
	private JComboBox<String> mediumNameCold;
	private JComboBox<String> mediumNameHot;
	private JComboBox<String> hotLocationBox;
	private JComboBox<String> coldLocationBox;
	private BoxChangeImgPanel boxPanel;
	private ShowImageCenterPanel preImagePanel;

	public HeatDesignContionPanel(BEUHeatExchanger beuHeatExchanger) {

		this.beuHeatExchanger = beuHeatExchanger;

		setBackground(Color.WHITE);
		setBounds(new Rectangle(0, 0, 800, 800));
		setLayout(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBounds(new Rectangle(0, 0, 780, 675));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		add(contentPane);

		designConPanel = new JPanel();
		designConPanel.setBackground(SystemColor.menu);
		designConPanel.setBounds(5, 5, 270, 280);
		designConPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		designConPanel.setLayout(null);
		contentPane.add(designConPanel);

		JLabel label_2 = new JLabel("\u8BBE\u8BA1\u538B\u529B");
		label_2.setBounds(10, 40, 60, 20);
		designConPanel.add(label_2);

		JLabel label_3 = new JLabel("\u8FDB\u53E3\u6E29\u5EA6");
		label_3.setBounds(10, 70, 60, 20);
		designConPanel.add(label_3);

		JLabel label_4 = new JLabel("\u4ECB\u8D28\u540D\u79F0");
		label_4.setBounds(10, 190, 60, 20);
		designConPanel.add(label_4);

		mediumNameHot = new JComboBox<String>();
		mediumNameHot.setModel(new DefaultComboBoxModel<String>(new String[] { "水", "待添加" }));
		mediumNameHot.setBounds(81, 190, 66, 20);
		designConPanel.add(mediumNameHot);

		inletTemHotField = new PureNumField();
		inletTemHotField.setText("70");
		inletTemHotField.setBounds(81, 70, 66, 20);
		designConPanel.add(inletTemHotField);

		designPressHotField = new PureNumField();
		designPressHotField.setText("1.6");
		designPressHotField.setBounds(81, 40, 66, 20);
		designConPanel.add(designPressHotField);

		JLabel label = new JLabel("\u70ED\u4FA7\u4ECB\u8D28");
		label.setBounds(87, 10, 60, 20);
		designConPanel.add(label);

		JLabel label_1 = new JLabel("\u51B7\u4FA7\u4ECB\u8D28");
		label_1.setBounds(157, 10, 60, 20);
		designConPanel.add(label_1);

		mediumNameCold = new JComboBox<String>();
		mediumNameCold.setModel(new DefaultComboBoxModel<String>(new String[] { "\u6C34", "\u5F85\u6DFB\u52A0" }));
		mediumNameCold.setBounds(157, 190, 66, 20);
		designConPanel.add(mediumNameCold);

		inletTemColdField = new PureNumField();
		inletTemColdField.setText("25");
		inletTemColdField.setBounds(157, 70, 66, 20);
		designConPanel.add(inletTemColdField);

		designPressColdField = new PureNumField();
		designPressColdField.setText("1.6");
		designPressColdField.setBounds(157, 40, 66, 20);
		designConPanel.add(designPressColdField);

		JLabel label_8 = new JLabel("Mpa");
		label_8.setBounds(224, 40, 29, 20);
		designConPanel.add(label_8);

		JLabel label_9 = new JLabel("\u2103");
		label_9.setBounds(227, 70, 29, 20);
		designConPanel.add(label_9);

		JLabel label_10 = new JLabel("\u8D28\u91CF\u6D41\u91CF");
		label_10.setBounds(10, 160, 60, 20);
		designConPanel.add(label_10);

		maffFlowFieldHot = new PureNumField();
		maffFlowFieldHot.setText("98690");
		maffFlowFieldHot.setBounds(81, 160, 66, 20);
		designConPanel.add(maffFlowFieldHot);

		JLabel lblKgh_1 = new JLabel("kg/h");
		lblKgh_1.setBounds(227, 160, 29, 20);
		designConPanel.add(lblKgh_1);

		JLabel label_15 = new JLabel("\u51FA\u53E3\u6E29\u5EA6");
		label_15.setBounds(10, 100, 60, 20);
		designConPanel.add(label_15);

		outletTemHotField = new PureNumField();
		outletTemHotField.setText("35");
		outletTemHotField.setBounds(81, 100, 66, 20);
		designConPanel.add(outletTemHotField);

		outletTemColdField = new PureNumField();
		outletTemColdField.setText("60");
		outletTemColdField.setBounds(157, 100, 66, 20);
		designConPanel.add(outletTemColdField);

		JLabel label_22 = new JLabel("\u2103");
		label_22.setBounds(227, 100, 29, 20);
		designConPanel.add(label_22);

		maffFlowLabelCold = new JLabel("");
		maffFlowLabelCold.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		maffFlowLabelCold.setBounds(157, 160, 66, 20);
		designConPanel.add(maffFlowLabelCold);

		JLabel label_6 = new JLabel("\u5BF9\u6D41\u65B9\u5F0F");
		label_6.setBounds(10, 220, 143, 20);
		designConPanel.add(label_6);

		JLabel label_5 = new JLabel("\u8BBE\u8BA1\u6E29\u5EA6");
		label_5.setBounds(10, 130, 60, 20);
		designConPanel.add(label_5);

		hotDesignTempField = new PureNumField();
		hotDesignTempField.setText("100");
		hotDesignTempField.setBounds(81, 130, 66, 20);
		designConPanel.add(hotDesignTempField);

		coldDesignTempField = new PureNumField();
		coldDesignTempField.setText("100");
		coldDesignTempField.setBounds(157, 130, 66, 20);
		designConPanel.add(coldDesignTempField);

		JLabel label_7 = new JLabel("\u2103");
		label_7.setBounds(227, 130, 29, 20);
		designConPanel.add(label_7);

		JLabel label_12 = new JLabel("\u4F4D\u7F6E");
		label_12.setBounds(10, 250, 60, 20);
		designConPanel.add(label_12);

		hotLocationBox = new JComboBox<String>();
		hotLocationBox.setModel(new DefaultComboBoxModel<String>(new String[] { "\u7BA1\u7A0B", "\u58F3\u7A0B" }));
		hotLocationBox.setBounds(81, 250, 66, 20);
		hotLocationBox.addActionListener(this);		
		designConPanel.add(hotLocationBox);

		coldLocationBox = new JComboBox<String>();
		coldLocationBox.setEditable(true);
		coldLocationBox.setEnabled(false);
		coldLocationBox.setModel(new DefaultComboBoxModel<String>(new String[] { "\u58F3\u7A0B", "\u7BA1\u7A0B" }));
		coldLocationBox.setBounds(157, 250, 66, 20);
		designConPanel.add(coldLocationBox);

		boxPanel = new BoxChangeImgPanel(streamType, streamImagePath, 280, 5, 400, 280,false);
		contentPane.add(boxPanel);

		streamBox = boxPanel.getBox();
		streamBox.setBounds(81, 220, 141, 20);
		designConPanel.add(streamBox);

		preImagePanel=new ShowImageCenterPanel(675, 260, 5, 290, preImagePath);		
		contentPane.add(preImagePanel);
		PanelUtils.setAllComFont(contentPane);
		PanelUtils.setAllComFont(designConPanel);		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if (hotLocationBox.getSelectedIndex() == 0) {
			coldLocationBox.setSelectedIndex(0);
		} else {
			coldLocationBox.setSelectedIndex(1);
		}
	
	}

	public void apply() {
		beuHeatExchanger.setHeatDesignConditions(null);
		double designPressHot = designPressHotField.getDoubleNoNull("请输入热侧设计压力");
		if (designPressHot == Constant.ERROR_DOUBLE) {
			return;
		}
		double inletTempHot = inletTemHotField.getDoubleNoNull("请输入热侧进口温度");
		if (inletTempHot == Constant.ERROR_DOUBLE) {
			return;
		}
		double outletTempHot = outletTemHotField.getDoubleNoNull("请输入热侧出口温度");
		if (outletTempHot == Constant.ERROR_DOUBLE) {
			return;
		}
		double hotDesignTemp = hotDesignTempField.getDoubleNoNull("请输入热侧设计温度");
		if (hotDesignTemp == Constant.ERROR_DOUBLE) {
			return;
		}
		double massFlowHot = maffFlowFieldHot.getDoubleNoNull("请输入热侧流量");
		if (massFlowHot == Constant.ERROR_DOUBLE) {
			return;
		}
		massFlowHot = massFlowHot / 3600.0;
		String mediumHotName = mediumNameHot.getSelectedItem().toString();
		double designPressCold = designPressColdField.getDoubleNoNull("请输入冷侧设计压力");
		if (designPressCold == Constant.ERROR_DOUBLE) {
			return;
		}
		double inletTempCold = inletTemColdField.getDoubleNoNull("请输入冷侧进口温度");
		if (inletTempCold == Constant.ERROR_DOUBLE) {
			return;
		}
		double outletTempCold = outletTemColdField.getDoubleNoNull("请输入冷侧出口温度");
		if (outletTempCold == Constant.ERROR_DOUBLE) {
			return;
		}
		double coldDesignTemp = coldDesignTempField.getDoubleNoNull("请输入冷侧设计温度");
		if (coldDesignTemp == Constant.ERROR_DOUBLE) {
			return;
		}
		String mediumColdName = mediumNameCold.getSelectedItem().toString();
		Color color = inletTemHotField.getCaretColor();
		if (inletTempHot <= outletTempHot) {
			inletTemHotField.setForeground(Color.RED);
			outletTemHotField.setForeground(Color.RED);
			inletTemColdField.setForeground(color);
			outletTemColdField.setForeground(color);
			beuHeatExchanger.setHeatDesignConditions(null);
			JOptionPaneUtils.warningMess(contentPane, "热侧进出口温度错误");
			return;
		}
		if (outletTempCold <= inletTempCold) {
			inletTemColdField.setForeground(Color.RED);
			outletTemColdField.setForeground(Color.RED);
			inletTemHotField.setForeground(color);
			outletTemHotField.setForeground(color);
			beuHeatExchanger.setHeatDesignConditions(null);
			JOptionPaneUtils.warningMess(contentPane, "冷侧进出口温度错误");
			return;
		}
		boolean isDownFlow = false;
		if (streamBox.getSelectedItem().toString().equals("顺流")) {
			isDownFlow = true;
		}
		if (!isDownFlow) {
			if (outletTempCold >= inletTempHot) {
				inletTemHotField.setForeground(Color.RED);
				inletTemColdField.setForeground(color);
				outletTemColdField.setForeground(Color.RED);
				outletTemHotField.setForeground(color);
				beuHeatExchanger.setHeatDesignConditions(null);
				JOptionPaneUtils.warningMess(contentPane, "温度输入错误");
				return;
			} else if (inletTempCold >= outletTempHot) {
				inletTemColdField.setForeground(Color.RED);
				inletTemHotField.setForeground(color);
				outletTemHotField.setForeground(Color.RED);
				outletTemColdField.setForeground(color);
				beuHeatExchanger.setHeatDesignConditions(null);
				JOptionPaneUtils.warningMess(contentPane, "温度输入错误");
				return;
			}
		} else {
			if (outletTempHot <= outletTempCold) {
				inletTemHotField.setForeground(color);
				inletTemColdField.setForeground(color);
				outletTemColdField.setForeground(Color.RED);
				outletTemHotField.setForeground(Color.RED);
				beuHeatExchanger.setHeatDesignConditions(null);
				JOptionPaneUtils.warningMess(contentPane, "温度输入错误");
				return;
			}
		}
		inletTemHotField.setForeground(color);
		outletTemHotField.setForeground(color);
		inletTemColdField.setForeground(color);
		outletTemColdField.setForeground(color);
		boolean isHotInTube;
		boolean isColdInTube;
		if (hotLocationBox.getSelectedIndex() == 0) {
			isHotInTube = true;
			isColdInTube = false;
		} else {
			isHotInTube = false;
			isColdInTube = true;
		}
		HeatDesignCondition hotdeDesignCondition;
		hotdeDesignCondition = new HeatDesignCondition(designPressHot, inletTempHot, outletTempHot, hotDesignTemp,
				mediumHotName, massFlowHot, isHotInTube);
		HeatDesignCondition coldDesignCondition;
		coldDesignCondition = new HeatDesignCondition(designPressCold, inletTempCold, outletTempCold, coldDesignTemp,
				mediumColdName, hotdeDesignCondition.getHeat(), isColdInTube);
		HeatDesignConditions heatDesignConditions = new HeatDesignConditions(hotdeDesignCondition, coldDesignCondition,
				isDownFlow);
		beuHeatExchanger.setHeatDesignConditions(heatDesignConditions);
		LabelAndFieldUtils.showDoublePointTwo(maffFlowLabelCold,
				heatDesignConditions.getColdDesignCondition().getMassFlow() * 3600.0);
	}

	public PureNumField getShellDesignTempField() {
		if (hotLocationBox.getSelectedIndex() == 0) {
			return coldDesignTempField;
		} else {
			return hotDesignTempField;
		}
	}

	public PureNumField getTubeDesignTempField() {
		if (hotLocationBox.getSelectedIndex() == 0) {
			return hotDesignTempField;
		} else {
			return coldDesignTempField;
		}
	}	
}
