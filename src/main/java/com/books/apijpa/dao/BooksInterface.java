package com.books.apijpa.dao;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.books.apijpa.entities.Book;

public interface BooksInterface extends  CrudRepository<Book, Integer> {

	Book findBybId(int bId);
	 
}
