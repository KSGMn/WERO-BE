package com.wero.finalProject.controller;

import com.wero.finalProject.dto.request.auth.*;
import com.wero.finalProject.dto.response.auth.*;
import com.wero.finalProject.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @작성자:오현암
 * @작성날짜:2024/04/25
 * @파일명:AuthController.class
 * @기능:로그인,회원가입,이메일인증,아이디중복체크_API
 **/
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/id-check")
    public ResponseEntity<? super IdCheckResponseDto> idCheck(@RequestBody @Valid IdCheckRequestDto requestBody){
        ResponseEntity<? super IdCheckResponseDto> response = authService.idCheck(requestBody);
        return response;
    }

    @PostMapping("/email-certification")
    public ResponseEntity<? super EmailCertificationResponseDto> emailCertification(@RequestBody @Valid EmailCertificationRequestDto requestBody){
        ResponseEntity<? super EmailCertificationResponseDto> response = authService.emailCertification(requestBody);
        return response;
    }

    @PostMapping("/check-certification")
    public ResponseEntity<? super CheckCertificationResponseDto> checkCertification(
            @RequestBody @Valid CheckCertificationRequestDto requestBody){
        ResponseEntity<? super CheckCertificationResponseDto> response = authService.checkCertification(requestBody);
        return response;
    }

    @PostMapping("/register")
    public ResponseEntity<? super RegisterResponseDto> register(
            @RequestBody @Valid RegisterRequestDto requestBody
    ){
        ResponseEntity<? super RegisterResponseDto> response = authService.register(requestBody);
        return response;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<? super SignInResponseDto> signIn(
            @RequestBody @Valid SignInRequestDto requestBody){
        ResponseEntity<? super SignInResponseDto> response = authService.signIn(requestBody);
        return response;
    }

}
