package com.wero.finalProject.Security.jwt;

/**
 * @작성자:김선규
 * @작성날짜:2024/4/25
 * @파일명:JwtTokenRequest.java
 **/

public record JwtTokenRequest(String email, String passWord) {

}
