package com.wero.finalProject.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @작성자:오현암
 * @작성날짜:2024/04/25
 * @파일명:UserRole.enum
 **/
@Getter
@RequiredArgsConstructor
public enum UserRole {

    GUEST,
    USER,
    ADMIN;

    private static final String PREFIX = "ROLE_";

    public String getAuthority(){
        return PREFIX+ this.name();
    }
}
