package com.wero.finalProject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wero.finalProject.domain.UserEntity;
import com.wero.finalProject.dto.request.user.UserUpdateRequestDto;
import com.wero.finalProject.dto.response.user.UserUpdateResponseDto;
import com.wero.finalProject.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

/**
 * @작성자:오현암
 * @작성날짜:2024/05/03
 * @파일명:UserController.class
 * @기능:유저_수정_삭제API
 *
 **/

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PatchMapping("/update")
    public ResponseEntity<? super UserUpdateResponseDto> updateReport(
            @RequestBody @Valid UserUpdateRequestDto requestBody,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<? super UserUpdateResponseDto> response = userService.userUpdate(requestBody, userId);
        return response;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable String userId) {
        UserEntity user = userService.findUserById(userId);
        return ResponseEntity.ok(user);
    }

}
