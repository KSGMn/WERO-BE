package com.wero.finalProject.dto.request.feeds;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wero.finalProject.domain.UserEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @작성자:김선규
 * @작성날짜:2024/05/07
 * @파일명: CreateFeedsRequestDto
 * @기능: 피드 생성 요청 데이터 전달
 **/

@Data
public class CreateFeedsRequestDto {

    private String content;
    private String trackName;
    private String category;
    private UserEntity writer;

}
