package com.duan.utils;

import java.io.File;
import java.util.Date;

public class FileUtils {
	/**
	 * 删除文件
	 * @param filePath
	 * @return
	 */
	public static boolean deleteFile(String filePath) {
		File file = new File(filePath);	
		if (file.isFile() && file.exists()) {
			boolean isSucess=file.delete();		
			if(isSucess) {
				return true;
			}
			return false;
		} else {			
			return false;
		}

	}

	/**
	 * 创建一个文件夹
	 * @param filePath
	 * @return
	 */
	public static boolean creatFolder(String filePath) {
		// TODO Auto-generated method stub
		File file = new File(filePath);
		file = new File(new File(filePath).getAbsolutePath());
		if (file.exists()) {
			return true;
		}
		file.mkdirs();
		return true;
	}
	/**
	 * 获得文件最后修改日期
	 * @param filePath
	 * @return
	 */
	public static String getLastModifiedTime(String filePath) {
		// TODO Auto-generated method stub
		File f = new File(filePath);
		long time = f.lastModified();
		Date date = new Date(time);
		return DateUtils.parseDateToStringDay(date);

	}

	/**
	 * 删除文件夹及其下所有文件
	 * @param sPath
	 * @return
	 */
	public static boolean deleteDirectory(String folderPath) {
		if (!folderPath.endsWith(File.separator)) {
			folderPath = folderPath + File.separator;
		}
		File dirFile = new File(folderPath);
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			return false;
		}
		boolean flag = true;
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag)
					break;
			} 
			else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
		}
		if (!flag)
			return false;
		if (dirFile.delete()) {
			return true;
		} else {
			return false;
		}
	}
}
