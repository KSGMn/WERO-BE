package com.wero.finalProject.domain;

import com.wero.finalProject.dto.request.auth.RegisterRequestDto;
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
@Entity(name="user")
@Table(name="user")
public class UserEntity {

    @Id
    private String userId;

    @Column(name ="email", updatable = false)
    private String email;

    @Column(name="password", updatable = false)
    private String password;

    @Column(name="type", updatable = false)
    private String type;

    @Column(name="nickName")
    private String nickName;

    @Column(name="gender", updatable = true)
    private String gender;

    //TODO: Enum화 시키기
    @Column(name="role", updatable = false)
    private String role;

    public UserEntity(RegisterRequestDto dto){
        this.userId = dto.getId();
        this.password = dto.getPassword();
        this.email = dto.getEmail();
        this.gender = dto.getGender();
        this.nickName = dto.getNickName();
        this.type = "app";
        this.role = "ROLE_USER";
    }

    public UserEntity(String userId, String email, String type){
        this.userId = userId;
        this.password = "password";
        this.email = email;
        this.type = type;
        this.role = "ROLE_USER";
    }

}
