package com.cg.toplevelpartyentities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class NotFoundExceptionHandler {
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity <String> handleException(Exception ex)
   {
		return new ResponseEntity <String> (" Please Enter an valid one : "+ex.getMessage(), HttpStatus.CONFLICT);
		
	}


}
