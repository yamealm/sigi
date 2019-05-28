package com.args.sigi.exception;

public class RegisterNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public RegisterNotFoundException(String message) {
        super(message);
    }

    public RegisterNotFoundException( String message, Exception e) {
        super(message, e);
    }

    public RegisterNotFoundException(String message, StackTraceElement[] stackTrace) {
        super(message);
        setStackTrace(stackTrace);
    }
}