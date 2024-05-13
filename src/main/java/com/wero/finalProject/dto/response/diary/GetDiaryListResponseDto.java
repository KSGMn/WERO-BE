package com.wero.finalProject.dto.response.diary;

import com.wero.finalProject.common.ResponseCode;
import com.wero.finalProject.common.ResponseMessage;
import com.wero.finalProject.domain.DiaryEntity;
import com.wero.finalProject.dto.object.DiaryListItem;
import com.wero.finalProject.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @작성자:최기원
 * @작성날짜:2024/05/09
 * @파일명:GetDiaryListResponseDto.class
 * @기능:일기 리스트 반환 dto
 **/

@Getter
public class GetDiaryListResponseDto extends ResponseDto {

    private List<DiaryListItem> list;//DiaryListItem리스트를 받아야 한다

    private GetDiaryListResponseDto(List<DiaryEntity> diaryEntities) {//일기 리스트를 받는다
            super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);//응답 코드 설정해주고
            this.list = DiaryListItem.getList(diaryEntities);//DiaryListItem의 메소드에 일기 리스트를 전달한다
        }

        public static ResponseEntity<GetDiaryListResponseDto> success(List<DiaryEntity> diaryEntities) {//일기 엔티티들이 담긴 리스트를 받는다
            GetDiaryListResponseDto result = new GetDiaryListResponseDto(diaryEntities);//응답 dto를 생성한다. 이떄 받은 리스트를 전달
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
}
