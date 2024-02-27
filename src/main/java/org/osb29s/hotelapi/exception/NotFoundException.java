package org.osb29s.hotelapi.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException {
  private final HttpStatus code;

  public NotFoundException(String message, HttpStatus code) {
    super(message);
    this.code = code;
  }
}
