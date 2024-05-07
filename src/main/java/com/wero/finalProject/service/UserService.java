package com.wero.finalProject.service;

import com.wero.finalProject.dto.request.user.UserUpdateEmailRequestDto;
import com.wero.finalProject.dto.request.user.UserUpdateRequestDto;
import com.wero.finalProject.dto.response.user.UserUpdateResponseDto;
import org.springframework.http.ResponseEntity;

/**
 * @작성자:오현암
 * @작성날짜:2024/05/03
 * @파일명:UserService.Interface
 * @기능:유저_수정_서비스_로직_생성
 **/
public interface UserService {
    ResponseEntity<? super UserUpdateResponseDto> userUpdate(UserUpdateRequestDto dto, String userId);
    ResponseEntity<? super UserUpdateResponseDto> userUpdateEmail(UserUpdateEmailRequestDto dto, String userId);
}
