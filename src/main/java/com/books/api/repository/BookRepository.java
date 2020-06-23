package com.books.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.api.model.Book;

public interface BookRepository extends JpaRepository<Book, Long > {

}
