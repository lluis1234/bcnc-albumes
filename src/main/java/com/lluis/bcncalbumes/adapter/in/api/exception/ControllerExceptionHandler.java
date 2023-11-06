package com.lluis.bcncalbumes.adapter.in.api.exception;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
    
    @ExceptionHandler({NoSuchElementException.class, HttpClientErrorException.NotFound.class})
    public ResponseEntity<ErrorMessage> notFoundExceptionHandler(Exception e, WebRequest request) {
        var errMsg = new ErrorMessage(
            HttpStatus.NOT_FOUND.value(),
            LocalDateTime.now(),
            e.getMessage(),
            request.getDescription(false));
        return new ResponseEntity<>(errMsg, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> defaultExceptionHandler(Exception e, WebRequest request) {
        var errMsg = new ErrorMessage(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            LocalDateTime.now(),
            e.getMessage(),
            request.getDescription(false));
        return new ResponseEntity<>(errMsg, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
