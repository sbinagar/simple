package com.acts.bin.io.util;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.acts.bin.io.Book;

public interface BinFileIOUtils {

	// Using Object Output Stream to write Books
	public static void saveBooks(List<Book> booksList, String fileName) throws IOException{
		// Java Appln -> OOS -> Binary Stream -> FOS -> File
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(fileName))) {
			for(Book book : booksList) {
				oos.writeObject(book);
			}
		}
	}
	
	public static List<Book> readBooks(String fileName) throws IOException, ClassNotFoundException{
		// Java Appln -> OOS -> Binary Stream -> FOS -> File
		List<Book> booksList = new ArrayList<Book>();
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(fileName))) {
			Book book;
			//while(true) {
			for(;;) {
				book = (Book)ois.readObject();
				booksList.add(book);
			}
		} catch (EOFException eof) {
			System.out.println("Stop Reading");
		}
		return booksList;
	}
}
