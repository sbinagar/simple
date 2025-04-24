package com.acts.bin.io.util;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Optional;

import com.acts.bin.io.Book;

public interface BinFileIOUtils {

	// Using Object Output Stream to write Books
	public static void saveBooks(Map<String, Book> booksMap, String fileName) throws IOException{
		// Java Appln -> OOS -> Binary Stream -> FOS -> File
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(fileName))) {
			oos.writeObject(booksMap);
		}
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Book> readBooks(String fileName) throws IOException, ClassNotFoundException{
		// Java Appln -> OOS -> Binary Stream -> FOS -> File
		Map<String, Book> bookMap = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			bookMap = (Map<String, Book>)ois.readObject();
		} catch (EOFException eof) {
			System.out.println("Stop Reading");
		}
		return bookMap;
	}
}
