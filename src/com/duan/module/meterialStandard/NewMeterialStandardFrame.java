package com.duan.module.meterialStandard;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.duan.component.CanStartFrame;
import com.duan.meterialstandard.GeneralMeterialStandard;
import com.duan.meterialstandard.MeterialStandard;
import com.duan.meterialstandard.MeterialStandardDAO;
import com.duan.meterialstandard.MeterialStandardProperty;
import com.duan.utils.Constant;
import com.duan.utils.DateUtils;
import com.duan.utils.JOptionPaneUtils;
import com.duan.utils.PanelUtils;

public class NewMeterialStandardFrame extends CanStartFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> typeBox;
	private JTextField nameField;
	private JTextField numField;
	private JComboBox<String> monthBox;
	private JComboBox<String> yearBox;
	private JComboBox<String> meterialComponentBoxBox;

	public NewMeterialStandardFrame() {
		super( 260, 250);

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label_1 = new JLabel("\u6750\u6599\u7C7B\u578B");
		label_1.setBounds(10, 10, 65, 25);
		contentPane.add(label_1);

		JButton createButton = new JButton("\u786E\u8BA4\u521B\u5EFA");
		createButton.setBounds(10, 187, 224, 25);
		contentPane.add(createButton);

		typeBox = new JComboBox<String>();
		typeBox.setModel(new DefaultComboBoxModel<String>(new String[] { "\u677F", "\u7BA1", "\u953B\u4EF6" }));
		typeBox.setBounds(162, 11, 72, 23);
		contentPane.add(typeBox);

		JLabel label = new JLabel("\u6807\u51C6\u7F16\u53F7");
		label.setBounds(10, 45, 65, 25);
		contentPane.add(label);

		JLabel label_2 = new JLabel("\u53D1\u5E03\u65E5\u671F");
		label_2.setBounds(10, 80, 65, 25);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("\u6807\u51C6\u540D\u79F0");
		label_3.setBounds(10, 115, 65, 25);
		contentPane.add(label_3);

		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		nameField.setBounds(95, 113, 139, 23);
		contentPane.add(nameField);
		nameField.enableInputMethods(true);

		numField = new JTextField();
		numField.setColumns(10);
		numField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		numField.setBounds(95, 47, 139, 23);
		contentPane.add(numField);

		JLabel label_4 = new JLabel("\u5E74");
		label_4.setBounds(162, 80, 15, 23);
		contentPane.add(label_4);

		monthBox = new JComboBox<String>();
		monthBox.setModel(new DefaultComboBoxModel<String>(Constant.MOTHS));
		monthBox.setBounds(175, 80, 48, 23);
		contentPane.add(monthBox);

		JLabel label_5 = new JLabel("\u6708");
		label_5.setBounds(225, 80, 18, 23);
		contentPane.add(label_5);

		yearBox = new JComboBox<String>();
		yearBox.setBounds(95, 80, 66, 23);
		contentPane.add(yearBox);

		JLabel label_6 = new JLabel("\u6750\u8D28");
		label_6.setBounds(10, 150, 65, 25);
		contentPane.add(label_6);

		meterialComponentBoxBox = new JComboBox<String>(Constant.METERIALCOMPONENT);
		meterialComponentBoxBox.setBounds(95, 151, 139, 23);
		contentPane.add(meterialComponentBoxBox);

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		int thisYear = DateUtils.getThisYear();
		for (int i = 0; i <= 30; i++, thisYear--) {
			yearBox.addItem(thisYear + "");
		}

		createButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				int type = typeBox.getSelectedIndex();
				String num =numField.getText();				
				if (num == null || num.trim() == "") {
					JOptionPaneUtils.warningMess(contentPane, "请输入标准号");
					numField.requestFocus();
					return;
				}
				String year = yearBox.getSelectedItem() + "";
				String month = monthBox.getSelectedItem() + "";
				String name = nameField.getText();
				if (name == null || name.trim().equals("")) {
					JOptionPaneUtils.warningMess(contentPane, "请输入标准名称");
					nameField.requestFocus();
					return;
				}
				MeterialStandard meterialStandard = new GeneralMeterialStandard();
				MeterialStandardProperty standardProperty = new MeterialStandardProperty();
				standardProperty.setMeterialComponent(meterialComponentBoxBox.getSelectedItem().toString());
				meterialStandard.setImplementationDate(DateUtils.parseStringToDate(year + "-" + month));
				meterialStandard.setMeterialType(type);
				meterialStandard.setName(name);
				meterialStandard.setStandardNum(num);
				meterialStandard.setProperty(standardProperty);			
				if ( new MeterialStandardDAO(meterialStandard).creat(contentPane)) {
					dispose();
				}
			}
		});
		PanelUtils.setAllComFont(contentPane);
	}
}
