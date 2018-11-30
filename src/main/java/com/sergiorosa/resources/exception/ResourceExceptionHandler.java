package com.sergiorosa.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.dao.DataIntegrityViolationException;

import com.sergiorosa.services.exceptions.ObjectNotFoundException;

@Controller
public class ResourceExceptionHandler { 
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError>  objectNotFound (ObjectNotFoundException e, 
			HttpServletRequest request){
		
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis() );
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError>  dataIntegrity(DataIntegrityViolationException e, 
			HttpServletRequest request){
		
		StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis() );
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
}
