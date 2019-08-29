package com.duan.component;

import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.duan.utils.FrameUtils;

public class ChildFrame extends JFrame implements WindowListener {

	private static final long serialVersionUID = 1L;

	public void start() {
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (Exception e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChildFrame(int width, int height) {
		// TODO Auto-generated constructor stub
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setIconImage(new ImageIcon("src/img/menu/main.png").getImage());
		FrameUtils.setFrameAtScreenCenter(this, width, height);
		addWindowListener(this);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO 自动生成的方法存根
		try {
			for (int i = 0; i <= 100; i++) {
				Thread.sleep(10);
				setSize(500-i, 500-i);
			}
		} catch (

		Exception e1) {

		}		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO 自动生成的方法存根

	}

}
