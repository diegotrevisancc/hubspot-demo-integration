package com.trevisan.hubspot.config;

import com.trevisan.hubspot.exception.InvalidResourceException;
import com.trevisan.hubspot.restmessages.BaseResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.logging.Logger;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
  private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class.getName());

  @ExceptionHandler(InvalidResourceException.class)
  private ResponseEntity<Object> handleInvalidResourceException(InvalidResourceException ex, WebRequest req) {
    logger.warning("Throwing InvalidResourceException!");
    BaseResponse body = new BaseResponse(ex.getCode() == null ? "500" : ex.getCode(), ex.getMessage());

    return handleExceptionInternal(ex, body, new HttpHeaders()
    , HttpStatus.INTERNAL_SERVER_ERROR, req);
  }
}
