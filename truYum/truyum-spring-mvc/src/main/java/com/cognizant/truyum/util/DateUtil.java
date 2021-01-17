package com.cognizant.truyum.util;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date convertToDate(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date parsedDate = sdf.parse(date);
		return parsedDate;
	}
}
