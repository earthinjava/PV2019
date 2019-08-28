package com.duan.module.medium.create;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.duan.component.CanStartFrame;
import com.duan.medium.MediumState;
import com.duan.utils.PanelUtils;

/**
 * 材料选择窗体
 * 
 * @author Administrator
 *
 */
public class SelectMediumStateFrame extends CanStartFrame {

	private static final long serialVersionUID = 653097626768066387L;
	private JPanel contentPane;
	private JComboBox<String> stateBox;// 介质状态选择
	private JButton button;// 查询材料按钮

	public SelectMediumStateFrame() {
		super(160, 110);
		SelectMediumStateFrame selectMediumStateFrame = this;

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		button = new JButton("确认");
		button.setBounds(10, 40, 120, 23);
		contentPane.add(button);

		stateBox = new JComboBox<String>();
		String[] stateStrings = { "气体", "液体" };
		stateBox.setModel(new DefaultComboBoxModel<String>(stateStrings));
		((JLabel)stateBox.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
		stateBox.setBounds(10, 10, 120, 23);
		contentPane.add(stateBox);

		button.addActionListener(new ActionListener() {// 创建一个新材料
			@Override
			public void actionPerformed(ActionEvent e) {
				MediumState mediumState;
				if (stateBox.getSelectedIndex() == 0) {
					mediumState = MediumState.GASS;
				} else {
					mediumState = MediumState.LIQUID;
				}
				new NewMediumFrame(mediumState, selectMediumStateFrame).start();
				setVisible(false);
			}
		});
		PanelUtils.setAllComFont(contentPane);
	}
}
