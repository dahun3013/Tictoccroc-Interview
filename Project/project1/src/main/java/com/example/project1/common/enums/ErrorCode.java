package com.example.project1.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.CONFLICT;


@Getter
@AllArgsConstructor
public enum ErrorCode {
    /* 400 BAD_REQUEST : 잘못된 요청 */
    INVALID_DATA(BAD_REQUEST, "유효하지 않은 데이터 입니다."),

    /* 404 NOT_FOUND : Resource 를 찾을 수 없음 */
    NO_DATA(NOT_FOUND, "데이터가 없습니다."),

    /* 409 CONFLICT : Resource 의 현재 상태와 충돌. 보통 중복된 데이터 존재 */
    DUPLICATE_RESOURCE(CONFLICT, "데이터가 이미 존재합니다"),

    ;

    private final HttpStatus httpStatus;
    private final String detail;
}
