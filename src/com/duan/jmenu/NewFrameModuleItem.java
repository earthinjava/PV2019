package com.duan.jmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

import com.duan.component.CanStartFrame;
import com.duan.utils.FontUtils;
import com.duan.utils.FrameUtils;

/**
 * 一个根部菜单项，点击此项时，可以打开一个新窗体。 打开的新窗体将获得焦点，并使主窗体不可操作。 新窗体关闭后，主窗体获得焦点并可操作。
 * 新窗体必须继承自CanStartFrame
 * 
 * @author Administrator
 *
 */
public class NewFrameModuleItem extends JMenuItem {

	private static final long serialVersionUID = -1536877957169306464L;

	/**
	 * 创建根部菜单项
	 * 
	 * @param name      菜单项名称
	 * @param className 所要开启的新窗体className
	 * @param mainFrame 主窗体
	 */
	public NewFrameModuleItem(String name, String className, JFrame mainFrame) {
		setText(name);
		FontUtils.setDefaultFont(this);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					CanStartFrame jMenuItemStartFrame = (CanStartFrame) Class.forName(className).getConstructor()
							.newInstance();
					// 设置锁定与解锁
					FrameUtils.clockAndUnclockFatherFrame(mainFrame, jMenuItemStartFrame);
				} catch ( ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (NoSuchMethodException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (SecurityException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}

			}
		});
	}

}
