package com.betrybe.agrix.ebytr.staff.controller.advice;

import com.betrybe.agrix.ebytr.staff.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global controller advice.
 */

@ControllerAdvice
public class GlobalControllerAdvice {

  @ExceptionHandler
  public ResponseEntity<String> handleNotFound(NotFoundException error) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
  }
}