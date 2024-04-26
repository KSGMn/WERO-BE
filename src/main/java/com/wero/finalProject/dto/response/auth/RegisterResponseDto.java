package com.wero.finalProject.dto.response.auth;

import com.wero.finalProject.auth.common.ResponseCode;
import com.wero.finalProject.auth.common.ResponseMessage;
import com.wero.finalProject.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @작성자:오현암
 * @작성날짜:2024/04/25
 * @파일명:RegisterResponseDto
 * @기능:회원_가입_응답_데이터_전달
 **/
@Getter
public class RegisterResponseDto extends ResponseDto {

    private RegisterResponseDto(){
        super();
    }
    public static ResponseEntity<RegisterResponseDto> success(){
        RegisterResponseDto responseBody = new RegisterResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> duplicatedId(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.DUPLICATE_ID, ResponseMessage.DUPLICATE_ID);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> certificationFail(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.CERTIFICATION_FAIL, ResponseMessage.CERTIFICATION_FAIL);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
    }

}
