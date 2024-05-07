package com.wero.finalProject.service;

import com.wero.finalProject.dto.request.diary.DiaryRequestDto;
import com.wero.finalProject.dto.request.diary.PatchDiaryRequestDto;
import com.wero.finalProject.dto.response.diary.DeleteDiaryResponseDto;
import com.wero.finalProject.dto.response.diary.GetDiaryResponseDto;
import com.wero.finalProject.dto.response.diary.DiaryResponseDto;
import com.wero.finalProject.dto.response.diary.PatchDiaryResponseDto;
import org.springframework.http.ResponseEntity;

/**
 * @작성자:최기원
 * @작성날짜:2024/05/04
 * @파일명:DiaryService.interface
 * @기능:일기 작성,조회,수정,삭제 서비스 인터페이스
 **/

public interface DiaryService {
    ResponseEntity<? super DiaryResponseDto> createDiary(DiaryRequestDto dto, String userId);

    //ResponseEntity<? super GetPostResponseDto> getPostAll();

    ResponseEntity<? super GetDiaryResponseDto> getDiary(Integer diaryId);

    ResponseEntity<? super DeleteDiaryResponseDto> deleteDiary(Integer diaryId,String userId);

    ResponseEntity<? super PatchDiaryResponseDto> patchDiary(PatchDiaryRequestDto dto, Integer diary_id, String userId);
}


