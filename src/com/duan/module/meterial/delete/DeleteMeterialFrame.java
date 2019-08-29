package com.duan.module.meterial.delete;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.duan.component.ChildFrame;
import com.duan.component.meterial.ConformStandardMeterialsBox;
import com.duan.component.meterial.MeterialTool;
import com.duan.component.meterial.MeterialStandardBox;
import com.duan.meterial.MeterialDao;
import com.duan.utils.PanelUtils;

public class DeleteMeterialFrame extends ChildFrame {

	private static final long serialVersionUID = 653097626768066387L;
	private JPanel contentPane;
	private JComboBox<String> typeBox;
	private MeterialStandardBox meterialStandardBox;
	private ConformStandardMeterialsBox conformStandardMeterialsBox;

	/**
	 * Create the frame.
	 */
	public DeleteMeterialFrame() {
		super( 250, 180);
		setTitle("删除材料");

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label_1 = new JLabel("\u6750\u6599\u7C7B\u578B");
		label_1.setBounds(10, 10, 65, 25);
		contentPane.add(label_1);

		JButton delButton = new JButton("\u5220\u9664\u6750\u6599");
		delButton.setBounds(10, 115, 214, 25);
		contentPane.add(delButton);

		JLabel label = new JLabel("\u6750\u6599\u6807\u51C6");
		label.setBounds(10, 45, 65, 25);
		contentPane.add(label);

		MeterialTool meterialBox = new MeterialTool(0);

		typeBox = meterialBox.getMeterialTypeBox();
		typeBox.setBounds(85, 11, 139, 23);
		contentPane.add(typeBox);

		meterialStandardBox = meterialBox.getMeterialStandardsBox();
		meterialStandardBox.setBounds(85, 46, 139, 23);
		contentPane.add(meterialStandardBox);

		conformStandardMeterialsBox = meterialBox.getConformStandardMeterialsBox();
		conformStandardMeterialsBox.setBounds(85, 79, 139, 23);
		contentPane.add(conformStandardMeterialsBox);

		JLabel label_2 = new JLabel("\u6750\u6599\u540D\u79F0");
		label_2.setBounds(10, 80, 65, 25);
		contentPane.add(label_2);

		delButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (new MeterialDao(conformStandardMeterialsBox.getSelctedMeterial()).del(contentPane)) {
					dispose();
				}
			}
		});			
		PanelUtils.setAllComFont(contentPane);
	}
}
