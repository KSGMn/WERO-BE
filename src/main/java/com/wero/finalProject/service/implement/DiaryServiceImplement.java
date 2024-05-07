package com.wero.finalProject.service.implement;

import com.wero.finalProject.Repository.DiaryRepository;
import com.wero.finalProject.Repository.UserRepository;
import com.wero.finalProject.domain.DiaryEntity;
import com.wero.finalProject.domain.UserEntity;
import com.wero.finalProject.dto.request.diary.DiaryRequestDto;
import com.wero.finalProject.dto.request.diary.PatchDiaryRequestDto;
import com.wero.finalProject.dto.response.ResponseDto;
import com.wero.finalProject.dto.response.diary.DeleteDiaryResponseDto;
import com.wero.finalProject.dto.response.diary.GetDiaryResponseDto;
import com.wero.finalProject.dto.response.diary.DiaryResponseDto;
import com.wero.finalProject.dto.response.diary.PatchDiaryResponseDto;
import com.wero.finalProject.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @작성자:최기원
 * @작성날짜:2024/05/04
 * @파일명:DiaryServiceImplement.class
 * @기능:일기 작성,조회,수정,삭제 서비스 로직
 **/

@Service
@RequiredArgsConstructor
public class DiaryServiceImplement implements DiaryService {

    private final UserRepository userRepository;
    private final DiaryRepository diaryRepository;

    @Override
    public ResponseEntity<? super DiaryResponseDto> createDiary(DiaryRequestDto dto, String userId) {

        try{
            UserEntity user = userRepository.findByUserId(userId);
            //OBJECT => 메모리에 주소값으로 저장
            if(user == null) return  DiaryResponseDto.notExistUser();
            DiaryEntity diaryEntity =new DiaryEntity(dto,user);
            diaryRepository.save(diaryEntity);

        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.dataBaseError();
        }

        return  DiaryResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetDiaryResponseDto> getDiary(Integer diaryId) {
        DiaryEntity diaryEntity;//일기 엔티티 생성한다
        try {
            Optional<DiaryEntity> optionalPostEntity= diaryRepository.findById(diaryId);//아이디로 해당 글이 있는지 확인한다
            if(!optionalPostEntity.isPresent()) return GetDiaryResponseDto.notExistDiary();//해당 글이 존재하지 않는다면 에러를 보내준다
            diaryEntity =optionalPostEntity.get();//해당 글이 존재한다면 가져온다

        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.dataBaseError();
        }
        return  GetDiaryResponseDto.success(diaryEntity);//GetDiaryResponseDto의 success함수에 가져온 일기 엔티티를 넣어서 호출한다
    }

    @Override
    public ResponseEntity<? super DeleteDiaryResponseDto> deleteDiary(Integer diaryId,String userId) {

        try {
            boolean existUser = diaryRepository.existsById(diaryId);
            if(!existUser) return  DeleteDiaryResponseDto.notExistUser();

            Optional<DiaryEntity> diaryEntity = diaryRepository.findById(diaryId);//아이디로 해당 글이 있는지 확인
            if(!diaryEntity.isPresent()) return  DeleteDiaryResponseDto.notExistDiary();//해당 글이 존재하지 않는다면 에러를 보내준다

            diaryRepository.deleteById(diaryId);//해당 아이디로 글을 삭제한다

        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.dataBaseError();
        }
        return  DeleteDiaryResponseDto.success();//DeleteDiaryResponseDto의 success함수를 호출한다
    }

    @Override
    public ResponseEntity<? super PatchDiaryResponseDto> patchDiary(PatchDiaryRequestDto dto, Integer diary_id, String userId) {

        try {

            Optional<DiaryEntity> diaryEntity=diaryRepository.findById(diary_id);//아이디로 해당 글이 있는지 확인, 꺼내온다
            if(!diaryEntity.isPresent()) return  PatchDiaryResponseDto.notExistDiary();//해당 글이 존재하지 않는다면 에러를 보내준다

            DiaryEntity patchedDiary = diaryEntity.get();//해당 글이 존재한다면 가져온다(optional은 get으로 가져와야 한다)
            patchedDiary.patchDiary(dto);//PatchEntity의 메서드 호출 ==> dto 에 담긴 내용으로 수정해준다

            diaryRepository.save(patchedDiary);//수정된 일기를 저장한다

        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.dataBaseError();
        }
        return  PatchDiaryResponseDto.success();//PatchDiaryResponseDto의 success함수를 호출한다
    }


}
