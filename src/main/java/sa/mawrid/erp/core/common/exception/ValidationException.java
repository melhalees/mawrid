package sa.mawrid.erp.core.common.exception;

import org.springframework.http.HttpStatus;

public class ValidationException extends BaseException {

    private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

    public ValidationException(String message) {
        super(STATUS, message);
    }

    public ValidationException(String message, Throwable cause) {
        super(STATUS, message, cause);
    }
}
