package com.employee.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException{
  private String message;
  private HttpStatus status;

  public BadRequestException(String message) {
    this.message = message;
    this.status = status;
  }

  public String getMessage() {
    return this.message;
  }

  public HttpStatus getStatus() {
    return this.status;
  }
}
