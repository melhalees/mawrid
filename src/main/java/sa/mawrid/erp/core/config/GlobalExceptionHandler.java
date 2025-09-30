package sa.mawrid.erp.core.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sa.mawrid.erp.core.common.dto.BaseResponseDTO;
import sa.mawrid.erp.core.common.exception.ConflictException;
import sa.mawrid.erp.core.common.exception.ResourceNotFoundException;
import sa.mawrid.erp.core.common.exception.ValidationException;
import sa.mawrid.erp.core.common.util.ResponseUtil;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<BaseResponseDTO<Void>> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseUtil.resolveError(ex.getStatus(), ex.getLocalizedMessage());
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<BaseResponseDTO<Void>> handleConflict(ConflictException ex) {
        return ResponseUtil.resolveError(ex.getStatus(), ex.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<BaseResponseDTO<Void>> handleValidation(ValidationException ex) {
        return ResponseUtil.resolveError(ex.getStatus(), ex.getMessage());
    }
}