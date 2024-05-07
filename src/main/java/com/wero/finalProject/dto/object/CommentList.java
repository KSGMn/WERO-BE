package com.wero.finalProject.dto.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentList {
    private String nickname;
    private String profileImage;
    private String content;
    private String writeDatetime;
}
