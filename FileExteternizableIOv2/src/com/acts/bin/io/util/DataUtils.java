package com.acts.bin.io.util;

import static com.acts.bin.io.BookType.COMEDY;
//Static import for Enum Value
import static com.acts.bin.io.BookType.FICTION;
import static com.acts.bin.io.BookType.TECH;
import static com.acts.bin.io.BookType.THRILLER;
//Static import for parse method
import static java.time.LocalDate.parse;

import java.util.ArrayList;
import java.util.List;

import com.acts.bin.io.Book;

public interface DataUtils {
	public static List<Book> getBooksList(){
		List<Book> booksList = new ArrayList<>();
		booksList.add(new Book("978-100", "Java 8 IN ACTION", "Raoul-Gabriel", TECH, parse("2010-04-24"), 800.00));
		booksList.add(new Book("978-101", "Java FAQ", "Jonni M. Kanerva", TECH, parse("2012-10-18"), 600.00));
		booksList.add(new Book("978-900", "Head First Java", "Kathy Sierra", TECH, parse("2015-04-20"), 1700.00));
		booksList.add(new Book("978-140", "I Too Had a Love Story", " Ravinder Singh", FICTION, parse("1988-08-30"), 400.00));
		booksList.add(new Book("978-150", "Brutal", "Uday Satpathy", THRILLER, parse("2010-04-24"), 600.00));
		booksList.add(new Book("978-160", "Asa Mi Asami", "P. L. Deshapande", COMEDY, parse("1984-04-24"), 250.00));
		return booksList;
	}
}
