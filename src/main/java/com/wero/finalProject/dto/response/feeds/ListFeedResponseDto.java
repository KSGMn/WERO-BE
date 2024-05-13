package com.wero.finalProject.dto.response.feeds;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wero.finalProject.common.ResponseCode;
import com.wero.finalProject.common.ResponseMessage;
import com.wero.finalProject.dto.response.ListResponseDto;
import com.wero.finalProject.dto.response.ResponseDto;

import lombok.Getter;

/**
 * @작성자:김선규
 * @작성날짜:2024/05/13
 * @파일명: ListFeedResponseDto
 * @기능: 피드 리스트 응답 데이터 전달
 **/

@Getter
public class ListFeedResponseDto<T> extends ResponseDto {

    private ListFeedResponseDto() {
        super();
    }

    public static <T> ResponseEntity<ListResponseDto<T>> getFeedsSuccess(List<T> data) {
        ListResponseDto<T> responseBody = new ListResponseDto<>(data);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static <T> ResponseEntity<ListResponseDto<T>> getFeesFail() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.UPDATE_FAIL,
                ResponseMessage.UPDATE_FAIL);
        ListResponseDto<T> errorResponse = new ListResponseDto<>(responseBody.getCode(), responseBody.getMsg(),
                new ArrayList<>());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}
