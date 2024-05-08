package com.wero.finalProject.dto.request.search;

import lombok.Getter;
import lombok.Setter;

/**
 * @작성자:김선규
 * @작성날짜:2024/05/07
 * @파일명:SearchDiaryRequestDto
 **/
@Getter
@Setter
public class DiarySearchRequestDto {

    private Integer diary_id;
    private String content;
    private String category;
    private String nickName;

    public DiarySearchRequestDto(Integer diary_id, String content, String category, String nickName) {
        this.diary_id = diary_id;
        this.content = content;
        this.category = category;
        this.nickName = nickName;
    }

}
