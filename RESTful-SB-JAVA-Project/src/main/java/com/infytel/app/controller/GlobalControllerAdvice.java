package com.infytel.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infytel.app.model.ErrorBean;
import com.infytel.app.model.ErrorDetail;
import com.infytel.app.model.Response;
import com.infytel.app.model.SystemException;
import com.infytel.app.model.SystemRuntimeException;

@RestControllerAdvice
public class GlobalControllerAdvice {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalControllerAdvice.class);

	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	public ResponseEntity validationExceptionhandler(MethodArgumentNotValidException ex) {
		LOGGER.error("validationExceptionhandler ",ex);
		List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
		ErrorBean errBean=new ErrorBean();
		for(ObjectError err: allErrors) {
			ErrorDetail errD=new ErrorDetail();
			errD.setCode(err.getCode()+"::"+err.getObjectName());
			errD.setMessage(err.getDefaultMessage());
			errBean.getErrors().add(errD);
		}
		Response<ErrorBean> errReponse = new Response<>();
		errReponse.setData(errBean);
		return new ResponseEntity(errReponse, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(value = { RuntimeException.class, SystemRuntimeException.class })
	public ResponseEntity<String> RuntimeExceptionhandler(Exception ex) {
		LOGGER.error("RuntimeExceptionhandler ",ex);
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(value = { Exception.class, SystemException.class })
	public ResponseEntity<String> GenericExceptionhandler(Exception ex) {
		LOGGER.error("GenericExceptionhandler ",ex);
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);

	}

}
