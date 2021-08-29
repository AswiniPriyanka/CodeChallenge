package com.jd.trackingmicroservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiValidationSubErrorVO extends ApiSubError{
	private String object;
	private String field;
	private Object rejectedValue;
	private String message;

	ApiValidationSubErrorVO(String object, String message) {
	       this.object = object;
	       this.message = message;
	   }

}
