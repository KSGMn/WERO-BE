package com.wero.finalProject.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wero.finalProject.Repository.MainFeedRepository;
import com.wero.finalProject.domain.MainFeedEntity;
import com.wero.finalProject.service.MainFeedService;

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

    @Override
    public List<MainFeedEntity> getAllFeeds() {
        return mainFeedRepository.findAll();
    }

    @Override
    public MainFeedEntity getFeedById(Integer id) {
        return mainFeedRepository.findById(id).orElse(null);
    }

    @Override
    public MainFeedEntity createFeed(MainFeedEntity MainFeedEntity) {
        return mainFeedRepository.save(MainFeedEntity);
    }

    @Override
    public MainFeedEntity updateFeed(Integer id, MainFeedEntity feedDetails) {
        MainFeedEntity MainFeedEntity = mainFeedRepository.findById(id).orElse(null);
        if (MainFeedEntity != null) {
            MainFeedEntity.builder().content(feedDetails.getContent()).build();
            mainFeedRepository.save(MainFeedEntity);
        }
        return MainFeedEntity;
    }

    @Override
    public void deleteFeed(Integer id) {
        mainFeedRepository.deleteById(id);
    }

}
