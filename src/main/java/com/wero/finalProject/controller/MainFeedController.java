package com.wero.finalProject.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wero.finalProject.domain.MainFeedEntity;
import com.wero.finalProject.domain.UserEntity;
import com.wero.finalProject.dto.request.feeds.CreateFeedsRequestDto;
import com.wero.finalProject.dto.response.feeds.CreateFeedsResponseDto;
import com.wero.finalProject.service.MainFeedService;
import com.wero.finalProject.service.UserService;

/**
 * @작성자:김선규
 * @작성날짜:2024/05/07
 * @파일명:MainFeedController
 * @기능:MainFeed 컨트롤러
 **/

@RestController
@RequestMapping("/api/v1/user/feeds")
public class MainFeedController {

    private final MainFeedService mainFeedService;
    private final UserService userService;

    @Autowired
    public MainFeedController(MainFeedService mainFeedService, UserService userService) {
        this.mainFeedService = mainFeedService;
        this.userService = userService;
    }

    @GetMapping
    public List<MainFeedEntity> getAllFeeds() {
        return mainFeedService.getAllFeeds();
    }

    @GetMapping("/{id}")
    public MainFeedEntity getFeedById(@PathVariable Integer id) {
        return mainFeedService.getFeedById(id);
    }

    @PostMapping("/{userId}/create")
    public ResponseEntity<CreateFeedsResponseDto> createFeed(@RequestBody CreateFeedsRequestDto requestDto,
            @PathVariable String userId) {

        System.out.println("Received 카테고리: " + requestDto.getCategory() + requestDto.getContent() +
                requestDto.getTrackName());

        UserEntity user = userService.findUserById(userId);

        MainFeedEntity feed = MainFeedEntity.builder()
                .content(requestDto.getContent())
                .trackName(requestDto.getTrackName())
                .category(requestDto.getCategory())
                .create_date(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .writer(user)
                .build();
        System.out.println("Received 카테고리 후 : " + requestDto.getCategory() + requestDto.getContent() +
                requestDto.getTrackName());
        MainFeedEntity createFeed = mainFeedService.createFeed(feed);
        CreateFeedsResponseDto responseDto = new CreateFeedsResponseDto(
                createFeed.getMainfeed_id(),
                "Feed created successfully!");

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public MainFeedEntity updateFeed(@PathVariable Integer id, @RequestBody MainFeedEntity feed) {
        return mainFeedService.updateFeed(id, feed);
    }

    @DeleteMapping("/{id}")
    public void deleteFeed(@PathVariable Integer id) {
        mainFeedService.deleteFeed(id);
    }

}
