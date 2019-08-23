package com.duan.module.calculate;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.duan.component.CanStartFrame;
import com.duan.component.tablebutton.MyJTable;
import com.duan.utils.PanelUtils;

public class SelectCalculateFrame extends CanStartFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JComboBox<String> calTypeBox;
	private MyJTable calsTable;

	public SelectCalculateFrame(JTabbedPane tabbedPane) {
		super(500, 420);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(SystemColor.menu);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel calTypeLabel = new JLabel("计算");
		calTypeLabel.setBounds(208, 10, 65, 25);
		contentPane.add(calTypeLabel);

		calTypeBox = new JComboBox<String>();
		calTypeBox.setBounds(283, 11, 200, 23);
		contentPane.add(calTypeBox);

		String[] calTypes = CalculateDao.getCalTypeList();

		if (calTypes != null && calTypes.length > 0) {
			calTypeBox.setModel(new DefaultComboBoxModel<String>(calTypes));
			refreshTable(tabbedPane);
			calTypeBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					refreshTable(tabbedPane);
				}
			});
		}
		PanelUtils.setAllComFont(contentPane);
	}

	/**
	 * 根据选择的计算类型，刷新计算显示列表
	 * 
	 * @param tabbedPane
	 */
	public void refreshTable(JTabbedPane tabbedPane) {
		if (scrollPane != null) {
			contentPane.remove(scrollPane);
		}
		String calType = calTypeBox.getSelectedItem().toString();
		calsTable = CalculateDao.getCalTypeTable(calType, this, tabbedPane);
		scrollPane = new JScrollPane(calsTable);
		scrollPane.setBackground(Color.white);
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBounds(10, 45, 473, 337);
		contentPane.add(scrollPane);
	}

}
