package com.example.project1.common.error;

import com.example.project1.common.enums.ErrorCode;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorResponse {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private final int status;
    private final String error;
    private final String code;
    private final String message;

    public static ResponseEntity<ErrorResponse> toResponseEntity(ErrorCode code) {
        return ResponseEntity
                .status(code.getHttpStatus())
                .body(ErrorResponse.builder()
                        .status(code.getHttpStatus().value())
                        .error(code.getHttpStatus().name())
                        .code(code.name())
                        .message(code.getDetail())
                        .build()
                );
    }
}