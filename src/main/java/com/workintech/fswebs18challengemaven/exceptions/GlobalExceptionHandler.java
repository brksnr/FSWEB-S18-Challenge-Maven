package com.workintech.fswebs18challengemaven.exceptions;

import com.workintech.fswebs18challengemaven.entity.Card;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    private ResponseEntity<CardErrorResponse> handleExcepiton(CardException excepiton){
        log.error("Card Excepiton accured! Details:", excepiton);
        CardErrorResponse cardErrorResponse = new CardErrorResponse(excepiton.getLocalizedMessage());
        return new ResponseEntity<>(cardErrorResponse, excepiton.getHttpStatus());
    }

    @ExceptionHandler
    private ResponseEntity<CardErrorResponse> handleExcepiton(Exception excepiton){
        log.error("Card Excepiton accured! Details:", excepiton);
        CardErrorResponse cardErrorResponse = new CardErrorResponse(excepiton.getLocalizedMessage());
        return new ResponseEntity<>(cardErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
