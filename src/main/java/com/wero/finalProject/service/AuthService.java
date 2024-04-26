package com.wero.finalProject.service;

import com.wero.finalProject.dto.request.auth.*;
import com.wero.finalProject.dto.response.auth.*;
import org.springframework.http.ResponseEntity;

/**
 * @작성자:오현암
 * @작성날짜:2024/04/25
 * @파일명:AuthService.interface
 * @기능:인증처리
 **/
public interface AuthService {
    ResponseEntity<? super IdCheckResponseDto> idCheck(IdCheckRequestDto dto);
    ResponseEntity<? super EmailCertificationResponseDto> emailCertification(EmailCertificationRequestDto dto);
    ResponseEntity<? super CheckCertificationResponseDto> checkCertification(CheckCertificationRequestDto dto);
    ResponseEntity<? super RegisterResponseDto> register(RegisterRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);

}
