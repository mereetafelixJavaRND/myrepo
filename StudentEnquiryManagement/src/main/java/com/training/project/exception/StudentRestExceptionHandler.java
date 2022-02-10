package com.training.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.training.project.model.EnquiryErrorResponse;

@ControllerAdvice
public class StudentRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<EnquiryErrorResponse> handleException(EnquiryNotFound e) {

		EnquiryErrorResponse error = new EnquiryErrorResponse(HttpStatus.FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

	}

}
