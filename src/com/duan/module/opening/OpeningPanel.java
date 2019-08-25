package com.duan.module.opening;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.duan.component.PureNumField;
import com.duan.component.ResultLabel;
import com.duan.component.image.ShowImageCenterPanel;
import com.duan.module.opening.bean.A1;
import com.duan.module.opening.bean.A2;
import com.duan.module.opening.bean.A3;
import com.duan.module.opening.bean.A4;
import com.duan.module.opening.bean.Ae;
import com.duan.module.opening.bean.Ar;
import com.duan.module.opening.bean.Openging;
import com.duan.module.opening.bean.ReinforcementPlate;
import com.duan.utils.Constant;
import com.duan.utils.JOptionPaneUtils;
import com.duan.utils.LabelAndFieldUtils;
import com.duan.utils.PanelUtils;
import com.duan.vessel.GB150;

public class OpeningPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private ShellPanel shellPanel;
	private PipePanel pipePanel;
	private PureNumField h1;
	private PureNumField h2;
	private PureNumField reinforceThick;
	private PureNumField reinforceOD;
	private PureNumField a3TextField;
	private JRadioButton haveReinforcementPlate;
	private JComboBox<String> reinType;
	private JLabel arJLabel;
	private JLabel a1JLabel;
	private JLabel a2JLabel;
	private JLabel a4JLabel;
	private JLabel aeJLabel;
	private JLabel exJLabel;
	private ResultLabel resultJLabel;
	private Ar ar;
	private Ae ae;
	private ReinforcementPlate reinforcementPlate;
	private OpeningDesignContionPanel designConJPanel;
	private Openging openging;
	private A1 a1;
	private A2 a2;
	private A3 a3;
	private A4 a4;
	private ShowImageCenterPanel imgPanel;
	/**
	 * Create the panel.
	 */
	public OpeningPanel(OpeningDesignContionPanel designConJPanel, ShellPanel shellPanel, PipePanel pipePanel,
			Openging openging, ShowImageCenterPanel imgPanel) {

		this.shellPanel = shellPanel;
		this.pipePanel = pipePanel;
		this.designConJPanel = designConJPanel;
		this.openging = openging;
		this.imgPanel=imgPanel;

		setToolTipText("");
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setSize(210, 460);
		setLayout(null);

		JLabel adfaf = new JLabel("\u63A5\u7BA1\u5916\u4F38\u9AD8\u5EA6");
		adfaf.setBounds(10, 10, 91, 20);
		add(adfaf);

		h1 = new PureNumField();
		h1.setBounds(117, 10, 66, 20);
		add(h1);

		JLabel adfasdf = new JLabel("\u63A5\u7BA1\u5185\u4F38\u9AD8\u5EA6");
		adfasdf.setBounds(10, 40, 91, 20);
		add(adfasdf);

		h2 = new PureNumField();
		h2.setBounds(117, 40, 66, 20);
		h2.setText("0.0");
		add(h2);

		JLabel reinforceThickt = new JLabel("\u8865\u5F3A\u5708\u539A\u5EA6");
		reinforceThickt.setBounds(10, 100, 91, 20);
		add(reinforceThickt);

		reinforceThick = new PureNumField();
		reinforceThick.setEnabled(false);
		reinforceThick.setBounds(117, 100, 66, 20);
		add(reinforceThick);

		JLabel reinforceOD2 = new JLabel("\u8865\u5F3A\u5708\u5916\u5F84");
		reinforceOD2.setBounds(10, 130, 91, 20);
		add(reinforceOD2);

		reinforceOD = new PureNumField();
		reinforceOD.setEnabled(false);
		reinforceOD.setBounds(117, 130, 66, 20);
		add(reinforceOD);

		JLabel asdfadf = new JLabel("A4\u8865\u5F3A\u5708\u9762\u79EF");
		asdfadf.setBounds(10, 279, 104, 20);
		add(asdfadf);

		JLabel label_24 = new JLabel("mm");
		label_24.setBounds(184, 10, 25, 20);
		add(label_24);

		JLabel label_33 = new JLabel("mm");
		label_33.setBounds(184, 40, 25, 20);
		add(label_33);

		JLabel label_34 = new JLabel("mm");
		label_34.setBounds(184, 100, 25, 20);
		add(label_34);

		JLabel label_35 = new JLabel("mm");
		label_35.setBounds(184, 130, 25, 20);
		add(label_35);

		JLabel lblMm = new JLabel("mm\u00B2");
		lblMm.setBounds(184, 279, 25, 20);
		add(lblMm);

		haveReinforcementPlate = new JRadioButton("\u52A0\u5F3A\u5708");
		haveReinforcementPlate.setBounds(10, 70, 91, 20);
		add(haveReinforcementPlate);

		haveReinforcementPlate.addChangeListener(new RadioButtonChangeListener() );

		reinType = new JComboBox<String>();
		reinType.setName("");
		reinType.setModel(new DefaultComboBoxModel<String>(
				new String[] { "自定义", "DN600", "DN500", "DN450", "DN400", "DN350", "DN300", "DN250", "DN225", "DN200",
						"DN175", "DN150", "DN125", "DN100", "DN80", "DN65", "DN50" }));
		reinType.setEnabled(false);
		reinType.setBounds(117, 70, 86, 20);
		add(reinType);

		reinType.addActionListener(new ReinTypeActionListener());

		JLabel lblAr = new JLabel("Ar\u6240\u9700\u8865\u5F3A\u9762\u79EF");
		lblAr.setBounds(10, 189, 104, 20);
		add(lblAr);

		JLabel label_26 = new JLabel("mm\u00B2");
		label_26.setBounds(184, 189, 25, 20);
		add(label_26);

		JLabel label_25 = new JLabel("A1\u7B52\u4F53\u591A\u4F59\u9762\u79EF");
		label_25.setBounds(10, 219, 104, 20);
		add(label_25);

		JLabel label_27 = new JLabel("mm\u00B2");
		label_27.setBounds(184, 219, 25, 20);
		add(label_27);

		JLabel label_28 = new JLabel("A2\u63A5\u7BA1\u591A\u4F59\u9762\u79EF");
		label_28.setBounds(10, 249, 104, 20);
		add(label_28);

		JLabel label_29 = new JLabel("mm\u00B2");
		label_29.setBounds(184, 249, 25, 20);
		add(label_29);

		JLabel label_30 = new JLabel("A3\u710A\u7F1D\u8865\u5F3A\u9762\u79EF");
		label_30.setBounds(10, 160, 104, 20);
		add(label_30);

		JLabel label_31 = new JLabel("mm\u00B2");
		label_31.setBounds(184, 159, 25, 20);
		add(label_31);

		a1JLabel = new JLabel();
		a1JLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		a1JLabel.setBounds(117, 219, 66, 20);
		add(a1JLabel);

		a2JLabel = new JLabel();
		a2JLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		a2JLabel.setBounds(117, 249, 66, 20);
		add(a2JLabel);

		a4JLabel = new JLabel();
		a4JLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		a4JLabel.setBounds(117, 279, 66, 20);
		add(a4JLabel);

		JLabel label_32 = new JLabel("Ae\u8865\u5F3A\u9762\u79EF");
		label_32.setBounds(10, 309, 104, 20);
		add(label_32);

		JLabel label_36 = new JLabel("mm\u00B2");
		label_36.setBounds(184, 309, 25, 20);
		add(label_36);

		a3TextField = new PureNumField();
		a3TextField.setBounds(117, 157, 66, 20);
		add(a3TextField);

		JLabel label_37 = new JLabel("\u8865\u5F3A\u88D5\u91CF");
		label_37.setBounds(10, 339, 56, 20);
		add(label_37);

		JLabel label_40 = new JLabel("%");
		label_40.setBounds(184, 339, 25, 20);
		add(label_40);

		resultJLabel = new ResultLabel();
		resultJLabel.setBounds(117, 369, 66, 20);
		add(resultJLabel);

		arJLabel = resultJLabel.getRequiredLabel();
		arJLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		arJLabel.setBounds(117, 189, 66, 20);
		add(arJLabel);

		aeJLabel = resultJLabel.getActualLabel();
		aeJLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		aeJLabel.setBounds(117, 309, 66, 20);
		add(aeJLabel);

		exJLabel = resultJLabel.getExJLabel();
		exJLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		exJLabel.setBounds(117, 339, 66, 20);
		add(exJLabel);

		JLabel label = new JLabel("\u7ED3\u679C");
		label.setBounds(10, 371, 56, 20);
		add(label);

		JButton applyButton = new JButton("\u5E94\u7528");
		applyButton.setBounds(10, 430, 190, 23);
		applyButton.setBackground(SystemColor.control);
		add(applyButton);

		PanelUtils.setAllComFont(this);
		applyButton.addActionListener(this);
	}

	class ReinTypeActionListener implements ActionListener, Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = -8367046953510884609L;

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			String rein = (String) (reinType.getSelectedItem());
			double od = ReinforcementPlate.getStandardPlateOD(rein);
			reinforceOD.setText(od + "");
		}

	}

	class RadioButtonChangeListener implements ChangeListener, Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = -6716995198812773162L;

		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO 自动生成的方法存根
			if (haveReinforcementPlate.isSelected()) {
				reinforceThick.setEnabled(true);
				reinforceOD.setEnabled(true);
				reinType.setEnabled(true);
				imgPanel.setImgPath("src/img/opening/showB.png");
				imgPanel.repaint();
			} else {
				reinforceOD.setText("");
				reinforceThick.setText("");
				reinforceThick.setEnabled(false);
				reinforceOD.setEnabled(false);
				reinType.setEnabled(false);
				imgPanel.setImgPath("src/img/opening/showA.png");
				imgPanel.repaint();
			}

		}

	}

	public void apply() {
		shellPanel.apply();
		if (!designConJPanel.isSucessApply()) {
			return;
		}
		if (!shellPanel.isSucessApply()) {
			return;
		}
		pipePanel.apply();
		if (!pipePanel.isSucessApply()) {
			return;
		}
		if (getInput())
			showOutput();
	}

	public boolean getInput() {
		ar = new Ar(openging);
		if (GB150.isOpeningOutOfSpecGB150(openging)) {
			JOptionPaneUtils.warningMess(this, "开孔补强计算超出GB150计算范围");
			return false;
		}
		if (!openging.isNeedCal()) {
			JOptionPaneUtils.warningMess(this, "此开孔若满足与其他开孔距离要求可免除计算");
			return false;
		}

		double outLth = h1.getDoubleNoNull("请输入接管外伸高度");
		if (outLth == Constant.ERROR_DOUBLE) {
			return false;
		}
		double inLth = h2.getDoubleCanNull();
		if (inLth == Constant.ERROR_DOUBLE) {
			inLth = 0;
		}
		a1 = new A1(openging);
		a2 = new A2(openging.getShell(), openging.getPipe(), outLth, inLth);

		if (a3TextField.getDoubleCanNull() != Constant.ERROR_DOUBLE) {
			a3 = new A3(a3TextField.getDoubleCanNull());
		} else {
			a3 = new A3(0.0);
		}

		if (haveReinforcementPlate.isSelected()) {
			double oDia = reinforceOD.getDoubleNoNull("请输入补强圈外径");
			if (oDia == Constant.ERROR_DOUBLE) {
				return false;
			}
			if (oDia < openging.getPipe().getOutDia()) {
				JOptionPaneUtils.warningMess(this, "补强圈外径小于接管外径，请重新输入");
				return false;
			}
			double rt = reinforceThick.getDoubleNoNull("请输入补强圈厚度");
			if (rt == Constant.ERROR_DOUBLE) {
				return false;
			}
			double iDia = openging.getPipe().getOutDia();
			double c2 = openging.getShell().getC2();
			reinforcementPlate = new ReinforcementPlate(oDia, iDia, c2, rt, openging.getShell().getMeterial());
			openging.setReinforcementPlate(reinforcementPlate);
			if (!openging.isPlateCanUsed(shellPanel)) {
				openging.setReinforcementPlate(null);
				return false;
			}
			a4 = new A4(reinforcementPlate);
			ae = new Ae(a1, a2, a3, a4);
			LabelAndFieldUtils.showDoublePointTwo(a4JLabel, a4.getValue());
		} else {
			ae = new Ae(a1, a2, a3);
		}
		openging.setAe(ae);
		openging.setAr(ar);
		return true;
	}

	public void showOutput() {
		LabelAndFieldUtils.showDoublePointTwo(arJLabel, ar.getValue());
		LabelAndFieldUtils.showDoublePointTwo(a1JLabel, a1.getValue());
		LabelAndFieldUtils.showDoublePointTwo(a2JLabel, a2.getValue());
		LabelAndFieldUtils.showDoublePointTwo(aeJLabel, ae.getValue());
		resultJLabel.showResult();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		apply();
	}

}
