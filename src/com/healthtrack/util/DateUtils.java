package com.healthtrack.util;

import java.text.ParseException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Date;


public class DateUtils {
	public static Date ConverterParaData (String date) throws ParseException {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate newDate = LocalDate.parse(date, formatter);
			
			java.sql.Date data = java.sql.Date.valueOf(newDate);
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
