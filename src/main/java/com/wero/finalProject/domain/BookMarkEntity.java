package com.wero.finalProject.domain;

import com.wero.finalProject.domain.primaryKey.BookMarkPk;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @작성자:최기원
 * @작성날짜:2024/05/13
 * @파일명:BookMarkEntity.class
 * @기능:북마크 엔티티
 **/

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="bookmark")
@Table(name="favorite")
@IdClass(BookMarkPk.class)
public class BookMarkEntity {
    @Id
    private String userId;
    @Id
    private int diaryId;
}
