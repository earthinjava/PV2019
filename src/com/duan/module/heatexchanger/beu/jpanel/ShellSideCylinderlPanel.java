package com.duan.module.heatexchanger.beu.jpanel;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import com.duan.component.PureNumField;
import com.duan.component.ResultLabel;
import com.duan.component.image.ShowImageCenterPanel;
import com.duan.component.meterial.MeterialButton;
import com.duan.meterial.Meterial;
import com.duan.module.heatexchanger.beu.bean.BEUHeatExchanger;
import com.duan.utils.Constant;
import com.duan.utils.JOptionPaneUtils;
import com.duan.utils.LabelAndFieldUtils;
import com.duan.utils.PanelUtils;
import com.duan.vessel.shell.CylinderShell;
import com.duan.vessel.shell.Shell;

public class ShellSideCylinderlPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private PureNumField shellDia;
	private PureNumField shellStress;
	private PureNumField shellEff;
	private PureNumField shellC1;
	private PureNumField shellC2;
	private PureNumField nThickField;
	private JLabel shellMinThick;
	private JLabel shellCalThick;
	private ResultLabel result;
	private JLabel od;
	private JLabel mawp;
	private BEUHeatExchanger beuHeatExchanger;
	private JPanel contentPanel;
	private MeterialButton meterialButton;

	public ShellSideCylinderlPanel() {

		setBackground(Color.WHITE);
		setToolTipText("");
		setBorder(null);
		setSize(779, 631);
		setLayout(null);

		contentPanel = new JPanel();
		contentPanel.setLocation(5, 5);
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPanel.setSize(175, 400);
		contentPanel.setBackground(SystemColor.menu);
		add(contentPanel);

		JLabel label_4 = new JLabel("\u5185\u5F84");
		label_4.setBounds(10, 10, 74, 20);
		contentPanel.add(label_4);

		shellDia = new PureNumField();
		shellDia.setBounds(81, 10, 66, 20);
		contentPanel.add(shellDia);

		JLabel label_5 = new JLabel("mm");
		label_5.setBounds(148, 10, 26, 20);
		contentPanel.add(label_5);

		JLabel label_6 = new JLabel("\u6750\u6599");
		label_6.setBounds(10, 70, 74, 20);
		contentPanel.add(label_6);

		JLabel label_7 = new JLabel("\u8BB8\u7528\u5E94\u529B");
		label_7.setBounds(10, 190, 74, 20);
		contentPanel.add(label_7);

		JLabel label_8 = new JLabel("Mpa");
		label_8.setBounds(148, 190, 26, 20);
		contentPanel.add(label_8);

		JLabel label_9 = new JLabel("\u63A5\u5934\u7CFB\u6570");
		label_9.setBounds(10, 100, 74, 20);
		contentPanel.add(label_9);

		shellEff = new PureNumField();
		shellEff.setText("1.0");
		shellEff.setBounds(81, 100, 66, 20);
		contentPanel.add(shellEff);

		JLabel label_10 = new JLabel("\u8150\u8680\u88D5\u91CF");
		label_10.setBounds(10, 130, 74, 20);
		contentPanel.add(label_10);

		shellC1 = new PureNumField();
		shellC1.setText("1.0");
		shellC1.setBounds(81, 130, 66, 20);
		contentPanel.add(shellC1);

		JLabel label_12 = new JLabel("mm");
		label_12.setBounds(148, 130, 26, 20);
		contentPanel.add(label_12);

		JLabel label_11 = new JLabel("\u8D1F\u504F\u5DEE");
		label_11.setBounds(10, 160, 74, 20);
		contentPanel.add(label_11);

		shellC2 = new PureNumField();
		shellC2.setText("0.3");
		shellC2.setBounds(100, 160, 46, 20);
		contentPanel.add(shellC2);

		JLabel label_15 = new JLabel("mm");
		label_15.setBounds(148, 160, 26, 20);
		contentPanel.add(label_15);

		JLabel label_16 = new JLabel("\u8BA1\u7B97\u539A\u5EA6");
		label_16.setBounds(10, 250, 74, 20);
		contentPanel.add(label_16);

		shellCalThick = new JLabel("");
		shellCalThick.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		shellCalThick.setBounds(81, 250, 66, 20);
		contentPanel.add(shellCalThick);

		JLabel label_17 = new JLabel("mm");
		label_17.setBounds(148, 250, 26, 20);
		contentPanel.add(label_17);

		JLabel label_19 = new JLabel("\u6700\u5C0F\u539A\u5EA6");
		label_19.setBounds(10, 220, 74, 20);
		contentPanel.add(label_19);

		JLabel label_18 = new JLabel("mm");
		label_18.setBounds(148, 220, 26, 20);
		contentPanel.add(label_18);

		JLabel label_1 = new JLabel("\u540D\u4E49\u539A\u5EA6");
		label_1.setBounds(10, 40, 74, 20);
		contentPanel.add(label_1);

		JLabel label_2 = new JLabel("mm");
		label_2.setBounds(148, 40, 26, 20);

		JButton applybutton = new JButton("应用");
		applybutton.setBounds(10, 370, 152, 23);
		contentPanel.add(applybutton);
		applybutton.setBackground(SystemColor.control);
		contentPanel.add(label_2);
		
		result = new ResultLabel();
		result.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		result.setBounds(81, 340, 66, 20);
		contentPanel.add(result);

		shellMinThick = result.getRequiredLabel();
		shellMinThick.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		shellMinThick.setBounds(81, 220, 66, 20);
		contentPanel.add(shellMinThick);
		
		JLabel label_3 = new JLabel("\u7ED3\u679C");
		label_3.setBounds(10, 340, 74, 20);
		contentPanel.add(label_3);

		JLabel odLabel = new JLabel("外径");
		odLabel.setBounds(10, 280, 74, 20);
		contentPanel.add(odLabel);

		od = new JLabel("");
		od.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		od.setBounds(81, 280, 66, 20);
		contentPanel.add(od);

		JLabel odLabel2 = new JLabel("mm");
		odLabel2.setBounds(148, 310, 26, 20);

		JLabel mawpLabel = new JLabel("MAWP");
		mawpLabel.setBounds(10, 310, 74, 20);
		contentPanel.add(mawpLabel);

		mawp = new JLabel("");
		mawp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		mawp.setBounds(81, 310, 66, 20);
		contentPanel.add(mawp);

		JLabel label = new JLabel("mm");
		label.setBounds(148, 280, 26, 20);
		contentPanel.add(label);

		JLabel lblMpa = new JLabel("Mpa");
		lblMpa.setBounds(148, 310, 26, 20);
		contentPanel.add(lblMpa);

		JLabel label_13 = new JLabel("\u00B1");
		label_13.setBounds(81, 160, 26, 20);
		contentPanel.add(label_13);

		JPanel imgPanel =new ShowImageCenterPanel(595, 400, "src/img/HeatExchanger/shell.png",false);		
		imgPanel.setBounds(185, 5, 595, 400);
		add(imgPanel);

		JLabel mawpodLabel2 = new JLabel("Mpa");
		mawpodLabel2.setBounds(148, 340, 26, 20);

		applybutton.addActionListener(this);
		PanelUtils.setAllComFont(contentPanel);

	}

	public ShellSideCylinderlPanel(BEUHeatExchanger beuHeatExchanger, HeatDesignContionPanel heatDesignContionPanel) {
		this();
		this.beuHeatExchanger = beuHeatExchanger;

		meterialButton = new MeterialButton();
		meterialButton.setLocation(81, 70);
		contentPanel.add(meterialButton);
		
		meterialButton.setDesignTempField(heatDesignContionPanel.getShellDesignTempField());
		
		nThickField =meterialButton.getnThickField();
		nThickField.setBounds(81, 40, 66, 20);
		contentPanel.add(nThickField);

		result.setActualField(nThickField);
		
		shellStress = meterialButton.getStressField();
		shellStress.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		shellStress.setColumns(10);
		shellStress.setBounds(81, 190, 66, 20);
		contentPanel.add(shellStress);
	}

	public void apply() {
		beuHeatExchanger.setShellSideCylinder(null);
		double shellID = shellDia.getDoubleNoNull("请输入筒体内径");
		if (shellID == Constant.ERROR_DOUBLE) {
			return;
		}
		double nThick = nThickField.getDoubleNoNull("请输入筒体名义厚度");
		if (nThick == Constant.ERROR_DOUBLE) {
			return;
		}
		Meterial shellMeterial = meterialButton.getMeterial();
		if (shellMeterial == null) {
			JOptionPaneUtils.warningMess(contentPanel, "请选择筒体材料");
			return;
		}
		double shellE = shellEff.getDoubleNoNull("请输入筒体焊接接头系数");
		if (shellE == Constant.ERROR_DOUBLE) {
			return;
		}

		double shellC11 = shellC1.getDoubleNoNull("请输入筒体腐蚀裕量");
		if (shellC11 == Constant.ERROR_DOUBLE) {
			return;
		}
		double shellC12 = shellC2.getDoubleNoNull("请输入筒体厚度负偏差");
		if (shellC12 == Constant.ERROR_DOUBLE) {
			return;
		}
		double stress = shellStress.getDoubleNoNull("请输入筒体材料许用应力");
		if (stress == Constant.ERROR_DOUBLE) {
			return;
		}
		Shell shell = new CylinderShell(shellID, nThick, shellMeterial, stress, shellE, shellC11, shellC12,
				beuHeatExchanger.getHeatDesignConditions().getShellDesignCondition());
		beuHeatExchanger.setShellSideCylinder(shell);
		LabelAndFieldUtils.showDoublePointTwo(shellCalThick, shell.getCalculateThickness());
		LabelAndFieldUtils.showDoublePointTwo(shellMinThick, shell.getMinThickness());
		LabelAndFieldUtils.showDoublePointTwo(od, shell.getOutDia());
		LabelAndFieldUtils.showDoublePointTwo(mawp, shell.getMaxAllowWokrPressure());
		result.showResult();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		apply();
	}
}
