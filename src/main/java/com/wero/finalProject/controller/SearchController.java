package com.wero.finalProject.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wero.finalProject.Repository.SearchRepository;
import com.wero.finalProject.Repository.UserRepository;
import com.wero.finalProject.domain.DiaryEntity;
import com.wero.finalProject.dto.request.search.SearchRequestDto;

/**
 * @작성자:김선규
 * @작성날짜:2024/05/07
 * @파일명:SearchController
 **/

@RestController
@RequestMapping("/api/v1/user/search")
public class SearchController {

        @Autowired
        private SearchRepository searchDiaryRepository;
        private UserRepository userRepository;

        // 일기 내용으로 검색
        @GetMapping("/content/{keyword}")
        public ResponseEntity<List<SearchRequestDto>> getDiariesByContent(@PathVariable String keyword) {

                List<DiaryEntity> results = searchDiaryRepository.findByContentContaining(keyword);

                List<SearchRequestDto> dtos = results.stream()
                                .map(entity -> new SearchRequestDto(
                                                entity.getDiary_id(),
                                                entity.getContent(),
                                                entity.getCategory(),
                                                entity.getWriter().getNickName()))
                                .collect(Collectors.toList());

                return ResponseEntity.ok(dtos); // List<DiaryEntity> 반환
        }

        // 일기 카테고리로 검색
        @GetMapping("/category/{keyword}")
        public ResponseEntity<List<SearchRequestDto>> getDiariesByCategory(@PathVariable String keyword) {

                List<DiaryEntity> results = searchDiaryRepository.findByCategoryContaining(keyword);

                List<SearchRequestDto> dtos = results.stream()
                                .map(entity -> new SearchRequestDto(
                                                entity.getDiary_id(),
                                                entity.getContent(),
                                                entity.getCategory(),
                                                entity.getWriter().getNickName()))
                                .collect(Collectors.toList());

                return ResponseEntity.ok(dtos); // List<DiaryEntity> 반환
        }

}
