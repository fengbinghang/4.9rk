package fengbinghang_utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.fengbinghang.common.utils.DateUtil;

public class MyTest {

	@Test
	public void t1() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = sdf.parse("2020-2-21 12:12:12");
		String sql = "select * from t_order where create_time>='{1}' and create_time<='{2}' ";
		sql = sql.replace("{1}", sdf.format(DateUtil.getDateByInitMonth(d)));
		sql = sql.replace("{2}", sdf.format(DateUtil.getDateByFullMonth(d)));
		System.out.println(sql);
	}

}
