package com.augusto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Operação não Suportada")
public class CurrencyUnsupportedException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CurrencyUnsupportedException () {
		super("Operação não Suportada");
	}

}
