package com.abhijith.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhijith.lms.model.book.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
