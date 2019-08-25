package com.duan.module.heatexchanger.beu.jpanel;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.duan.component.PureNumField;
import com.duan.component.image.ShowImageCenterPanel;
import com.duan.module.heatexchanger.beu.bean.BEUHeatExchanger;
import com.duan.module.heatexchanger.beu.bean.structural.TubePlateGasket;
import com.duan.utils.Constant;
import com.duan.utils.LabelAndFieldUtils;
import com.duan.utils.PanelUtils;

public class TubePlateGasketPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PureNumField IdField;
	private PureNumField OdField;
	private PureNumField sealIdField;
	private PureNumField sealOdField;
	private JLabel b0Label;
	private JLabel bLabel;
	private JLabel fdLabel;
	private BEUHeatExchanger beuHeatExchanger;

	/**
	 * Create the panel.
	 */
	public TubePlateGasketPanel(BEUHeatExchanger beuHeatExchanger) {

		// TODO Auto-generated constructor stub

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
		InputPanel.setBounds(5, 5, 210, 160);
		contentPane.add(InputPanel);
		InputPanel.setLayout(null);

		JLabel idLabel = new JLabel("\u5185\u5F84");
		idLabel.setBounds(10, 13, 54, 15);
		InputPanel.add(idLabel);

		IdField = new PureNumField();
		IdField.setBounds(100, 10, 66, 21);
		InputPanel.add(IdField);

		JLabel odLabel = new JLabel("\u5916\u5F84");
		odLabel.setBounds(10, 43, 80, 15);
		InputPanel.add(odLabel);

		OdField = new PureNumField();
		OdField.setBounds(100, 40, 66, 21);
		InputPanel.add(OdField);

		JButton applyButton = new JButton("\u5E94\u7528");
		applyButton.setBounds(10, 128, 190, 23);
		InputPanel.add(applyButton);

		JLabel label = new JLabel("\u5B9E\u9645\u5BC6\u5C01\u5185\u5F84");
		label.setBounds(10, 73, 80, 15);
		InputPanel.add(label);

		sealIdField = new PureNumField();
		sealIdField.setBounds(100, 70, 66, 21);
		InputPanel.add(sealIdField);

		JLabel label_1 = new JLabel("\u5B9E\u9645\u5BC6\u5C01\u5916\u5F84");
		label_1.setBounds(10, 103, 80, 15);
		InputPanel.add(label_1);

		sealOdField = new PureNumField();
		sealOdField.setBounds(100, 100, 66, 21);
		InputPanel.add(sealOdField);

		JLabel lblMm = new JLabel("mm");
		lblMm.setBounds(171, 13, 29, 15);
		InputPanel.add(lblMm);

		JLabel label_5 = new JLabel("mm");
		label_5.setBounds(171, 41, 29, 15);
		InputPanel.add(label_5);

		JLabel label_6 = new JLabel("mm");
		label_6.setBounds(171, 71, 29, 15);
		InputPanel.add(label_6);

		JLabel label_7 = new JLabel("mm");
		label_7.setBounds(171, 103, 29, 15);
		InputPanel.add(label_7);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(5, 170, 210, 103);
		contentPane.add(panel);

		JLabel label_2 = new JLabel("\u5BC6\u5C01\u9762\u5BBD\u5EA6");
		label_2.setBounds(10, 13, 80, 15);
		panel.add(label_2);

		JLabel label_3 = new JLabel("\u5BC6\u5C01\u9762\u6709\u6548\u5BBD\u5EA6");
		label_3.setBounds(10, 43, 95, 15);
		panel.add(label_3);

		JLabel label_4 = new JLabel("\u4F5C\u7528\u5706\u76F4\u5F84");
		label_4.setBounds(10, 73, 80, 15);
		panel.add(label_4);

		b0Label = new JLabel("");
		b0Label.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		b0Label.setBounds(100, 10, 66, 21);
		panel.add(b0Label);

		bLabel = new JLabel("");
		bLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		bLabel.setBounds(100, 40, 66, 21);
		panel.add(bLabel);

		fdLabel = new JLabel("");
		fdLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fdLabel.setBounds(100, 70, 66, 21);
		panel.add(fdLabel);

		JLabel label_8 = new JLabel("mm");
		label_8.setBounds(171, 13, 29, 15);
		panel.add(label_8);

		JLabel label_9 = new JLabel("mm");
		label_9.setBounds(171, 43, 29, 15);
		panel.add(label_9);

		JLabel label_10 = new JLabel("mm");
		label_10.setBounds(171, 73, 29, 15);
		panel.add(label_10);

		applyButton.addActionListener(this);

		PanelUtils.setAllComFont(InputPanel);
		PanelUtils.setAllComFont(panel);
		
		JPanel panel_1 = new ShowImageCenterPanel(500, 500, "src/img/HeatExchanger/gasket.png",false);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(220, 5, 500, 500);
		contentPane.add(panel_1);
	}

	public void apply() {
		// TODO Auto-generated method stub
		beuHeatExchanger.setTubePlateGasket(null);
		double id = IdField.getDoubleNoNull("请输入垫片内径");
		if (id == Constant.ERROR_DOUBLE) {
			return;
		}
		double od = OdField.getDoubleNoNull("请输入垫片外径");
		if (od == Constant.ERROR_DOUBLE) {
			return;
		}
		double sealId = sealIdField.getDoubleNoNull("请输入垫片密封内径");
		if (sealId == Constant.ERROR_DOUBLE) {
			return;
		}
		double sealOd = sealOdField.getDoubleNoNull("请输入垫片密封外径");
		if (sealOd == Constant.ERROR_DOUBLE) {
			return;
		}
		TubePlateGasket tubePlateGasket = new TubePlateGasket(id, od, sealId, sealOd);
		beuHeatExchanger.setTubePlateGasket(tubePlateGasket);
		double b0 = tubePlateGasket.getB0();
		double b = tubePlateGasket.getB();
		double fd = tubePlateGasket.getFd();
		LabelAndFieldUtils.showDoublePointTwo(b0Label, b0);
		LabelAndFieldUtils.showDoublePointTwo(bLabel, b);
		LabelAndFieldUtils.showDoublePointTwo(fdLabel, fd);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		apply();
	}
}
