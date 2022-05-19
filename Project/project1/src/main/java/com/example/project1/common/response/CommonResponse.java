package com.example.project1.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CommonResponse extends BasicResponse {
    private Object data;
    public CommonResponse(int code, String message){
        super(code,message);
    }
    public CommonResponse(int code, String message, Object data){
        super(code,message);
        this.data = data;
    }
}
