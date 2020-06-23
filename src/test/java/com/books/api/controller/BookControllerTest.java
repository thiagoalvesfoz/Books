package com.books.api.controller;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.books.api.model.Book;
import com.books.api.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)	
@WebMvcTest(controllers = BookController.class) // -> sube o contexto rest para testar o controller
@AutoConfigureMockMvc 
public class BookControllerTest {
	
	static final String API = "/books";
	static final MediaType JSON = MediaType.APPLICATION_JSON;
	
	@MockBean
	BookService service;
	
	@Autowired
	MockMvc mvc;
	
	@Test
	public void deveRegistrarUmLivro() throws Exception {
		//cenário
		String name = "usuario";
		String isbn = "123";
		
		var bookJson = new Book();
		bookJson.setName(name);
		bookJson.setIsbn(isbn);
		
		var bookSalvo = new Book();
		bookSalvo.setId(13L);
		bookSalvo.setName(name);
		bookSalvo.setIsbn(isbn);
		
		
		String json = new ObjectMapper().writeValueAsString(bookJson);
		
		//NullPointerException ????
		Mockito.when(service.save(Mockito.any(Book.class))).thenReturn(bookSalvo);
		
		//execução e verificação
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
										.post(API)
										.accept(JSON)
										.contentType(JSON)
										.content(json);
		
		mvc.perform(request)
		.andExpect(MockMvcResultMatchers.status().isCreated())
		.andExpect(MockMvcResultMatchers.jsonPath("id").value(bookSalvo.getId()))
		.andExpect(MockMvcResultMatchers.jsonPath("name").value(bookSalvo.getName()))
		.andExpect(MockMvcResultMatchers.jsonPath("isnb").value(bookSalvo.getIsbn()));		
	}

}
