package com.github.user_service.usergameprofile.exception;

public class AccessException extends RuntimeException {

  private final String resourceName;
  private final String destinationResourceName;

  public AccessException(String destinationResourceName, String resourceName) {
    super(String.format("Cannot access %s with %s account", destinationResourceName, resourceName));
    this.resourceName = resourceName;
    this.destinationResourceName = destinationResourceName;
  }
}
