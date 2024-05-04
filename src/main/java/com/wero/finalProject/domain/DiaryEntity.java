package com.wero.finalProject.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wero.finalProject.dto.request.diary.DiaryRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="diary")
public class DiaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int diary_id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "create_date", nullable = true)
    private String create_date;

    @Column(name = "category", nullable = false)
    private String category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private UserEntity writer;//유저아이디(외래키)

    @Column(name = "modificate_date")
    private String modificate_date;

    public DiaryEntity(DiaryRequestDto dto, UserEntity user) {

        this.content = dto.getContent();
        this.category="category";
        this.writer=user;

    }
}