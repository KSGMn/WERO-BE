package com.wero.finalProject.dto.response.diary;

import com.wero.finalProject.common.ResponseCode;
import com.wero.finalProject.common.ResponseMessage;
import com.wero.finalProject.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @작성자:최기원
 * @작성날짜:2024/05/04
 * @파일명:DeleteDiaryResponseDto.class
 * @기능:일기 삭제 response dto
 **/

@Getter
public class DeleteDiaryResponseDto extends ResponseDto {

    private DeleteDiaryResponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }


    public static ResponseEntity<DeleteDiaryResponseDto> success() {
        DeleteDiaryResponseDto result = new DeleteDiaryResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistDiary() {
        ResponseDto result=new ResponseDto(ResponseCode.NOT_EXIST_DIARY, ResponseMessage.NOT_EXIST_DIARY);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result=new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> noPermission() {
        ResponseDto result=new ResponseDto(ResponseCode.NO_PERMISSION, ResponseMessage.NO_PERMISSION);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(result);
    }
}
