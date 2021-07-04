package com.books.apijpa.fileEntities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="savefilewith_api")
public class FileUploade {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fId;
	private String fImage;
	public FileUploade(int fId, String fImage) {
		super();
		this.fId = fId;
		this.fImage = fImage;
	}
	public FileUploade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
	}
	public String getfImage() {
		return fImage;
	}
	public void setfImage(String fImage) {
		this.fImage = fImage;
	}
	@Override
	public String toString() {
		return "File [fId=" + fId + ", fImage=" + fImage + "]";
	}
	
}
