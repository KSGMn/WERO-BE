package com.wero.finalProject.controller;

import com.wero.finalProject.dto.request.afterService.AfterServiceRequestDto;
import com.wero.finalProject.dto.response.afterService.AfterServiceResponseDto;
import com.wero.finalProject.service.AfterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @작성자:
 * @작성날짜:
 * @파일명:
 **/
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/afterService")
public class AfterServiceController {

    private final AfterService afterService;

    @PostMapping("/addAfterService")
    public ResponseEntity<? super AfterServiceResponseDto> addBoard(@RequestBody @Valid AfterServiceRequestDto requestBody){
        ResponseEntity<? super AfterServiceResponseDto> response = afterService.save(requestBody);
        return response;
    }

}
