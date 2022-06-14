package com.hsquare.project.exceptions;

public class HSquareMedException extends Exception{
    public HSquareMedException() {
        super();
    }

    public HSquareMedException(String message) {
        super(message);
    }

    public HSquareMedException(String message, Throwable cause) {
        super(message, cause);
    }

    public HSquareMedException(Throwable cause) {
        super(cause);
    }

    protected HSquareMedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
