package com.wero.finalProject.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Table(name="cerification")
public class Certification {

    @Id //인증 테이블 기본키
    @GeneratedValue(strategy = GenerationType.AUTO) //기본키 생성 전략 -> Int 일떄 IDENTITY
    private String userId;

    @Column(name ="email", updatable = false) //인증시 사용할 이메일
    private String email;

    @Column(name="password") //로그인 인증때 사용하는 비밀번호
    private String password;

    @Column(name = "certificationNumber") //이메일로 발송되는 인증 번호
    private String certificationNumber;

    public Certification(String userId,
                         String email,
                         String certificationNumber){
        this.userId=userId;
        this.email = email;
        this.certificationNumber = certificationNumber;

    }

}