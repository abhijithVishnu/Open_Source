package com.abhijith.lms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.HttpResource;

import com.abhijith.lms.model.book.Book;
import com.abhijith.lms.service.BooksService;

@RestController
public class BookController {
	
	@Autowired
	private BooksService bookServices;
	
	@GetMapping("/books")
	private List<Book> getAllBooks() {
//		Book b1 = new Book();
//		b1.setAuthor("asd");
//		b1.setIsbn("asdasdasda");
//		b1.setName("book1");
//		b1.setBookId(1);
//		b1.setStatus("A");
		
//		Book b2 = new Book("asdasd", "Book2", "vavaddvvad", "A");
		
		List<Book> books = bookServices.getAllBooks();
//		books.add(b1);
//		books.add(b2);
		
		return books;

	}
	
	@PostMapping("/books")
	public ResponseEntity<String> addBooks(@RequestBody Book books) {
		
		HttpStatus status = HttpStatus.OK;
		String message = "SUCCESS";
		
		List<Book> bookList = new ArrayList<Book>();
		bookList.add(books);
		
		message = bookServices.addBooks(bookList);
		
		if (message.startsWith("ERROR")) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		ResponseEntity<String> response = new ResponseEntity<String>(message, status);
		return response;

	}

}
