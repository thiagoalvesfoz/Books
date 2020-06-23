package com.books.api.service;

import java.util.List;

import com.books.api.model.Book;

public interface BookService {
	Book save(Book book);
	Book findById(Long id);
	List<Book> findAll();
	void delete(Long id);
	Book update(Book book, Book updated);
}
