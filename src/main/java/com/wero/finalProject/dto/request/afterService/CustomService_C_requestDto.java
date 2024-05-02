package com.wero.finalProject.dto.request.afterService;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @작성자:
 * @작성날짜:
 * @파일명:
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
