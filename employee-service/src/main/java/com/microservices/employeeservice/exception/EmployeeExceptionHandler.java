package com.microservices.employeeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class EmployeeExceptionHandler {

    // Handle specific exceptions for the Employee Service
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<EmployeeErrorDetails> handleEmployeeNotFoundException(EmployeeNotFoundException exception,
                                                                                WebRequest webRequest) {
        EmployeeErrorDetails errorDetails = new EmployeeErrorDetails(new Date(), exception.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(EmployeeAPIException.class)
//    public ResponseEntity<EmployeeErrorDetails> handleEmployeeAPIException(EmployeeAPIException exception,
//                                                                           WebRequest webRequest) {
//        EmployeeErrorDetails errorDetails = new EmployeeErrorDetails(new Date(), exception.getMessage(),
//                webRequest.getDescription(false));
//        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
//    }

    // Handle global exceptions for the Employee Service
    @ExceptionHandler(Exception.class)
    public ResponseEntity<EmployeeErrorDetails> handleGlobalException(Exception exception,
                                                                      WebRequest webRequest) {
        EmployeeErrorDetails errorDetails = new EmployeeErrorDetails(new Date(), exception.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
