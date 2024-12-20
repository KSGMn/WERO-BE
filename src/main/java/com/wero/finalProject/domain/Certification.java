package com.wero.finalProject.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @작성자:오현암
 * @작성날짜:2024/04/25
 * @파일명:Certification.class
 * @기능:인증정보Entity
 **/
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="cerification")
public class Certification {

    @Id //인증 테이블 기본키
    private String userId;

    private String email;

    private String certificationNumber;

    public Certification(String userId,
                         String email,
                         String certificationNumber){
        this.userId=userId;
        this.email = email;
        this.certificationNumber = certificationNumber;
    }

}