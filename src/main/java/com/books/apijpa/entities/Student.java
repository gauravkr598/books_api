package com.books.apijpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="student_books")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sId;
	private String sName;
	private String sCource;
	private String sCity;
	@OneToOne(mappedBy = "bStudent")
	@JsonBackReference
	private Book sBook;
	public Student(int sId, String sName, String sCource, String sCity, Book sBook) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sCource = sCource;
		this.sCity = sCity;
		this.sBook = sBook;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsCource() {
		return sCource;
	}
	public void setsCource(String sCource) {
		this.sCource = sCource;
	}
	public String getsCity() {
		return sCity;
	}
	public void setsCity(String sCity) {
		this.sCity = sCity;
	}
	public Book getsBook() {
		return sBook;
	}
	public void setsBook(Book sBook) {
		this.sBook = sBook;
	}
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", sCource=" + sCource + ", sCity=" + sCity + ", sBook="
				+ sBook + "]";
	}
	
}
