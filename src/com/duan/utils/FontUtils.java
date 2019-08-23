package com.duan.utils;

import java.awt.Component;
import java.awt.Font;

public class FontUtils {
	/**
	 * 更改此字体可以修改所有组件的字体
	 * 
	 * @param component
	 */
	public static void setDefaultFont(Component component) {
		if (component == null) {
			return;
		}
		component.setFont(Constant.DEFAULT_FONT);		
	}

	/**
	 * 设为宋体18
	 * 
	 * @param component
	 */
	public static void setFontSong18(Component component) {
		if (component == null) {
			return;
		}
		component.setFont(new Font("宋体", Font.PLAIN, 18));
	}

	public static void setFont12(Component component) {
		if (component == null) {
			return;
		}
		component.setFont(Constant.FONT_SONG12);			
	}
}
