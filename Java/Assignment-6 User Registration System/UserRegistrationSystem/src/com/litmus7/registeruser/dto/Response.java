package com.litmus7.registeruser.dto;

public class Response<T> {
private String statusMessage;
private String errorMessage;
private int statusCode;
/**
 * @return the statusCode
 */
public int getStatusCode() {
	return statusCode;
}
/**
 * @param statusCode the statusCode to set
 */
public void setStatusCode(int statusCode) {
	this.statusCode = statusCode;
}
private T data;
/**
 * @return the statusMessage
 */
public String getStatusMessage() {
	return statusMessage;
}
/**
 * @param statusMessage the statusMessage to set
 */
public void setStatusMessage(String statusMessage) {
	this.statusMessage = statusMessage;
}
/**
 * @return the errorMessage
 */
public String getErrorMessage() {
	return errorMessage;
}
/**
 * @param errorMessage the errorMessage to set
 */
public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}
/**
 * @return the data
 */
public T getData() {
	return data;
}
/**
 * @param data the data to set
 */
public void setData(T data) {
	this.data = data;
}
}
