package com.employee.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDate;

public class ErrorResponse {

  private String message;



  private HttpStatus status;
  private LocalDate timeStamp;

  public ErrorResponse(String message, HttpStatus status) {
    this.message = message;
    this.status = status;
    this.timeStamp = LocalDate.now();
  }

  public String getMessage() {
    return this.message;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public LocalDate getTimeStamp() {
    return timeStamp;
  }
}
