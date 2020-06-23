package com.books.api.repository;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.books.api.model.Book;

@ExtendWith(SpringExtension.class)							 // -> JUnit 5
@DataJpaTest												 // -> testes de integração
@AutoConfigureTestDatabase(replace = Replace.NONE)			 // -> não sobrescreve minhas configs
public class BookRepositoryTest {
	
	BookRepository repository;
	TestEntityManager entityManager;
	
	@Autowired
	public BookRepositoryTest(BookRepository repository, TestEntityManager entityManager) {
		this.repository = repository;		// -> alvo
		this.entityManager = entityManager; // -> auxilia na criação de cenários
	}
	
	@Test
	public void deveSalvarUmLivro() {		
		//cenário
		Book book = criarBook();
		
		//acão
		book = repository.save(book);
		
		//verificação
		Assertions.assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void deveDeletarUmLivro() {
		//cenário
		Book book = criarBook();
		entityManager.persist(book);
		
		book = entityManager.find(Book.class, book.getId());
		
		//açao
		repository.delete(book);
		
		//verificação
		Book inexistente = entityManager.find(Book.class, book.getId());		
		Assertions.assertThat(inexistente).isNull();
	}
	
	@Test
	public void deveBuscarUmLivroPorId() {
		//cenario
		Book book = criarBook();
		entityManager.persist(book);
		
		//Ação
		Optional<Book> livroEncontrado = repository.findById(book.getId());
		
		//verificação
		Assertions.assertThat(livroEncontrado.isPresent()).isTrue();
	}
	
	@Test
	public void deveAtualizarUmlivro() {
		//cenario
		Book book = criarBook();
		book.setName("Java 8");
		book.setIsbn("101011");
		
		entityManager.persist(book); 
		var id = book.getId(); 
		
		//ação		
		book.setName("Spring Rest");
		book.setIsbn("12345678");
		
		repository.save(book);
		
		//verificação
		Book livroAtualizado = entityManager.find(Book.class, id);
	
		Assertions.assertThat(livroAtualizado.getName()).isEqualTo("Spring Rest");
		Assertions.assertThat(livroAtualizado.getIsbn()).isEqualTo("12345678");
	}
	
	public static Book criarBook() {
		Book book = new Book();
		book.setName("Linguagem C");
		book.setIsbn("8521615191");
		return book;
	}
}
