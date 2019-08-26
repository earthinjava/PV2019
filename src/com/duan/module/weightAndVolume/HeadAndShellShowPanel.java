package com.duan.module.weightAndVolume;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import com.duan.component.PureNumField;
import com.duan.component.meterial.MeterialButton;
import com.duan.meterial.Meterial;
import com.duan.module.calculate.HaveNeedSavePanel;
import com.duan.utils.Constant;
import com.duan.utils.FontUtils;
import com.duan.utils.JOptionPaneUtils;
import com.duan.utils.LabelAndFieldUtils;
import com.duan.utils.PanelUtils;
import com.duan.vessel.HeadAndShell;
import com.duan.vessel.head.EHA;
import com.duan.vessel.head.Head;
import com.duan.vessel.shell.CylinderShell;

public class HeadAndShellShowPanel extends HaveNeedSavePanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JPanel tablePanel;
	private JComboBox<String> isHorizontalBox;
	private JComboBox<String> headTypeComboBox;
	private PureNumField iDTextField;
	private PureNumField shellFormingThickTextField;
	private PureNumField shellLengthField;
	private PureNumField levelHeightField;
	private PureNumField headFormingThickTextField;
	private PureNumField mediumDensityField;
	private JLabel meterialDensityLable;
	private JLabel shellVolumeLable;
	private JLabel shellTotalWeightLabel;
	private JLabel headTotalWeightLabel;
	private JLabel headVolumeLabel;
	private JLabel totalVolumeLabel;
	private JLabel massWeithtLabel;
	private JLabel shellandheadweightLabel;
	private JLabel totalWeightLable;
	private JLabel lengthLabel;
	private JLabel longLabel;
	private MeterialButton meterialButton;
	private HeadAndShell headAndShell;
	private double levelHeigt;

	public HeadAndShellShowPanel() {

		setBackground(Color.WHITE);
		setLayout(null);

		contentPanel = new JPanel();
		contentPanel.setBackground(SystemColor.menu);
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPanel.setSize(215, 615);
		contentPanel.setLocation(5, 5);
		contentPanel.setToolTipText("\u5C01\u5934\u91CD\u91CF");
		contentPanel.setLayout(null);
		add(contentPanel);

		tablePanel = new JPanel();
		tablePanel.setLocation(225, 5);
		tablePanel.setBackground(SystemColor.menu);
		tablePanel.setLayout(null);
		tablePanel.setSize(560, 615);
		tablePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		add(tablePanel);

		headTypeComboBox = new JComboBox<String>();
		headTypeComboBox.setModel(new DefaultComboBoxModel<String>(Constant.HEAD_TYPES));
		headTypeComboBox.setBounds(74, 40, 81, 20);
		contentPanel.add(headTypeComboBox);

		JLabel label = new JLabel("\u5185\u5F84");
		label.setBounds(10, 100, 66, 20);
		contentPanel.add(label);

		JLabel label_1 = new JLabel("\u7B52\u4F53\u539A\u5EA6");
		label_1.setBounds(10, 160, 66, 20);
		contentPanel.add(label_1);

		JLabel label_2 = new JLabel("\u7B52\u4F53\u5BB9\u79EF");
		label_2.setBounds(10, 370, 66, 20);
		contentPanel.add(label_2);

		JLabel label_3 = new JLabel("\u6750\u6599\u5BC6\u5EA6");
		label_3.setBounds(10, 280, 66, 20);
		contentPanel.add(label_3);

		iDTextField = new PureNumField();
		iDTextField.setBounds(74, 100, 81, 20);
		contentPanel.add(iDTextField);

		shellFormingThickTextField = new PureNumField();
		shellFormingThickTextField.setBounds(74, 160, 81, 20);
		contentPanel.add(shellFormingThickTextField);

		JButton button = new JButton("\u8BA1\u7B97");
		button.addActionListener(this);

		button.setBounds(10, 580, 195, 23);
		contentPanel.add(button);

		JLabel label_5 = new JLabel("\u578B\u5F0F");
		label_5.setBounds(10, 10, 66, 20);
		contentPanel.add(label_5);

		JLabel label_6 = new JLabel("mm");
		label_6.setBounds(165, 100, 28, 20);
		contentPanel.add(label_6);

		JLabel label_7 = new JLabel("mm");
		label_7.setBounds(165, 160, 28, 20);
		contentPanel.add(label_7);

		JLabel lblM = new JLabel("m\u00B3");
		lblM.setBounds(165, 370, 18, 20);
		contentPanel.add(lblM);

		JLabel lblTm = new JLabel("t/m\u00B3");
		lblTm.setBounds(165, 280, 28, 20);
		contentPanel.add(lblTm);

		isHorizontalBox = new JComboBox<String>();
		isHorizontalBox.setModel(new DefaultComboBoxModel<String>(new String[] { "\u5367\u5F0F", "\u7ACB\u5F0F" }));
		isHorizontalBox.setBounds(74, 10, 81, 20);
		contentPanel.add(isHorizontalBox);

		isHorizontalBox.addActionListener(new BoxActionListener());

		JLabel label_8 = new JLabel("\u6750\u6599");
		label_8.setBounds(10, 70, 66, 20);
		contentPanel.add(label_8);

		meterialButton = new MeterialButton();
		meterialButton.setBounds(74, 70, 81, 20);
		contentPanel.add(meterialButton);

		meterialDensityLable = meterialButton.getDensityLabel();
		meterialDensityLable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		meterialDensityLable.setBounds(74, 280, 81, 20);
		contentPanel.add(meterialDensityLable);

		shellVolumeLable = new JLabel("");
		shellVolumeLable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		shellVolumeLable.setBounds(74, 370, 81, 20);
		contentPanel.add(shellVolumeLable);

		JLabel label_11 = new JLabel("\u7B52\u4F53\u957F\u5EA6");
		label_11.setBounds(10, 130, 66, 20);
		contentPanel.add(label_11);

		shellLengthField = new PureNumField();
		shellLengthField.setBounds(74, 130, 81, 20);
		contentPanel.add(shellLengthField);

		JLabel label_12 = new JLabel("mm");
		label_12.setBounds(165, 130, 28, 20);
		contentPanel.add(label_12);

		JLabel label_9 = new JLabel("\u95F4\u9694\u9AD8\u5EA6");
		label_9.setBounds(10, 220, 66, 20);
		contentPanel.add(label_9);

		levelHeightField = new PureNumField();
		levelHeightField.setBounds(74, 220, 81, 20);
		contentPanel.add(levelHeightField);

		JLabel label_10 = new JLabel("mm");
		label_10.setBounds(165, 220, 28, 20);
		contentPanel.add(label_10);

		JLabel label_13 = new JLabel("\u5C01\u5934\u7C7B\u578B");
		label_13.setBounds(10, 40, 66, 20);
		contentPanel.add(label_13);

		JLabel label_14 = new JLabel("\u5C01\u5934\u539A\u5EA6");
		label_14.setBounds(10, 190, 66, 20);
		contentPanel.add(label_14);

		headFormingThickTextField = new PureNumField();
		headFormingThickTextField.setBounds(74, 190, 81, 20);
		contentPanel.add(headFormingThickTextField);

		JLabel label_15 = new JLabel("mm");
		label_15.setBounds(165, 190, 28, 20);
		contentPanel.add(label_15);

		JLabel label_16 = new JLabel("\u7B52\u4F53\u603B\u91CD");
		label_16.setBounds(10, 310, 66, 20);
		contentPanel.add(label_16);

		shellTotalWeightLabel = new JLabel("");
		shellTotalWeightLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		shellTotalWeightLabel.setBounds(74, 310, 81, 20);
		contentPanel.add(shellTotalWeightLabel);

		JLabel label_18 = new JLabel("kg");
		label_18.setBounds(165, 310, 18, 20);
		contentPanel.add(label_18);

		JLabel label_19 = new JLabel("\u5C01\u5934\u5355\u91CD");
		label_19.setBounds(10, 340, 66, 20);
		contentPanel.add(label_19);

		headTotalWeightLabel = new JLabel("");
		headTotalWeightLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		headTotalWeightLabel.setBounds(74, 340, 81, 20);
		contentPanel.add(headTotalWeightLabel);

		JLabel label_21 = new JLabel("kg");
		label_21.setBounds(165, 340, 18, 20);
		contentPanel.add(label_21);

		JLabel label_22 = new JLabel("\u5C01\u5934\u5355\u5BB9\u79EF");
		label_22.setBounds(10, 400, 81, 20);
		contentPanel.add(label_22);

		headVolumeLabel = new JLabel("");
		headVolumeLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		headVolumeLabel.setBounds(74, 400, 81, 20);
		contentPanel.add(headVolumeLabel);

		JLabel label_24 = new JLabel("m\u00B3");
		label_24.setBounds(165, 400, 18, 20);
		contentPanel.add(label_24);

		JLabel label_25 = new JLabel("\u603B\u5BB9\u79EF");
		label_25.setBounds(10, 430, 66, 20);
		contentPanel.add(label_25);

		totalVolumeLabel = new JLabel("");
		totalVolumeLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		totalVolumeLabel.setBounds(74, 430, 81, 20);
		contentPanel.add(totalVolumeLabel);

		JLabel label_27 = new JLabel("m\u00B3");
		label_27.setBounds(165, 430, 18, 20);
		contentPanel.add(label_27);

		JLabel label_28 = new JLabel("\u4ECB\u8D28\u5BC6\u5EA6");
		label_28.setBounds(10, 250, 66, 20);
		contentPanel.add(label_28);

		JLabel lblKgm = new JLabel("kg/m\u00B3");
		lblKgm.setBounds(165, 250, 40, 20);
		contentPanel.add(lblKgm);

		mediumDensityField = new PureNumField();
		mediumDensityField.setBounds(74, 250, 81, 20);
		contentPanel.add(mediumDensityField);

		JLabel label_29 = new JLabel("\u8F7D\u91CD");
		label_29.setBounds(10, 490, 66, 20);
		contentPanel.add(label_29);

		massWeithtLabel = new JLabel("");
		massWeithtLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		massWeithtLabel.setBounds(74, 490, 81, 20);
		contentPanel.add(massWeithtLabel);

		JLabel label_31 = new JLabel("kg");
		label_31.setBounds(165, 490, 18, 20);
		contentPanel.add(label_31);

		JLabel label_32 = new JLabel("\u603B\u91CD");
		label_32.setBounds(10, 520, 66, 20);
		contentPanel.add(label_32);

		totalWeightLable = new JLabel("");
		totalWeightLable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		totalWeightLable.setBounds(74, 520, 81, 20);
		contentPanel.add(totalWeightLable);

		JLabel label_34 = new JLabel("kg");
		label_34.setBounds(165, 520, 18, 20);
		contentPanel.add(label_34);

		longLabel = new JLabel("\u5916\u90E8\u603B\u957F");
		longLabel.setBounds(10, 550, 66, 20);
		contentPanel.add(longLabel);

		lengthLabel = new JLabel("");
		lengthLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lengthLabel.setBounds(74, 550, 81, 20);
		contentPanel.add(lengthLabel);

		JLabel label_37 = new JLabel("mm");
		label_37.setBounds(165, 550, 28, 20);
		contentPanel.add(label_37);

		JLabel label_4 = new JLabel("\u7A7A\u91CD");
		label_4.setBounds(10, 460, 66, 20);
		contentPanel.add(label_4);

		shellandheadweightLabel = new JLabel("");
		shellandheadweightLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		shellandheadweightLabel.setBounds(74, 460, 81, 20);
		contentPanel.add(shellandheadweightLabel);

		JLabel label_20 = new JLabel("kg");
		label_20.setBounds(165, 460, 18, 20);
		contentPanel.add(label_20);
		PanelUtils.setAllComFont(contentPanel);
	}

	class BoxActionListener implements ActionListener, Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = -4679975539033118276L;

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			if (isHorizontalBox.getSelectedIndex() == 0) {
				longLabel.setText("外部总长");
			} else if (isHorizontalBox.getSelectedIndex() == 1) {
				longLabel.setText("外部总高");
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		apply();
	}

	public void apply() {
		// TODO 自动生成的方法存根
		if (getInput()) {
			showOutput();
		}
	}

	/**
	 * 获得输入
	 * 
	 * @return
	 */
	private boolean getInput() {
		try {
			// 获得立式还是卧式容器
			boolean isHorizontal;
			if (isHorizontalBox.getSelectedIndex() == 0) {
				isHorizontal = true;
			} else {
				isHorizontal = false;
			}
			// 获得封头型式
			String headType = headTypeComboBox.getSelectedItem() + "";
			// 获得设备材料
			Meterial meterial = meterialButton.getSelectedMeterial();
			if (meterial == null) {
				JOptionPaneUtils.warningMess(contentPanel, "请先选择材料");
				return false;
			}
			// 获得内径
			double id = iDTextField.getDoubleNoNull("请输入内径");
			if (id == Constant.ERROR_DOUBLE) {
				return false;
			}
			// 筒体长度
			double length = shellLengthField.getDoubleNoNull("请输入筒体长度");
			if (length == Constant.ERROR_DOUBLE) {
				return false;
			}
			// 筒体成型厚度
			double shellFormingThick = shellFormingThickTextField.getDoubleNoNull("请输入筒体成型厚度");
			if (shellFormingThick == Constant.ERROR_DOUBLE) {
				return false;
			}
			// 封头成型厚度
			double headFormingThick = headFormingThickTextField.getDoubleNoNull("请输入封头成型厚度");
			if (headFormingThick == Constant.ERROR_DOUBLE) {
				return false;
			}
			// 间隔高度
			levelHeigt = levelHeightField.getDoubleNoNull("请输入间隔高度");
			if (levelHeigt == Constant.ERROR_DOUBLE || levelHeigt <= 0) {
				return false;
			}
			// 介质密度
			double mediumDensity = mediumDensityField.getDoubleNoNull("请输入介质密度");
			if (mediumDensity == Constant.ERROR_DOUBLE) {
				return false;
			}
			// 创建筒体对象
			CylinderShell cylinderShell = new CylinderShell(id, shellFormingThick, meterial, length, isHorizontal);
			// 创建封头对象
			Head head = (Head) Class.forName(EHA.class.getPackage().getName() + "." + headType).getConstructor()
					.newInstance();
			// 判断直段长度
			double strLength;
			if (id > 2000) {
				strLength = 40;
			} else {
				strLength = 25;
			}
			head.setFormingThick(headFormingThick);
			head.setMeterial(meterial);
			head.setStrLength(strLength);
			head.setLongID(id);
			head.setShortID(id / 2);
			// 创建封头和筒体组合容器
			if (headAndShell == null) {
				headAndShell = new HeadAndShell();
			}
			headAndShell.setHead(head);
			headAndShell.setCylinderShell(cylinderShell);
			headAndShell.setMediumDensity(mediumDensity);
			headAndShell.setHorizontal(cylinderShell.isHorizontal());
			return true;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	/**
	 * 显示计算结果
	 */
	private void showOutput() {
		// 显示信息
		LabelAndFieldUtils.showDoublePointTwo(meterialDensityLable,
				headAndShell.getCylinderShell().getMeterial().getDensity());
		LabelAndFieldUtils.showDoublePointTwo(shellTotalWeightLabel, headAndShell.getCylinderShell().getWeight());
		LabelAndFieldUtils.showDoublePointTwo(headTotalWeightLabel, headAndShell.getHead().getWeight());
		LabelAndFieldUtils.showDoublePointTwo(shellVolumeLable, headAndShell.getCylinderShell().getTotalVolume());
		LabelAndFieldUtils.showDoublePointTwo(headVolumeLabel, headAndShell.getHead().getInletVolume());
		LabelAndFieldUtils.showDoublePointTwo(totalVolumeLabel, headAndShell.getTotalVolume());
		LabelAndFieldUtils.showDoublePointTwo(shellandheadweightLabel, headAndShell.getWeight());
		LabelAndFieldUtils.showDoublePointTwo(massWeithtLabel, headAndShell.getLoadWeigth());
		LabelAndFieldUtils.showDoublePointTwo(totalWeightLable,
				headAndShell.getLoadWeigth() + headAndShell.getWeight());
		LabelAndFieldUtils.showDoublePointTwo(lengthLabel, headAndShell.getLength());
		// 根据高度间隔，获得容积数组
		tablePanel.removeAll();
		Double[][] hvs = headAndShell.getMessByLevelHeigt(levelHeigt);
		String[] tableTitle = { "液位高度mm", "容积m³", "充装质量kg", "充满率%", "水静压KPa", "介质静压KPa" };
		JTable table = new JTable(hvs, tableTitle);
		FontUtils.setDefaultFont(table.getTableHeader());
		FontUtils.setDefaultFont(table);
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(0, 0, 559, 614);
		jScrollPane.setBackground(SystemColor.menu);
		tablePanel.add(jScrollPane);
		tablePanel.repaint();
	}

	@Override
	public boolean isNeedSave() {
		if (!PanelUtils.isHaveInput(contentPanel)) {
			return false;
		}
		return true;
	}

	@Override
	public String getChiName() {
		// TODO 自动生成的方法存根
		return Constant.MODULE_CHINAME[3];
	}
}
