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
		setSize(width, height);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
			int w = getWidth();
			int h = getHeight();
			int i = w / 15;
			int j = h / 15;
			while (w >= 0 && h >= 0) {
				Thread.sleep(10);
				setSize(w, h);
				w -= i;
				h -= j;
			}
		} catch (Exception e1) {

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
