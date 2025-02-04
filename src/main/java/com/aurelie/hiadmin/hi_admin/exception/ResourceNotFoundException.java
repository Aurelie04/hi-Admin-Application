package com.aurelie.hiadmin.hi_admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
 public ResourceNotFoundException(String message){

     super(message);
 }
}
