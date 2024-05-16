package com.wero.finalProject.Repository;

import com.wero.finalProject.domain.BookMarkEntity;
import com.wero.finalProject.domain.primaryKey.BookMarkPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @작성자:최기원
 * @작성날짜:2024/05/13
 * @파일명:BookMarkRepository.class
 * @기능:북마크 레포지토리
 **/

@Repository
public interface BookMarkRepository extends JpaRepository<BookMarkEntity, BookMarkPk> {

    BookMarkEntity findByDiaryIdAndUserId(Integer diaryId, String userId);
}
