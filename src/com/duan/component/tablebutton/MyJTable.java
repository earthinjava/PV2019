package com.duan.component.tablebutton;

import javax.swing.JTable;

/**
 * 一个某列不可编辑的表格
 * 
 * @author Administrator
 *
 */
public class MyJTable extends JTable {

	private static final long serialVersionUID = 1L;
	private int[] uneditableColumns;

	public MyJTable(String[][] tableContentStrings, String[] tableHeader) {
		super(tableContentStrings, tableHeader);
	}

	public void setUneditable(int[] uneditableColumns) {
		this.uneditableColumns = uneditableColumns;
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		if(uneditableColumns==null) {
			return true;
		}
		for (int col : uneditableColumns) {
			if (column == col) {
				return false;
			}
		}
		return true;
	}

}
