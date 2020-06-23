package com.books.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.books.api.model.Book;
import com.books.api.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api("Books")
@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
	
	private final BookService bookService;
	
	@ApiOperation("Faz o registro do livro")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Book save(@RequestBody Book book) {				
		return bookService.save(book);
	}
	
	@ApiOperation("Consulta um registro")
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Book findBook(@PathVariable Long id) {
		return bookService.findById(id);
	}
	
	@ApiOperation("Consulta todos os registros")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Book> All() {
		return bookService.findAll();
	}
	
	@ApiOperation("Deleta um registro específico")
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		bookService.delete(id);
	}
	
	@ApiOperation("Altera um registro específico")
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Book update(@PathVariable Long id, @RequestBody Book updated) {
		var book = bookService.findById(id);
		return bookService.update(book, updated);
	}
}
