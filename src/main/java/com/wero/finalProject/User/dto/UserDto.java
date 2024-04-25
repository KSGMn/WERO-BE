package com.wero.finalProject.User.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @작성자:김선규
 * @작성날짜:2024/4/25
 * @파일명:UserDto.java
 **/

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private String email;
    private String passWord;
    private String userName;
    private String access_token;
    private String profile_image;
    private String platform_type;
    private String roles;

}
