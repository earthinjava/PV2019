package com.duan.utils;

import javax.swing.JTable;

public class JTableUtils {
	/**
	 * 清空table中除表头所有内容
	 * 
	 * @param table
	 */
	public static void clearTable(JTable table) {
		if (table == null) {
			return;
		}
		if (table.isEditing())
			table.getCellEditor().stopCellEditing();
		int r = table.getRowCount();
		int c = table.getColumnCount();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				table.setValueAt("", i, j);
			}
		}
	}
}
