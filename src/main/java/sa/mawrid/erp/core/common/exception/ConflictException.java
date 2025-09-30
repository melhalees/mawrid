package sa.mawrid.erp.core.common.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends BaseException {

    private static final HttpStatus STATUS = HttpStatus.CONFLICT;

    public ConflictException(String fieldName, Object fieldValue) {
        super(STATUS,
                String.format("The field '%s' with value '%s' already exists.",
                        fieldName,
                        fieldValue));
    }

    public ConflictException(String message) {
        super(STATUS, message);
    }
}
