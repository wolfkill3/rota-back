package com.sut.ist.rotaback.exception;

public class LoginException extends RuntimeException{
    public LoginException() {
        super();
    }

    public LoginException(final String message) {
        super(message);
    }

    public LoginException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public LoginException(final Throwable cause) {
        super(cause);
    }

    protected LoginException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
