package com.wero.finalProject.auth.certification;

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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userId;

    @Column(name ="email", updatable = false)
    private String email;

    @Column(name="password")
    private String password;

    @Column(name = "certificationNumber")
    private String certificationNumber;

    public Certification(String userId,
                         String email,
                         String certificationNumber){
        this.userId=userId;
        this.email = email;
        this.certificationNumber = certificationNumber;

    }

}