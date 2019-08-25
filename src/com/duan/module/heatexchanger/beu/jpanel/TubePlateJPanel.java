package com.duan.module.heatexchanger.beu.jpanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.duan.component.PureNumField;
import com.duan.component.meterial.MeterialButton;
import com.duan.meterial.Meterial;
import com.duan.module.heatexchanger.beu.bean.BEUHeatExchanger;
import com.duan.module.heatexchanger.beu.bean.designCondition.HeatDesignCondition;
import com.duan.module.heatexchanger.beu.bean.structural.TubeBundle;
import com.duan.module.heatexchanger.beu.bean.structural.TubePlate;
import com.duan.module.heatexchanger.beu.bean.structural.TubePlateGasket;
import com.duan.utils.Constant;
import com.duan.utils.JOptionPaneUtils;
import com.duan.utils.LabelAndFieldUtils;
import com.duan.utils.PanelUtils;

public class TubePlateJPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PureNumField plateOdField;
	private PureNumField allowStressField;
	private PureNumField PdField;
	private PureNumField strenthExpansionLengthField;
	private PureNumField strenthWeldedLengthField;
	private JLabel AtLabel;
	private JLabel PtLabel;
	private JLabel CcLabel;
	private JLabel tubeDisLabel;
	private JLabel divideDislabel;
	private JLabel otherNLabel;
	private JLabel uLabel;
	private JLabel DgLabel;
	private JLabel lbldg;
	private JLabel tubesOdField;
	private JLabel tubesNthickField;
	private JLabel AdLabel;
	private JLabel shellPressLabel;
	private JLabel tubePressLabel;
	private JComboBox<String> connectTypeBox;
	private PureNumField tubeC1Field;
	private PureNumField shellC1Field;
	private PureNumField tubeSoltDepthField;
	private PureNumField shellSoltDepthField;
	private JLabel allPullStressLabel;
	private JLabel calThickLabel;
	private JLabel maxPullStressLabel;
	private JLabel allAxialStressLabel;
	private JLabel maxAxialStressLabel;
	private JLabel minThickLabel;
	private BEUHeatExchanger beuHeatExchanger;
	private JLabel dtLabel;
	private MeterialButton meterialButton;
	private JLabel plateThickJLabel;
	private JPanel showTubePlatePanel;

	/**
	 * Create the panel.
	 */
	public TubePlateJPanel(BEUHeatExchanger beuHeatExchanger, HeatDesignContionPanel heatDesignConJPanel) {

		setBounds(new Rectangle(0, 0, 800, 800));
		setLayout(null);
		setBackground(Color.WHITE);
		this.beuHeatExchanger = beuHeatExchanger;

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBounds(new Rectangle(0, 0, 800, 800));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		add(contentPane);

		JPanel InputPanel = new JPanel();
		InputPanel.setBackground(SystemColor.menu);
		InputPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		InputPanel.setBounds(5, 5, 250, 360);
		contentPane.add(InputPanel);
		InputPanel.setLayout(null);

		JButton applyButton = new JButton("\u5E94\u7528");
		applyButton.setBounds(10, 326, 230, 23);
		InputPanel.add(applyButton);

		JLabel lblpd = new JLabel("\u8BA1\u7B97\u538B\u529BPd");
		lblpd.setBounds(10, 71, 92, 15);
		InputPanel.add(lblpd);

		JLabel label_7 = new JLabel("\u8BB8\u7528\u5E94\u529B");
		label_7.setBounds(10, 100, 80, 15);
		InputPanel.add(label_7);

		JLabel label_14 = new JLabel("\u7BA1\u677F\u5916\u5F84");
		label_14.setBounds(10, 13, 80, 15);
		InputPanel.add(label_14);

		plateOdField = new PureNumField();
		plateOdField.setBounds(100, 10, 66, 21);
		InputPanel.add(plateOdField);

		PdField = new PureNumField();
		PdField.setBounds(100, 67, 66, 21);
		InputPanel.add(PdField);

		JLabel lbll = new JLabel("\u5F3A\u5EA6\u80C0\u957F\u5EA6l");
		lbll.setBounds(10, 156, 80, 15);
		InputPanel.add(lbll);

		strenthExpansionLengthField = new PureNumField();
		strenthExpansionLengthField.setText("50");
		strenthExpansionLengthField.setBounds(100, 152, 66, 21);
		InputPanel.add(strenthExpansionLengthField);

		JLabel lbll_1 = new JLabel("\u5F3A\u5EA6\u710A\u957F\u5EA6l");
		lbll_1.setBounds(10, 184, 80, 15);
		InputPanel.add(lbll_1);

		strenthWeldedLengthField = new PureNumField();
		strenthWeldedLengthField.setText("0");
		strenthWeldedLengthField.setEnabled(false);
		strenthWeldedLengthField.setBounds(100, 180, 66, 21);
		InputPanel.add(strenthWeldedLengthField);

		connectTypeBox = new JComboBox<String>();
		connectTypeBox.setModel(new DefaultComboBoxModel<String>(Constant.TUBECONTACTPALTE_TYPE));
		connectTypeBox.setBounds(100, 124, 140, 21);
		InputPanel.add(connectTypeBox);

		JLabel label_16 = new JLabel("\u8FDE\u63A5\u65B9\u5F0F");
		label_16.setBounds(10, 128, 80, 15);
		InputPanel.add(label_16);

		JLabel label_11 = new JLabel("\u7BA1\u4FA7\u8150\u8680\u4F59\u91CF");
		label_11.setBounds(10, 212, 80, 15);
		InputPanel.add(label_11);

		tubeC1Field = new PureNumField();
		tubeC1Field.setText("1");
		tubeC1Field.setBounds(100, 209, 66, 21);
		InputPanel.add(tubeC1Field);

		shellC1Field = new PureNumField();
		shellC1Field.setText("1");
		shellC1Field.setBounds(100, 237, 66, 21);
		InputPanel.add(shellC1Field);

		JLabel label_12 = new JLabel("\u58F3\u4FA7\u8150\u8680\u88D5\u91CF");
		label_12.setBounds(10, 241, 92, 15);
		InputPanel.add(label_12);

		JLabel label_18 = new JLabel("\u7BA1\u4FA7\u5F00\u69FD\u6DF1\u5EA6");
		label_18.setBounds(10, 272, 92, 15);
		InputPanel.add(label_18);

		tubeSoltDepthField = new PureNumField();
		tubeSoltDepthField.setText("6");
		tubeSoltDepthField.setBounds(100, 268, 66, 21);
		InputPanel.add(tubeSoltDepthField);

		JLabel label_19 = new JLabel("\u58F3\u4FA7\u5F00\u69FD\u6DF1\u5EA6");
		label_19.setBounds(10, 301, 92, 15);
		InputPanel.add(label_19);

		shellSoltDepthField = new PureNumField();
		shellSoltDepthField.setText("0");
		shellSoltDepthField.setBounds(100, 297, 66, 21);
		InputPanel.add(shellSoltDepthField);

		JLabel lblMm = new JLabel("mm");
		lblMm.setBounds(176, 10, 49, 21);
		InputPanel.add(lblMm);

		JLabel lblMpa = new JLabel("Mpa");
		lblMpa.setBounds(176, 67, 49, 21);
		InputPanel.add(lblMpa);

		JLabel lblMpa_1 = new JLabel("Mpa");
		lblMpa_1.setBounds(176, 96, 49, 21);
		InputPanel.add(lblMpa_1);

		JLabel label_26 = new JLabel("mm");
		label_26.setBounds(176, 152, 49, 21);
		InputPanel.add(label_26);

		JLabel label_29 = new JLabel("mm");
		label_29.setBounds(176, 180, 49, 21);
		InputPanel.add(label_29);

		JLabel label_30 = new JLabel("mm");
		label_30.setBounds(176, 209, 49, 21);
		InputPanel.add(label_30);

		JLabel label_31 = new JLabel("mm");
		label_31.setBounds(176, 237, 49, 21);
		InputPanel.add(label_31);

		JLabel label_32 = new JLabel("mm");
		label_32.setBounds(176, 268, 49, 21);
		InputPanel.add(label_32);

		JLabel label_33 = new JLabel("mm");
		label_33.setBounds(176, 297, 49, 21);
		InputPanel.add(label_33);

		JLabel label_34 = new JLabel("\u7BA1\u677F\u6750\u6599");
		label_34.setBounds(10, 42, 92, 15);
		InputPanel.add(label_34);

		showTubePlatePanel = new JPanel() {
			private static final long serialVersionUID = -8438743392958501617L;

			@Override
			public void paint(Graphics g) {
				super.paint(g);
				Graphics2D g2 = (Graphics2D) g;
				if (beuHeatExchanger.getTubePlate() != null && beuHeatExchanger.getTubePlate().getOd() != 0) {
					beuHeatExchanger.getTubePlate().draw(g2);
					beuHeatExchanger.getTubePlateGasket().draw(g2, beuHeatExchanger.getTubePlate().getDrawRatio());

				}
			}
		};
		showTubePlatePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		showTubePlatePanel.setBounds(260, 160, Constant.BEUTUBEARRAY_WIDETH, Constant.BEUTUBEARRAY_HEIGHT);
		showTubePlatePanel.setBackground(SystemColor.menu);
		contentPane.add(showTubePlatePanel);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(260, 5, 520, 155);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label_6 = new JLabel("\u5206\u7A0B\u5904\u9762\u79EFAd");
		label_6.setBounds(10, 13, 80, 15);
		panel.add(label_6);

		AdLabel = new JLabel("");
		AdLabel.setBounds(100, 10, 66, 21);
		panel.add(AdLabel);
		AdLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel label_8 = new JLabel("\u5206\u7A0B\u5904\u9762\u79EFAt");
		label_8.setBounds(10, 43, 80, 15);
		panel.add(label_8);

		AtLabel = new JLabel("");
		AtLabel.setBounds(100, 40, 66, 21);
		panel.add(AtLabel);
		AtLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel lblMm_1 = new JLabel("mm\u00B2");
		lblMm_1.setBounds(176, 10, 49, 21);
		panel.add(lblMm_1);

		JLabel label_25 = new JLabel("mm\u00B2");
		label_25.setBounds(176, 38, 49, 21);
		panel.add(label_25);

		JLabel label_20 = new JLabel("\u8BA1\u7B97\u539A\u5EA6");
		label_20.setBounds(10, 73, 57, 15);
		panel.add(label_20);

		calThickLabel = new JLabel("");
		calThickLabel.setBounds(100, 70, 66, 21);
		panel.add(calThickLabel);
		calThickLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel label_22 = new JLabel("\u6700\u5C0F\u539A\u5EA6");
		label_22.setBounds(10, 100, 57, 15);
		panel.add(label_22);

		minThickLabel = new JLabel("");
		minThickLabel.setBounds(100, 100, 66, 21);
		panel.add(minThickLabel);
		minThickLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel label_40 = new JLabel("mm");
		label_40.setBounds(176, 69, 20, 21);
		panel.add(label_40);

		maxAxialStressLabel = new JLabel("");
		maxAxialStressLabel.setBounds(285, 10, 66, 21);
		panel.add(maxAxialStressLabel);
		maxAxialStressLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel label_27 = new JLabel("\u8BB8\u7528\u8F74\u5411\u529B");
		label_27.setBounds(210, 43, 66, 15);
		panel.add(label_27);

		allAxialStressLabel = new JLabel("");
		allAxialStressLabel.setBounds(285, 40, 66, 21);
		panel.add(allAxialStressLabel);
		allAxialStressLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel label_28 = new JLabel("\u6700\u5927\u62C9\u6258\u529B");
		label_28.setBounds(210, 73, 66, 15);
		panel.add(label_28);

		maxPullStressLabel = new JLabel("");
		maxPullStressLabel.setBounds(285, 70, 66, 21);
		panel.add(maxPullStressLabel);
		maxPullStressLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel label_24 = new JLabel("\u8BB8\u7528\u62C9\u6258\u529B");
		label_24.setBounds(210, 103, 66, 15);
		panel.add(label_24);

		allPullStressLabel = new JLabel("");
		allPullStressLabel.setBounds(285, 100, 66, 21);
		panel.add(allPullStressLabel);
		allPullStressLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel label_42 = new JLabel("mm");
		label_42.setBounds(176, 103, 20, 21);
		panel.add(label_42);

		JLabel label_43 = new JLabel("\u6700\u5927\u8F74\u5411\u529B");
		label_43.setBounds(210, 13, 66, 15);
		panel.add(label_43);

		JLabel label_44 = new JLabel("Mpa");
		label_44.setBounds(361, 13, 33, 21);
		panel.add(label_44);

		JLabel label_45 = new JLabel("Mpa");
		label_45.setBounds(361, 43, 33, 21);
		panel.add(label_45);

		JLabel label_46 = new JLabel("Mpa");
		label_46.setBounds(361, 70, 33, 21);
		panel.add(label_46);

		JLabel label_47 = new JLabel("Mpa");
		label_47.setBounds(361, 100, 33, 21);
		panel.add(label_47);

		JLabel label_10 = new JLabel("\u03C1t");
		label_10.setBounds(10, 133, 80, 15);
		panel.add(label_10);

		PtLabel = new JLabel("");
		PtLabel.setBounds(100, 128, 66, 21);
		panel.add(PtLabel);
		PtLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel label_13 = new JLabel("Cc");
		label_13.setBounds(210, 133, 80, 15);
		panel.add(label_13);

		CcLabel = new JLabel("");
		CcLabel.setBounds(285, 131, 66, 21);
		panel.add(CcLabel);
		CcLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(5, 360, 250, 320);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel label = new JLabel("\u58F3\u7A0B\u8BBE\u8BA1\u538B\u529B");
		label.setBounds(10, 41, 80, 15);
		panel_1.add(label);

		shellPressLabel = new JLabel("");
		shellPressLabel.setBounds(100, 38, 66, 21);
		panel_1.add(shellPressLabel);
		shellPressLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		tubePressLabel = new JLabel("");
		tubePressLabel.setBounds(100, 66, 66, 21);
		panel_1.add(tubePressLabel);
		tubePressLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel label_1 = new JLabel("\u7BA1\u7A0B\u8BBE\u8BA1\u538B\u529B");
		label_1.setBounds(10, 69, 80, 15);
		panel_1.add(label_1);

		JLabel label_3 = new JLabel("\u6362\u70ED\u7BA1\u4E2D\u5FC3\u8DDD");
		label_3.setBounds(10, 153, 80, 15);
		panel_1.add(label_3);

		tubeDisLabel = new JLabel("");
		tubeDisLabel.setBounds(100, 150, 66, 21);
		panel_1.add(tubeDisLabel);
		tubeDisLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel label_4 = new JLabel("\u5206\u7A0B\u69FD\u95F4\u8DDD");
		label_4.setBounds(10, 181, 80, 15);
		panel_1.add(label_4);

		divideDislabel = new JLabel("");
		divideDislabel.setBounds(100, 178, 66, 21);
		panel_1.add(divideDislabel);
		divideDislabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel labeaaa = new JLabel("\u9694\u677F\u4FA7\u7BA1\u6839\u6570");
		labeaaa.setBounds(10, 209, 80, 15);
		panel_1.add(labeaaa);

		otherNLabel = new JLabel("");
		otherNLabel.setBounds(100, 206, 66, 21);
		panel_1.add(otherNLabel);
		otherNLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		uLabel = new JLabel("0.4");
		uLabel.setBounds(100, 234, 66, 21);
		panel_1.add(uLabel);
		uLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel label_5 = new JLabel("\u5F3A\u5EA6\u524A\u5F31\u7CFB\u6570\u03BC");
		label_5.setBounds(10, 237, 92, 15);
		panel_1.add(label_5);

		DgLabel = new JLabel("");
		DgLabel.setBounds(100, 262, 66, 21);
		panel_1.add(DgLabel);
		DgLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		lbldg = new JLabel("\u57AB\u7247\u4F5C\u7528\u76F4\u5F84Dg");
		lbldg.setBounds(10, 265, 92, 15);
		panel_1.add(lbldg);

		JLabel label_15 = new JLabel("\u6362\u70ED\u7BA1\u5916\u5F84");
		label_15.setBounds(10, 97, 80, 15);
		panel_1.add(label_15);

		tubesOdField = new JLabel("");
		tubesOdField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tubesOdField.setBounds(100, 94, 66, 21);
		panel_1.add(tubesOdField);

		tubesNthickField = new JLabel("");
		tubesNthickField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tubesNthickField.setBounds(100, 122, 66, 21);
		panel_1.add(tubesNthickField);

		JLabel label_17 = new JLabel("\u6362\u70ED\u7BA1\u539A\u5EA6");
		label_17.setBounds(10, 125, 80, 15);
		panel_1.add(label_17);

		JLabel label_21 = new JLabel("\u7BA1\u677F\u540D\u4E49\u539A\u5EA6");
		label_21.setBounds(10, 13, 80, 15);
		panel_1.add(label_21);

		JLabel label_23 = new JLabel("mm");
		label_23.setBounds(176, 10, 49, 21);
		panel_1.add(label_23);

		JLabel lblMpa_2 = new JLabel("Mpa");
		lblMpa_2.setBounds(176, 38, 49, 21);
		panel_1.add(lblMpa_2);

		JLabel lblMpa_3 = new JLabel("Mpa");
		lblMpa_3.setBounds(176, 66, 49, 21);
		panel_1.add(lblMpa_3);

		JLabel label_35 = new JLabel("mm");
		label_35.setBounds(176, 98, 49, 21);
		panel_1.add(label_35);

		JLabel label_36 = new JLabel("mm");
		label_36.setBounds(176, 122, 49, 21);
		panel_1.add(label_36);

		JLabel label_37 = new JLabel("mm");
		label_37.setBounds(176, 150, 49, 21);
		panel_1.add(label_37);

		JLabel label_38 = new JLabel("mm");
		label_38.setBounds(176, 178, 49, 21);
		panel_1.add(label_38);

		JLabel label_41 = new JLabel("mm");
		label_41.setBounds(176, 262, 49, 21);
		panel_1.add(label_41);

		JLabel label_9 = new JLabel("\u5F53\u91CF\u76F4\u5F84Dt");
		label_9.setBounds(10, 293, 80, 21);
		panel_1.add(label_9);

		dtLabel = new JLabel("");
		dtLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		dtLabel.setBounds(100, 293, 66, 21);
		panel_1.add(dtLabel);

		JLabel label_39 = new JLabel("mm");
		label_39.setBounds(176, 293, 49, 21);
		panel_1.add(label_39);

		applyButton.addActionListener(this);

		meterialButton = new MeterialButton(heatDesignConJPanel.getShellDesignTempField(),
				heatDesignConJPanel.getTubeDesignTempField());
		meterialButton.setLocation(100, 38);
		InputPanel.add(meterialButton);

		plateThickJLabel = meterialButton.getnThickLabel();
		plateThickJLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		plateThickJLabel.setBounds(100, 10, 66, 21);
		panel_1.add(plateThickJLabel);

		allowStressField = meterialButton.getStressField();
		allowStressField.setBounds(100, 96, 66, 21);
		InputPanel.add(allowStressField);

		connectTypeBox.addActionListener(new BoxActionListener());
		PanelUtils.setAllComFont(InputPanel);
		PanelUtils.setAllComFont(panel_1);
		PanelUtils.setAllComFont(panel);
	}

	class BoxActionListener implements ActionListener, Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = -2581323698204913765L;

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			if (connectTypeBox.getSelectedItem().toString().equals(Constant.TUBECONTACTPALTE_TYPE[0])) {
				strenthWeldedLengthField.setText("0");
				strenthWeldedLengthField.setEnabled(false);
				strenthExpansionLengthField.setEnabled(true);
			} else if (connectTypeBox.getSelectedItem().toString().equals(Constant.TUBECONTACTPALTE_TYPE[1])) {
				strenthExpansionLengthField.setText("0");
				strenthExpansionLengthField.setEnabled(false);
				strenthWeldedLengthField.setEnabled(true);
			} else if (connectTypeBox.getSelectedItem().toString().equals(Constant.TUBECONTACTPALTE_TYPE[2])) {
				strenthWeldedLengthField.setText("0");
				strenthWeldedLengthField.setEnabled(false);
				strenthExpansionLengthField.setEnabled(true);
			} else if (connectTypeBox.getSelectedItem().toString().equals(Constant.TUBECONTACTPALTE_TYPE[3])) {
				strenthExpansionLengthField.setText("0");
				strenthExpansionLengthField.setEnabled(false);
				strenthWeldedLengthField.setEnabled(true);
			} else if (connectTypeBox.getSelectedItem().toString().equals(Constant.TUBECONTACTPALTE_TYPE[4])) {
				strenthExpansionLengthField.setText("0");
				strenthExpansionLengthField.setEnabled(false);
				strenthWeldedLengthField.setText("0");
				strenthWeldedLengthField.setEnabled(false);
			}

		}

	}

	public void autoFill() {
		HeatDesignCondition shellDesignCondition = beuHeatExchanger.getHeatDesignConditions().getShellDesignCondition();
		HeatDesignCondition tubeDesignCondition = beuHeatExchanger.getHeatDesignConditions().getTubeDesignCondition();
		TubeBundle tubeBundle = beuHeatExchanger.getTubeBundle();
		TubePlateGasket tubePlateGasket = beuHeatExchanger.getTubePlateGasket();
		TubePlate tubePlate = new TubePlate(shellDesignCondition, tubeDesignCondition, tubeBundle, tubePlateGasket);
		beuHeatExchanger.setTubePlate(tubePlate);
		double od = plateOdField.getDoubleCanNull();
		if (od != Constant.ERROR_DOUBLE) {
			tubePlate.setOd(od);
		}
		LabelAndFieldUtils.showDoublePointTwo(plateThickJLabel, tubeBundle.getPreTubePlateThick());
		LabelAndFieldUtils.showDoublePointTwo(shellPressLabel, shellDesignCondition.getDesignPress());
		LabelAndFieldUtils.showDoublePointTwo(tubePressLabel, tubeDesignCondition.getDesignPress());
		LabelAndFieldUtils.showDoublePointTwo(tubesOdField,
				tubeBundle.getHeatTubeLines().get(0).getHeatTubes().get(0).getOutDia());
		LabelAndFieldUtils.showDoublePointTwo(tubesNthickField,
				tubeBundle.getHeatTubeLines().get(0).getHeatTubes().get(0).getNThick());
		LabelAndFieldUtils.showDoublePointTwo(tubeDisLabel, tubeBundle.getTubeDis());
		LabelAndFieldUtils.showDoublePointTwo(divideDislabel, tubeBundle.getDivideDis());
		LabelAndFieldUtils.showDoublePointTwo(otherNLabel, tubeBundle.getOtherN());
		LabelAndFieldUtils.showDoublePointTwo(DgLabel, tubePlateGasket.getFd());
		LabelAndFieldUtils.showDoublePointTwo(PdField, tubePlate.getCalPress());
	}

	public void apply() {
		double od = plateOdField.getDoubleNoNull("请输入管板外径");
		if (od == Constant.ERROR_DOUBLE) {
			return;
		}
		double calPress = PdField.getDoubleNoNull("请输入计算压力");
		if (calPress == Constant.ERROR_DOUBLE) {
			return;
		}
		double allowStress = allowStressField.getDoubleNoNull("请输入管板许用应力");
		if (allowStress == Constant.ERROR_DOUBLE) {
			return;
		}

		double strExpLth = strenthExpansionLengthField.getDoubleCanNull();
		double strWeldLth = strenthWeldedLengthField.getDoubleCanNull();

		if (connectTypeBox.getSelectedItem().toString().equals(Constant.TUBECONTACTPALTE_TYPE[0])) {
			if (strExpLth == Constant.ERROR_DOUBLE || strExpLth <= 0) {
				JOptionPaneUtils.warningMess(contentPane, "请输入强度胀长度");
				strenthExpansionLengthField.requestFocus();
				return;
			}
		}
		if (connectTypeBox.getSelectedItem().toString().equals(Constant.TUBECONTACTPALTE_TYPE[1])) {
			if (strWeldLth == Constant.ERROR_DOUBLE || strWeldLth <= 0) {
				JOptionPaneUtils.warningMess(contentPane, "请输入强度焊长度");
				strenthWeldedLengthField.requestFocus();
				return;
			}
		}
		if (connectTypeBox.getSelectedItem().toString().equals(Constant.TUBECONTACTPALTE_TYPE[2])) {
			if (strExpLth == Constant.ERROR_DOUBLE || strExpLth <= 0) {
				JOptionPaneUtils.warningMess(contentPane, "请输入强度胀长度");
				strenthExpansionLengthField.requestFocus();
				return;
			}
		}
		if (connectTypeBox.getSelectedItem().toString().equals(Constant.TUBECONTACTPALTE_TYPE[3])) {
			if (strWeldLth == Constant.ERROR_DOUBLE || strWeldLth <= 0) {
				JOptionPaneUtils.warningMess(contentPane, "请输入强度焊长度");
				strenthWeldedLengthField.requestFocus();
				return;
			}
		}
		Meterial m = meterialButton.getMeterial();
		if (m == null) {
			JOptionPaneUtils.warningMess(this, "请选择管板材料");
			return;
		}
		String conType = connectTypeBox.getSelectedItem().toString();
		double tubeC1 = tubeC1Field.getDoubleCanNull();
		double shellC1 = shellC1Field.getDoubleCanNull();
		double tubeSoltDth = tubeSoltDepthField.getDoubleCanNull();
		double shellSoltDth = shellSoltDepthField.getDoubleCanNull();
		beuHeatExchanger.getTubePlate().setOd(od);
		beuHeatExchanger.getTubePlate().setMeterial(m);
		beuHeatExchanger.getTubePlate().setAllowStress(allowStress);
		beuHeatExchanger.getTubePlate().setCalPress(calPress);
		beuHeatExchanger.getTubePlate().setAll(conType, strExpLth, strWeldLth, tubeC1, shellC1, tubeSoltDth,
				shellSoltDth);
		double ad = (beuHeatExchanger.getTubePlate().getAreaDivide());
		double at = (beuHeatExchanger.getTubePlate().getAreaTube());
		double diaTubes = (beuHeatExchanger.getTubePlate().getDiaTubes());
		double pt = (beuHeatExchanger.getTubePlate().getRhoTubes());
		double Cc = (beuHeatExchanger.getTubePlate().getCc());
		double calThick = (beuHeatExchanger.getTubePlate().getCalThick());
		double maxAxialStress = (beuHeatExchanger.getTubePlate().getMaxAxisalStress());
		double minThick = (beuHeatExchanger.getTubePlate().getMinThick());
		double maxPullOutStress = (beuHeatExchanger.getTubePlate().getPullOutStress());
		double allAxisaStress = (beuHeatExchanger.getTubePlate().getAllowAxialStress());
		double allPullStress = (beuHeatExchanger.getTubePlate().getAllowPullOutForce());
		LabelAndFieldUtils.showDoublePointTwo(AdLabel, ad);
		LabelAndFieldUtils.showDoublePointTwo(AtLabel, at);
		LabelAndFieldUtils.showDoublePointTwo(dtLabel, diaTubes);
		LabelAndFieldUtils.showDoublePointTwo(PtLabel, pt);
		LabelAndFieldUtils.showDoublePointTwo(CcLabel, Cc);
		LabelAndFieldUtils.showDoublePointTwo(calThickLabel, calThick);
		LabelAndFieldUtils.showDoublePointTwo(minThickLabel, minThick);
		LabelAndFieldUtils.showDoublePointTwo(maxAxialStressLabel, maxAxialStress);
		LabelAndFieldUtils.showDoublePointTwo(allAxialStressLabel, allAxisaStress);
		LabelAndFieldUtils.showDoublePointTwo(maxPullStressLabel, maxPullOutStress);
		LabelAndFieldUtils.showDoublePointTwo(allPullStressLabel, allPullStress);
		if (beuHeatExchanger.getTubePlate().isSafeThick()) {
			plateThickJLabel.setForeground(Color.BLUE);
		} else {
			plateThickJLabel.setForeground(Color.RED);
		}
		if (beuHeatExchanger.getTubePlate().isSafeAxialStress()) {
			maxAxialStressLabel.setForeground(Color.BLUE);
		} else {
			maxAxialStressLabel.setForeground(Color.RED);
		}
		if (beuHeatExchanger.getTubePlate().isSafePullOutForce()) {
			maxPullStressLabel.setForeground(Color.BLUE);
		} else {
			maxPullStressLabel.setForeground(Color.RED);
		}

		showTubePlatePanel.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		apply();
	}
}
