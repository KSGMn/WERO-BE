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
public class AfterServiceRequestDto {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotBlank
    private String writer;
}
