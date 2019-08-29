package com.duan.component.meterial;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.duan.component.ChildFrame;
import com.duan.meterial.Meterial;
import com.duan.meterial.MeterialDao;
import com.duan.meterialstandard.MeterialStandard;
import com.duan.module.meterial.create.NewMeterialFrame;
import com.duan.utils.Constant;
import com.duan.utils.DateUtils;
import com.duan.utils.FontUtils;
import com.duan.utils.FrameUtils;
import com.duan.utils.JOptionPaneUtils;
import com.duan.utils.LabelAndFieldUtils;
import com.duan.utils.PanelUtils;

/**
 * 材料选择窗体
 * 
 * @author Administrator
 *
 */
public class SelectMeterialFrame extends ChildFrame {

	private static final long serialVersionUID = 653097626768066387L;
	private JPanel contentPane;
	private JComboBox<String> typeBox;
	private MeterialStandardBox meterialStandardBox;
	private ConformStandardMeterialsBox conformStandardMeterialsBox;
	private JButton button;// 查询材料按钮

	/**
	 * 一个材料选择界面，用来查询材料，被反射创建
	 */
	public SelectMeterialFrame() {
		this(0);
	}

	/**
	 * 一个材料选择界面，用来查询材料
	 */
	public SelectMeterialFrame(int fistStandType) {
		super(250, 180);
		setTitle("查询材料");
		SelectMeterialFrame slectMeterialFrame = this;

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label_1 = new JLabel("\u6750\u6599\u7C7B\u578B");
		label_1.setBounds(10, 10, 65, 25);
		contentPane.add(label_1);

		button = new JButton("\u786E\u8BA4\u67E5\u8BE2");
		button.setBounds(10, 115, 214, 25);
		contentPane.add(button);

		JLabel label = new JLabel("\u6750\u6599\u6807\u51C6");
		label.setBounds(10, 45, 65, 25);
		contentPane.add(label);

		MeterialTool meterialBox = new MeterialTool(fistStandType);

		JLabel label_2 = new JLabel("\u6750\u6599\u540D\u79F0");
		label_2.setBounds(10, 80, 65, 25);
		contentPane.add(label_2);

		typeBox = meterialBox.getMeterialTypeBox();
		typeBox.setBounds(85, 11, 139, 23);
		contentPane.add(typeBox);

		meterialStandardBox = meterialBox.getMeterialStandardsBox();
		meterialStandardBox.setBounds(85, 46, 139, 23);
		contentPane.add(meterialStandardBox);

		conformStandardMeterialsBox = meterialBox.getConformStandardMeterialsBox();
		conformStandardMeterialsBox.setBounds(85, 79, 139, 23);
		contentPane.add(conformStandardMeterialsBox);

		button.addActionListener(new ActionListener() {// 创建一个新材料
			@Override
			public void actionPerformed(ActionEvent e) {
				new NewMeterialFrame(conformStandardMeterialsBox.getSelctedMeterial(), slectMeterialFrame).start();
				setVisible(false);
			}
		});
		PanelUtils.setAllComFont(contentPane);
	}

	/**
	 * 创建一个材料选择窗体，可根据材料温度和厚度，设置许用应力
	 * 
	 * @param meterialButton
	 * @param designTempField
	 * @param nThickField
	 */
	public SelectMeterialFrame(MeterialButton meterialButton) {
		this(meterialButton.getFirstStandardType());
		remove(button);

		JButton confirmbutton = new JButton("确定");
		confirmbutton.setBounds(10, 115, 100, 25);
		contentPane.add(confirmbutton);
		FontUtils.setDefaultFont(confirmbutton);

		JButton checkbutton = new JButton("查询");
		checkbutton.setBounds(130, 115, 100, 25);
		contentPane.add(checkbutton);
		FontUtils.setDefaultFont(checkbutton);

		confirmbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Meterial selctedMeterial = conformStandardMeterialsBox.getSelctedMeterial();
				MeterialStandard selMeterialStandard = meterialStandardBox.getSelectedStand();
				if (selctedMeterial == null) {
					JOptionPaneUtils.warningMess(checkbutton, "还未选择材料!");
					dispose();
					return;
				}
				// 设定所选材料
				meterialButton.setSelectedMeterial(selctedMeterial);
				meterialButton.setToolTipText(selctedMeterial.getName() + " " + selMeterialStandard.getStandardNum()
						+ " " + DateUtils.parseDateToStringMonth(selMeterialStandard.getImplementationDate()));
				// 设定许用应力
				double designTemp = meterialButton.getDesignTempField().getDoubleCanNull();
				double nThick = meterialButton.getNThick();
				// 温度与厚度有输入，则设定许用应力
				if (designTemp != Constant.ERROR_DOUBLE && nThick != Constant.ERROR_DOUBLE) {
					MeterialDao meterialDao = new MeterialDao(selctedMeterial);
					double allowstress = meterialDao.getAllowStressByTempAndThick(designTemp,
							meterialButton.getNThick(), (JButton) e.getSource());
					LabelAndFieldUtils.showDoublePointTwo(meterialButton.getStressField(), allowstress);
				}
				// 设定材料密度值
				double density = selctedMeterial.getDensity();
				LabelAndFieldUtils.showDoublePointTwo(meterialButton.getDensityLabel(), density);
				dispose();
			}
		});

		checkbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Meterial selMeterial = conformStandardMeterialsBox.getSelctedMeterial();
				if (selMeterial == null) {
					JOptionPaneUtils.warningMess(checkbutton, "还未选择材料!");
					return;
				}
				// 设置子窗口打开，则隐藏本窗口。子窗口关闭，则关闭本窗口。
				NewMeterialFrame meterialFrame = new NewMeterialFrame(selMeterial, null);
				FrameUtils.hideAndcloseFatherFrame(checkbutton, meterialFrame);
			}
		});
		// 设置本窗口打开则锁定父窗口，本窗口关闭则解锁父窗口
		FrameUtils.clockAndUnclockFatherFrame(meterialButton, this);
		PanelUtils.setAllComFont(contentPane);
	}
}
