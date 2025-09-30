package sa.mawrid.erp.core.common.util;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import sa.mawrid.erp.core.common.dto.BaseResponseDTO;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ResponseUtil {
    public static <T> ResponseEntity<BaseResponseDTO<T>> resolveSuccess(HttpStatus status, String message, T data) {
        return ResponseEntity.status(status).body(BaseResponseDTO.success(status.value(), message, data));
    }

    public static ResponseEntity<BaseResponseDTO<Void>> resolveError(HttpStatus status, String message) {
        return ResponseEntity.status(status).body(BaseResponseDTO.error(status.value(), message));
    }

    public static ResponseEntity<Object> resolveErrorWithErrorsList(HttpStatus status, String message, Map<String, List<String>> errors) {
        return ResponseEntity.status(status).body(BaseResponseDTO.errorWithErrorsList(status.value(), message, errors));
    }

    public static void writeErrorResponse(HttpServletResponse response, HttpStatus status, String message) {
        response.setStatus(status.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        String jsonResponse = String.format("""
                        {
                            "success": false,
                            "statusCode": %d,
                            "message": "%s",
                            "data": null,
                            "errors": null
                        }""",
                status.value(), message);

        try {
            response.getWriter().write(jsonResponse);
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
