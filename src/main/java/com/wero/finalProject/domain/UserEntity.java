package com.wero.finalProject.domain;

import java.util.HashSet;
import java.util.Set;

import com.wero.finalProject.dto.request.auth.RegisterRequestDto;
import com.wero.finalProject.dto.request.user.UserUpdateEmailRequestDto;
import com.wero.finalProject.dto.request.user.UserUpdateRequestDto;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @작성자:오현암
 * @작성날짜:2024/04/25
 * @파일명:User.class
 * @기능:User엔티티
 **/

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @Column(name = "userId", updatable = false)
    private String userId;

    @Column(name = "email")
    private String email;

    @Column(name = "password", updatable = true)
    private String password;

    @Column(name = "type", updatable = false)
    private String type;

    @Column(name = "nickname")
    private String nickName;

    @Column(name = "gender", updatable = true)
    private String gender;

    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private Set<LikeEntity> likes = new HashSet<>();

    // TODO: Enum화 시키기
    @Column(name = "role", updatable = false)
    private String role;

    @Column(name = "restriction", updatable = true)
    private boolean restriction;



    public UserEntity(RegisterRequestDto dto) {
        this.userId = dto.getId();
        this.password = dto.getPassword();
        this.email = dto.getEmail();
        this.gender = dto.getGender();
        this.nickName = dto.getNickName();
        this.type = "app";
        this.role = "ROLE_USER";
        this.restriction = false;
    }

    public UserEntity(String userId, String nickName, String email, String type) {
        this.userId = userId;
        this.nickName = nickName;
        this.password = "password";
        this.email = email;
        this.type = type;
        this.role = "ROLE_USER";
        this.restriction = false;
    }

    public void patchUserEntity(UserUpdateRequestDto dto, String userId) {
        this.userId = userId;
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.gender = dto.getGender();
        this.nickName = dto.getNickName();
    }

    public void patchUserEmail(UserUpdateEmailRequestDto dto, String userId) {
        this.userId = userId;
        this.email = dto.getEmail();
    }

}
