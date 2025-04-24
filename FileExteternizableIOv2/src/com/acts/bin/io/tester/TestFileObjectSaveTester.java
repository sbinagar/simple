package com.acts.bin.io.tester;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.acts.bin.io.Book;
import com.acts.bin.io.util.DataUtils;


public class TestFileObjectSaveTester {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter file name:");
			String fileName = sc.nextLine();
			//Getting first book from list
			Book book = DataUtils.getBooksList().get(0);

			//Serialize Book
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(book);
			oos.flush();
			oos.close();

			//De-serialize Book
			FileInputStream fis	= new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Book bookRead = (Book)ois.readObject();
			ois.close();
			System.out.println("Book Original:"+ book);
			System.out.println("Book read:"+ bookRead);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
