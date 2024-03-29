package com.duan.module.meterial.create;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import com.duan.component.ChildFrame;
import com.duan.component.meterial.SelectMeterialFrame;
import com.duan.meterial.Meterial;
import com.duan.utils.FontUtils;

public class NewMeterialFrame extends ChildFrame {

	private static final long serialVersionUID = 8925496833041725076L;
	private JPanel contentPanel;
	private JTabbedPane tabbedPane;
	private StressAndPropertyPanel stressAndPropertiesPanel;
	private SelectMeterialFrame slectMeterialFrame;

	/**
	 * 新建材料窗体
	 */
	public NewMeterialFrame() {
		super( 1100, 440);
		setTitle("新建材料");

		contentPanel = new JPanel();
		contentPanel.setBackground(Color.white);
		contentPanel.setBounds(new Rectangle(0, 0, 1100, 450));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		setContentPane(contentPanel);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1200, 450);
		contentPanel.add(tabbedPane);
		
		Meterial meterial = new Meterial();
		stressAndPropertiesPanel = new StressAndPropertyPanel(meterial, this);
		stressAndPropertiesPanel.setLocation(0, 0);
		tabbedPane.addTab( "许用应力及物理属性", null, stressAndPropertiesPanel, null);
		FontUtils.setDefaultFont(tabbedPane);		
	}

	/**
	 * 查询材料窗体
	 * 
	 * @param meterial
	 * @param slectMeterialFrame
	 */
	public NewMeterialFrame(Meterial meterial, SelectMeterialFrame slectMeterialFrame) {
		this();
		setTitle("查询材料");
		tabbedPane.removeAll();
		this.slectMeterialFrame = slectMeterialFrame;		
		stressAndPropertiesPanel = new StressAndPropertyPanel(meterial, this, 1);
		stressAndPropertiesPanel.setLocation(0, 0);		
		tabbedPane.addTab( "许用应力及物理属性", null, stressAndPropertiesPanel, null);
		FontUtils.setDefaultFont(tabbedPane);
	}

	@Override
	public void dispose() {
		// TODO 自动生成的方法存根
		super.dispose();		
		if (slectMeterialFrame != null) {			
			slectMeterialFrame.dispose();
		}
	}
}
