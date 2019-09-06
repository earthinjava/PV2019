package com.duan.module.medium.query;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.duan.component.ChildFrame;
import com.duan.medium.MediumState;
import com.duan.module.medium.create.NewMediumFrame;
import com.duan.utils.Constant;
import com.duan.utils.PanelUtils;
import com.duan.utils.SerializeUtils;

public class QueryMediumFrame extends ChildFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> typeBox;
	private ArrayList<String> liquidList;
	private ArrayList<String> gassList;

	/**
	 * Create the frame.
	 */
	public QueryMediumFrame() {
		super(260, 330);
		setTitle("查询材料标准");

		// 获得所有类型的介质
		liquidList = new ArrayList<String>();
		gassList = new ArrayList<String>();

		File file = new File(Constant.MEDIUM_FOLDERPATH);
		String[] fileStrings = file.list();

		for (String f : fileStrings) {
			int i = f.lastIndexOf(".");
			String type = f.substring(i + 1, f.length());
			String name = f.substring(0, i);

			if (type.equals(MediumState.LIQUID.toString())) {
				liquidList.add(name);
			} else {
				gassList.add(name);
			}

		}

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label_1 = new JLabel("介质类型");
		label_1.setBounds(10, 10, 65, 23);
		contentPane.add(label_1);

		typeBox = new JComboBox<String>();
		String[] types = { "气体", "液体" };
		typeBox.setModel(new DefaultComboBoxModel<String>(types));
		typeBox.setBounds(128, 10, 100, 20);
		contentPane.add(typeBox);

		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setBounds(10, 40, 220, 207);
		jScrollPane.setBackground(Color.white);
		contentPane.add(jScrollPane);

		JList<String> mediumJList = new JList<String>(new MylistModel());
		jScrollPane.setViewportView(mediumJList);

		JButton queryButton = new JButton("查询");
		queryButton.setBounds(10, 257, 93, 23);
		contentPane.add(queryButton);

		JButton delButton = new JButton("删除");
		delButton.setBounds(137, 257, 93, 23);
		contentPane.add(delButton);

		typeBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				jScrollPane.setViewportView(mediumJList);
			}
		});

		PanelUtils.setAllComFont(contentPane);

		queryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String name = mediumJList.getSelectedValue();
				if (name == null) {
					return;
				}
				String lastNameString;
				if (typeBox.getSelectedIndex() == 0) {
					lastNameString = MediumState.GASS.toString();
				} else {
					lastNameString = MediumState.LIQUID.toString();
				}
				File file = new File(Constant.MEDIUM_FOLDERPATH + "/" + name + "." + lastNameString);
				NewMediumFrame mediumFrame=(NewMediumFrame) SerializeUtils.deSerializable(file, queryButton);
				mediumFrame.start();
			}
		});
	}

	/**
	 * 根据选择的材料标准显示材料的列表模式
	 * 
	 * @author Administrator
	 *
	 */
	class MylistModel extends AbstractListModel<String> {

		private static final long serialVersionUID = 1L;

		@Override
		public String getElementAt(int index) {

			if (typeBox.getSelectedIndex() == 0) {// gass
				return gassList.get(index);
			} else {
				return liquidList.get(index);
			}

		}

		@Override
		public int getSize() {
			if (typeBox.getSelectedIndex() == 0) {// gass
				return gassList.size();
			} else {
				return liquidList.size();
			}
		}

	}
}
