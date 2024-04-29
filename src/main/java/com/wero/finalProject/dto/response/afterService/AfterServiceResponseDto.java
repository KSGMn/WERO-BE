package com.wero.finalProject.dto.response.afterService;

import com.wero.finalProject.common.ResponseCode;
import com.wero.finalProject.common.ResponseMessage;
import com.wero.finalProject.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @작성자:
 * @작성날짜:
 * @파일명:
 **/

@Getter
public class AfterServiceResponseDto extends ResponseDto {
    private AfterServiceResponseDto(){
        super();
    }

    public static ResponseEntity<AfterServiceResponseDto> success(){
        AfterServiceResponseDto result = new AfterServiceResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
