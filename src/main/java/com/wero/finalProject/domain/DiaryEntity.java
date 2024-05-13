package com.wero.finalProject.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wero.finalProject.dto.request.diary.DiaryRequestDto;
import com.wero.finalProject.dto.request.diary.PatchDiaryRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @작성자:최기원
 * @작성날짜:2024/05/04
 * @파일명:DiaryEntity.class
 * @기능:일기 엔티티
 **/

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "diary")
public class DiaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int diaryId;

    @Column(name = "diary_content", nullable = false)
    private String diaryContent;

    @Column(name = "emotion", nullable = true)
    private String emotion;

    @Column(name = "song", nullable = false)
    private String song;

    @Column(name = "bookmark_count")
    private int bookMarkCount;

    // like, songTitle

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private UserEntity writer;// 유저아이디(외래키)

    @Column(name = "modificate_date")
    private String modificate_date;

    public DiaryEntity(DiaryRequestDto dto, UserEntity user) {

        this.diaryContent = dto.getDiaryContent();
        this.song = dto.getSong();
        this.emotion = dto.getEmotion();
        this.writer = user;
        this.bookMarkCount = 0;
    }

    public void patchDiary(PatchDiaryRequestDto dto) {
        this.diaryContent = dto.getDiaryContent();
        this.emotion = dto.getEmotion();
        this.song = dto.getSong();
    }

    public void increaseBookMarkCount() {
        this.bookMarkCount++;
    }

    public void decreaseBookMarkCount() {
        this.bookMarkCount--;
    }
}