package com.wero.finalProject.dto.response.feeds;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @작성자:김선규
 * @작성날짜:2024/05/07
 * @파일명: CreateFeedsRequestDto
 * @기능: 피드 생성 응답 데이터 전달
 **/

@Data
@AllArgsConstructor
public class CreateFeedsResponseDto {

    private Integer id;
    private String message;

}
