package com.duan.module.heatexchanger.beu;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import com.duan.module.heatexchanger.beu.bean.structural.UHeatTube;
import com.duan.utils.Constant;
import com.duan.utils.JOptionPaneUtils;
import com.duan.utils.LabelAndFieldUtils;
import com.duan.utils.PanelUtils;
import com.duan.vessel.designCondition.DesignCondition;

public class UHeatTubePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private PureNumField pipeStress;
	private JLabel odOffsetLabel;
	private PureNumField nThickField;
	private JLabel calThickLable;
	private JComboBox<String> odBox;
	private JComboBox<String> tubeClassBox;
	private JLabel beforeBendThickLable;
	private JLabel densityLable;
	private BEUHeatExchanger beuHeatExchanger;
	private JPanel contentPanel;
	private JLabel bendRLable;
	private MeterialButton meterialButton;
	private ResultLabel isSafeLable;

	/**
	 * Create the panel.
	 * 
	 * @param heatDesignConJPanel
	 */
	public UHeatTubePanel(BEUHeatExchanger beuHeatExchanger, HeatDesignContionPanel heatDesignContionPanel) {

		this.beuHeatExchanger = beuHeatExchanger;

		setBackground(Color.WHITE);
		setToolTipText("");
		setBorder(null);
		setSize(779, 631);
		setLayout(null);

		contentPanel = new JPanel();
		contentPanel.setLocation(5, 5);
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPanel.setSize(210, 370);
		contentPanel.setBackground(SystemColor.menu);
		add(contentPanel);

		JLabel label_4 = new JLabel("\u5916\u5F84");
		label_4.setBounds(10, 10, 74, 20);
		contentPanel.add(label_4);

		JLabel label_5 = new JLabel("mm");
		label_5.setBounds(167, 10, 26, 20);
		contentPanel.add(label_5);

		JLabel label_6 = new JLabel("\u6750\u6599");
		label_6.setBounds(10, 70, 74, 20);
		contentPanel.add(label_6);

		JLabel label_7 = new JLabel("\u8BB8\u7528\u5E94\u529B");
		label_7.setBounds(11, 130, 74, 20);
		contentPanel.add(label_7);

		JLabel label_8 = new JLabel("Mpa");
		label_8.setBounds(168, 130, 25, 20);
		contentPanel.add(label_8);

		JLabel label_11 = new JLabel("\u5916\u5F84\u504F\u5DEE");
		label_11.setBounds(10, 190, 74, 20);
		contentPanel.add(label_11);

		odOffsetLabel = new JLabel("");
		odOffsetLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		odOffsetLabel.setBounds(117, 190, 46, 20);
		contentPanel.add(odOffsetLabel);

		JLabel label_15 = new JLabel("mm");
		label_15.setBounds(168, 190, 25, 20);
		contentPanel.add(label_15);

		JLabel label_1 = new JLabel("\u539A\u5EA6");
		label_1.setBounds(10, 40, 74, 20);
		contentPanel.add(label_1);

		JLabel label_2 = new JLabel("mm");
		label_2.setBounds(168, 40, 25, 20);
		contentPanel.add(label_2);

		JButton applybutton = new JButton("应用");
		applybutton.setBounds(10, 336, 190, 23);
		applybutton.setBackground(SystemColor.control);
		contentPanel.add(applybutton);

		JLabel label_3 = new JLabel("\u7ED3\u679C");
		label_3.setBounds(10, 310, 74, 20);
		contentPanel.add(label_3);

		JLabel odLabel2 = new JLabel("mm");
		odLabel2.setBounds(148, 310, 26, 20);

		JLabel label_14 = new JLabel("\u7BA1\u675F\u7B49\u7EA7");
		label_14.setBounds(10, 100, 74, 20);
		contentPanel.add(label_14);

		tubeClassBox = new JComboBox<String>();
		tubeClassBox.setModel(new DefaultComboBoxModel<String>(new String[] { "II", "I" }));
		tubeClassBox.setBorder(null);
		tubeClassBox.setBounds(97, 100, 66, 20);
		contentPanel.add(tubeClassBox);

		JLabel label_17 = new JLabel("mm");
		label_17.setBounds(168, 220, 25, 20);
		contentPanel.add(label_17);

		JLabel adfa = new JLabel("\u8BA1\u7B97\u539A\u5EA6");
		adfa.setBounds(10, 220, 74, 20);
		contentPanel.add(adfa);

		JLabel label_18 = new JLabel("\u5F2F\u66F2\u524D\u539A\u5EA6");
		label_18.setBounds(10, 250, 74, 20);
		contentPanel.add(label_18);

		beforeBendThickLable = new JLabel("");
		beforeBendThickLable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		beforeBendThickLable.setBounds(97, 250, 66, 20);
		contentPanel.add(beforeBendThickLable);

		JLabel label_20 = new JLabel("mm");
		label_20.setBounds(168, 250, 25, 20);
		contentPanel.add(label_20);

		JLabel label_19 = new JLabel("\u6750\u6599\u5BC6\u5EA6");
		label_19.setBounds(10, 280, 74, 20);
		contentPanel.add(label_19);

		odBox = new JComboBox<String>();
		odBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "10", "12", "14", "16", "19", "20", "22", "25", "30", "32" }));
		odBox.setBorder(null);
		odBox.setBounds(97, 10, 66, 20);
		contentPanel.add(odBox);

		JLabel lblTm = new JLabel("T/m\u00B3");
		lblTm.setBounds(168, 280, 38, 20);
		contentPanel.add(lblTm);

		JLabel label_9 = new JLabel("\u6700\u5C0F\u5F2F\u66F2\u534A\u5F84");
		label_9.setBounds(10, 160, 93, 20);
		contentPanel.add(label_9);

		bendRLable = new JLabel("");
		bendRLable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		bendRLable.setBounds(97, 160, 66, 20);
		contentPanel.add(bendRLable);

		JLabel label_12 = new JLabel("mm");
		label_12.setBounds(168, 160, 25, 20);
		contentPanel.add(label_12);

		JLabel label = new JLabel("\u00B1");
		label.setBounds(97, 190, 25, 20);
		contentPanel.add(label);

		JPanel panel = new ShowImageCenterPanel(560, 180, "src/img/HeatExchanger/tube.png",false);
		panel.setBounds(220, 5, 560, 180);
		add(panel);

		JLabel mawpodLabel2 = new JLabel("Mpa");
		mawpodLabel2.setBounds(148, 340, 26, 20);

		meterialButton = new MeterialButton(heatDesignContionPanel.getShellDesignTempField(),
				heatDesignContionPanel.getTubeDesignTempField());
		meterialButton.setFirstStandardType(1);
		meterialButton.setLocation(97, 70);
		contentPanel.add(meterialButton);		

		densityLable = meterialButton.getDensityLabel();
		densityLable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		densityLable.setBounds(97, 280, 66, 20);
		contentPanel.add(densityLable);

		pipeStress = meterialButton.getStressField();
		pipeStress.setBounds(97, 130, 66, 20);
		contentPanel.add(pipeStress);		
		
		nThickField = meterialButton.getnThickField();
		nThickField.setBounds(97, 40, 66, 20);
		contentPanel.add(nThickField);
		
		isSafeLable = new ResultLabel();
		isSafeLable.setBounds(97, 310, 66, 20);
		isSafeLable.setActualField(nThickField);
		contentPanel.add(isSafeLable);
		
		calThickLable =isSafeLable.getRequiredLabel();
		calThickLable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		calThickLable.setBounds(97, 220, 66, 20);
		contentPanel.add(calThickLable);


		applybutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				apply();
			}
		});

		meterialButton.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub
				if (meterialButton.getMeterial() == null) {
					return;
				}
				boolean isNonferrous = meterialButton.getMeterial().getMeterialStandard().getProperty().isNonferrous();
				if (isNonferrous) {
					tubeClassBox.removeAllItems();
					tubeClassBox.addItem("高精级");
				} else {
					tubeClassBox.removeAllItems();
					tubeClassBox.addItem("II");
					tubeClassBox.addItem("I");
				}

			}
		});
		PanelUtils.setAllComFont(contentPanel);
	}

	public void apply() {
		beuHeatExchanger.setUHeatTube(null);
		DesignCondition tubeDesignCondition = beuHeatExchanger.getHeatDesignConditions().getTubeDesignCondition();
		double od = Double.parseDouble(odBox.getSelectedItem() + "");
		double nThickess = nThickField.getDoubleNoNull("请输入换热管名义厚度");
		if (nThickess == Constant.ERROR_DOUBLE) {
			return;
		}
		double stress = pipeStress.getDoubleNoNull("请输入换热管许用应力");
		if (stress == Constant.ERROR_DOUBLE) {
			return;
		}
		Meterial m = meterialButton.getMeterial();
		if (m == null) {
			JOptionPaneUtils.warningMess(this, "请选择换热管材料");
			return;
		}
		String tubeClass = tubeClassBox.getSelectedItem().toString();
		UHeatTube uheatTube = new UHeatTube(od, nThickess, stress, m, tubeClass, tubeDesignCondition);
		beuHeatExchanger.setUHeatTube(uheatTube);
		LabelAndFieldUtils.showDoublePointTwo(bendRLable, uheatTube.getBendR());
		LabelAndFieldUtils.showDoublePointTwo(calThickLable, uheatTube.getCalculateThickness());
		LabelAndFieldUtils.showDoublePointTwo(beforeBendThickLable, uheatTube.getBeforeBendThick());
		LabelAndFieldUtils.showDoublePointTwo(densityLable, uheatTube.getMeterial().getDensity());
		LabelAndFieldUtils.showDoublePointTwo(odOffsetLabel, uheatTube.getOdOffset());
		isSafeLable.showResult();
	}
}
