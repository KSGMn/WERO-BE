package com.wero.finalProject.service;

import com.wero.finalProject.dto.request.afterService.CustomService_C_requestDto;
import com.wero.finalProject.dto.response.afterService.CustomService_C_responseDto;
import org.springframework.http.ResponseEntity;

/**
 * @작성자:오현암
 * @작성날짜:2024/05/02
 * @파일명:CustomService_Service
 * @기능:고객센터글저장서비스로직
 **/
public interface CustomService_Service {
    ResponseEntity<? super CustomService_C_responseDto> save(CustomService_C_requestDto dto, String userId);
}
