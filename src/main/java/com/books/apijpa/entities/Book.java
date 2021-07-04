package com.books.apijpa.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="book_api")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bId;
	private String bTitle;
	private String bAuthor;
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Student bStudent;
	public Book(int bId, String bTitle, String bAuthor, Student bStudent) {
		super();
		this.bId = bId;
		this.bTitle = bTitle;
		this.bAuthor = bAuthor;
		this.bStudent = bStudent;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbAuthor() {
		return bAuthor;
	}
	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}
	public Student getbStudent() {
		return bStudent;
	}
	public void setbStudent(Student bStudent) {
		this.bStudent = bStudent;
	}
	@Override
	public String toString() {
		return "Book [bId=" + bId + ", bTitle=" + bTitle + ", bAuthor=" + bAuthor + ", bStudent=" + bStudent + "]";
	}
	
}
