package sa.mawrid.erp.core.common.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
public class BaseResponseDTO<T> {
    private Boolean success;
    private Integer statusCode;
    private String message;
    private T data;
    private Map<String, List<String>> errors;

    public static <T> BaseResponseDTO<T> success(Integer statusCode, String message, T data) {
        return BaseResponseDTO.<T>builder()
                .success(true)
                .statusCode(statusCode)
                .message(message)
                .data(data)
                .build();
    }

    public static BaseResponseDTO<Void> error(Integer statusCode, String message) {
        return BaseResponseDTO.<Void>builder()
                .success(false)
                .statusCode(statusCode)
                .message(message)
                .build();
    }

    public static BaseResponseDTO<Object> errorWithErrorsList(Integer statusCode, String message, Map<String, List<String>> errors) {
        return BaseResponseDTO.<Object>builder()
                .success(false)
                .statusCode(statusCode)
                .message(message)
                .errors(errors)
                .build();
    }
}
