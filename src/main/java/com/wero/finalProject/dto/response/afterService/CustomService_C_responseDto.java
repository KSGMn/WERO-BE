package com.wero.finalProject.dto.response.afterService;

import com.wero.finalProject.common.ResponseCode;
import com.wero.finalProject.common.ResponseMessage;
import com.wero.finalProject.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @작성자:오현암
 * @작성날짜:2024/05/02
 * @파일명:CustomService_C_responseDto.class
 * @기능:고객센터요청응답
 **/

@Getter
public class CustomService_C_responseDto extends ResponseDto {

    private CustomService_C_responseDto(){
        super();
    }

    public static ResponseEntity<CustomService_C_responseDto> success(){
        CustomService_C_responseDto responseBody = new CustomService_C_responseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> notExistUser(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
    }
}
