package com.demo.notes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotesExceptionHandler {

	
	@ExceptionHandler(value = NoteNotFoundException.class)
	   public ResponseEntity<Object> exception(NoteNotFoundException exception) {
	      return new ResponseEntity<>("Notes not found", HttpStatus.NOT_FOUND);
	   }
}
