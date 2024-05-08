package com.wero.finalProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wero.finalProject.domain.DiaryEntity;

/**
 * @작성자:김선규
 * @작성날짜:2024/05/07
 * @파일명:SearchDiaryRepository
 **/
@Repository
public interface SearchRepository extends JpaRepository<DiaryEntity, Integer> {
    // List<DiaryEntity> findByWriterAndCategoryAndContentContaining(UserEntity
    // writer, String category, String content);
    List<DiaryEntity> findByContentContaining(String keyword);

    List<DiaryEntity> findByCategoryContaining(String keyword);
}
