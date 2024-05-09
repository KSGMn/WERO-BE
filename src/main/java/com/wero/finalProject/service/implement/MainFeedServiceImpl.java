package com.wero.finalProject.service.implement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wero.finalProject.Repository.LikeRepository;
import com.wero.finalProject.Repository.MainFeedRepository;
import com.wero.finalProject.domain.LikeEntity;
import com.wero.finalProject.domain.MainFeedEntity;
import com.wero.finalProject.domain.UserEntity;
import com.wero.finalProject.dto.response.feeds.FeedsResponseDto;
import com.wero.finalProject.service.MainFeedService;
import com.wero.finalProject.service.UserService;

import jakarta.persistence.EntityNotFoundException;

/**
 * @작성자:김선규
 * @작성날짜:2024/05/07
 * @파일명:MainFeedServiceImpl
 * @기능:MainFeed 서비스 상세
 **/

@Service("MainFeedServiceImpl")
public class MainFeedServiceImpl implements MainFeedService {

    @Autowired
    private MainFeedRepository mainFeedRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private LikeRepository likeRepository;

    // 메인 피드 전체 조회
    @Override
    public List<FeedsResponseDto> getAllFeeds(String userId) {
        List<MainFeedEntity> feeds = mainFeedRepository.findAll();

        try {
            if (feeds.isEmpty()) {
                throw new RuntimeException("Not found feeds");
            }

            List<FeedsResponseDto> responseDtos = feeds.stream()
                    .map(feed -> {
                        Optional<LikeEntity> like = likeRepository
                                .findIsLikedByUserId_UserIdAndMainfeedId_MainfeedId(userId, feed.getMainfeedId());
                        boolean isLiked = like.map(LikeEntity::isLiked).orElse(false);
                        return new FeedsResponseDto(
                                feed.getMainfeedId(),
                                feed.getContent(),
                                feed.getTrackName(),
                                feed.getImage(),
                                feed.getCreateDate(),
                                feed.getModificateDate(),
                                feed.getCategory(),
                                isLiked);
                    })
                    .collect(Collectors.toList());
            return responseDtos;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 유저 피드 userId로 찾기
    @Override
    public List<FeedsResponseDto> getFeedByUserId(String userId) {
        List<MainFeedEntity> feeds = mainFeedRepository.findByWriter_UserId(userId);

        try {
            if (feeds.isEmpty()) {
                throw new RuntimeException("Not found feeds");
            }

            List<FeedsResponseDto> responseDtos = feeds.stream()
                    .map(feed -> {
                        Optional<LikeEntity> like = likeRepository
                                .findIsLikedByUserId_UserIdAndMainfeedId_MainfeedId(userId, feed.getMainfeedId());
                        boolean isLiked = like.map(LikeEntity::isLiked).orElse(false);
                        return new FeedsResponseDto(
                                feed.getMainfeedId(),
                                feed.getContent(),
                                feed.getTrackName(),
                                feed.getImage(),
                                feed.getCreateDate(),
                                feed.getModificateDate(),
                                feed.getCategory(),
                                isLiked);
                    })
                    .collect(Collectors.toList());
            return responseDtos;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    // 메인 피드 생성
    @Override
    public MainFeedEntity createFeed(String userId, MainFeedEntity mainFeedEntity) {
        try {
            UserEntity user = userService.findUserById(userId);
            MainFeedEntity feed = MainFeedEntity.builder()
                    .content(mainFeedEntity.getContent())
                    .trackName(mainFeedEntity.getTrackName())
                    .category(mainFeedEntity.getCategory())
                    .createDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .writer(user)
                    .build();

            return mainFeedRepository.save(feed);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create feed", e);
        }
    }

    // 메인 피드 수정
    @Override
    public MainFeedEntity updateFeed(Integer id, MainFeedEntity feedDetails) {
        MainFeedEntity mainFeedEntity = mainFeedRepository.findById(id).orElse(null);

        try {
            if (mainFeedEntity == null || mainFeedEntity.getMainfeedId() == null) {

                throw new EntityNotFoundException();
            } else {

                MainFeedEntity updateFeed = MainFeedEntity.builder()
                        .mainfeedId(mainFeedEntity.getMainfeedId())
                        .content(feedDetails != null ? feedDetails.getContent() : mainFeedEntity.getContent())
                        .trackName(feedDetails != null ? feedDetails.getTrackName() : mainFeedEntity.getTrackName())
                        .category(feedDetails != null ? feedDetails.getCategory() : mainFeedEntity.getCategory())
                        .createDate(mainFeedEntity.getCreateDate())
                        .modificateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                        .build();
                return mainFeedRepository.save(updateFeed);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to update feed", e);
        }

    }

    // 메인 피드 삭제
    @Override
    public void deleteFeed(Integer id) {
        MainFeedEntity mainFeedEntity = mainFeedRepository.findById(id).orElse(null);
        if (mainFeedEntity == null || mainFeedEntity.getMainfeedId() == null) {
            throw new EntityNotFoundException();
        }
        try {
            mainFeedRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete feed", e);
        }

    }

}
