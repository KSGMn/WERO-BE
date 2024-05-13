package com.wero.finalProject.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wero.finalProject.dto.request.diary.DiaryRequestDto;
import com.wero.finalProject.dto.request.diary.PatchDiaryRequestDto;
import jakarta.persistence.*;
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
@Table(name="diary")
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

    //like, songTitle

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private UserEntity writer;//유저아이디(외래키)

    @Column(name = "modificate_date")
    private String modificate_date;

    public DiaryEntity(DiaryRequestDto dto, UserEntity user) {

        this.diaryContent = dto.getDiaryContent();
        this.song="song";
        this.writer=user;

    }

    public void patchDiary(PatchDiaryRequestDto dto) {
        this.diaryContent = dto.getDiaryContent();
        this.emotion=dto.getEmotion();
        this.song=dto.getSong();
    }
}