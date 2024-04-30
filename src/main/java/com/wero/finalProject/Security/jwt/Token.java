package com.wero.finalProject.Security.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @작성자:김선규
 * @작성날짜:2024/4/25
 * @파일명:Token.java
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Token {

    private String grantType;
    private String access_token;
    private String refresh_token;

}
