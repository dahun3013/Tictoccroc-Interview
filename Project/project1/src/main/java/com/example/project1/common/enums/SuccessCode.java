package com.example.project1.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessCode {
    /* OK : 성공 */
    SUCCESS(200);

    private final int code;
}
