package com.oooffers.common.util;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oooffers.common.util.exception.EOAException;
import com.oooffers.common.util.exception.EOAExceptionUtil;
import com.oooffers.common.util.exception.ErrorCode;

/**
 * 
 * @author Zrieq
 * 
 */
public class Util {

	private final static Logger LOG = LoggerFactory.getLogger(Util.class);

	private Util() {
	}

	private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		}
	};

	public static String formatDate(Date date) {
		return formatter.get().format(date);
	}

	public static Date parseDate(String date) throws EOAException {
		String methodName = "parseDate";
		try {
			return formatter.get().parse(date);
		} catch (ParseException e) {
			EOAExceptionUtil.logAndRethrowEOAException(LOG, ErrorCode.EOA_PARSING_ERROR, methodName, e.getMessage(), e);
		}
		return null;
	}

	public static Date addDaysToDate(Date date, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, days);
		return c.getTime();
	}

	public static int getDifferenceDays(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();
		return new Integer(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + "");
	}

	public static String returnMapEntriesAsString(Map map) {
		StringBuilder sb = new StringBuilder();
		if (map != null) {
			Iterator<Entry> iter = map.entrySet().iterator();
			while (iter.hasNext()) {
				Entry entry = iter.next();
				sb.append(entry.getKey());
				sb.append('=').append('"');
				sb.append(entry.getValue());
				sb.append('"');
				if (iter.hasNext()) {
					sb.append(',').append(' ');
				}
			}
		}
		return sb.toString();
	}

	public static String returnMapEntriesAsQueryString(Map map) {
		StringBuilder sb = new StringBuilder();
		Iterator<Entry> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Entry entry = iter.next();
			sb.append(entry.getKey());
			sb.append('=');
			sb.append(entry.getValue());
			if (iter.hasNext()) {
				sb.append('&');
			}
		}
		return sb.toString();
	}

	public static String getString(ResourceBundle bundle, String key, Object... params) {
		try {
			return MessageFormat.format(bundle.getString(key), params);
		} catch (MissingResourceException e) {
			LOG.error("Missing resource bundle: ", e);
			return '!' + key + '!';
		}
	}

}
