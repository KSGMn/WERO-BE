package com.wero.finalProject.controller;

import com.wero.finalProject.dto.request.user.UserUpdateRequestDto;
import com.wero.finalProject.dto.response.user.UserUpdateResponseDto;
import com.wero.finalProject.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

/**
 * @작성자:
 * @작성날짜:
 * @파일명:
 **/

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PatchMapping("/update")
    public ResponseEntity<? super UserUpdateResponseDto> updateReport
            (@RequestBody @Valid UserUpdateRequestDto requestBody,
             @AuthenticationPrincipal String userId){
        ResponseEntity<? super UserUpdateResponseDto> response = userService.userUpdate(requestBody, userId);
        return response;
    }
}
