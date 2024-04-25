package com.wero.finalProject.User.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @작성자:오현암
 * @작성날짜:2024/4/24
 * @파일명:User.java
 **/

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "User")
@Builder
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private String user_id;

    @Column(name = "email", length = 320, nullable = false)
    private String email;

    @Column(name = "passWord", length = 30, nullable = false)
    private String passWord;

    @Column(name = "userName", length = 8, nullable = false)
    private String userName;

    @Column(name = "access_token", length = 500, nullable = false)
    private String access_token;

    @Column(name = "profile_image", length = 500, nullable = false)
    private String profile_image;

    @Column(name = "bio", length = 500, nullable = true)
    private String bio;

    @Column(name = "platform_type", length = 10, nullable = false)
    private String platform_type;

    @Column(name = "roles", nullable = false)
    private String rolse;

}
