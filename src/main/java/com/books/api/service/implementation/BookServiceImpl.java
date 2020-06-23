package com.books.api.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.books.api.exception.BusinessRuleException;
import com.books.api.exception.ResourceNotFoundException;
import com.books.api.model.Book;
import com.books.api.repository.BookRepository;
import com.books.api.service.BookService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
	
	private final BookRepository bookRepository;

	@Override
	public Book save(Book book) {
		this.hasAuthor(book);		
		return bookRepository.save(book);
	}

	@Override
	public Book findById(Long id) {			
		return bookRepository.findById(id)
				.orElseThrow( () -> new ResourceNotFoundException("Livro não encontrado"));		
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		var book = this.findById(id);
		bookRepository.delete(book);
	}

	@Override
	@Transactional
	public Book update(Book book, Book updated) {
		
		if(!book.getName().equals(updated.getName()))
			book.setName(updated.getName());
		
		if(!book.getIsbn().equals(updated.getIsbn()))
			book.setIsbn(updated.getIsbn());
		
		return bookRepository.save(book);
	}
	
	private void hasAuthor(Book book) {
		
		if (book.getAuthors() != null && !book.getAuthors().isEmpty())
			return;
		
		throw new BusinessRuleException( "Insira pelo menos um autor" );
	}

}
