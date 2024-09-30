package com.andromeda.fintrack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.andromeda.fintrack.dto.ErrorInfo;
import com.andromeda.fintrack.util.Utility;

@RestControllerAdvice(assignableTypes = CompanyController.class)
public class CompanyControllerAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyControllerAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> uncaughtException(Exception e){
		logger.error("Error uncaught Exception ",e);
		ErrorInfo error = new ErrorInfo(HttpStatus.INTERNAL_SERVER_ERROR.name(), Utility.UNKNOW_ERROR);
		return new ResponseEntity<ErrorInfo>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
