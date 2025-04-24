package com.acts.bin.io.tester;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.acts.bin.io.Book;
import com.acts.bin.io.util.BinFileIOUtils;
import com.acts.bin.io.util.DataUtils;


public class TestFileObjectSaveTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter file name:");
			String fileName = sc.nextLine();
			List<Book> booksList = DataUtils.getBooksList();
			
//			//Save many book
//			BinFileIOUtils.saveBooks(booksList, fileName);
//			System.out.println("*****Books saved successfully*****");
			
			//Read many book
			List<Book> booksFromFile = BinFileIOUtils.readBooks(fileName);
			System.out.println("Book read:"+ booksFromFile);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
