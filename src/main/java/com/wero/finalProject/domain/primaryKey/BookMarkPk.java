package com.wero.finalProject.domain.primaryKey;

import jakarta.persistence.Column;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @작성자:최기원
 * @작성날짜:2024/05/13
 * @파일명:BookMarkPk.class
 * @기능:북마크 엔티티의 기본 키
 **/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookMarkPk implements Serializable {
    @Column(name="user_id")
    private String userId;
    @Column(name="diary_id")
    private int diaryId;
}
