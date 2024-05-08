package com.wero.finalProject.service;

import java.util.List;

import com.wero.finalProject.domain.MainFeedEntity;

/**
 * @작성자:김선규
 * @작성날짜:2024/05/07
 * @파일명:MainFeedService
 * @기능:MainFeed 서비스
 **/

public interface MainFeedService {

    List<MainFeedEntity> getAllFeeds();

    MainFeedEntity getFeedById(Integer id);

    MainFeedEntity createFeed(MainFeedEntity mainFeed);

    MainFeedEntity updateFeed(Integer id, MainFeedEntity mainFeed);

    void deleteFeed(Integer id);

}
