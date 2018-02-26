package net.devk.core.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class JalaliDateUtilTest {

	@Test
	public void testDateToString() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2017);
		calendar.set(Calendar.MONTH, Calendar.NOVEMBER);
		calendar.set(Calendar.DAY_OF_MONTH, 29);
		Assert.assertEquals("1396/09/08", JalaliDateUtil.toString(calendar.getTime()));
	}

	@Test
	public void testStringToDate() throws ParseException {
		Date date = JalaliDateUtil.toDate("1396/09/08");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Assert.assertEquals(2017, calendar.get(Calendar.YEAR));
		Assert.assertEquals(Calendar.NOVEMBER, calendar.get(Calendar.MONTH));
		Assert.assertEquals(29, calendar.get(Calendar.DAY_OF_MONTH));
	}

}
