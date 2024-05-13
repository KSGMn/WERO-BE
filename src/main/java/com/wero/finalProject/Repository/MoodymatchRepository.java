package com.wero.finalProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wero.finalProject.domain.MainFeedEntity;

/**
 * @작성자:김선규
 * @작성날짜:2024/05/12
 * @파일명:MoodymatchRepository
 * @기능:Moodymatch 레포지토리
 **/

@Repository
public interface MoodymatchRepository extends JpaRepository<MainFeedEntity, Integer> {

    List<MainFeedEntity> findByLikes_UserId_UserId(String userId);

}