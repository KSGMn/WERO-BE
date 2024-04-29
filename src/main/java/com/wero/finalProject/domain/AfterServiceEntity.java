package com.wero.finalProject.domain;

import com.wero.finalProject.dto.request.afterService.AfterServiceRequestDto;
import com.wero.finalProject.dto.response.afterService.AfterServiceResponseDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @작성자:오현암
 * @작성날짜:2024/04/28
 * @파일명:AfterService.class
 * @기능:고객센터_테이블
 **/

@Getter
@Entity
@Table(name ="AfterService")
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class AfterServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AId", nullable = false, updatable = false)
    private Long aId;

    @Column(name = "a_title", nullable = false, updatable = true)
    private String a_title;

    @Column(name = "a_content", nullable = false, updatable = true)
    private String a_content;

    @Column(name = "a_writer", nullable = false ,updatable = false)
    private String a_writer;

    @Column(name="created_At")
    private LocalDateTime createdAt;

    @Column(name="modified_At")
    private LocalDateTime modifiedAt;

    public AfterServiceEntity(AfterServiceRequestDto dto){

        LocalDateTime createdAt = null;
        this.a_writer = dto.getWriter();
        this.a_title = dto.getTitle();
        this.a_content = dto.getContent();
        this.createdAt = createdAt;
    }



}
