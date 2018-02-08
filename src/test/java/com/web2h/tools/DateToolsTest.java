package com.web2h.tools;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.web2h.tools.DateTools;

public class DateToolsTest {

	@Test
	public void addDays() {
		Date date1 = new Date();
		Date date2 = DateTools.addDays(date1, 2);
		assertThat(date2.getTime() - date1.getTime(), is(1000l * 60 * 60 * 24 * 2));

		try {
			DateTools.addDays(null, 2);
			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}

		date1 = new Date();
		date2 = DateTools.addDays(date1, 0);
		assertThat(date2.getTime() - date1.getTime(), is(0l));
	}

	@Test
	public void addYears() {
		Date date1 = new Date();
		Date date2 = DateTools.addYears(date1, 10);
		assertThat(date2.getTime() - date1.getTime(), greaterThanOrEqualTo(1000l * 60 * 60 * 24 * 365 * 10 + 1000l * 60 * 60 * 24 * 2));
		assertThat(date2.getTime() - date1.getTime(), lessThanOrEqualTo(1000l * 60 * 60 * 24 * 365 * 10 + 1000l * 60 * 60 * 24 * 3));

		try {
			DateTools.addYears(null, 2);
			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}

		date1 = new Date();
		date2 = DateTools.addYears(date1, 0);
		assertThat(date2.getTime() - date1.getTime(), is(0l));
	}

	@Test
	public void removeYears() {
		Date date1 = new Date();
		Date date2 = DateTools.removeYears(date1, 10);
		assertThat(date1.getTime() - date2.getTime(), greaterThanOrEqualTo(1000l * 60 * 60 * 24 * 365 * 10 + 1000l * 60 * 60 * 24 * 2));
		assertThat(date1.getTime() - date2.getTime(), lessThanOrEqualTo(1000l * 60 * 60 * 24 * 365 * 10 + 1000l * 60 * 60 * 24 * 3));

		try {
			DateTools.removeYears(null, 2);
			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}

		date1 = new Date();
		date2 = DateTools.removeYears(date1, 0);
		assertThat(date2.getTime() - date1.getTime(), is(0l));
	}

	@Test
	public void removeDays() {
		Date date1 = new Date();
		Date date2 = DateTools.removeDays(date1, 2);
		assertThat(date1.getTime() - date2.getTime(), is(1000l * 60 * 60 * 24 * 2));

		try {
			DateTools.addDays(null, 2);
			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}

		date1 = new Date();
		date2 = DateTools.addDays(date1, 0);
		assertThat(date2.getTime() - date1.getTime(), is(0l));
	}

	@Test
	public void toStringWithDefaultFormat() {

		Calendar calendar = Calendar.getInstance();
		calendar.set(2014, 05, 01, 10, 35, 25);

		String formattedDate = DateTools.toString(new Date(calendar.getTimeInMillis()));
		assertThat(formattedDate, is("2014-06-01 10:35:25"));
	}

	@Test
	public void toStringWithCustomFormat() {

		Calendar calendar = Calendar.getInstance();
		calendar.set(2014, 05, 01, 10, 35, 25);

		String formattedDate = DateTools.toString(new Date(calendar.getTimeInMillis()), "dd-MM-yyyy");
		assertThat(formattedDate, is("01-06-2014"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void toStringWithWrongFormat() {

		Calendar calendar = Calendar.getInstance();
		calendar.set(2014, 05, 01, 10, 35, 25);

		DateTools.toString(new Date(calendar.getTimeInMillis()), "dd-MM-xfdrt");
	}

	@Test
	public void toDateWithDefaultFormat() {
		String dateString = "2011-01-05 15:00:01";
		Date date = DateTools.toDate(dateString);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		assertThat(calendar.get(Calendar.YEAR), is(2011));
		assertThat(calendar.get(Calendar.MONTH), is(0));
		assertThat(calendar.get(Calendar.DAY_OF_MONTH), is(5));
		assertThat(calendar.get(Calendar.HOUR_OF_DAY), is(15));
		assertThat(calendar.get(Calendar.MINUTE), is(0));
		assertThat(calendar.get(Calendar.SECOND), is(1));
	}

	@Test
	public void toDateWithCustomFormat() {
		String dateString = "2011/01/05 15:00";
		Date date = DateTools.toDate(dateString, "yyyy/MM/dd HH:mm");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		assertThat(calendar.get(Calendar.YEAR), is(2011));
		assertThat(calendar.get(Calendar.MONTH), is(0));
		assertThat(calendar.get(Calendar.DAY_OF_MONTH), is(5));
		assertThat(calendar.get(Calendar.HOUR_OF_DAY), is(15));
		assertThat(calendar.get(Calendar.MINUTE), is(0));
	}
}
