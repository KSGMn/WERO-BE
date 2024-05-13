package com.wero.finalProject.dto.response.feeds;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wero.finalProject.common.ResponseCode;
import com.wero.finalProject.common.ResponseMessage;
import com.wero.finalProject.dto.response.ResponseDto;

import lombok.Getter;

/**
 * @작성자:김선규
 * @작성날짜:2024/05/07
 * @파일명: DeleteFeedsResponseDto
 * @기능: 피드 삭제 응답 데이터 전달
 **/
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
        ResponseDto responseBody = new ResponseDto(ResponseCode.DELET_FAIL, ResponseMessage.DELET_FAIL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}
