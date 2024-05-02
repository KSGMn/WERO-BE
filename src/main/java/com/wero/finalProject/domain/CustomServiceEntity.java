package com.wero.finalProject.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @작성자:
 * @작성날짜:
 * @파일명:
 **/
@Getter
@Entity
@Table(name="CustomService")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CustomServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inquiry_id;

    @Column(name ="inquiry")
    private String inquiry;

    @Column(name = "response")
    private String response;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;
}
