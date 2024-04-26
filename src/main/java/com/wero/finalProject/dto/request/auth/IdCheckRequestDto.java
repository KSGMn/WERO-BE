package com.wero.finalProject.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @작성자:오현암
 * @작성날짜:2024/04/25
 * @파일명:IdCheckRequestDto
 * @기능:아이디_검증_요청_데이터_전달
 **/
@Getter
@Setter
@NoArgsConstructor
public class IdCheckRequestDto {
    @NotBlank
    private String id;
}
