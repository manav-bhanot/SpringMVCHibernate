/**
 * 
 */
package edu.csulb.library.model;

import edu.csulb.library.entity.Book;

/**
 * @author Manav
 *
 */
public class BookTO {

	private Long id;
	private String title;
	private String author;
	private Integer publishingYear;

	public BookTO() {
	}

	public BookTO(String title, String author, Integer publishingYear) {
		super();
		this.title = title;
		this.author = author;
		this.publishingYear = publishingYear;
	}

	public BookTO(Long id, String title, String author, Integer publishingYear) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publishingYear = publishingYear;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Integer getPublishingYear() {
		return publishingYear;
	}

	public void setPublishingYear(Integer publishingYear) {
		this.publishingYear = publishingYear;
	}

	public Book copyTransferObjectToEntity() {
		Book book = null;
		if (this.id == null) {
			book = new Book(this.title, this.author, this.publishingYear);
		} else {
			book = new Book(this.id, this.title, this.author, this.publishingYear);
		}
		return book;
	}

	public void copyEntityToTransferObject(Book bookEntity) {
		this.setId(bookEntity.getId());
		this.setAuthor(bookEntity.getAuthor());
		this.setTitle(bookEntity.getTitle());
		this.setPublishingYear(bookEntity.getPublishingYear());
	}

}
