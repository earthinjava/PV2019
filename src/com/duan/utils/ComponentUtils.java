package com.duan.utils;

import java.awt.Component;

public class ComponentUtils {

	/**
	 * 获得根部组件
	 * 
	 * @param childComponent
	 * @return
	 */
	public static Component getRootComponent(Component childComponent) {
		while (childComponent != null && childComponent.getParent() != null) {
			childComponent = childComponent.getParent();
		}
		return childComponent;
	}

}
