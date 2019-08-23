package com.duan.module.meterial.create;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import com.duan.component.PureNumField;
import com.duan.component.meterial.MeterialTool;
import com.duan.component.meterial.MeterialStandardBox;
import com.duan.meterial.Meterial;
import com.duan.meterial.MeterialDao;
import com.duan.meterialstandard.MeterialStandardDAO;
import com.duan.utils.Constant;
import com.duan.utils.FontUtils;
import com.duan.utils.JOptionPaneUtils;
import com.duan.utils.JTableUtils;
import com.duan.utils.PanelUtils;

public class StressAndPropertyPanel extends JPanel {

	private static final long serialVersionUID = -1000714411346903710L;
	private JTable allowStressTable;
	private JScrollPane jScrollPane;
	private JTextField meterialNameField;
	private PureNumField densityField;
	private PureNumField modulusField;
	private PureNumField expansionField;
	private PureNumField thermalConductivityField;
	private PureNumField minTempField;
	private JLabel meComLabel;
	private JButton saveButton;
	private JLabel standardNameLabel;
	private JButton editButton;
	private JButton clearButton;
	private Meterial meterial;

	/**
	 * Create the panel.
	 */
	public StressAndPropertyPanel() {
		setBackground(SystemColor.menu);
		setLayout(null);
		setSize(1100, 376);

		saveButton = new JButton("\u4FDD\u5B58");
		saveButton.setBounds(980, 340, 90, 25);
		add(saveButton);

		densityField = new PureNumField();
		densityField.setText("7.85");
		densityField.setBounds(67, 344, 70, 20);
		add(densityField);

		JLabel lblNewLabel = new JLabel("\u6750\u6599\u540D\u79F0");
		lblNewLabel.setBounds(10, 310, 65, 20);
		add(lblNewLabel);

		JLabel label = new JLabel("\u6750\u6599\u6807\u51C6\uFF1A");
		label.setBounds(406, 310, 65, 20);
		add(label);

		JLabel label_1 = new JLabel("\u5BC6\u5EA6");
		label_1.setBounds(10, 343, 65, 20);
		add(label_1);

		JLabel label_2 = new JLabel("t/m\u00B3");
		label_2.setBounds(147, 343, 54, 20);
		add(label_2);

		JLabel label_3 = new JLabel("\u5F39\u6027\u6A21\u91CF");
		label_3.setBounds(203, 310, 54, 20);
		add(label_3);

		modulusField = new PureNumField();
		modulusField.setBounds(267, 311, 70, 20);
		add(modulusField);

		JLabel label_4 = new JLabel("10\u00B3MPa");
		label_4.setBounds(347, 310, 54, 20);
		add(label_4);

		JLabel label_5 = new JLabel("\u7EBF\u81A8\u80C0\u7CFB\u6570");
		label_5.setBounds(203, 344, 65, 20);
		add(label_5);

		JLabel label_6 = new JLabel("mm/m.\u2103");
		label_6.setBounds(347, 344, 54, 20);
		add(label_6);

		JLabel label_7 = new JLabel("\u5BFC\u70ED\u7CFB\u6570");
		label_7.setBounds(406, 344, 54, 20);
		add(label_7);

		JLabel label_8 = new JLabel("W/m.\u2103");
		label_8.setBounds(550, 344, 54, 20);
		add(label_8);

		expansionField = new PureNumField();
		expansionField.setBounds(267, 344, 70, 20);
		add(expansionField);

		thermalConductivityField = new PureNumField();
		thermalConductivityField.setBounds(470, 344, 70, 20);
		add(thermalConductivityField);

		meComLabel = new JLabel("");
		meComLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		meComLabel.setBounds(830, 344, 120, 20);
		add(meComLabel);

		minTempField = new PureNumField();
		minTempField.setText("-20");
		minTempField.setBounds(710, 344, 70, 20);
		add(minTempField);

		JLabel label_9 = new JLabel("\u6700\u4F4E\u8BB8\u7528\u6E29\u5EA6");
		label_9.setBounds(625, 344, 79, 20);
		add(label_9);

		JLabel label_10 = new JLabel("\u2103");
		label_10.setBounds(790, 344, 54, 20);
		add(label_10);
		PanelUtils.setAllComFont(this);

		editButton = new JButton("\u7F16\u8F91");
		editButton.setBounds(980, 310, 90, 25);
		add(editButton);

	}

	/**
	 * 新建材料的面板
	 * 
	 * @param meterial
	 * @param meterialFrame
	 */
	public StressAndPropertyPanel(Meterial meterial, NewMeterialFrame meterialFrame) {
		this();
		this.meterial = meterial;

		String[][] tableContentStrings = new String[20][20];
		allowStressTable = new JTable(tableContentStrings, Constant.STRESSTABLE_HEADER);
		for (int i = 0; i < 4; i++) {
			allowStressTable.getColumnModel().getColumn(i).setPreferredWidth(135);
		}
		for (int i = 4; i < 20; i++) {
			allowStressTable.getColumnModel().getColumn(i).setPreferredWidth(70);
		}

		FontUtils.setDefaultFont(allowStressTable.getTableHeader());
		FontUtils.setDefaultFont(allowStressTable);
		jScrollPane = new JScrollPane(allowStressTable);
		jScrollPane.setBounds(0, 0, 1083, 300);
		add(jScrollPane);

		meterialNameField = new JTextField();
		meterialNameField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		meterialNameField.setBounds(69, 310, 70, 20);
		meterialNameField.setColumns(10);
		add(meterialNameField);

		modulusField.setText("200");
		expansionField.setText("0.0111");
		thermalConductivityField.setText("73.3");

		MeterialTool meterialBox = new MeterialTool(0);

		standardNameLabel = meterialBox.getNameLabel();
		standardNameLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		standardNameLabel.setBounds(710, 310, 242, 20);
		add(standardNameLabel);

		meterialBox.setMeterialComponentLabel(meComLabel);

		JComboBox<String> typeComboBox = meterialBox.getMeterialTypeBox();
		typeComboBox.setBounds(470, 310, 70, 20);
		add(typeComboBox);

		MeterialStandardBox standardsBox = meterialBox.getMeterialStandardsBox();
		standardsBox.setLocation(550, 310);
		add(standardsBox);

		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = meterialNameField.getText();
				if (name.trim().contentEquals("")) {
					JOptionPaneUtils.warningMess(jScrollPane, "请输入材料名称");
					return;
				}
				setMeterialProperty();
				meterial.setMeterialStandard(standardsBox.getSelectedStand());
				meterial.setName(name);
				if (new MeterialDao(meterial).save()) {
					meterialFrame.dispose();
				}
			}
		});

		clearButton = new JButton("\u6E05\u7A7A\u8868\u683C");
		clearButton.setBounds(980, 310, 90, 25);
		add(clearButton);

		editButton.setVisible(false);

		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTableUtils.clearTable(allowStressTable);
			}
		});

		PanelUtils.setAllComFont(this);
	}

	/**
	 * 查看材料的面板
	 * 
	 * @param meterial
	 * @param showMeterialFrame
	 * @param i                 仅为了和上面的构造方法区分
	 */
	public StressAndPropertyPanel(Meterial meterial, NewMeterialFrame meterialStressAndPropertyFrame, int i) {
		this();
		this.meterial = meterial;

		allowStressTable = meterial.getAllowStressTable();
		FontUtils.setDefaultFont(allowStressTable.getTableHeader());
		FontUtils.setDefaultFont(allowStressTable);
		jScrollPane = new JScrollPane(allowStressTable);
		jScrollPane.setBounds(0, 0, 1083, 300);
		add(jScrollPane);

		allowStressTable.setEnabled(false);
		saveButton.setVisible(false);
		editButton.setVisible(true);

		densityField.setEnabled(false);
		densityField.setText(meterial.getDensity() + "");

		modulusField.setEnabled(false);
		modulusField.setText(meterial.getModulus() + "");

		expansionField.setEnabled(false);
		expansionField.setText(meterial.getExpansion() + "");

		thermalConductivityField.setEnabled(false);
		thermalConductivityField.setText(meterial.getThermalConductivity() + "");

		minTempField.setEnabled(false);
		minTempField.setText(meterial.getMinAllowTemp() + "");

		JLabel meterialNameLabel = new JLabel("");
		meterialNameLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		meterialNameLabel.setBounds(67, 310, 80, 20);
		meterialNameLabel.setText(meterial.getName());
		add(meterialNameLabel);

		JLabel standardTypeLabel = new JLabel("");
		standardTypeLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		standardTypeLabel.setBounds(470, 310, 70, 20);
		standardTypeLabel.setText(new MeterialStandardDAO(meterial.getMeterialStandard()).getTypeString());
		add(standardTypeLabel);

		JLabel standardNumAndDateLabel = new JLabel("");
		standardNumAndDateLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		standardNumAndDateLabel.setSize(150, 20);
		standardNumAndDateLabel.setLocation(550, 310);
		standardNumAndDateLabel
				.setText(new MeterialStandardDAO(meterial.getMeterialStandard()).getStandardNumAndDate());
		add(standardNumAndDateLabel);
		
		standardNameLabel =new JLabel();
		standardNameLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		standardNameLabel.setBounds(710, 310, 242, 20);
		add(standardNameLabel);

		standardNameLabel.setText(meterial.getMeterialStandard().getName());

		meComLabel.setText(meterial.getMeterialStandard().getProperty().getMeterialComponent());

		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setMeterialProperty();
				if (new MeterialDao(meterial).save()) {
					allowStressTable.setEnabled(false);
					densityField.setEnabled(false);
					modulusField.setEnabled(false);
					expansionField.setEnabled(false);
					thermalConductivityField.setEnabled(false);
					minTempField.setEnabled(false);
					saveButton.setVisible(false);
					meterialStressAndPropertyFrame.dispose();
				}
			}
		});

		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				allowStressTable.setEnabled(true);
				densityField.setEnabled(true);
				modulusField.setEnabled(true);
				expansionField.setEnabled(true);
				thermalConductivityField.setEnabled(true);
				minTempField.setEnabled(true);
				saveButton.setVisible(true);
			}
		});
		PanelUtils.setAllComFont(this);
	}

	/**
	 * 设置材料的许用应力和属性
	 */
	private void setMeterialProperty() {
		double density = densityField.getDoubleNoNull("请输材料密度");
		if (density == Constant.ERROR_DOUBLE) {
			return;
		}
		double modulus = modulusField.getDoubleNoNull("请输入弹性模量");
		if (modulus == Constant.ERROR_DOUBLE) {
			return;
		}
		double expansion = expansionField.getDoubleNoNull("请输入线膨胀系数");
		if (expansion == Constant.ERROR_DOUBLE) {
			return;
		}
		double thermalConductivity = thermalConductivityField.getDoubleNoNull("请输入导热系数");
		if (thermalConductivity == Constant.ERROR_DOUBLE) {
			return;
		}
		double minTemp = minTempField.getDoubleNoNull("请输入最低许用温度");
		if (minTemp == Constant.ERROR_DOUBLE) {
			return;
		}
		meterial.setAllowStressTable(allowStressTable);
		meterial.setModulus(modulus);
		meterial.setExpansion(expansion);
		meterial.setDensity(density);
		meterial.setThermalConductivity(thermalConductivity);
		meterial.setMinAllowTemp(minTemp);
	}
}
