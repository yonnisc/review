package com.organization.users.service.exceptions;

public class UserServiceException extends IllegalArgumentException{
  public UserServiceException(String format) {
    super(format);
  }
}
