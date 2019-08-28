package com.duan.module.medium.create;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.duan.component.CanStartFrame;
import com.duan.medium.MediumState;

public class NewMediumFrame extends CanStartFrame {

	private static final long serialVersionUID = 8925496833041725076L;
	private JPanel contentPanel;
	private JTabbedPane tabbedPane;
	private JTable propertyTable;
	private SelectMediumStateFrame selectMediumStateFrame;

	
	
	private double standardDensity;// 标况密度
	private double viscosity; // 粘度
	private double specificHeatCapacity;// 比热容
	private double thermalConductivity;// 导热系数
	
	/**
	 * 新建材料窗体
	 */
	public NewMediumFrame() {
		super( 600, 800);
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.white);
		contentPanel.setBounds(new Rectangle(0, 0, 1100, 450));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		setContentPane(contentPanel);	
	}

	/**
	 * 查询材料窗体
	 * 
	 * @param meterial
	 * @param slectMeterialFrame
	 */
	public NewMediumFrame(MediumState mediumState, SelectMediumStateFrame selectMediumStateFrame) {
		this();	
		this.selectMediumStateFrame=selectMediumStateFrame;
	}

	@Override
	public void dispose() {
		super.dispose();		
		if (selectMediumStateFrame != null) {			
			selectMediumStateFrame.dispose();
		}
	}	
}
