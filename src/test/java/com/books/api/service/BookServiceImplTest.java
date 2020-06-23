package com.books.api.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.books.api.model.Book;
import com.books.api.repository.BookRepository;
import com.books.api.repository.BookRepositoryTest;
import com.books.api.service.implementation.BookServiceImpl;

@ExtendWith(SpringExtension.class)			
public class BookServiceImplTest {

	@SpyBean
	BookServiceImpl service;
	
	@MockBean
	BookRepository repository;	
	
	@Test
	public void deveSalvarUmUmLivro() {
		//cenário
		Book book = BookRepositoryTest.criarBook();
		book.setId(1L);
		
		Mockito
			.when( repository.save( Mockito.any(Book.class) ) )
			.thenReturn(book); //NullPointerException, por que ?
		
		//ação
		var resultado = service.save(new Book());		
		
		//verificação
		Assertions.assertThat(resultado.getId()).isEqualTo(book.getId());
	}
}
