package com.test.testdb.controller.advice;

import com.test.testdb.exceptions.FailedDBMethodException;
import com.test.testdb.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ProductControllerAdvice {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Error> handleNoSuchElementException (NoSuchElementException e){
        Error error = new Error("Invalid product id provided", "400");
        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FailedDBMethodException.class)
    public ResponseEntity<Error> handleFailedDBMethodException (FailedDBMethodException e){
        Error error = new Error("Failed to execute, this method", "404");
        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
    }
}
