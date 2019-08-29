package com.duan.utils;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeUtils {
	/**
	 * 输入文件的文件夹，文件前缀，文件后缀名称，保存文件 c:/data/a.xls
	 * 
	 * @param serializable 要序列化的对象
	 * @param messComp     信息提示框
	 * @param folderPath   文件夹名称 如：c:/data
	 * @param firstName    文件前缀名称 如：a
	 * @param lastName     文件后缀名称 如：xls
	 * @return
	 */
	public static boolean seriallized(Serializable serializable, Component messComp, String folderPath,
			String firstName, String lastName) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			File floder = new File(folderPath);
			File file = new File(folderPath + "/" + firstName + "." + lastName);
			if (!floder.exists()) { // 若文件的目录不存在则创建
				floder.mkdirs();
			} 
			if (!file.exists()) {// 判断文件是否存在
				boolean isScucess = file.createNewFile();// 不存在先创建
				if (!isScucess) {
					JOptionPaneUtils.warningMess(messComp, firstName + "所输入文件名含有非法字符，请重新输入");
					return false;
				}
			} else {
				boolean isCover = JOptionPaneUtils.selectMess(messComp, "文件已存在，点击是覆盖文件，点击否重新命名");
				if (!isCover) {
					return false;
				}
			}
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(serializable);
			return true;
		} catch (IOException e1) {
			JOptionPaneUtils.warningMess(messComp, "文件正在被占用，请先关闭");
			e1.printStackTrace();
		} finally {
			StreamUtils.close(oos);
			StreamUtils.close(fos);
		}
		return false;
	}

	/**
	 * 弹出填写名称对话框，将对象序列化保存 如：c:/data/a.xls
	 * 
	 * @param serializableObject 需要序列化的對象
	 * @param messComp           信息提示框
	 * @param folderName         文件夹名称 c:/data/
	 * @param lastName           要保存的文件的后缀名 .xls
	 * @return
	 */
	public static boolean seriallized(Serializable serializable, Component messComp, String folderName,
			String lastName) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			// 弹出输入文件名对话框
			String firstName = JOptionPaneUtils.inPutFileNameMess(messComp);
			if (firstName == null) {
				return false;
			}
			while (firstName.trim().equals("")) {
				JOptionPaneUtils.warningMess(messComp, "所输入的文件名为空");
				firstName = JOptionPaneUtils.inPutFileNameMess(messComp);
				if (firstName == null) {
					return false;
				}
			}
			File floder = new File(Constant.SERIALIZEFOLDER_PATH + "/" + folderName + "/");
			File file = new File(Constant.SERIALIZEFOLDER_PATH + "/" + folderName + "/" + firstName + "." + lastName);
			// 若文件的目录不存在则创建
			if (!floder.exists()) {
				floder.mkdirs();
			}
			// 判断文件是否存在
			if (!file.exists()) {
				boolean isScucess = file.createNewFile();// 不存在先创建
				while (!isScucess) {
					JOptionPaneUtils.warningMess(messComp, firstName + "所输入文件名含有非法字符，请重新输入");
					firstName = JOptionPaneUtils.inPutFileNameMess(messComp);
					if (firstName == null) {
						return false;
					}
					while (firstName.trim().equals("")) {
						JOptionPaneUtils.warningMess(messComp, "所输入的文件名为空");
						firstName = JOptionPaneUtils.inPutFileNameMess(messComp);
						if (firstName == null) {
							return false;
						}
					}
					file = new File(
							Constant.SERIALIZEFOLDER_PATH + "/" + folderName + "/" + firstName + "." + lastName);
					isScucess = file.createNewFile();
				}
			} else {
				boolean isCover = JOptionPaneUtils.selectMess(messComp, "文件已存在，点击是覆盖文件，点击否重新命名");
				if (!isCover) {
					return false;
				}
			}
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(serializable);
			return true;
		} catch (IOException e1) {
			JOptionPaneUtils.warningMess(messComp, "文件正在被占用，请先关闭");
			e1.printStackTrace();
		} finally {
			StreamUtils.close(oos);
			StreamUtils.close(fos);
		}
		return false;
	}

	/**
	 * 将filePaht文件反序列化
	 * 
	 * @param filePath
	 * @return
	 */
	public static Object deSerializable(File file, Component messComp) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			return ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			JOptionPaneUtils.warningMess(messComp, "文件正在被占用，请先关闭");
			e.printStackTrace();
		} finally {
			StreamUtils.close(ois);
			StreamUtils.close(fis);
		}
		return null;
	}
}
