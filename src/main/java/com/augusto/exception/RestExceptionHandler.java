package com.augusto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(CurrencyUnsupportedException.class)
	private ResponseEntity<String> userNotFoundException(CurrencyUnsupportedException exception){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Operação não suportada");
		
	}

}
