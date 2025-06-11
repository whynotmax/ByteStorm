package io.bytestorm.common.exception;

/**
 * ByteStormException is a custom runtime exception for the ByteStorm application.
 * It extends RuntimeException and is used to signal errors specific to ByteStorm's operations.
 */
public class ByteStormException extends RuntimeException {
    public ByteStormException() {
        super();
    }

    public ByteStormException(String message) {
        super(message);
    }

    public ByteStormException(String message, Throwable cause) {
        super(message, cause);
    }

    public ByteStormException(Throwable cause) {
        super(cause);
    }

    protected ByteStormException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
