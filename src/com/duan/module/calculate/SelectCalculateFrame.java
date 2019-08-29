package com.duan.module.calculate;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.duan.component.ChildFrame;
import com.duan.component.tablebutton.MyJTable;
import com.duan.utils.PanelUtils;

public class SelectCalculateFrame extends ChildFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JComboBox<String> calTypeBox;
	private MyJTable calsTable;

	public SelectCalculateFrame(JTabbedPane tabbedPane) {
		super(500, 420);
		setTitle("计算库");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(SystemColor.menu);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		calTypeBox = new JComboBox<String>();
		calTypeBox.setBounds(280, 11, 200, 23);
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
		scrollPane.setBackground(SystemColor.menu);
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBounds(5, 45, 475, 330);
		contentPane.add(scrollPane);
	}

}
