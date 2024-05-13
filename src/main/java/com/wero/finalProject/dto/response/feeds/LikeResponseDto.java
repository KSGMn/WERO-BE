package com.wero.finalProject.dto.response.feeds;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wero.finalProject.common.ResponseCode;
import com.wero.finalProject.common.ResponseMessage;
import com.wero.finalProject.dto.response.ResponseDto;

import lombok.Getter;

/**
 * @작성자:김선규
 * @작성날짜:2024/05/13
 * @파일명: LikeResponse
 * @기능: 피드 라이크 추가/삭제 응답 데이터 전달
 **/

@Getter
public class LikeResponseDto extends ResponseDto {

    private LikeResponseDto() {
        super();
    }

    public static ResponseEntity<ResponseDto> addLike() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.CREATED, ResponseMessage.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> addLikeFail() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.CREATE_FAIL, ResponseMessage.CREATE_FAIL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> deleteLike() {
        ResponseDto responseBody = new ResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> deleteLikeFail() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.DELET_FAIL, ResponseMessage.DELET_FAIL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

}
