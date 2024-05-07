package com.wero.finalProject.dto.object;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wero.finalProject.domain.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostListItem {
    private int post_id;
    private String content;
    private String boardTitleImage;
    private int favoriteCount;
    private int commentCount;
    private int viewCount;
    private String writeDatetime;
    private String writerNickname;
    private String writerProfileImage;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int post_id;
//
//    @Column(name = "content")
//    private String content;
//
//    @Column(name = "create_date")
//    private String create_date;
//
//    @Column(name = "category")
//    private String category;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    @JsonManagedReference
//    private UserEntity user;//유저아이디(외래키)
//
//    @Column(name = "modificate_date")
//    private String modificate_date;
}
