package com.duan.start;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.duan.jmenu.NewFrameModuleItem;
import com.duan.jmenu.dataBase.MediumJMenu;
import com.duan.jmenu.dataBase.MeterialJMenu;
import com.duan.jmenu.dataBase.MeterialStandardJMenu;
import com.duan.jmenu.newBulid.HeatExchangerJMenu;
import com.duan.jmenu.newBulid.PartJMenu;
import com.duan.module.calculate.SelectCalculateFrame;
import com.duan.module.message.ContactMeFrame;
import com.duan.module.message.VersionFrame;
import com.duan.module.queryImage.CarbonAllowTempFrame;
import com.duan.utils.FontUtils;
import com.duan.utils.FrameUtils;

public class StartFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;
	private JPanel contentPanel;
	private JMenuBar menuBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
					new StartFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StartFrame() {
		FrameUtils.setFrameAtScreenCenter(this, 800, 800);
		FontUtils.setDefaultFont(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setIconImage(new ImageIcon("src/img/menu/main.png").getImage());

		contentPanel = new JPanel();
		contentPanel.setBackground(SystemColor.menu);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		setContentPane(contentPanel);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 2000, 2000);
		FontUtils.setDefaultFont(tabbedPane);
		// 菜单条
		menuBar = new JMenuBar();
		menuBar.setAlignmentX(10.0f);
		menuBar.setBounds(0, 0, 2000, 20);
		setJMenuBar(menuBar);
		FontUtils.setDefaultFont(menuBar);
		// 新建菜单
		JMenu newMenu = buildRootMenu("新建");
		newMenu.add(new PartJMenu(tabbedPane, contentPanel));
		newMenu.addSeparator();
		newMenu.add(new HeatExchangerJMenu(tabbedPane, contentPanel));
		// 数据菜单
		JMenu dataMenu = buildRootMenu("数据");
		dataMenu.add(new MeterialJMenu(this));
		dataMenu.addSeparator();
		dataMenu.add(new MeterialStandardJMenu(this));
		dataMenu.addSeparator();
		dataMenu.add(new MediumJMenu(this));
		dataMenu.addSeparator();

		// 创建计算文件选项
		JMenuItem calItem = new JMenuItem("计算库");
		FontUtils.setDefaultFont(calItem);
		dataMenu.add(calItem);
		// 点击最终选项，添加tab界面
		calItem.addActionListener(this);
		// 查图菜单
		JMenu imgMenu = buildRootMenu("查图");
		imgMenu.add(new NewFrameModuleItem("钢板许用温度下限", CarbonAllowTempFrame.class.getName(), this));
		// 信息菜单
		JMenu messMenu = buildRootMenu("信息");
		messMenu.add(new NewFrameModuleItem("联系", ContactMeFrame.class.getName(), this));
		messMenu.addSeparator();
		messMenu.add(new NewFrameModuleItem("版本", VersionFrame.class.getName(), this));
	}

	/**
	 * 创建一个根部菜单
	 * 
	 * @param rootName 根部菜单名称
	 * @return
	 */
	private JMenu buildRootMenu(String rootName) {
		JMenu rootMenu = new JMenu(rootName);
		FontUtils.setDefaultFont(rootMenu);
		rootMenu.setAlignmentX(10.0f);
		rootMenu.setBorder(UIManager.getBorder("Button.border"));
		menuBar.add(rootMenu);
		return rootMenu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		contentPanel.add(tabbedPane);
		FrameUtils.clockAndUnclockFatherFrame(contentPanel, new SelectCalculateFrame(tabbedPane));	
	}
}
