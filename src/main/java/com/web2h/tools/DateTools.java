package com.web2h.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Date utils class
 * 
 * @author Web2h
 */
public final class DateTools {

	private final static String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * Adds x days to the given date.
	 * 
	 * @param date
	 *            Date to which add the days
	 * @param days
	 *            Number of days to add
	 * @return Date with the x added days
	 */
	public static Date addDays(final Date date, final int days) {
		return DateTools.add(date, Calendar.DATE, days);
	}

	/**
	 * Adds x minutes to the given date.
	 * 
	 * @param date
	 *            Date to which add the minutes
	 * @param minutes
	 *            Number of minutes to add
	 * @return Date with the x added minutes
	 */
	public static Date addMinutes(final Date date, final int minutes) {
		return DateTools.add(date, Calendar.MINUTE, minutes);
	}

	/**
	 * Adds x months to the given date.
	 * 
	 * @param date
	 *            Date to which add the months
	 * @param days
	 *            Number of months to add
	 * @return Date with the x added months
	 */
	public static Date addMonths(final Date date, final int months) {
		return DateTools.add(date, Calendar.MONTH, months);
	}

	/**
	 * Adds x seconds to the given date.
	 * 
	 * @param date
	 *            Date to which add the seconds
	 * @param days
	 *            Number of seconds to add
	 * @return Date with the x added seconds
	 */
	public static Date addSeconds(final Date date, final int seconds) {
		return DateTools.add(date, Calendar.SECOND, seconds);
	}

	/**
	 * Adds x years to the given date.
	 * 
	 * @param date
	 *            Date to which add the years
	 * @param days
	 *            Number of years to add
	 * @return Date with the x added years
	 */
	public static Date addYears(final Date date, final int years) {
		return DateTools.add(date, Calendar.YEAR, years);
	}

	/**
	 * Returns a date at the start of the day.
	 * 
	 * @param date
	 *            The date parameter
	 * @return The date at the start of the day
	 */
	public static Date atStartOfDay(final Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * Converts a date given in string to a Date instance.
	 * 
	 * @param stringDate
	 *            The date in string
	 * @param format
	 *            The format in which the date is
	 * @return The Date instance, returns null if the parsing could not be done
	 */
	public static Date toDate(final String stringDate, final String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setLenient(false);
		try {
			return dateFormat.parse(stringDate);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * Converts a date given in string to a Date instance using the default format (yyyy-MM-dd HH:mm:ss).
	 * 
	 * @param stringDate
	 *            The date in string
	 * @return The Date instance, returns now if the parsing could not be done
	 */
	public static Date toDate(final String stringDate) {
		return toDate(stringDate, DEFAULT_FORMAT);
	}

	/**
	 * Gives a string representation of a date following the default format yyyy/MM/dd HH:mm:ss
	 * 
	 * @param date
	 *            The date to convert
	 * @return The string representation of the date
	 */
	public static String toString(Date date) {
		return toString(date, null);
	}

	/**
	 * Gives a string representation of a date following the given format
	 * 
	 * @param date
	 *            The date to convert
	 * @param format
	 *            The format to follow for the conversion
	 * @return The string representation of the date
	 */
	public static String toString(Date date, String format) {
		if (date == null) {
			return null;
		}
		DateFormat dateFormat = null;
		if (format == null) {
			dateFormat = new SimpleDateFormat(DEFAULT_FORMAT);
		} else {
			dateFormat = new SimpleDateFormat(format);
		}
		String dateString = dateFormat.format(date);
		return dateString;
	}

	/**
	 * Removes x days from the given date.
	 * 
	 * @param date
	 *            Date from which remove the days
	 * @param days
	 *            Number of days to remove
	 * @return Date with the x days removed
	 */
	public static Date removeDays(final Date date, final int days) {
		return DateTools.add(date, Calendar.DATE, -days);
	}

	/**
	 * Removes x minutes from the given date.
	 * 
	 * @param date
	 *            Date from which remove the minutes
	 * @param minutes
	 *            Number of minutes to remove
	 * @return Date with the x removed minutes
	 */
	public static Date removeMinutes(final Date date, final int minutes) {
		return DateTools.add(date, Calendar.MINUTE, -minutes);
	}

	/**
	 * Removes x months from the given date.
	 * 
	 * @param date
	 *            Date from which remove the months
	 * @param months
	 *            Number of months to remove
	 * @return Date with the x removed months
	 */
	public static Date removeMonth(final Date date, final int months) {
		return DateTools.add(date, Calendar.MONTH, -months);
	}

	/**
	 * Removes x seconds from the given date.
	 * 
	 * @param date
	 *            Date from which remove the seconds
	 * @param seconds
	 *            Number of seconds to remove
	 * @return Date with the x removed seconds
	 */
	public static Date removeSeconds(final Date date, final int seconds) {
		return DateTools.add(date, Calendar.SECOND, -seconds);
	}

	/**
	 * Removes x years from the given date.
	 * 
	 * @param date
	 *            Date from which remove the years
	 * @param years
	 *            Number of years to remove
	 * @return Date with the x removed years
	 */
	public static Date removeYears(final Date date, final int years) {
		return DateTools.add(date, Calendar.YEAR, -years);
	}

	/**
	 * Adds/removes a amount of time (defined by calendarField) to/from the given date
	 * 
	 * @param date
	 *            Date to be altered
	 * @param calendarField
	 *            Calendar field (day, month, minute, ...)
	 * @param amount
	 *            Amount of time to add or remove
	 * @return The altered date (If the calendarField isn't recognized, return the input date)
	 */
	private static Date add(final Date date, final int calendarField, int amount) {
		if (calendarField != Calendar.DATE && calendarField != Calendar.HOUR && calendarField != Calendar.MINUTE && calendarField != Calendar.SECOND && calendarField != Calendar.MONTH
				&& calendarField != Calendar.YEAR) {
			// Field must be either Calendar.SECOND, Calendar.MINUTE, Calendar.HOUR, Calendar.DATE, Calendar.MONTH or Calendar.YEAR
			return date;
		}
		Calendar calendar = Calendar.getInstance();
		if (date == null) {
			calendar.setTime(new Date());
		} else {
			calendar.setTime(date);
		}
		calendar.add(calendarField, amount);
		return calendar.getTime();
	}
}