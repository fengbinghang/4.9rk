package com.fengbinghang.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/*
	 * 方法1：(10分) 给一个时间对象，返回该时间所在月的1日0时0分0秒。例如一个Date对象的值是2019-05-18 11:37:22
	 * 则返回的结果为2019-05-01 00:00:00
	 */

	public static Date getDateByInitMonth(Date src) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(src);
		Date d = new Date();
		try {
			d = sdf.parse(str.substring(0, 8) + "01 00:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	/*
	 * 方法2：(10分) 给任意一个时间对象，返回该时间所在月的最后日23时59分59秒，需要考虑月大月小和二月特殊情况。
	 * 例如一个Date对象的值是2019-05-18 11:37:22，则返回的时间为2019-05-31 23:59:59
	 * 例如一个Date对象的值是2019-02-05 15:42:18，则返回的时间为2019-02-28 23:59:59
	 */
	public static Date getDateByFullMonth(Date src) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(src);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;// 西方日历从0月开始到11月结束
		// 31:1 3 5 7 8 10 12
		// 28/29:2
		// 30:4 6 9 11
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			cal.set(Calendar.DAY_OF_MONTH, 30);
		} else if (month == 2) {
			if (year % 4 == 0 || year % 400 == 0) {
				cal.set(Calendar.DAY_OF_MONTH, 29);
			} else {
				cal.set(Calendar.DAY_OF_MONTH, 28);
			}
		} else {
			cal.set(Calendar.DAY_OF_MONTH, 31);
		}
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

}
