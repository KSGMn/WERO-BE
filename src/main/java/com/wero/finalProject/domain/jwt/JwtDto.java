package com.wero.finalProject.domain.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * @작성자:오현암
 * @작성날짜:2024/04/25
 * @파일명:JwtDto
 **/

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class JwtDto {
    private String accessToken;
    private String refreshToken;

}
