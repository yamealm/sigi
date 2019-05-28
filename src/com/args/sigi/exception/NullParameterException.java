package com.args.sigi.exception;

public class NullParameterException extends Exception {

    private static final long serialVersionUID = 1L;

    public NullParameterException(String message) {
        super(message);
    }

    public NullParameterException( String message, Exception e) {
        super(message, e);
    }

    public NullParameterException(String message, StackTraceElement[] stackTrace) {
        super(message);
        setStackTrace(stackTrace);
    }
}