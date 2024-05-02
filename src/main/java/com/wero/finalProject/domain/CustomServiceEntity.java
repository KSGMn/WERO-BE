package com.wero.finalProject.domain;

import com.wero.finalProject.dto.request.afterService.CustomService_C_requestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * @작성자:
 * @작성날짜:
 * @파일명:
 **/
@Getter
@Entity(name = "customerservice")
@Table(name="customerservice")
@NoArgsConstructor
@AllArgsConstructor
public class CustomServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inquiry_id;

    @Column(name = "inquiryTitle")
    private String inquiryTitle;


    private String inquiryContent;

    private String response;

    private String writeDateTime;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity writer;



    public CustomServiceEntity(CustomService_C_requestDto dto, UserEntity user){
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
        this.writeDateTime = simpleDateFormat.format(now);
        this.inquiryTitle = dto.getInquiryTitle();
        this.inquiryContent = dto.getInquiryContent();
        this.response = "";
        this.writer = user;
    }


}
