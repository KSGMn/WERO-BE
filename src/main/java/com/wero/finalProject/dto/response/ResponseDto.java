package com.wero.finalProject.dto.response;

import com.wero.finalProject.auth.common.ResponseCode;
import com.wero.finalProject.auth.common.ResponseMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @작성자:
 * @작성날짜:
 * @파일명:
 **/
@Getter
@AllArgsConstructor
public class ResponseDto {
    private String code;
    private String msg;


    public ResponseDto(){
        this.code = ResponseCode.SUCCESS;
        this.msg = ResponseMessage.SUCCESS;
    }

    public static ResponseEntity<ResponseDto> dataBaseError(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.DATABASE_ERROR, ResponseMessage.DATABASE_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);//500
    }

    public static ResponseEntity<ResponseDto> validationFail(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.VALIDATION_FAIL, ResponseMessage.VALIDATION_FAIL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);//Bad Request

    }

}

