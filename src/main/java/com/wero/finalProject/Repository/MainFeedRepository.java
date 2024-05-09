package com.wero.finalProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wero.finalProject.domain.MainFeedEntity;

/**
 * @작성자:김선규
 * @작성날짜:2024/05/07
 * @파일명:MainFeedRepository
 * @기능:MainFeed 레포지토리
 **/

@Repository
public interface MainFeedRepository extends JpaRepository<MainFeedEntity, Integer> {
    List<MainFeedEntity> findByWriter_UserId(String userId);
}
