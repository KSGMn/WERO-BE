//package com.wero.finalProject.service.implement;
//
//import com.wero.finalProject.Repository.AfterServiceRepository;
//import com.wero.finalProject.domain.AfterServiceEntity;
//import com.wero.finalProject.dto.request.afterService.AfterServiceRequestDto;
//import com.wero.finalProject.dto.response.afterService.AfterServiceResponseDto;
//import com.wero.finalProject.service.AfterService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
///**
// * @작성자:
// * @작성날짜:
// * @파일명:
// **/
//
//@Service
//@RequiredArgsConstructor
//public class AfterServiceImpl implements AfterService {
//
//    private final AfterServiceRepository afterServiceRepository;
//
//    @Override
//    public ResponseEntity<? super AfterServiceResponseDto> save(AfterServiceRequestDto dto) {
//        try{
//            AfterServiceEntity afterServiceEntity = new AfterServiceEntity(dto);
//            afterServiceRepository.save(afterServiceEntity);
//        }catch (Exception e){
//            e.printStackTrace();
//            return AfterServiceResponseDto.dataBaseError();
//        }
//        return AfterServiceResponseDto.success();
//    }
//
////    @Override
////    public ResponseEntity<? super AfterServiceResponseDto> delete(AfterServiceRequestDto dto) {
////       try{
////           Long aId = dto.getAid();
////           afterServiceRepository.findByAId(aId);
////
////       }catch (Exception e){
////           e.printStackTrace();
////           return AfterServiceResponseDto.dataBaseError();
////       }
////       return AfterServiceResponseDto.success();
////    }
//
//
//}
