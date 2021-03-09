package br.com.erudio.exception;

import javax.naming.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidJwtAuthenticationExceptionException extends AuthenticationException{

	private static final long serialVersionUID = 1L;
	
	public InvalidJwtAuthenticationExceptionException(String exception) {
		super(exception);
	}

}
