package com.duan.component.tablebutton;

import javax.swing.JButton;

import com.duan.utils.FontUtils;

public class TableButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int row;
	private int column;

	public TableButton(String text) {
		// TODO Auto-generated constructor stub
		super(text);
		FontUtils.setFont12(this);
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
}
