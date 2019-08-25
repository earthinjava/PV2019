package com.duan.module.meterialStandard;

import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.duan.component.CanStartFrame;
import com.duan.component.meterial.MeterialTool;
import com.duan.component.meterial.MeterialStandardBox;
import com.duan.meterialstandard.MeterialStandardDAO;
import com.duan.utils.PanelUtils;

/**
 * 删除材料标准
 * 
 * @author Administrator
 *
 */
public class DelMeterialStandardFrame extends CanStartFrame implements ActionListener {

	private static final long serialVersionUID = 653097626768066387L;
	private JPanel contentPane;
	private JComboBox<String> typeBox;
	private JLabel nameLabel;
	private JScrollPane scrollPane;
	private MeterialStandardBox meterialStandardBox;
	private MeterialTool meterialBox;
	private JLabel meComLabel;

	public DelMeterialStandardFrame() {
		super(260, 395);

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label_1 = new JLabel("\u6807\u51C6\u7C7B\u578B");
		label_1.setBounds(10, 10, 65, 23);
		contentPane.add(label_1);

		JLabel label = new JLabel("\u6807\u51C6\u4EE3\u53F7");
		label.setBounds(10, 45, 65, 23);
		contentPane.add(label);

		JLabel label_2 = new JLabel("\u6807\u51C6\u540D\u79F0");
		label_2.setBounds(10, 80, 65, 23);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("材质");
		label_3.setBounds(10, 115, 65, 23);
		contentPane.add(label_3);

		JButton delButton = new JButton("\u5220\u9664\u6807\u51C6");
		delButton.setBounds(10, 340, 224, 25);
		contentPane.add(delButton);

		meterialBox = new MeterialTool(0);

		nameLabel = meterialBox.getNameLabel();
		nameLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		nameLabel.setBounds(63, 80, 171, 23);
		contentPane.add(nameLabel);

		meComLabel = meterialBox.getMeterialComponentLabel();
		meComLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		meComLabel.setBounds(63, 115, 171, 23);
		contentPane.add(meComLabel);

		typeBox = meterialBox.getMeterialTypeBox();
		typeBox.setBounds(144, 11, 90, 23);
		contentPane.add(typeBox);

		meterialStandardBox = meterialBox.getMeterialStandardsBox();
		meterialStandardBox.setBounds(63, 46, 171, 23);
		contentPane.add(meterialStandardBox);

		scrollPane = meterialBox.getMeterialsScrollPane();
		scrollPane.setSize(224, 170);
		scrollPane.setPreferredSize(new Dimension(224, 222));
		scrollPane.setLocation(10, 150);
		contentPane.add(scrollPane);

		delButton.addActionListener(this);

		PanelUtils.setAllComFont(contentPane);
	}

	/**
	 * 删除材料操作
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if (new MeterialStandardDAO(meterialStandardBox.getSelectedStand()).del(contentPane)) {
			dispose();
		}
	}

}
