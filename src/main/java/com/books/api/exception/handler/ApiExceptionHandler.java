package com.books.api.exception.handler;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.books.api.exception.BusinessRuleException;
import com.books.api.exception.ResourceNotFoundException;

@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resouceNotFound(ResourceNotFoundException ex, 
			HttpServletRequest request){		
		
		var status = HttpStatus.NOT_FOUND;
		var path = request.getRequestURI();
		var err = new StandardError(Instant.now(), status.value(), ex.getMessage(), path);
		
		return ResponseEntity.status(status).body(err);	
	}
	
	@ExceptionHandler(BusinessRuleException.class)
	public ResponseEntity<StandardError> handleBusinessError(BusinessRuleException ex, 
			HttpServletRequest request){
		
		var status = HttpStatus.BAD_REQUEST;
		var path = request.getRequestURI();		
		var body = new StandardError(Instant.now(), status.value(), ex.getMessage(), path);		
		return ResponseEntity.status(status).body(body);	
		
	}
	
	
}
