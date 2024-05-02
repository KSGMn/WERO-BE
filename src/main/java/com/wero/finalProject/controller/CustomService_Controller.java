package com.wero.finalProject.controller;

import com.wero.finalProject.domain.UserEntity;
import com.wero.finalProject.dto.request.afterService.CustomService_C_requestDto;
import com.wero.finalProject.dto.response.afterService.CustomService_C_responseDto;
import com.wero.finalProject.service.CustomService_Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @작성자:
 * @작성날짜:
 * @파일명:
 **/

@RestController
@RequestMapping("/api/v1/cs")
@RequiredArgsConstructor
public class CustomService_Controller {

    private final CustomService_Service customServiceService;

    @PostMapping("/write")
    public ResponseEntity<? super CustomService_C_responseDto> post
            (@RequestBody @Valid CustomService_C_requestDto requestBody, @AuthenticationPrincipal String userId) {
        ResponseEntity<? super CustomService_C_responseDto> response =customServiceService.save(requestBody, userId);
        return response;
    }
}
