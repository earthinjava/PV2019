package com.duan.module.heatexchanger.beu.jpanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.duan.component.PureNumField;
import com.duan.component.tablebutton.MyTableRenderAndEditor;
import com.duan.meterial.Meterial;
import com.duan.module.heatexchanger.beu.bean.BEUHeatExchanger;
import com.duan.module.heatexchanger.beu.bean.structural.HeatTubeLine;
import com.duan.module.heatexchanger.beu.bean.structural.TubeBundle;
import com.duan.module.heatexchanger.beu.bean.structural.TubeLimitCircle;
import com.duan.module.heatexchanger.beu.bean.structural.UHeatTube;
import com.duan.utils.Constant;
import com.duan.utils.DoubleUtils;
import com.duan.utils.FontUtils;
import com.duan.utils.LabelAndFieldUtils;
import com.duan.utils.PanelUtils;

public class TubeBundleJPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private BEUHeatExchanger beuHeatExchanger;
	private PureNumField tubeDisField;
	private PureNumField dividDisField;
	private PureNumField tubePlateThickField;
	private PureNumField strLthField;
	private JComboBox<String> tubesTypeBox;
	private JComboBox<Integer> tubesPassBox;
	private JTable table;
	private JLabel limitCircleLabel;
	private JLabel canUsedNumLabel;
	private JLabel areaULabel;
	private JLabel usedNumLabel;
	private JLabel areaLabel;
	private JLabel totalWeightLabel;
	private JPanel tablePanel;
	private JPanel contentPane;
	private JLabel shellSideIdLabel;
	private JLabel heatTubeOdLabel;
	private JLabel densityLabel;
	private JPanel tubeArrayPanel;
	private TubeBundle tubeBundle;

	public TubeBundleJPanel(BEUHeatExchanger beuHeatExchanger) {
		// TODO Auto-generated constructor stub
		this.beuHeatExchanger = beuHeatExchanger;
		setBounds(new Rectangle(0, 0, 800, 800));
		setBackground(Color.WHITE);
		setLayout(null);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBounds(new Rectangle(0, 0, 800, 800));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		add(contentPane);

		JPanel InputPanel = new JPanel();
		InputPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		InputPanel.setBounds(5, 5, 250, 220);
		InputPanel.setBackground(SystemColor.menu);
		InputPanel.setLayout(null);
		contentPane.add(InputPanel);

		JLabel label_2 = new JLabel("\u6392\u5217\u65B9\u5F0F");
		label_2.setBounds(10, 43, 80, 15);
		InputPanel.add(label_2);

		tubesTypeBox = new JComboBox<String>();
		tubesTypeBox.setModel(new DefaultComboBoxModel<String>(Constant.TUBEARRAY_TYPE));
		tubesTypeBox.setBounds(100, 40, 106, 23);
		InputPanel.add(tubesTypeBox);

		JLabel label_3 = new JLabel("\u6362\u70ED\u7BA1\u4E2D\u5FC3\u8DDD");
		label_3.setBounds(10, 133, 80, 15);
		InputPanel.add(label_3);

		tubeDisField = new PureNumField();
		tubeDisField.setBounds(100, 130, 66, 21);
		InputPanel.add(tubeDisField);

		JLabel label_4 = new JLabel("\u5206\u7A0B\u7BA1\u95F4\u8DDD");
		label_4.setBounds(10, 163, 80, 15);
		InputPanel.add(label_4);

		dividDisField = new PureNumField();
		dividDisField.setBounds(100, 160, 66, 21);
		InputPanel.add(dividDisField);

		JLabel label_9 = new JLabel("\u76F4\u6BB5\u957F\u5EA6");
		label_9.setBounds(10, 13, 80, 15);
		InputPanel.add(label_9);

		strLthField = new PureNumField();
		strLthField.setBounds(100, 10, 66, 21);
		InputPanel.add(strLthField);

		JLabel label_11 = new JLabel("\u7BA1\u677F\u539A\u5EA6");
		label_11.setBounds(10, 103, 80, 15);
		InputPanel.add(label_11);

		tubePlateThickField = new PureNumField();
		tubePlateThickField.setBounds(100, 100, 66, 21);
		InputPanel.add(tubePlateThickField);

		tubesPassBox = new JComboBox<Integer>();
		tubesPassBox.setModel(new DefaultComboBoxModel<Integer>(new Integer[] { 2, 4 }));
		tubesPassBox.setBounds(100, 70, 106, 23);
		InputPanel.add(tubesPassBox);

		JLabel label_12 = new JLabel("\u7BA1\u7A0B");
		label_12.setBounds(10, 73, 80, 15);
		InputPanel.add(label_12);

		JButton applyButton = new JButton("\u5E94\u7528");
		applyButton.setBounds(10, 188, 230, 23);
		InputPanel.add(applyButton);

		JLabel label_15 = new JLabel("mm");
		label_15.setBounds(176, 10, 26, 20);
		InputPanel.add(label_15);

		JLabel label_16 = new JLabel("mm");
		label_16.setBounds(176, 98, 26, 20);
		InputPanel.add(label_16);

		JLabel label_17 = new JLabel("mm");
		label_17.setBounds(176, 133, 26, 20);
		InputPanel.add(label_17);

		JLabel label_18 = new JLabel("mm");
		label_18.setBounds(176, 163, 26, 20);
		InputPanel.add(label_18);

		applyButton.addActionListener(this);

		tubeArrayPanel = new JPanel() {
			private static final long serialVersionUID = -1246147653990515510L;
			@Override
			public void paint(Graphics g) {
				// TODO 自动生成的方法存根
				super.paint(g);
				Graphics2D g2 = (Graphics2D) g;
				if (beuHeatExchanger.getTubeBundle() != null
						&& beuHeatExchanger.getTubeBundle().getTubeLimitCircle() != null) {
					beuHeatExchanger.getTubeBundle().draw(g2,
							beuHeatExchanger.getTubeBundle().getTubeLimitCircle().getRatio());
					beuHeatExchanger.getTubeBundle().getTubeLimitCircle().draw(g2);
				}
			}
		};
		tubeArrayPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tubeArrayPanel.setBounds(260, 5, Constant.BEUTUBEARRAY_WIDETH, Constant.BEUTUBEARRAY_HEIGHT);
		tubeArrayPanel.setBackground(SystemColor.menu);
		contentPane.add(tubeArrayPanel);

		tablePanel = new JPanel();
		tablePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tablePanel.setBounds(5, 530, 775, 145);
		tablePanel.setLayout(null);
		tablePanel.setBackground(SystemColor.menu);
		contentPane.add(tablePanel);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(5, 230, 250, 295);
		panel.setBackground(SystemColor.menu);
		panel.setLayout(null);
		contentPane.add(panel);

		JLabel label_5 = new JLabel("\u5E03\u7BA1\u9650\u5B9A\u5706");
		label_5.setBounds(10, 40, 80, 21);
		panel.add(label_5);

		totalWeightLabel = new JLabel("");
		totalWeightLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		totalWeightLabel.setBounds(100, 252, 66, 21);
		panel.add(totalWeightLabel);

		areaLabel = new JLabel("");
		areaLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		areaLabel.setBounds(100, 190, 66, 21);
		panel.add(areaLabel);

		areaULabel = new JLabel("");
		areaULabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		areaULabel.setBounds(100, 160, 66, 21);
		panel.add(areaULabel);

		usedNumLabel = new JLabel("");
		usedNumLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		usedNumLabel.setBounds(100, 130, 66, 21);
		panel.add(usedNumLabel);

		canUsedNumLabel = new JLabel("");
		canUsedNumLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		canUsedNumLabel.setBounds(100, 100, 66, 21);
		panel.add(canUsedNumLabel);

		limitCircleLabel = new JLabel("");
		limitCircleLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		limitCircleLabel.setBounds(100, 40, 66, 21);
		panel.add(limitCircleLabel);

		shellSideIdLabel = new JLabel("");
		shellSideIdLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		shellSideIdLabel.setBounds(100, 10, 66, 21);
		panel.add(shellSideIdLabel);

		JLabel label_19 = new JLabel("mm");
		label_19.setBounds(176, 10, 26, 20);
		panel.add(label_19);

		JLabel label_21 = new JLabel("mm");
		label_21.setBounds(176, 40, 26, 20);
		panel.add(label_21);

		JLabel label = new JLabel("\u58F3\u4FA7\u5185\u5F84");
		label.setBounds(10, 10, 80, 21);
		panel.add(label);

		heatTubeOdLabel = new JLabel("");
		heatTubeOdLabel.setBounds(100, 70, 66, 21);
		heatTubeOdLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.add(heatTubeOdLabel);

		JLabel label_22 = new JLabel("\u6362\u70ED\u7BA1\u5916\u5F84");
		label_22.setBounds(10, 70, 80, 21);
		panel.add(label_22);

		JLabel label_1 = new JLabel("mm");
		label_1.setBounds(176, 70, 26, 20);
		panel.add(label_1);

		JLabel label_6 = new JLabel("\u53EF\u5E03\u7BA1\u6570");
		label_6.setBounds(10, 100, 80, 21);
		panel.add(label_6);

		JLabel label_7 = new JLabel("\u5B9E\u9645\u5E03\u7BA1\u603B\u6570");
		label_7.setBounds(10, 130, 80, 21);
		panel.add(label_7);

		JLabel lblu_1 = new JLabel("\u6362\u70ED\u9762\u79EF\uFF08U\uFF09");
		lblu_1.setBounds(10, 160, 90, 21);
		panel.add(lblu_1);

		JLabel label_20 = new JLabel("\u6362\u70ED\u9762\u79EF");
		label_20.setBounds(10, 190, 90, 21);
		panel.add(label_20);

		JLabel label_8 = new JLabel("\u6362\u70ED\u7BA1\u603B\u91CD");
		label_8.setBounds(10, 252, 90, 21);
		panel.add(label_8);

		JLabel label_10 = new JLabel("\u33A1");
		label_10.setBounds(176, 160, 26, 20);
		panel.add(label_10);

		JLabel label_23 = new JLabel("\u33A1");
		label_23.setBounds(176, 190, 26, 20);
		panel.add(label_23);

		JLabel lblKg = new JLabel("kg");
		lblKg.setBounds(176, 252, 26, 20);
		panel.add(lblKg);

		JLabel label_13 = new JLabel("\u6362\u70ED\u7BA1\u5BC6\u5EA6");
		label_13.setBounds(10, 221, 90, 21);
		panel.add(label_13);

		densityLabel = new JLabel("");
		densityLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		densityLabel.setBounds(100, 221, 66, 21);
		panel.add(densityLabel);

		JLabel lblTm = new JLabel("T/m\u00B3");
		lblTm.setBounds(176, 221, 41, 20);
		panel.add(lblTm);

		PanelUtils.setAllComFont(panel);
		PanelUtils.setAllComFont(tablePanel);
		PanelUtils.setAllComFont(InputPanel);
	}

	public void apply() {
		// TODO Auto-generated method stub
		beuHeatExchanger.setTubeBundle(null);
		double id = beuHeatExchanger.getShellSideCylinder().getInterDia();
		double tubeOd = beuHeatExchanger.getUHeatTube().getOutDia();
		double strLth = strLthField.getDoubleNoNull("请输入直管段长度");
		if (strLth == Constant.ERROR_DOUBLE) {
			return;
		}
		double plateThick = tubePlateThickField.getDoubleNoNull("请输入管板名义厚度");
		if (plateThick == Constant.ERROR_DOUBLE) {
			return;
		}
		double tubeDis = tubeDisField.getDoubleNoNull("请输入管程数");
		if (tubeDis == Constant.ERROR_DOUBLE) {
			return;
		}
		double dividDis = dividDisField.getDoubleNoNull("请输入分程间距");
		if (dividDis == Constant.ERROR_DOUBLE) {
			return;
		}
		String tubesType = tubesTypeBox.getSelectedItem().toString();
		int tubesPass = (int) tubesPassBox.getSelectedItem();
		TubeLimitCircle tubeLimitCircle = new TubeLimitCircle(id, tubeOd);
		tubeBundle = new TubeBundle(tubeLimitCircle, tubeOd, strLth, plateThick, tubesType, tubeDis, dividDis,
				tubesPass);
		UHeatTube uHeatTube = beuHeatExchanger.getUHeatTube();
		double nThick = uHeatTube.getNThick();
		Meterial meterial = uHeatTube.getMeterial();
		double allowStress = uHeatTube.getAllowStress();
		tubeBundle.setNthickAndMeterialOfAll(nThick, meterial, allowStress);
		beuHeatExchanger.setTubeBundle(tubeBundle);
		LabelAndFieldUtils.showDoublePointTwo(limitCircleLabel, tubeLimitCircle.getD());
		LabelAndFieldUtils.showDoublePointTwo(canUsedNumLabel, tubeBundle.getHeatTubesTotalNumber());
		LabelAndFieldUtils.showDoublePointTwo(usedNumLabel, tubeBundle.getUsedTubesNum());
		LabelAndFieldUtils.showDoublePointTwo(areaULabel, tubeBundle.getHeatAreaU() / 1000000);
		LabelAndFieldUtils.showDoublePointTwo(areaLabel, tubeBundle.getHeatArea() / 1000000);
		LabelAndFieldUtils.showDoublePointTwo(totalWeightLabel, tubeBundle.getWeight());
		tablePanel.removeAll();
		creatTubesTable();
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(0, 0, 775, 145);
		tablePanel.add(jScrollPane);
		// 布管重画
		tubeArrayPanel.repaint();
	}

	/**
	 * 对象创建时填入预设内容
	 */
	public void autoFill() {
		LabelAndFieldUtils.showDoublePointTwo(shellSideIdLabel, beuHeatExchanger.getShellSideCylinder().getInterDia());
		LabelAndFieldUtils.showDoublePointTwo(heatTubeOdLabel, beuHeatExchanger.getUHeatTube().getOutDia());
		LabelAndFieldUtils.showDoublePointTwo(densityLabel, beuHeatExchanger.getUHeatTube().getMeterial().getDensity());
		tubeDisField.setText(TubeBundle.calTubesDis(beuHeatExchanger.getUHeatTube().getOutDia()) + "");
		dividDisField.setText(TubeBundle.calPassDis(beuHeatExchanger.getUHeatTube().getOutDia(), "U") + "");
	}

	/**
	 * 按下减少与增加按钮后，刷新第几行的组件和画布内容
	 * 
	 * @param rowNum 第几行
	 */
	private void refresh(int rowNum) {
		HeatTubeLine ht = tubeBundle.getHeatTubeLines().get(rowNum);
		int num = ht.getIsUsedNum();
		int totalUsedNum = tubeBundle.getUsedTubesNum();		
		double lineLength = DoubleUtils.doubleSavePointTwo(ht.getLineLength());
		double lineWeight =DoubleUtils.doubleSavePointTwo( ht.getLineWeight());
		table.setValueAt(num + "", rowNum, 5);
		table.setValueAt(lineLength + "", rowNum, 6);
		table.setValueAt(lineWeight + "", rowNum, 7);
		usedNumLabel.setText(totalUsedNum + "");		
		LabelAndFieldUtils.showDoublePointTwo(totalWeightLabel, tubeBundle.getWeight());
		LabelAndFieldUtils.showDoublePointTwo(areaULabel, tubeBundle.getHeatAreaU() / 1000000);
		LabelAndFieldUtils.showDoublePointTwo(areaLabel, tubeBundle.getHeatArea() / 1000000);			
		tubeArrayPanel.repaint();
	}

	private void creatTubesTable() {
		// 创建换热管表
		String[] tableTitle = { "序号", "直管长mm", "弯曲半径mm", "展开长度mm", "单重kg", "数量", "总长mm", "总重kg", "删除", "增加" };
		String[][] tableContent = new String[tubeBundle.getHeatTubeLines().size()][tableTitle.length];
		int i = 0;
		for (HeatTubeLine ht : tubeBundle.getHeatTubeLines()) {
			int lineNum = ht.getLineNum();
			double strLength = ht.getHeatTubes().get(0).getStrLength();
			double r = DoubleUtils.doubleSavePointTwo(ht.getR());
			double length = DoubleUtils.doubleSavePointTwo(ht.getHeatTubes().get(0).getLength());
			double weight = DoubleUtils.doubleSavePointTwo(ht.getHeatTubes().get(0).getWeight());
			int num = ht.getIsUsedNum();
			double lineLength = DoubleUtils.doubleSavePointTwo(ht.getLineLength());
			double lineWeight = DoubleUtils.doubleSavePointTwo(ht.getLineWeight());
			tableContent[i][0] = lineNum + "";
			tableContent[i][1] = strLength + "";
			tableContent[i][2] = r + "";
			tableContent[i][3] = length + "";
			tableContent[i][4] = weight + "";
			tableContent[i][5] = num + "";
			tableContent[i][6] = lineLength + "";
			tableContent[i][7] = lineWeight + "";
			i++;
		}
		// 减少按钮
		MyTableRenderAndEditor reduce = new MyTableRenderAndEditor("-");
		reduce.getButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int rowNum = reduce.getButton().getRow();
				tubeBundle.removeTwoTubesAtLineNumber(rowNum + 1, tubeArrayPanel.getGraphics());
				refresh(rowNum);
			}
		});
		// 增加按钮
		MyTableRenderAndEditor plus = new MyTableRenderAndEditor("+");
		plus.getButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int rowNum = plus.getButton().getRow();
				tubeBundle.addTwoTubesAtLineNumbe(rowNum + 1, tubeArrayPanel.getGraphics());
				refresh(rowNum);
			}
		});
		// 添加增加与减少按钮
		table = new JTable(tableContent, tableTitle);
		table.getColumnModel().getColumn(8).setCellEditor(reduce);
		table.getColumnModel().getColumn(8).setCellRenderer(reduce);
		table.getColumnModel().getColumn(9).setCellEditor(plus);
		table.getColumnModel().getColumn(9).setCellRenderer(plus);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		
		FontUtils.setDefaultFont(table.getTableHeader());
		FontUtils.setDefaultFont(table);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		apply();
	}
}
