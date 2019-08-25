package com.duan.module.heatexchanger.sprialPlate.jpanel;

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
import com.duan.module.heatexchanger.sprialPlate.bean.SprialPlateHeatExchanger;
import com.duan.module.heatexchanger.sprialPlate.bean.designCondition.SPHEColdDesignCondition;
import com.duan.module.heatexchanger.sprialPlate.bean.designCondition.SPHEDesignConditions;
import com.duan.module.heatexchanger.sprialPlate.bean.designCondition.SPHEHotDesignCondition;
import com.duan.utils.Constant;
import com.duan.utils.JOptionPaneUtils;
import com.duan.utils.LabelAndFieldUtils;
import com.duan.utils.PanelUtils;

public class SPHEDesignConditionJPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private SprialPlateHeatExchanger sprialHeat;
	private String preImagePathI = "src/img/SprialPlateHeatExchanger/preImagePathI.png";
	private String preImagePathII = "src/img/SprialPlateHeatExchanger/preImagePathII.png";
	private String preImagePathIII = "src/img/SprialPlateHeatExchanger/preImagePathIII.png";
	private String preImagePathIIII = "src/img/SprialPlateHeatExchanger/preImagePathIIII.png";
	private String[] preImagePath = new String[] { preImagePathI, preImagePathII, preImagePathIII, preImagePathIIII };
	private String[] types = { "I\u5207\u5411\u7F29\u53E3\u578B", "I\u534A\u5706\u7B52\u4F53\u578B",
			"II\u53EF\u62C6\u5C01\u5835\u578B", "III\u8F74\u5411\u8D2F\u901A\u578B" };
	private String downStreamImagePath = "src/img/SprialPlateHeatExchanger/Downstream.png";
	private String upStreamImagePath = "src/img/SprialPlateHeatExchanger/Upstream.png";
	private String[] streamPaths = { upStreamImagePath, downStreamImagePath };
	private JPanel designConPanel;
	private PureNumField inletTemHotField;
	private PureNumField designPressHotField;
	private PureNumField inletTemColdField;
	private PureNumField designPressColdField;
	private PureNumField maffFlowFieldHot;
	private PureNumField outletTemHotField;
	private PureNumField outletTemColdField;
	private JComboBox<String> mediumBoxHot;
	private JComboBox<String> mediumBoxCold;
	private JPanel contentPane;
	private JLabel maffFlowLabelCold;
	private JComboBox<String> streamBox;
	private PureNumField hotDesignTempField;
	private PureNumField coldDesignTempField;
	private JComboBox<String> typeBox;
	private JComboBox<String> hotSpiralFlowtBox;
	private JComboBox<String> coldSpiralFlowtBox;
	private BoxChangeImgPanel showTypePanel;
	private BoxChangeImgPanel streamImagePanel;

	public SPHEDesignConditionJPanel(SprialPlateHeatExchanger sprialHeat) {

		setBounds(new Rectangle(0, 0, 800, 800));
		setLayout(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBounds(new Rectangle(0, 0, 800, 800));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		add(contentPane);

		this.sprialHeat = sprialHeat;

		showTypePanel = new BoxChangeImgPanel(types, preImagePath, 280, 5, 340, 670, false);
		contentPane.add(showTypePanel);

		designConPanel = new JPanel();
		designConPanel.setBackground(SystemColor.menu);
		designConPanel.setBounds(5, 5, 270, 310);
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

		mediumBoxHot = new JComboBox<String>();
		mediumBoxHot.setModel(new DefaultComboBoxModel<String>(new String[] { "水" }));
		mediumBoxHot.setBounds(81, 190, 66, 20);
		designConPanel.add(mediumBoxHot);

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

		mediumBoxCold = new JComboBox<String>();
		mediumBoxCold.setModel(new DefaultComboBoxModel<String>(new String[] { "\u6C34", "\u5F85\u6DFB\u52A0" }));
		mediumBoxCold.setBounds(157, 190, 66, 20);
		designConPanel.add(mediumBoxCold);

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

		JLabel label_11 = new JLabel("\u6362\u70ED\u5668\u578B\u5F0F");
		label_11.setBounds(10, 250, 70, 20);
		designConPanel.add(label_11);

		typeBox = showTypePanel.getBox();
		typeBox.setBounds(81, 250, 142, 20);
		designConPanel.add(typeBox);

		JLabel label_12 = new JLabel("\u6D41\u52A8\u72B6\u6001");
		label_12.setBounds(10, 280, 60, 20);
		designConPanel.add(label_12);

		hotSpiralFlowtBox = new JComboBox<String>();
		hotSpiralFlowtBox
				.setModel(new DefaultComboBoxModel<String>(new String[] { "\u87BA\u65CB\u6D41", "\u8F74\u5411\u6D41" }));
		hotSpiralFlowtBox.setBounds(81, 280, 66, 20);
		designConPanel.add(hotSpiralFlowtBox);

		coldSpiralFlowtBox = new JComboBox<String>();
		coldSpiralFlowtBox
				.setModel(new DefaultComboBoxModel<String>(new String[] { "\u87BA\u65CB\u6D41", "\u8F74\u5411\u6D41" }));
		coldSpiralFlowtBox.setBounds(157, 280, 66, 20);

		hotSpiralFlowtBox.setEnabled(false);
		coldSpiralFlowtBox.setEnabled(false);

		designConPanel.add(coldSpiralFlowtBox);

		streamImagePanel = new BoxChangeImgPanel(new String[] { "逆流", "顺流" }, streamPaths, 5, 320, 270, 180, false);
		contentPane.add(streamImagePanel);
		
		streamBox = streamImagePanel.getBox();
		streamBox.setBounds(81, 220, 141, 20);
		designConPanel.add(streamBox);

		typeBox.addActionListener(this);		
		PanelUtils.setAllComFont(designConPanel);
	}

	public void apply() {
		// TODO Auto-generated method stub
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
		double massFlowHot = maffFlowFieldHot.getDoubleNoNull("请输入热侧质量流量");
		if (massFlowHot == Constant.ERROR_DOUBLE) {
			return;
		}
		double hotDesignTemp = hotDesignTempField.getDoubleNoNull("请输入热侧设计温度");
		if (hotDesignTemp == Constant.ERROR_DOUBLE) {
			return;
		}
		massFlowHot = massFlowHot / 3600.0;
		String mediumHotName = mediumBoxHot.getSelectedItem().toString();
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
		String mediumColdName = mediumBoxCold.getSelectedItem().toString();
		Color color = inletTemHotField.getCaretColor();
		if (inletTempHot <= outletTempHot) {
			inletTemHotField.setForeground(Color.RED);
			outletTemHotField.setForeground(Color.RED);
			inletTemColdField.setForeground(color);
			outletTemColdField.setForeground(color);
			sprialHeat.setSpheDesignConditions(null);
			JOptionPaneUtils.warningMess(contentPane, "温度大小有误");
			return;
		}
		if (outletTempCold <= inletTempCold) {
			inletTemColdField.setForeground(Color.RED);
			outletTemColdField.setForeground(Color.RED);
			inletTemHotField.setForeground(color);
			outletTemHotField.setForeground(color);
			sprialHeat.setSpheDesignConditions(null);
			JOptionPaneUtils.warningMess(contentPane, "温度大小有误");
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
				sprialHeat.setSpheDesignConditions(null);
				JOptionPaneUtils.warningMess(contentPane, "温度大小有误");
				return;
			} else if (inletTempCold >= outletTempHot) {
				inletTemColdField.setForeground(Color.RED);
				inletTemHotField.setForeground(color);
				outletTemHotField.setForeground(Color.RED);
				outletTemColdField.setForeground(color);
				sprialHeat.setSpheDesignConditions(null);
				JOptionPaneUtils.warningMess(contentPane, "温度大小有误");
				return;
			}
		} else {
			if (outletTempHot <= outletTempCold) {
				inletTemHotField.setForeground(color);
				inletTemColdField.setForeground(color);
				outletTemColdField.setForeground(Color.RED);
				outletTemHotField.setForeground(Color.RED);
				sprialHeat.setSpheDesignConditions(null);
				JOptionPaneUtils.warningMess(contentPane, "温度大小有误");
				return;
			}
		}
		inletTemHotField.setForeground(color);
		outletTemHotField.setForeground(color);
		inletTemColdField.setForeground(color);
		outletTemColdField.setForeground(color);
		int type = typeBox.getSelectedIndex();
		boolean isHotSpiralFlow;
		boolean isColdSpiralFlow;
		if (type < 3) {
			isHotSpiralFlow = true;
			isColdSpiralFlow = true;
		} else {
			if (hotSpiralFlowtBox.getSelectedIndex() == 0) {
				isHotSpiralFlow = true;
			} else {
				isHotSpiralFlow = false;
			}
			if (coldSpiralFlowtBox.getSelectedIndex() == 0) {
				isColdSpiralFlow = true;
			} else {
				isColdSpiralFlow = false;
			}
			if (isColdSpiralFlow && isHotSpiralFlow) {
				JOptionPaneUtils.warningMess(contentPane, "至少有一侧应为轴向流");				
			}
		}
		SPHEHotDesignCondition hotDesignCon;
		hotDesignCon = new SPHEHotDesignCondition(designPressHot, inletTempHot, outletTempHot, mediumHotName,
				massFlowHot, hotDesignTemp, isHotSpiralFlow);
		SPHEColdDesignCondition coldDesignCon;
		coldDesignCon = new SPHEColdDesignCondition(designPressCold, inletTempCold, outletTempCold, mediumColdName,
				hotDesignCon.getHeat(), coldDesignTemp, isColdSpiralFlow);
		int hotLoca = hotSpiralFlowtBox.getSelectedIndex();
		boolean isHotOut = false;
		if (hotLoca == 0) {
			isHotOut = true;
		}
		SPHEDesignConditions designConditions = sprialHeat.getSpheDesignConditions();
		designConditions = new SPHEDesignConditions(hotDesignCon, coldDesignCon, isDownFlow, isHotOut, type);
		sprialHeat.setSpheDesignConditions(designConditions);
		LabelAndFieldUtils.showDoublePointTwo(maffFlowLabelCold,
				designConditions.getColdDesignCondition().getMassFlow() * 3600);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (typeBox.getSelectedIndex() == 0) {
			hotSpiralFlowtBox.setSelectedIndex(0);
			coldSpiralFlowtBox.setSelectedIndex(0);
			hotSpiralFlowtBox.setEnabled(false);
			coldSpiralFlowtBox.setEnabled(false);
		} else if (typeBox.getSelectedIndex() == 1) {
			hotSpiralFlowtBox.setSelectedIndex(0);
			coldSpiralFlowtBox.setSelectedIndex(0);
			hotSpiralFlowtBox.setEnabled(false);
			coldSpiralFlowtBox.setEnabled(false);
		} else if (typeBox.getSelectedIndex() == 2) {
			hotSpiralFlowtBox.setSelectedIndex(0);
			coldSpiralFlowtBox.setSelectedIndex(0);
			hotSpiralFlowtBox.setEnabled(false);
			coldSpiralFlowtBox.setEnabled(false);
		} else {
			hotSpiralFlowtBox.setEnabled(true);
			coldSpiralFlowtBox.setEnabled(true);
		}

	
	}

}
