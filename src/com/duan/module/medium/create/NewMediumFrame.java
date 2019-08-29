package com.duan.module.medium.create;

import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.duan.component.ChildFrame;
import com.duan.medium.MediumState;
import com.duan.utils.Constant;
import com.duan.utils.FontUtils;
import com.duan.utils.JOptionPaneUtils;
import com.duan.utils.SerializeUtils;

public class NewMediumFrame extends ChildFrame implements ActionListener {

	private static final long serialVersionUID = 8925496833041725076L;
	private JPanel contentPanel;
	private JTextField nameFiled;
	private JPanel panel;
	private JButton saveButton;
	private NewMediumFrame newMediumFrame = this;
	private JComboBox<String> stateBox;
	private JScrollPane jScrollPane;

	/**
	 * 新建材料窗体
	 */
	public NewMediumFrame() {
		super(800, 780);
		setTitle("新建介质");

		contentPanel = new JPanel();
		contentPanel.setBackground(Color.white);
		contentPanel.setBounds(new Rectangle(0, 0, 1100, 450));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		setContentPane(contentPanel);

		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(7, 7, 771, 42);
		panel.setBackground(SystemColor.menu);
		panel.setLayout(null);
		contentPanel.add(panel);

		nameFiled = new JTextField();
		nameFiled.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		nameFiled.setBounds(70, 10, 64, 20);
		panel.add(nameFiled);

		JLabel nameLabel = new JLabel("介质名称");
		nameLabel.setBounds(10, 10, 60, 23);
		panel.add(nameLabel);

		stateBox = new JComboBox<String>();
		stateBox.setModel(new DefaultComboBoxModel<String>(new String[] { "气体", "液体" }));
		stateBox.setSelectedIndex(1);
		((JLabel) stateBox.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
		stateBox.setBounds(154, 10, 80, 22);
		panel.add(stateBox);

		saveButton = new JButton("保存");
		saveButton.setBounds(705, 4, 60, 33);
		saveButton.addActionListener(this);
		panel.add(saveButton);

		

		jScrollPane = new JScrollPane(getTable());
		jScrollPane.setViewportView(getTable());
		jScrollPane.setBounds(5, 50, 775, 685);
		jScrollPane.setBackground(SystemColor.menu);
		
		stateBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				jScrollPane.setViewportView(getTable());
				
				
			}
		});

		contentPanel.add(jScrollPane);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String name = nameFiled.getText();
		if (name == null || name.trim().equals("")) {
			JOptionPaneUtils.warningMess((Component) e.getSource(), "请输入介质名称");
			return;
		}
		if (SerializeUtils.seriallized(newMediumFrame, newMediumFrame, Constant.MEDIUM_FOLDERPATH, name,
				getMediumState().toString())) {
			dispose();
		}
	}

	public MediumState getMediumState() {
		if (stateBox.getSelectedIndex() == 0) {
			return MediumState.GASS;
		} else {
			return MediumState.LIQUID;
		}
	}

	private JTable getTable() {
		if (getMediumState().equals(MediumState.LIQUID)) {
			String[][] content = new String[50][8];
			String[] tableTitle = { "温度℃", "密度kg/m³", "焓kJ/kg", "比热容kJ/(kg.K)", "热导率W/(m.K)", "粘度mPa.s",
					"运动粘度10^-5 m²/s", "表面张力mN/m" };
			JTable table = new JTable(content, tableTitle);
			FontUtils.setDefaultFont(table.getTableHeader());
			FontUtils.setDefaultFont(table);

			table.getColumnModel().getColumn(0).setPreferredWidth(20);
			table.getColumnModel().getColumn(1).setPreferredWidth(40);
			table.getColumnModel().getColumn(2).setPreferredWidth(40);
			table.getColumnModel().getColumn(3).setPreferredWidth(60);
			table.getColumnModel().getColumn(4).setPreferredWidth(50);
			table.getColumnModel().getColumn(5).setPreferredWidth(50);
			return table;
		} else {
			return null;
		}
	}
}
