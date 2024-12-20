package com.wero.finalProject.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wero.finalProject.common.ResponseCode;
import com.wero.finalProject.common.ResponseMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @작성자:오현암
 * @작성날짜:2024/04/25
 * @파일명:ResponseDto.class
 * @기능:공통_응답_데이터_생성
 **/
@Getter
@AllArgsConstructor
public class ResponseDto {

    private String code;
    private String msg;

    public ResponseDto() {
        this.code = ResponseCode.SUCCESS;
        this.msg = ResponseMessage.SUCCESS;
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
