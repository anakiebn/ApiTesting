package com.anakie.TestingAPI.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URISyntaxException;

@ControllerAdvice
public class GlobalExceptionHandler {


    private static final Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({URISyntaxException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<ErrorResponse> handleURISyntaxException(URISyntaxException ex){
        ErrorResponse errorResponse=new ErrorResponse(HttpStatus.NOT_ACCEPTABLE.value(),ex.getMessage(),System.currentTimeMillis());
        logger.error("URI Syntax Exception detected! {} \n",ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler({IOException.class, InterruptedException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<ErrorResponse> handleIOException(IOException ex){
        ErrorResponse errorResponse=new ErrorResponse(HttpStatus.NOT_ACCEPTABLE.value(),ex.getMessage(),System.currentTimeMillis());
        logger.error("Error dealing handling request and response!\n{} \n",ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler({NumberFormatException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<ErrorResponse> handleNumberFormatException(Exception ex){
        ErrorResponse errorResponse=new ErrorResponse(HttpStatus.NOT_ACCEPTABLE.value(),ex.getMessage(),System.currentTimeMillis());
        logger.error("Invalid number! Can't convert to integer type!\n {} ",ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<ErrorResponse> handleException(Exception ex){
        ErrorResponse errorResponse=new ErrorResponse(HttpStatus.NOT_ACCEPTABLE.value(),ex.getMessage(),System.currentTimeMillis());
        logger.error("Unexpected exception occurred! {} \n",ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_ACCEPTABLE);
    }

}
