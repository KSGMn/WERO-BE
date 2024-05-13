package com.wero.finalProject.service;

import java.util.List;

import com.wero.finalProject.dto.response.feeds.FeedsResponseDto;

/**
 * @작성자:김선규
 * @작성날짜:2024/05/12
 * @파일명:MoodyMatchService
 * @기능:MoodyMatch 서비스
 **/

public interface MoodyMatchService {

    List<FeedsResponseDto> getNotLikeFeeds(String userId);

}
