package com.wero.finalProject.service.implement;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wero.finalProject.Repository.LikeRepository;
import com.wero.finalProject.Repository.MoodymatchRepository;
import com.wero.finalProject.domain.LikeEntity;
import com.wero.finalProject.domain.MainFeedEntity;
import com.wero.finalProject.dto.response.feeds.FeedsResponseDto;
import com.wero.finalProject.service.MoodyMatchService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * @작성자:김선규
 * @작성날짜:2024/05/12
 * @파일명:MoodyMatchServiceImpl
 * @기능:MoodyMatch 서비스 상세
 **/

@Service("MoodyMatchServiceImpl")
public class MoodyMatchServiceImpl implements MoodyMatchService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private MoodymatchRepository moodymatchRepository;

    @PersistenceContext
    private EntityManager entityManager;

    // 유저가 좋아요 누르지 않은 피드 조회
    @Override
    public List<FeedsResponseDto> getNotLikeFeeds(String userId) {
        List<MainFeedEntity> allFeeds = moodymatchRepository.findAll();

        List<MainFeedEntity> likeFeeds = moodymatchRepository.findByLikes_UserId_UserId(userId);

        List<MainFeedEntity> feeds = allFeeds.stream()
                .filter(feed -> !likeFeeds.contains(feed))
                .collect(Collectors.toList());

        Collections.shuffle(feeds);

        try {
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
                                isLiked,
                                feed.getWriter().getUserId());
                    })
                    .collect(Collectors.toList());

            return responseDtos;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
