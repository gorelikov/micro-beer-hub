package com.example.spring.beer.hub.controller;

public class BeerException extends RuntimeException {
    public BeerException() {
    }

    public BeerException(String message) {
        super(message);
    }

    public BeerException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeerException(Throwable cause) {
        super(cause);
    }

    public BeerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
