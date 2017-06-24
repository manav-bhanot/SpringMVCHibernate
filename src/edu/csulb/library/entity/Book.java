/**
 * 
 */
package edu.csulb.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Manav
 *
 */

@Entity
@Table(name = "Book")
public class Book {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "title")
	private String title;

	@Column(name = "author")
	String author;

	public Book() {
	}

	public Book(String id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}

	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Book : " + this.id + ", " + this.title + ", " + this.author;
	}

}
