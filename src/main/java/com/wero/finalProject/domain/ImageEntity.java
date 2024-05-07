package com.wero.finalProject.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Scanner;

/**
 * @작성자:오현암
 * @작성날짜:2024/05/04
 * @파일명:ImageEntity.class
 **/
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name="User_Image")
public class ImageEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long i_id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity userId;

    @Column(name = "imageTitle", length = 255, nullable = true)
    private String imageTitle;

    public ImageEntity(UserEntity user, String imageTitle){
        this.userId = user;
        this.imageTitle = imageTitle;
    }

}
