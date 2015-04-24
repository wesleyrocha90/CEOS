package br.com.ceos.entity.exceptions;

public class ValidateException extends Exception{

  public ValidateException(String message) {
    super(message);
  }

  @Override
  public String getMessage() {
    return super.getMessage();
  }
}
