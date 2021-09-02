package com.abhijith.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhijith.lms.model.book.Book;
import com.abhijith.lms.repository.BookRepository;

@Service
public class BooksService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> getAllBooks() {
		return bookRepo.findAll();

	}
	
	public String addBooks(List<Book> books) {
		String status = "SUCCESS";
		
		try {
			bookRepo.saveAll(books);
		} catch (Exception e) {
			e.printStackTrace();
			
			status = "ERROR.";
			status += e.getLocalizedMessage();
		}
		
		return status;

	}

}
