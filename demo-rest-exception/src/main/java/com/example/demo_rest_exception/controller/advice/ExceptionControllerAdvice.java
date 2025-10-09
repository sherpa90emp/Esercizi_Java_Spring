package com.example.demo_rest_exception.controller.advice;

import com.example.demo_rest_exception.exception.NotEnoughMoneyException;
import com.example.demo_rest_exception.model.dto.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// punto centrale per la gestione delle eccezioni che vengono lanciate al controller rest
@RestControllerAdvice
public class ExceptionControllerAdvice {
    //creiamo un metodo che scatta quando viene lanciata una NotEnoughMoneyException al controller
    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> NotEnoughMoneyExceptionHandler(NotEnoughMoneyException nemEx) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(nemEx.getMessage());
        return ResponseEntity.badRequest().body(errorDetails);
    }
}
