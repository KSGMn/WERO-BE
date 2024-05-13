package com.wero.finalProject.dto.response.feeds;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wero.finalProject.common.ResponseCode;
import com.wero.finalProject.common.ResponseMessage;
import com.wero.finalProject.dto.response.ResponseDto;

import lombok.Getter;

/**
 * @작성자:김선규
 * @작성날짜:2024/05/08
 * @파일명: UpdateFeedsResponsetDto
 * @기능: 피드 업데이트 응답 데이터 전달
 **/

@Getter
public class UpdateFeedsResponseDto extends ResponseDto {

    private UpdateFeedsResponseDto() {
        super();
    }

    public static ResponseEntity<ResponseDto> update() {
        ResponseDto responseBody = new ResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> updateFail() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.UPDATE_FAIL, ResponseMessage.UPDATE_FAIL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

}
