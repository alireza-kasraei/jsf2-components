package net.devk.core.util;

import java.text.ParseException;
import java.util.Date;

import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.ULocale;

public class JalaliDateUtil {

	private static final String FARSI_LOCALE = "@calendar=persian";
	private static final String JALALI_YEAR_PATTERN = "yyyy/MM/dd";
	private static ULocale locale = new ULocale(FARSI_LOCALE);

	public static String toString(Date date) {
		Calendar calendar = Calendar.getInstance(locale);
		calendar.setTime(date);
		SimpleDateFormat dateFormat = new SimpleDateFormat(JALALI_YEAR_PATTERN, locale);
		return dateFormat.format(date);
	}

	public static Date toDate(String date) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(JALALI_YEAR_PATTERN, locale);
		return simpleDateFormat.parse(date);
	}

}
