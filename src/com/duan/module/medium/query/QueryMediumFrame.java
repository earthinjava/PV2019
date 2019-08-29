package com.duan.module.medium.query;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.duan.component.ChildFrame;

public class QueryMediumFrame extends ChildFrame {
	private static final long serialVersionUID = 5049972612639138256L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public QueryMediumFrame() {
		super(800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
	}

}
