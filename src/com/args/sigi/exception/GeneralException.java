package com.args.sigi.exception;

public class GeneralException extends Exception {

    private static final long serialVersionUID = 1L;

    public GeneralException(String message) {
        super(message);
    }

    public GeneralException( String message, Exception e) {
        super(message, e);
    }

    public GeneralException(String message, StackTraceElement[] stackTrace) {
        super(message);
        setStackTrace(stackTrace);
    }
}