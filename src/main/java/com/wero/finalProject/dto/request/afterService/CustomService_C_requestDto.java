package com.wero.finalProject.dto.request.afterService;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @작성자:오현암
 * @작성날짜:2024/05/02
 * @파일명:CustomService_C_requestDto.class
 * @기능:고객센터_글쓰기_요청_dto
 **/

@Getter
@Setter
@NoArgsConstructor
public class CustomService_C_requestDto {

    @NotBlank
    private String inquiryTitle;

    @NotBlank
    private String inquiryContent;

}
