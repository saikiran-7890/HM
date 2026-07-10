package com.kiran.www.exceptions;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handlerMethodArgument(MethodArgumentNotValidException exception){
		
		Map<String,String> errors =  new LinkedHashMap<>();
		exception.getBindingResult().getFieldErrors().forEach(fieldError->{
		
		errors.put(fieldError.getField(),fieldError.getDefaultMessage());
		
		
		});
		
		
		return errors;
	}
		@ExceptionHandler(DuplicateRecordException.class)
		public ResponseEntity<String> duplicateException(DuplicateRecordException e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
			
		}
	 
		
		
	

}
