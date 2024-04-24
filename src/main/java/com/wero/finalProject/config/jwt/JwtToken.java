package com.wero.finalProject.config.jwt;

import lombok.Builder;
import lombok.Data;

/**
 * @작성자:오현암
 * @작성날짜:2024/04/25
 * @파일명:JwtToken.class
 **/

@Data
public class JwtToken {

    private String grantType;
    private String accessToken;
    private String refreshToken;

    @Builder
    public JwtToken(String grantType,
                    String accessToken,
                    String refreshToken){
        this.grantType = grantType;
        this.accessToken = accessToken;
        this. refreshToken = refreshToken;
    }
}
