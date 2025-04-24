package com.acts.bin.io;

import java.time.LocalDate;
import java.util.Optional;

public class ValidationUtils {
	//get enum from String
	public static Optional<BookType> getValidCourse(String bookType) {
		BookType bookEnum = null;
		try {
			bookEnum = BookType.valueOf(bookType);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(bookEnum);
	}
	
	public static Optional<LocalDate> validatePublishDate(String strDob) {
		LocalDate publishDate = LocalDate.parse(strDob);
		LocalDate today = LocalDate.now();
		LocalDate date = null;
		if(publishDate.isBefore(today)) {
			date = publishDate;
		}
		return Optional.ofNullable(date);
	}

}
