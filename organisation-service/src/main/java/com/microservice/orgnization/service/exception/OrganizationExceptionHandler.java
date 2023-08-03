package com.microservice.orgnization.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class OrganizationExceptionHandler {

    // Handle specific exceptions for the Organization Service
    @ExceptionHandler(OrganizationNotFoundException.class)
    public ResponseEntity<OrganizationErrorDetails> handleOrganizationNotFoundException(OrganizationNotFoundException exception,
                                                                                        WebRequest webRequest) {
        OrganizationErrorDetails errorDetails = new OrganizationErrorDetails(new Date(), exception.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    // Handle global exceptions for the Organization Service
    @ExceptionHandler(Exception.class)
    public ResponseEntity<OrganizationErrorDetails> handleGlobalException(Exception exception,
                                                                          WebRequest webRequest) {
        OrganizationErrorDetails errorDetails = new OrganizationErrorDetails(new Date(), exception.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
