package com.wero.finalProject.service;


import com.wero.finalProject.domain.UserEntity;
import com.wero.finalProject.dto.request.afterService.CustomService_C_requestDto;
import com.wero.finalProject.dto.response.afterService.CustomService_C_responseDto;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;

/**
 * @작성자:
 * @작성날짜:
 * @파일명:
 **/
public interface CustomService_Service {
    ResponseEntity<? super CustomService_C_responseDto> save(CustomService_C_requestDto dto, String userId);

}
