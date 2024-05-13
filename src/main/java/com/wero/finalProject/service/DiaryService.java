package com.wero.finalProject.service;

import com.wero.finalProject.dto.request.diary.DiaryRequestDto;
import com.wero.finalProject.dto.request.diary.PatchDiaryRequestDto;
import com.wero.finalProject.dto.response.diary.*;
import org.springframework.http.ResponseEntity;

/**
 * @작성자:최기원
 * @작성날짜:2024/05/04
 * @파일명:DiaryService.interface
 * @기능:일기 작성,조회,수정,삭제 서비스 인터페이스
 **/

public interface DiaryService {
    ResponseEntity<? super DiaryResponseDto> createDiary(DiaryRequestDto dto, String userId);//일기 작성

    ResponseEntity<? super GetDiaryResponseDto> getDiary(Integer diaryId);//일기 아이디로 조회

    ResponseEntity<? super DeleteDiaryResponseDto> deleteDiary(Integer diaryId,String userId);//일기 삭제

    ResponseEntity<? super PatchDiaryResponseDto> patchDiary(PatchDiaryRequestDto dto, Integer diary_id, String userId);//일기 수정

    ResponseEntity<? super GetDiaryListResponseDto> getDiaryList();//일기 전체 조회

    ResponseEntity<? super PutBookMarkResponseDto> putBookMark(Integer diaryId, String userId);
}


