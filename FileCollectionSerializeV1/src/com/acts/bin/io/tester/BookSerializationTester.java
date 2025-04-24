package com.acts.bin.io.tester;


import static java.time.LocalDate.parse;

import java.io.File;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import com.acts.bin.io.Book;
import com.acts.bin.io.BookType;
import com.acts.bin.io.util.BinFileIOUtils;

public class BookSerializationTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter file name:");
			String fileName = sc.nextLine();
			File file = new File(fileName);
			if(!file.exists()) {
				file.createNewFile();
			}
			// Read Books.
			//Optional<Map<String, Book>> optionalMap = BinFileIOUtils.readBooks(fileName);
			//Map<String, Book> booksMap = optionalMap.orElse(new HashMap<String, Book>());
			Map<String, Book> booksMap = BinFileIOUtils.readBooks(fileName);

			System.out.println("Initial Book Map:" + booksMap);
			boolean exit = false;
			int choice = 0;
			while (!exit) {
				System.out.println(
						"\n 1.Add Book"
								+ "\n 2.Update Book Price"
								+ "\n 3.Print all Books"
								+ "\n 4.Display books sorted by Prices"
								+ "\n 5.Filter by Type"
								+ "\n 6.Remove a book "
								+ "\n 0.Save in file and Exit");
				
				System.out.println("Please enter choice:");
				choice = sc.nextInt();
				try {
					switch (choice) {
					case 1: {//Add book
						//Get book details from user
						System.out.println("Enter ISBN");
						String isbn = sc.next();

						System.out.println("Enter Title");
						String title = sc.next();

						System.out.println("Enter Author");
						String author = sc.next();

						System.out.println("Enter Book Type");
						String bookType = sc.next();

						System.out.println("Enter publish date in yyyy-MM-dd format");
						String publishDate = sc.next();

						System.out.println("Enter Price");
						Double price = sc.nextDouble();

						Book b1 = new Book(isbn, title, author, BookType.valueOf(bookType), parse(publishDate), price);
						booksMap.put(b1.getIsbn(), b1);
					} break;
					case 2: {
						System.out.println("Enter Book ISBN");
						String isbn = sc.next();
						Book book = booksMap.get(isbn);
						if (null == isbn) {
							System.out.println("Book Not Found");
						} else {
							System.out.println("Book Found");
							System.out.println("Enter new Book Price");
							Double price = sc.nextDouble();
							book.setPrice(price);
							System.out.println("Book price updated");
						}
					} break;
					case 3: {
						System.out.println("All Books ");
						booksMap.forEach((k, v) -> System.out.println(v));
					}break;
					case 4: {
						// Map-> values -> Collection<Book> -> stream() -> Sort -> Print
						System.out.println("Sorted Books : ");
						booksMap.values().stream().sorted(Comparator.comparing(Book::getPrice))
						.forEach(System.out::println);
					}break;
					
					case 5: {
						// Map-> values -> Collection<Book> -> stream() -> filter -> Print
						System.out.println("Enter Book Type");
						String bookType = sc.next();
						System.out.println("Filtered Books : ");
						booksMap.values().stream().filter((b)-> b.getBookType().equals(BookType.valueOf(bookType)))
						.forEach(System.out::println);
					}break;

					case 6: // Remove Book 
						System.out.println("Enter ISBN");
						String isbn = sc.next();
						Book book = booksMap.remove(isbn);
						if (null == isbn) {
							System.out.println("Book Not Found");
						} else {
							System.out.println("Book removed :" + book);
						}
						break;
					case 0:
						exit = true;
						// store product details before exiting
						BinFileIOUtils.saveBooks(booksMap, fileName);
						System.out.println("Saved books in File");
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				sc.nextLine(); // Eater
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
