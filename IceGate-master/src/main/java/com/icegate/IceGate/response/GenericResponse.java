package com.icegate.IceGate.response;

public class GenericResponse {

	private Boolean success;
	private String message;
	private Integer statusCode;
	private Object data;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}


	public GenericResponse(Boolean success, String message, Integer statusCode, Object data) {
		super();
		this.success = success;
		this.message = message;
		this.statusCode = statusCode;
		this.data = data;
	}

	public GenericResponse() {
		super();
	}
}
