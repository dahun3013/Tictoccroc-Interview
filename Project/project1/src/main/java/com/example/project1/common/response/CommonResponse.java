package com.example.project1.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CommonResponse extends BasicResponse {
    private int code;
    private String message;
    private Object data;
}
