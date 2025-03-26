package com.trevisan.hubspot.exception;

public class InvalidResourceException extends RuntimeException {
  private String code;

  public InvalidResourceException(String message) {
    super(message);
  }

  public InvalidResourceException(String code, String message) {
    super(message);
    this.code = code;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
