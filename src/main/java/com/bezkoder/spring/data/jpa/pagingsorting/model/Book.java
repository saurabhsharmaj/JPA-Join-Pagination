package com.bezkoder.spring.data.jpa.pagingsorting.model;

import javax.persistence.*;

@Entity
@Table(name = "books",schema = "testdb")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "book_title")
	private String bookTitle;

	@Column(name = "description")
	private String description;

	public Book() {

	}

	public Book(String title, String description) {
		this.bookTitle = title;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
