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
 * @파일명:DiaryResponseDto.class
 * @기능:일기 생성 response dto
 **/

@Getter
public class DiaryResponseDto extends ResponseDto {//응답 관련 dto
    //TODO: 게시판에 관한 응답 처리

    private DiaryResponseDto() {//일기 생성 응답 dto 생성자
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);//부모(ResponseDto)의 생성자에 '응답 성공 코드'를 넣어 호출한다
    }

    public static ResponseEntity<DiaryResponseDto> success(){//ResponseEntity타입을 반환하는 succes함수
            DiaryResponseDto result = new DiaryResponseDto();//DiaryResponseDto객체 생성한다
            return ResponseEntity.status(HttpStatus.OK).body(result);//ResponseEntity에 상태코드를 싣고 body부분에는 생성한 DiaryResponseDto객체를 넣어 리턴한다
    }

    public static ResponseEntity<ResponseDto> notExistUser(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER,ResponseMessage.NOT_EXIST_USER);
        return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }

//   public static ResponseEntity<ResponseDto> notExistPost(){
//        ResponseDto result=new ResponseDto(ResponseCode.NOT_EXIST_BOARD,ResponseMessage.NOT_EXIST_BOARD);
//        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
//   }

}
