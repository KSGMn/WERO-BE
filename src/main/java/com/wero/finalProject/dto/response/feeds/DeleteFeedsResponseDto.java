package com.wero.finalProject.dto.response.feeds;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wero.finalProject.common.ResponseCode;
import com.wero.finalProject.common.ResponseMessage;
import com.wero.finalProject.dto.response.ResponseDto;

import lombok.Getter;

@Getter
public class DeleteFeedsResponseDto extends ResponseDto {

    private DeleteFeedsResponseDto() {
        super();
    }

    public static ResponseEntity<ResponseDto> delete() {
        ResponseDto responseBody = new ResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> deleteFail() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.UPDATE_FAIL, ResponseMessage.UPDATE_FAIL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}
