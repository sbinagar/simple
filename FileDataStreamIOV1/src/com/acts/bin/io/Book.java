package com.acts.bin.io;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable{
	private static final long serialVersionUID = -3343568466418384658L;
	//An ISBN is an International Standard Book Number
	//EX: 978-93-5119-743-0 for Java 8 in action  ( dreamtech)
	private String isbn; 
	private String title;
	private String author;
	private BookType bookType;
	//New feature java 8 (yyyy-MM-dd)
	private LocalDate publishDate;
	private Double price;
	
	public Book() {
		super();
	}
	
	public Book(String isbn, String title, String author, BookType bookType, LocalDate publishDate, Double price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.bookType = bookType;
		this.publishDate = publishDate;
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BookType getBookType() {
		return bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", bookType=" + bookType
				+ ", publishDate=" + publishDate + ", price=" + price + "]";
	}
}
