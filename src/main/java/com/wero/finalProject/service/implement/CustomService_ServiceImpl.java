package com.wero.finalProject.service.implement;

import com.wero.finalProject.Repository.CustomServiceRepository;
import com.wero.finalProject.Repository.UserRepository;
import com.wero.finalProject.domain.CustomServiceEntity;
import com.wero.finalProject.domain.UserEntity;
import com.wero.finalProject.dto.request.afterService.CustomService_C_requestDto;
import com.wero.finalProject.dto.response.ResponseDto;
import com.wero.finalProject.dto.response.afterService.CustomService_C_responseDto;
import com.wero.finalProject.service.CustomService_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @작성자:오현암
 * @작성날짜:2024/05/02
 * @파일명:CustomService_ServiceImpl.class
 * @기능:고객센터서비스상세구현
 **/

@Service
@RequiredArgsConstructor
public class CustomService_ServiceImpl implements CustomService_Service {

    private final CustomServiceRepository customServiceRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super CustomService_C_responseDto> save(CustomService_C_requestDto dto, String userId) {
        try{
            UserEntity user = userRepository.findByUserId(userId);
            if(user==null) return CustomService_C_responseDto.notExistUser();

            CustomServiceEntity csEntity = new CustomServiceEntity(dto, user);
            customServiceRepository.save(csEntity);

        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.dataBaseError();
        }
        return CustomService_C_responseDto.success();
    }
}
