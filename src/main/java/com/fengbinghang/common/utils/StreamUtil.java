package com.fengbinghang.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamUtil {
	/*
	 * 方法1：批量关闭流，参数能传入无限个。(10分)
	 * 例如传入FileInputStream对象、JDBC中Connection对象都可以关闭，并且参数个数不限。
	 */
	public static void closeAll(AutoCloseable... autoCloseables) {
		if (autoCloseables != null && autoCloseables.length > 0) {
			for (AutoCloseable autoCloseable : autoCloseables) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * 方法2：传入一个文本文件对象，默认为UTF-8编码，返回该文件内容(10分)，要求方法内部调用上面第1个方法关闭流(5分)
	 */
	public static String readTextFile(InputStream src) {
		BufferedReader re = null;
		try {
			re = new BufferedReader(new InputStreamReader(src, "utf-8"));
			StringBuffer sb = new StringBuffer();
			String str = "";
			do {
				str = re.readLine();
				sb.append(str);
			} while (str.length() > 0);
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "文件读取错误";
		} finally {
			closeAll(re);
		}
	}

	/*
	 * 方法3：传入文本文件对象，返回该文件内容(10分)，并且要求内部调用上面第2个方法(5分)。* 这是典型的方法重载，记住了吗？少年…
	 */
	public static String readTextFile(File txtFile) {
		try {
			return readTextFile(new FileInputStream(txtFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "文件读取错误";
		}
	}

}
