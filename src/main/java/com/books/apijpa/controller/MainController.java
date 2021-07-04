package com.books.apijpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.books.apijpa.dao.BooksInterface;
import com.books.apijpa.entities.Book;

@Controller
public class MainController {
	
	@Autowired
	private BooksInterface bookInterface;
	
	//get all boook
		@GetMapping("/book")
		public ResponseEntity<List<Book>> getBooks() {
			  List<Book> list=(List<Book>) this.bookInterface.findAll();
			  if(list.size()<=0) {
				  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			  }
			return ResponseEntity.status(HttpStatus.CREATED).body(list);
		}
		//handel single boook 
		@GetMapping("/book/{bId}")
		public ResponseEntity<Book> getBook(@PathVariable("bId") int bId ) {
			Book book=this.bookInterface.findBybId(bId);
			if(book==null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(book));
		}
		//add new book
	@PostMapping("/book")
	public ResponseEntity<Book> saveNewBook(@RequestBody Book book){
		try {
			this.bookInterface.save(book);
			return ResponseEntity.ok().body(book);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@DeleteMapping("/book/{bId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bId") int bId){
		try {
		 this.bookInterface.deleteById(bId);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	//update the book handler
 	@PutMapping("/book/{bId}")
 	public ResponseEntity<Book> updatedBook(@RequestBody Book book ,@PathVariable("bId") int bId) {
 		try {
 		book.setbId(bId);
 		this.bookInterface.save(book);
 		return ResponseEntity.ok().body(book);
 		}catch (Exception e) {
			// TODO: handle exception
 			e.printStackTrace(); 
 			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

 	}
}
