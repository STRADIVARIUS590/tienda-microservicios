
package com.cesar.msproducts.controllers;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Map<Integer, String>> dataIntegrityViolationException(DataIntegrityViolationException e){
		Throwable cause = e.getRootCause();
		if(cause != null && cause.getMessage()!= null) {
			return ResponseEntity.badRequest().body(
				Map.of(0, "Violacion de integridad de datos: " + e.getMessage()));
		}
		return null;
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Map<Integer, String>> constraintViolationException(ConstraintViolationException e){
		return ResponseEntity.badRequest().body(Map.of(0, "Violacion de integridad de datos: " + e.getMessage()));
	}
	/*
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> runtimeException(RuntimeException e){
		return ResponseEntity.badRequest().body("Error " + e.getMessage());
		
	}*/
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<Integer, String>> runtimeException(MethodArgumentNotValidException e){
		return ResponseEntity.badRequest().body(Map.of(0, "Violacion de Tipo de  datos: " + e.getMessage()));
	}

	
	
}
