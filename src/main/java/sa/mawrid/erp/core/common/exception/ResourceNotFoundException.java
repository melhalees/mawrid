package sa.mawrid.erp.core.common.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends BaseException {

    private static final HttpStatus STATUS = HttpStatus.NOT_FOUND;

    public ResourceNotFoundException(String resourceName, Object resourceId) {
        super(STATUS,
                String.format("The requested %s with ID %s was not found.",
                        resourceName,
                        resourceId));
    }

    public ResourceNotFoundException(String message) {
        super(STATUS, message);
    }
}
