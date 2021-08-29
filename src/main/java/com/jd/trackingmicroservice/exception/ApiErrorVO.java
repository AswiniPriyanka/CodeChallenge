package com.jd.trackingmicroservice.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ApiErrorVO {
	
	   private HttpStatus status;
	   private LocalDateTime timestamp;
	   private String message;
	   private String debugMessage;
	   private List<ApiSubError> subErrors;

	   private ApiErrorVO() {
	       timestamp = LocalDateTime.now();
	   }

	   ApiErrorVO(HttpStatus status) {
	       this();
	       this.status = status;
	   }

	   ApiErrorVO(HttpStatus status, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = "Unexpected error";
	       this.debugMessage = ex.getLocalizedMessage();
	   }

	   ApiErrorVO(HttpStatus status, String message, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = message;
	       this.debugMessage = ex.getLocalizedMessage();
	   }
	   private void addValidationError(FieldError fieldError) {
	        this.addValidationError(
	                fieldError.getObjectName(),
	                fieldError.getField(),
	                fieldError.getRejectedValue(),
	                fieldError.getDefaultMessage());
	    }
	   
	   private void addSubError(ApiSubError subError) {
	        if (subErrors == null) {
	            subErrors = new ArrayList<>();
	        }
	        subErrors.add(subError);
	    }
	   private void addValidationError(String object, String field, Object rejectedValue, String message) {
	        addSubError(new ApiValidationSubErrorVO(object, field, rejectedValue, message));
	    }
	   
	   private void addValidationError(String object, String message) {
	        addSubError(new ApiValidationSubErrorVO(object, message));
	    }
	   
	   public void addValidationErrors(List<FieldError> fieldErrors) {
	        fieldErrors.forEach(this::addValidationError);
	    }
	   
	   private void addValidationError(ObjectError objectError) {
	        this.addValidationError(
	                objectError.getObjectName(),
	                objectError.getDefaultMessage());
	    }
	   
	   public void addValidationError(List<ObjectError> globalErrors) {
	        globalErrors.forEach(this::addValidationError);
	    }
	
}
