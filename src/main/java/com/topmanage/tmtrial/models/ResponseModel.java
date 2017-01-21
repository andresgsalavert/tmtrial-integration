package com.topmanage.tmtrial.models;

public class ResponseModel<R> {

	private String code;
	private String message;
	private String optional;
	private R response;

	public ResponseModel() {
		this.code = "200";
		this.message = "Ok";
		this.optional = "";		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOptional() {
		return optional;
	}

	public void setOptional(String optional) {
		this.optional = optional;
	}

	public R getResponse() {
		return response;
	}

	public void setResponse(R response) {
		this.response = response;
	}

}
