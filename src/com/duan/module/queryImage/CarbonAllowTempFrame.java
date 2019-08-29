package com.duan.module.queryImage;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.duan.component.ChildFrame;
import com.duan.component.image.ShowImageCenterPanel;
import com.duan.utils.FrameUtils;

public class CarbonAllowTempFrame extends ChildFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public CarbonAllowTempFrame() {
		super(0, 0);
		String path = "src/img/meterial/allowTempCarbon.png";
		ImageIcon icon = new ImageIcon(path);
		int iconHeigt = icon.getIconHeight();
		int iconWidth = icon.getIconWidth();

		FrameUtils.setFrameAtScreenCenter(this, iconWidth, iconHeigt);
		setSize(iconWidth, iconHeigt + 25);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JPanel preImagePanel = new ShowImageCenterPanel(iconWidth - 15, iconHeigt, 0, 0, path);
		contentPane.add(preImagePanel);
	}

}
