package com.workintech.fswebs18challengemaven.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class CardException extends RuntimeException {
    private HttpStatus httpStatus;

    public CardException(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public CardException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public CardException(String message, Throwable cause, HttpStatus httpStatus) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    public CardException(Throwable cause, HttpStatus httpStatus) {
        super(cause);
        this.httpStatus = httpStatus;
    }

    public CardException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, HttpStatus httpStatus) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.httpStatus = httpStatus;
    }
}
