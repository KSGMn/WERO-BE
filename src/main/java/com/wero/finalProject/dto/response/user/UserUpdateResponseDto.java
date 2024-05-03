package com.wero.finalProject.dto.response.user;

import com.wero.finalProject.common.ResponseCode;
import com.wero.finalProject.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @작성자:
 * @작성날짜:
 * @파일명:
 **/

@Getter
public class UserUpdateResponseDto extends ResponseDto {


    public static ResponseEntity<UserUpdateResponseDto> success(){
        UserUpdateResponseDto responseBody = new UserUpdateResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> updateFail(){
        ResponseDto responseBody  = new ResponseDto(ResponseCode.UPDATE_FAIL, ResponseCode.UPDATE_FAIL);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> notExistUser(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseCode.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }


}
