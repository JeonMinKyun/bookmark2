package com.min.edu.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException ex){
		Map<String, Object> errorResponse = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error ->{
			String fieldName = ((FieldError)error).getField();
			String errorMessage = error.getDefaultMessage();
			errorResponse.put("field", fieldName);
			errorResponse.put("message", errorMessage);
		});
		
		errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
