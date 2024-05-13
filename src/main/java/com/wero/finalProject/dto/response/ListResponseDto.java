package com.wero.finalProject.dto.response;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wero.finalProject.common.ResponseCode;
import com.wero.finalProject.common.ResponseMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ListResponseDto<T> {

    private String code;
    private String msg;
    private List<T> data;

    public ListResponseDto(List<T> data) {
        this.code = ResponseCode.SUCCESS;
        this.msg = ResponseMessage.SUCCESS;
        this.data = data;
    }

    public static ResponseEntity<ResponseDto> dataBaseError() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.DATABASE_ERROR, ResponseMessage.DATABASE_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);// 500
    }

    public static ResponseEntity<ResponseDto> validationFail() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.VALIDATION_FAIL, ResponseMessage.VALIDATION_FAIL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);// Bad Request

    }

}
