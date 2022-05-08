package com.empl.system.utils;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponse {

    private HttpStatus status;
    private Object data;
    private String error;
    private int statusCode;

    public ApiResponse(HttpStatus status, Object data, String error, int statusCode) {
        this.status = status;
        this.data = data;
        this.error = error;
        this.statusCode = statusCode;
    }

    public ApiResponse() {
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
