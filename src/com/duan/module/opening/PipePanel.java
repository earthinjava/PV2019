package com.duan.module.opening;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import com.duan.component.PureNumField;
import com.duan.component.ResultLabel;
import com.duan.component.meterial.MeterialButton;
import com.duan.meterial.Meterial;
import com.duan.module.opening.bean.Openging;
import com.duan.utils.Constant;
import com.duan.utils.LabelAndFieldUtils;
import com.duan.utils.PanelUtils;
import com.duan.vessel.designCondition.DesignConditionPanel;
import com.duan.vessel.pipe.Pipe;
import com.duan.vessel.pipe.StraightPipe;

public class PipePanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private DesignConditionPanel designConJPanel;
	private Pipe pipe;
	private PureNumField pipeDia;
	private PureNumField pipeStress;
	private PureNumField pipeC1;
	private JLabel pipeC2;
	private JLabel pipeCalThick;
	private JLabel pipeMinThick;
	private PureNumField nThickField;
	private PureNumField pipeEff;
	private ResultLabel result;
	private JLabel mawp;
	private JLabel od;
	private boolean isSucessApply;
	private MeterialButton meterialButton;
	private Openging openging;

	public PipePanel(Openging openging, DesignConditionPanel dsConPanel) {
		this.designConJPanel = dsConPanel;
		this.openging = openging;
		setToolTipText("");
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setSize(175, 460);
		setLayout(null);
		setBackground(SystemColor.menu);

		JLabel label = new JLabel("\u63A5\u7BA1");
		label.setBounds(97, 10, 46, 20);
		add(label);

		JLabel label_4 = new JLabel("\u5185\u5F84");
		label_4.setBounds(10, 40, 74, 20);
		add(label_4);

		pipeDia = new PureNumField();
		pipeDia.setBounds(81, 40, 66, 20);
		add(pipeDia);

		JLabel label_5 = new JLabel("mm");
		label_5.setBounds(148, 40, 26, 20);
		add(label_5);

		JLabel label_6 = new JLabel("\u6750\u6599");
		label_6.setBounds(10, 100, 155, 20);
		add(label_6);

		JLabel label_7 = new JLabel("\u8BB8\u7528\u5E94\u529B");
		label_7.setBounds(10, 220, 74, 20);
		add(label_7);

		JLabel label_8 = new JLabel("Mpa");
		label_8.setBounds(148, 220, 25, 20);
		add(label_8);

		JLabel label_9 = new JLabel("\u63A5\u5934\u7CFB\u6570");
		label_9.setBounds(10, 130, 74, 20);
		add(label_9);

		pipeEff = new PureNumField();
		pipeEff.setText("1.0");
		pipeEff.setBounds(81, 130, 66, 20);
		add(pipeEff);

		JLabel label_10 = new JLabel("\u8150\u8680\u88D5\u91CF");
		label_10.setBounds(10, 160, 74, 20);
		add(label_10);

		pipeC1 = new PureNumField();
		pipeC1.setText("1.0");
		pipeC1.setBounds(81, 160, 66, 20);
		add(pipeC1);

		JLabel label_11 = new JLabel("\u8D1F\u504F\u5DEE");
		label_11.setBounds(10, 190, 74, 20);
		add(label_11);

		pipeC2 = new JLabel("");
		pipeC2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pipeC2.setBounds(81, 190, 66, 20);
		add(pipeC2);

		JLabel label_12 = new JLabel("mm");
		label_12.setBounds(149, 160, 25, 20);
		add(label_12);

		JLabel label_15 = new JLabel("mm");
		label_15.setBounds(149, 190, 25, 20);
		add(label_15);

		JLabel label_16 = new JLabel("\u8BA1\u7B97\u539A\u5EA6");
		label_16.setBounds(10, 280, 74, 20);
		add(label_16);

		pipeCalThick = new JLabel("");
		pipeCalThick.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pipeCalThick.setBounds(81, 280, 66, 20);
		add(pipeCalThick);

		JLabel label_19 = new JLabel("\u6700\u5C0F\u539A\u5EA6");
		label_19.setBounds(10, 250, 74, 20);
		add(label_19);

		JLabel label_17 = new JLabel("mm");
		label_17.setBounds(148, 280, 25, 20);
		add(label_17);

		JLabel label_18 = new JLabel("mm");
		label_18.setBounds(148, 250, 25, 20);
		add(label_18);

		JLabel label_1 = new JLabel("\u540D\u4E49\u539A\u5EA6");
		label_1.setBounds(10, 70, 74, 20);
		add(label_1);

		JLabel label_2 = new JLabel("mm");
		label_2.setBounds(149, 70, 25, 20);
		add(label_2);

		JButton applybutton = new JButton("应用");
		applybutton.setBounds(10, 430, 152, 23);
		add(applybutton);
		applybutton.setBackground(SystemColor.control);
		add(label_2);
		applybutton.addActionListener(this);

		JLabel label_3 = new JLabel("\u7ED3\u679C");
		label_3.setBounds(10, 370, 74, 20);
		add(label_3);

		JLabel odLabel = new JLabel("外径");
		odLabel.setBounds(10, 310, 74, 20);
		add(odLabel);

		od = new JLabel("");
		od.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		od.setBounds(81, 310, 66, 20);
		add(od);

		JLabel odLabel2 = new JLabel("mm");
		odLabel2.setBounds(148, 310, 26, 20);

		JLabel mawpLabel = new JLabel("MAWP");
		mawpLabel.setBounds(10, 340, 74, 20);
		add(mawpLabel);

		mawp = new JLabel("");
		mawp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		mawp.setBounds(81, 340, 66, 20);
		add(mawp);

		JLabel label_13 = new JLabel("mm");
		label_13.setBounds(148, 310, 25, 20);
		add(label_13);

		JLabel mawpodLabel2 = new JLabel("Mpa");
		mawpodLabel2.setBounds(148, 340, 26, 20);

		meterialButton = new MeterialButton();
		meterialButton.setFirstStandardType(1);
		meterialButton.setLocation(81, 100);
		add(meterialButton);

		meterialButton.setDesignTempField(dsConPanel.getDesignTempField());

		nThickField = meterialButton.getnThickField();
		nThickField.addActionListener(new FieldActionListener());
		nThickField.setBounds(81, 70, 66, 20);
		add(nThickField);

		result = new ResultLabel();
		result.setBounds(81, 370, 66, 20);
		result.setActualField(nThickField);
		add(result);

		pipeMinThick = result.getRequiredLabel();
		pipeMinThick.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pipeMinThick.setBounds(81, 250, 66, 20);
		add(pipeMinThick);

		pipeStress = meterialButton.getStressField();
		pipeStress.setBounds(81, 220, 66, 20);
		add(pipeStress);

		PanelUtils.setAllComFont(this);
	}

	class FieldActionListener implements ActionListener, Serializable {

		private static final long serialVersionUID = 7993655189843479764L;

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			pipeC2.setText(Double.parseDouble(nThickField.getText()) * 0.1 + "");
		}

	}

	public void apply() {
		designConJPanel.apply();
		if (!designConJPanel.isSucessApply()) {
			isSucessApply = false;
			return;
		}
		if (getInput())
			showOutput();
	}

	public boolean getInput() {
		double pID = pipeDia.getDoubleNoNull("请输入接管内径");
		if (pID == Constant.ERROR_DOUBLE) {
			isSucessApply = false;
			return false;
		}
		Meterial pMeterial = meterialButton.getMeterial();
		double pStr = pipeStress.getDoubleNoNull("请输入接管许用应力");
		if (pStr == Constant.ERROR_DOUBLE) {
			isSucessApply = false;
			return false;
		}
		double pE = pipeEff.getDoubleNoNull("请输入接管焊接接头系数");
		if (pE == Constant.ERROR_DOUBLE) {
			isSucessApply = false;
			return false;
		}
		double nThick = nThickField.getDoubleNoNull("请输入接管厚度");
		if (nThick == Constant.ERROR_DOUBLE) {
			isSucessApply = false;
			return false;
		}
		double piC1 = pipeC1.getDoubleNoNull("请输入接管腐蚀裕量");
		if (piC1 == Constant.ERROR_DOUBLE) {
			isSucessApply = false;
			return false;
		}
		pipe = new StraightPipe(pID, nThick, pMeterial, pStr, pE, piC1, designConJPanel.getDsgcon());
		openging.setPipe(pipe);
		return true;
	}

	public void showOutput() {
		LabelAndFieldUtils.showDoublePointTwo(pipeCalThick, pipe.getCalculateThickness());
		LabelAndFieldUtils.showDoublePointTwo(pipeMinThick, pipe.getMinThickness());
		LabelAndFieldUtils.showDoublePointTwo(pipeC2, pipe.getC2());
		LabelAndFieldUtils.showDoublePointTwo(od, pipe.getOutDia());
		LabelAndFieldUtils.showDoublePointTwo(mawp, pipe.getMaxAllowWokrPressure());
		isSucessApply = true;
		result.showResult();
	}

	public boolean isSucessApply() {
		return isSucessApply;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		apply();
	}

}
