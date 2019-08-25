package com.duan.module.opening;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import com.duan.component.PureNumField;
import com.duan.module.opening.bean.Openging;
import com.duan.module.opening.bean.OpeningDesignCondition;
import com.duan.utils.Constant;
import com.duan.utils.JOptionPaneUtils;
import com.duan.utils.PanelUtils;
import com.duan.vessel.GB150;
import com.duan.vessel.designCondition.DesignCondition;
import com.duan.vessel.designCondition.DesignConditionPanel;

public class OpeningDesignContionPanel extends JPanel implements DesignConditionPanel,ActionListener {

	private static final long serialVersionUID = 1L;
	private PureNumField designTemField;
	private PureNumField designPressFiled;
	private DesignCondition dsgcon;
	private JComboBox<String> mediumBurnPropertyBox;
	private JComboBox<String> mediumLethalPropertyBox;
	private JButton applybutton;
	private boolean isSucessApply;
	private Openging openging;

	/**
	 * Create the panel.
	 */
	public OpeningDesignContionPanel(Openging openging, String title) {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setSize(175, 200);
		setLayout(null);
		setBackground(SystemColor.menu);
		this.openging = openging;

		JLabel label_2 = new JLabel("\u8BBE\u8BA1\u538B\u529B");
		label_2.setBounds(10, 40, 60, 20);
		add(label_2);

		JLabel label_3 = new JLabel("\u8BBE\u8BA1\u6E29\u5EA6");
		label_3.setBounds(10, 70, 60, 20);
		add(label_3);

		JLabel label_4 = new JLabel("易爆性");
		label_4.setBounds(10, 100, 60, 20);
		add(label_4);

		mediumBurnPropertyBox = new JComboBox<String>();
		mediumBurnPropertyBox.setModel(new DefaultComboBoxModel<String>(Constant.MEDIUM_BURNPROPERTY));
		mediumBurnPropertyBox.setBounds(81, 100, 80, 20);
		add(mediumBurnPropertyBox);

		JLabel label_5 = new JLabel("介质毒性");
		label_5.setBounds(10, 130, 60, 20);
		add(label_5);

		mediumLethalPropertyBox = new JComboBox<String>();
		mediumLethalPropertyBox.setModel(new DefaultComboBoxModel<String>(Constant.MEDIUM_LETHALPROPERTY));
		mediumLethalPropertyBox.setBounds(81, 130, 80, 20);
		add(mediumLethalPropertyBox);

		designTemField = new PureNumField();
		designTemField.setBounds(81, 70, 66, 20);
		add(designTemField);

		designPressFiled = new PureNumField();
		designPressFiled.setBounds(81, 40, 66, 20);
		add(designPressFiled);

		JLabel label_13 = new JLabel("Mpa");
		label_13.setBounds(148, 40, 29, 20);
		add(label_13);

		JLabel label_14 = new JLabel("\u2103");
		label_14.setBounds(151, 70, 29, 20);
		add(label_14);

		applybutton = new JButton("应用");
		applybutton.setBounds(10, 167, 152, 23);
		applybutton.setBackground(SystemColor.control);
		add(applybutton);

		JLabel titleLabel = new JLabel("");
		titleLabel.setBounds(81, 10, 60, 20);
		add(titleLabel);

		titleLabel.setText(title);

		PanelUtils.setAllComFont(this);

		applybutton.addActionListener(this);
	}

	public void hideApplyButton() {
		applybutton.setVisible(false);
	}

	public void apply() {
		double dsgPress = designPressFiled.getDoubleNoNull("请输入设计压力");
		if (dsgPress == Constant.ERROR_DOUBLE) {
			isSucessApply = false;
			return;
		}
		if (!GB150.isPressMeetingGB150(dsgPress)) {
			JOptionPaneUtils.warningMess(applybutton, "设计压力超出GB150计算范围");
			isSucessApply = false;
			return;
		}
		double dsgTemp = designTemField.getDoubleNoNull("请输入设计温度");
		if (dsgTemp == Constant.ERROR_DOUBLE) {
			isSucessApply = false;
			return;
		}
		dsgcon = new OpeningDesignCondition(dsgPress, dsgTemp);
		openging.setDesignCondition(dsgcon);
		isSucessApply = true;
	}

	public boolean isSucessApply() {
		return isSucessApply;
	}

	public DesignCondition getDsgcon() {
		return dsgcon;
	}	

	@Override
	public PureNumField getDesignTempField() {
		// TODO Auto-generated method stub
		return designTemField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		apply();
	}
}
