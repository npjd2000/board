package com.board.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(value=Exception.class)
	public String handleArgumentException(IllegalArgumentException e) {
		return "<h2>"+e.getMessage() +"<h2>";
	}
}
