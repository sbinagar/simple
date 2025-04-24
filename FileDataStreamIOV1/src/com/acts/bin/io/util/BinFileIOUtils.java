package com.acts.bin.io.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.acts.bin.io.Book;
import com.acts.bin.io.BookType;


public interface BinFileIOUtils {

	//Static method for saveBook one at a time
	public static void saveBook(Book book, String fileName) throws IOException {
		// Java Appln -> DOS : Use java Datatypes Primitive/Wrapper : Bin  -> Buffer OS->  Bin File
		try (DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream(fileName)))) {
			// UTF for writing string
			dos.writeUTF(book.getIsbn());
			// Title
			dos.writeUTF(book.getTitle());
			// Author
			dos.writeUTF(book.getAuthor());
			// Book Type  in string format
			dos.writeUTF(book.getBookType().toString());
			// publish date
			dos.writeUTF(book.getPublishDate().toString());
			// price
			dos.writeDouble(book.getPrice());
			dos.flush();
		} //close dos
	}

	//Static method to read one Book at a time
	public static Book readBook(String fileName) throws IOException {
		// Check for file exits and then read file
		File file = new File(fileName);
		// validation
		if (file.exists() && file.canRead()) {
			// Java Appln <- DIS <- BIS <- FIS <- Binary file
			try (DataInputStream dis = new DataInputStream(
					new BufferedInputStream(new FileInputStream(fileName)))) {
				String isbn = dis.readUTF();
				String title = dis.readUTF(); 
				String author = dis.readUTF();
				BookType type = BookType.valueOf(dis.readUTF());
				LocalDate pubDate = LocalDate.parse(dis.readUTF());
				Double price = dis.readDouble();
				return new Book(isbn, title, author, type, pubDate, price);
			}
		} else {
			System.out.println("File does not exists");
		}
		return null;
	}

	//Static method for saveBooksList 
	//Public can be ignore as by default method is public in I/F
	public static void saveBooksList(List<Book> booksList, String fileName) throws IOException {
		// Java Appln -> DOS : Use java Datatypes Primitive/Wrapper : Bin  -> Buffer OS->  Bin File
		try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {

			for(Book book : booksList) {
				// UTF for writing string
				dos.writeUTF(book.getIsbn());
				// Title
				dos.writeUTF(book.getTitle());
				// Author
				dos.writeUTF(book.getAuthor());
				// Book Type  in string format
				dos.writeUTF(book.getBookType().toString());
				// publish date
				dos.writeUTF(book.getPublishDate().toString());
				// price
				dos.writeUTF(book.getPrice().toString());
				//Flush to write data in file from stream
				dos.flush();
			}
		} //close dos
	}

	//Static method to read one Book at a time
	public static List<Book> readBooksList(String fileName) throws IOException {
		// Check for file exits and then read file
		List<Book> booksList = new ArrayList<Book>();
		File file = new File(fileName);
		// validation
		if (file.exists() && file.canRead()) {
			// Java Appln <- DIS <- BIS <- FIS <- Binary file
			try (DataInputStream dis = new DataInputStream(
					new BufferedInputStream(new FileInputStream(fileName)))) {
				while(dis.available() > 0) {
					String isbn = dis.readUTF();
					String title = dis.readUTF(); 
					String author = dis.readUTF();
					BookType type = BookType.valueOf(dis.readUTF());
					LocalDate pubDate = LocalDate.parse(dis.readUTF());
					Double price = dis.readDouble();
					Book b = new Book(isbn, title, author, type, pubDate, price);
					booksList.add(b);
				}
			}
		} else {
			System.out.println("File does not exists");
		}
		return booksList;
	}
}
