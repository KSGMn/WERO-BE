package com.wero.finalProject.auth.jwt.handler;

import com.wero.finalProject.dto.response.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @작성자:오현암
 * @작성날짜:2024/04/25
 * @파일명:ValidationExceptionHandler.class
 * @기능:인증예외처리
 **/
@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<ResponseDto> validationExceptionHandler(Exception e){
        return ResponseDto.validationFail();
    }

}
